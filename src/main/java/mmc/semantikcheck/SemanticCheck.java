package mmc.semantikcheck;

import mmc.ast.*;
import mmc.ast.expressions.*;
import mmc.ast.expressions.Class;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.Crement;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.*;
import mmc.semantikcheck.Environment.ProgramEnvironment;
import mmc.semantikcheck.Environment.ScopeEnvironment;
import mmc.semantikcheck.Environment.ScopeInitialized;

import java.util.*;

import static mmc.ast.BasicType.*;

public class SemanticCheck implements SemanticVisitor {

    public ProgramEnvironment programEnvironment;
    public ClassDecl getClass;
    public String fileName;
    public Type currentMethodReturnType;
    private Type currentNullType;
    private ScopeEnvironment currentScope;
    public static ArrayList<Exception> errors = new ArrayList<>(); //Alle errors in einer Liste sammeln und am schluss raus geben
    public static ArrayList<String> getFields = new ArrayList<>();
    public static boolean methodIsStatic;
    private boolean assign = false;


    public static void main(String[] args) {
        ArrayList<Method> methods = new ArrayList<Method>();
        Method method1 = new Method(BasicType.VOID, "method1", new ArrayList<Parameter>(), new Block(), AccessModifier.PUBLIC, false);
        Method method2 = new Method(BasicType.INT, "method2", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(new IntExpr(1)))), AccessModifier.PUBLIC, false);
        Method method3 = new Method(BasicType.BOOL, "method3", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(new BoolExpr(true)))), AccessModifier.PUBLIC, false);
        Method method4 = new Method(BasicType.CHAR, "method4", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(new CharExpr('c')))), AccessModifier.PRIVATE, false);
        methods.add(method1);
        methods.add(method2);
        methods.add(method3);
        methods.add(method4);

    }

    public static Program generateTypedast(Program program) { //Erstelle getypter Baum
        SemanticCheck semanticCheck = new SemanticCheck();
        var result = program.accept(semanticCheck);
        if (result.isValid()) {
            return program; //Programm an ByteCode weitergeben
        } else { //Wenn nicht valide dann alle error Messages zurückgeben
            StringBuilder errorString = new StringBuilder("\n" + "\u001B[31m");
            for (var error: errors) {
                errorString.append(error.getMessage()).append("\n");
            }
            throw new Exception(errorString + "\u001B[0m");
        }
    }

    @Override
    public TypeCheckResult typeCheck(Program toCheck) { //Type Check für Program
        boolean valid = true;
        programEnvironment = new ProgramEnvironment(toCheck);
        toCheck.programEnvironment = programEnvironment; //für programm speicherung

        currentScope = new ScopeEnvironment();

        for (var classes : toCheck.classes) { //Geht durch alle Klassen und checkt ob sie valide sind

            //hier checken ob klassen gleich heißen//
            valid = classes.accept(this).isValid() && valid;
        }
        return new TypeCheckResult(valid, null);
    }

    @Override
    public TypeCheckResult typeCheck(ClassDecl toCheck) {
        var valid = true;

        this.getClass = toCheck; //Für die Umgebung merken welche Klasse gerade überprüft wird

        if (fileName == null) {
            this.fileName = toCheck.name + ".java";
            //Dies machen wir um mehrere klassen untereinander zuschreiben welche als einzelne files angesehen werden
        }

        if (toCheck.constructors.isEmpty()) { //leeren Konstruktor erstellen
            new Constructor().accept(this);
        } else {
            for (Constructor constructor : toCheck.constructors) { //Für jede Klasse Konstruktor überprüfen
                valid = constructor.accept(this).isValid() && valid;
            }
        }

        //Felder überprüfen
        List<String> fieldNames = new ArrayList<>();
        getFields.clear(); //Einmal Liste leeren das für jede klasse neue felder gemacht werden
        for (Field field : toCheck.fields) {
            var checkResult = field.accept(this);
            valid = valid && checkResult.isValid();
            if (valid) {
                fieldNames.add(field.name); //Wenn feld valid in identifier speichern TODO: Und wenn nicht? Wird kein Fehler ausgegeben sondern einfach ignoriert
            }
        }

        //Methoden überprüfen
        for (Method method : toCheck.methods) {
            //Für jede Methode durchgehen und schauen
            valid = method.accept(this).isValid() && valid;
        }

        return new TypeCheckResult(valid, new ReferenceType(toCheck.name));
    }


    @Override
    public TypeCheckResult typeCheck(Field toCheck) {

        boolean typeExist;

        //Erst schauen ob Feldname schon existiert
        if (getFields.contains(toCheck.name)) {
            errors.add(new Exception("Error in line " + toCheck.startLine + ": field variable " + toCheck.name + " is already defined in " + getClass.name));
            return new TypeCheckResult(false, null);
        } else {
            getFields.add(toCheck.name); //Wenn nein zur Liste hinzufügen
        }

        //schauen ob Datentyp eine andere Klasse ist oder die BasicTypes
        if (toCheck.getType() instanceof BasicType) {
            typeExist = true;
        }
        else{
            var fieldType = (ReferenceType) toCheck.getType();
            var programClasses = programEnvironment.getClasses();
            typeExist = programClasses.containsKey(fieldType.type);
        }

        if(toCheck.expression != null){
            TypeCheckResult expressionResult = toCheck.expression.accept(this);
            if(!toCheck.getType().equals(expressionResult.getType())){
                errors.add(new Exception("Error in line " + toCheck.startLine + ": incompatible types: " + toCheck.getType() + " cannot be converted to " + expressionResult.getType()));
                return new TypeCheckResult(false, null);
            }
        }

        return new TypeCheckResult(typeExist, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(Constructor toCheck) {
        boolean valid = true;

        methodIsStatic = false;
        currentScope.pushScope();

        for (Parameter parameter : toCheck.parameters) { //Für jeden Parameter im Konstruktor durchgehen
            valid = valid && parameter.accept(this).isValid();
            currentScope.addLocalVar(parameter); //Local Var auf Stack tun
        }

        currentMethodReturnType = BasicType.VOID;
        var checkResult = toCheck.statement.accept(this);
        currentScope.popScope();
        //schauen ob Konstruktor Return Type besitzt, darf nur VOID haben
        if (checkResult.getType() != null && checkResult.getType() != VOID) {
            errors.add(new Exception("Error in line " + toCheck.startLine +
                    ": unexpected return type " + checkResult.getType() + ": constructors can not have a return type"));
            valid = false;
        }
        valid = valid && checkResult.isValid();
        return new TypeCheckResult(valid, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(Method toCheck) {
        var valid = true;
        methodIsStatic = toCheck.isStatic;

        for (Method method : this.getClass.methods) {
            //von der aktullen Klasse methoden durchgehen und schauen ob toCheck schon mal drin ist
            if (method.equals(toCheck)) {
                break;
            }
            if (method.isSameDeclaration(toCheck)) {
                errors.add(new Exception("Error in line " + toCheck.startLine + ": Method " + toCheck.name + " is already defined in class "+ getClass.name));
                valid = false;
            }
        }

        currentScope.pushScope();

        for (var parameter : toCheck.parameters) { //Alle Parameter in einer Methode durchgehen
            var result = parameter.accept(this);
            valid = valid && result.isValid();
            currentScope.addLocalVar(parameter); //Parameter auf Stack tun
        }

        currentMethodReturnType = toCheck.getType();
        currentNullType = toCheck.getType(); // Solange nicht in Assign oder MethodCall dieser Typ
        // gesetzt ist, ist dieser der Rückgabewert der Methode
        var checkResult = toCheck.block.accept(this);
        valid = valid && checkResult.isValid();
        currentScope.popScope(); //Stack runter nehmen

        var resultType = checkResult.getType();
        if(resultType == null){
            resultType = VOID;
        }
        if (!resultType.equals(toCheck.getType())) { //Error wenn statement und Method nicht gleiche Typen haben
            errors.add(new Exception("Error in line " + toCheck.startLine + ": method declaration " + toCheck.name + " with type "
                    + toCheck.getType() + " has at least one mismatching return type"));
            valid = false;
        }
        return new TypeCheckResult(valid, resultType);
    }

    @Override
    public TypeCheckResult typeCheck(Assign toCheck) { //int a = 5;

        boolean valid = true;

        var lExpr = toCheck.leftExpr;
        var rExpr = toCheck.rightExpr;

/*        //a = a;
        if (lExpr.equals(rExpr)) {
            errors.add(new Exception("Cannot assign to self"));
            valid = false;
        }*/

        assign = true;
        var leftExpr = lExpr.accept(this);
        assign = false;
        currentNullType = leftExpr.getType();
        var rightExpr = rExpr.accept(this);

        if(!rightExpr.isValid() || !leftExpr.isValid()){
            return new TypeCheckResult(false, null);
        }

        valid = CheckType.isInitalised(currentScope,rExpr,lExpr);
        //---Info: deprecated!---
        //int a += a; a -= a; a *= a; a /= a, nur auf Integer anwenden
        if(toCheck.operator != Operator.ASSIGN){
            if(!((leftExpr.getType() == INT || leftExpr.getType() == CHAR) && (rightExpr.getType() == INT || rightExpr.getType() == CHAR))){
                errors.add(new Exception("Error in line " + toCheck.startLine + ": mismatch types in assign: both types need to be int or char and not "
                        + leftExpr.getType() + " and "
                        + rightExpr.getType()));
                valid = false;
            }
        }
        else{
            toCheck.type = lExpr.getType();
        }

        toCheck.type = lExpr.getType();


        //int a = "Hello";
        if (!Objects.equals(lExpr.getType(), rExpr.getType()) && valid) {
            errors.add(new Exception("Error in line " + toCheck.startLine + ": incompatible types: " + lExpr.getType() + " cannot be converted to " + rExpr.getType()));
            valid = false;
        } else {
            toCheck.type = lExpr.getType();
        }

        valid = valid && leftExpr.isValid() && rightExpr.isValid();
        currentNullType = null;
        return new TypeCheckResult(valid, null); //Hat keine Typ deswegen null zurück geben

    }

    @Override
    public TypeCheckResult typeCheck(Parameter toCheck) {
        boolean typeExist;
        if (toCheck.getType() instanceof BasicType) {
            typeExist = true;
        }
        else{
            var objectClass = (ReferenceType) toCheck.getType();
            var declaredClassnames = programEnvironment.getClasses();
            typeExist = declaredClassnames.containsKey(objectClass.type);
        }
        if (typeExist) {
            return new TypeCheckResult(true, toCheck.getType());
        } else {
            errors.add(new Exception("Error in line " + toCheck.startLine + ": type " + toCheck.getType() + " is unknown"));
            return new TypeCheckResult(false, toCheck.getType());
        }
    }

    @Override
    public TypeCheckResult typeCheck(While toCheck) {
        var valid = true;
        var condition = toCheck.expression.accept(this);

        valid = condition.isValid();

        if(condition.isValid()){
            //Schauen ob das in der While Schleife ein Bool ist
            boolean isBool = Objects.equals(BOOL, condition.getType());

            if (!isBool) { //Wenn kein bool enthalten ist
                errors.add(
                        new Exception("Error in line " + toCheck.startLine +
                                ": incompatible types: " + condition.getType() + " cannot be converted to " + BOOL));
                valid = false;
            }
        }

        //Check Block/Statement
        var statementResult = toCheck.statement.accept(this);
        toCheck.type = statementResult.getType();
        valid = valid && statementResult.isValid();
        return new TypeCheckResult(valid, statementResult.getType());
    }

    @Override
    public TypeCheckResult typeCheck(For toCheck) {
        var valid = true;

        currentScope.pushScope();

        //alle Statements durchgehen
        for(var initStatement : toCheck.initStatements){
            var initResult = initStatement.accept(this);
            valid = valid && initResult.isValid();
        }

        for(var updateStatements : toCheck.updateStatements){
            var updateResult = updateStatements.accept(this);
            valid = valid && updateResult.isValid();
        }

        if(toCheck.condition != null){
            var conditionResult = toCheck.condition.accept(this);
            valid = valid && conditionResult.isValid();
        }

        var bodyResult = toCheck.statementBlock.accept(this);
        currentScope.popScope();

        valid = valid && bodyResult.isValid();

        toCheck.type = bodyResult.getType();
        return new TypeCheckResult(valid, bodyResult.getType());
    }

    @Override
    public TypeCheckResult typeCheck(Return toCheck) {
        boolean valid = true;
        TypeCheckResult returnExpression;

        //Wenn kein Return Type dann Return Type VOID
        if (toCheck.expression == null) {
            returnExpression = new TypeCheckResult(valid, BasicType.VOID);
            toCheck.type = BasicType.VOID;
        } else { //return x;
            returnExpression = toCheck.expression.accept(this); //von Expression der Type
            if(!returnExpression.isValid()){
                return new TypeCheckResult(false, null);
            }
            toCheck.type = toCheck.expression.getType();
        }
        if (currentMethodReturnType != null && !currentMethodReturnType.equals(toCheck.getType())) {
            if(currentMethodReturnType instanceof ReferenceType){
                errors.add(
                new Exception("Error in line " + toCheck.startLine + ": return type mismatch: cannot convert from " + returnExpression.getType()
                        + " to " + ((ReferenceType)currentMethodReturnType).type));
            }else {
                //Wenn die aktuelle Methode einen Return Type hat aber nicht zu dem Return Typ passt exception
                errors.add(
                        new Exception("Error in line " + toCheck.startLine + ": return type mismatch: cannot convert from " + returnExpression.getType()
                                + " to " + currentMethodReturnType));
            }
            valid = false;
            return new TypeCheckResult(valid, returnExpression.getType());
        }

        return new TypeCheckResult(valid, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(LocalVarDecl toCheck) {
        //int x;

        //public void foo(){
        //		doodlesack i; //Type Doodlesack, i name, expression null
        //	}
        //public void foo(){
        //		int i; //Type Doodlesack, i name, expression null
        //		i++; //nicht valide
        //	}

        var valid = true;
        boolean isInitialized;

        if (toCheck.expression != null) {
            isInitialized = true;

            var checkResult = toCheck.expression.accept(this);
            var resultType = toCheck.expression.getType();
            valid = checkResult.isValid() && valid;

            if (!Objects.equals(resultType, toCheck.getType())) { //Expression muss zum LocalVar Typ passen
                if (toCheck.type instanceof ReferenceType){
                    errors.add(new Exception(
                            "Error in line: "+ toCheck.startLine + " Type mismatch: cannot convert from " + resultType + " to " + ((ReferenceType)toCheck.getType()).type));
            }else {
                errors.add(new Exception(
                        "Error in line: "+ toCheck.startLine + " Type mismatch: cannot convert from " + resultType + " to " + toCheck.getType()));
            }
                valid = false;
            }
        }else{
            isInitialized = false;
        }

        try {
            if(toCheck.type instanceof ReferenceType) {
                CheckType.getClassInType(toCheck, programEnvironment); //schauen ob es den Typ überhaupt gibt
            }
            currentScope.addLocalVar(toCheck, isInitialized);
        } catch (java.lang.Exception e) {
            errors.add(new Exception(e.getMessage()));
            valid = false;
        }
        return new TypeCheckResult(valid, null);
    }

    @Override
    public TypeCheckResult typeCheck(If toCheck) {
        var valid = true;

        // Condition überprüfen
        var expressionResult = toCheck.expression.accept(this);


        if(expressionResult.isValid()){
            valid = valid && expressionResult.isValid();
            boolean isBool = (Objects.equals(BasicType.BOOL,toCheck.expression.getType()));
            if (!isBool) {
                errors.add(
                        new Exception("Error in line " + toCheck.startLine +
                                ": incompatible types: " + expressionResult.getType() + " cannot be converted to " + BOOL));
                valid = false;
            }
        }
        else{
            valid = false;
        }

        //if Block überprüfen
        var ifResult = toCheck.blockIf.accept(this);

        var ifBlockType = ifResult.getType();
        valid = valid && ifResult.isValid();

        // else überprüfen
        if (toCheck.blockElse != null) { //Wenn es ein else block gibt dann..
            var elseBlockResult = toCheck.blockElse.accept(this);
            valid = valid && elseBlockResult.isValid();
            var elseBlockType = elseBlockResult.getType();


            // Folgendes if else ist für die Bestimmung des Rückgabetyps
            if (ifBlockType == null && elseBlockType != null) {
                //Falls if keinen return Typ nehmen wir den Typ von else
                toCheck.type = elseBlockType;
            } else if (ifBlockType != null && elseBlockType == null) {
                //Falls else keinen return Typ nehmen wir den Typ von if
                toCheck.type = ifResult.getType();

            } else if (ifBlockType != null || !ifResult.isValid() || !elseBlockResult.isValid()) {
                if(valid){
                    // Typen müssen übereinstimmen
                    if (!Objects.equals(elseBlockType, ifBlockType)) {
                        errors.add(new Exception(
                                "Error in line "+ toCheck.startLine + " Type mismatch: cannot convert from " + elseBlockType + " to " + ifBlockType));
                        valid = false;
                    } else {
                        toCheck.type = ifBlockType;
                        //Falls der Typ gleich ist, wählt er den Typ vom if Block
                    }
                }
            }
        } else {
            toCheck.type = ifBlockType; //Wenn kein else ist if der Typ der weitergegeben wird
        }

        return new TypeCheckResult(valid, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(Block toCheck) {
        var valid = true;
        Type blockReturnType = null;
        currentScope.pushScope();

        for (var statement : toCheck.statements) { //jedes statement im Block durchgehen
            TypeCheckResult checkResult;
            checkResult = statement.accept(this);
            Type statementReturnType = checkResult.getType();

            if (statementReturnType != null) { //keine änderung des Block Return Typs

                if (blockReturnType == null) { //Setzen den Return Type wenn null
                    blockReturnType = checkResult.getType();
                } else {
                    // wenn es 2 verschiedene return Types gibt error
                    if (!blockReturnType.equals(checkResult.getType())) {
                        errors.add(new Exception(
                                "Return types are mismatching in a single Block, got:" + blockReturnType
                                        + " and " + checkResult.getType()));
                        valid = false;
                    }
                }

            }
            valid = valid && checkResult.isValid();
        }
        toCheck.type = blockReturnType; //Type mitgeben
        currentScope.popScope();
        return new TypeCheckResult(valid, toCheck.type);
    }

    @Override
    public TypeCheckResult typeCheck(New toCheck) { //Nochmal schauen
        var valid = true;

        var newClass = toCheck.getType();
        boolean typeExist;
        if (toCheck.getType() instanceof BasicType) {
            typeExist = true;
        }
        else{
            var classes = (ReferenceType) toCheck.getType();
            var declaredClassnames = programEnvironment.getClasses();
            typeExist = declaredClassnames.containsKey(classes.type);
        }
        if (!typeExist) {
            errors.add(new Exception("Type: " + newClass + " is unknown"));
            valid = false;
        }

        for (var arguments : toCheck.arguments) {
            valid = valid && arguments.accept(this).isValid();
        }

        try {
            CheckType.getConstructor(toCheck, programEnvironment);
        } catch (java.lang.Exception e) {
            errors.add(new Exception(e.getMessage()));
            valid = false;
        }

        if(toCheck.type instanceof ReferenceType){
            return new TypeCheckResult(valid, newClass);
        }
        return new TypeCheckResult(valid, newClass);
    }

    @Override
    public TypeCheckResult typeCheck(MethodCall toCheck) { //später schauen

        //receiver wo ich es rein speicher
        //arguments die parameter in dem methoden aufruf
        // int a = x.add(5,6);

        var valid = true;

        for (var parameter : toCheck.arguments) {
            valid = parameter.accept(this).isValid();
        }

        if(toCheck.methodOwnerPrefix instanceof This){
            try {
                if (methodIsStatic){
                    errors.add(new Exception("non-static method " + toCheck.name + " cannot be referenced from a static context"));
                    return new TypeCheckResult(false, null);
                }
            }catch(Exception e){
                errors.add(new Exception(e.getMessage()));
                return new TypeCheckResult(false, null);
            }
        }


        if(toCheck.methodOwnerPrefix == null){
            try {
                var method = CheckType.getMethodInType(toCheck, new ReferenceType(getClass.name), programEnvironment, getClass);

                if(method.isStatic){
                    toCheck.methodOwnerPrefix = new Class(getClass.name, new ReferenceType(getClass.name));
                }
                else{
                    if(!methodIsStatic){
                        toCheck.methodOwnerPrefix = new This(new ReferenceType(getClass.name));
                    }
                    else{
                        errors.add(new Exception("non-static method " + toCheck.name + " cannot be referenced from a static context"));
                        return new TypeCheckResult(false, null);
                    }
                }

            }catch(Exception e){
                errors.add(new Exception(e.getMessage()));
                return new TypeCheckResult(false, null);
            }
        }

        var receiver = toCheck.methodOwnerPrefix.accept(this);

        valid = valid && receiver.isValid();

        try {
            boolean isStatic = false;
            if(toCheck.methodOwnerPrefix instanceof LocalOrFieldVar l) {
                isStatic = l.isStatic;
            }
            var method = CheckType.getMethodInType(toCheck, toCheck.methodOwnerPrefix.getType(), programEnvironment, getClass);

            if(isStatic && methodIsStatic){
                toCheck.methodOwnerPrefix = new Class(((LocalOrFieldVar) toCheck.methodOwnerPrefix).name, new ReferenceType(((LocalOrFieldVar) toCheck.methodOwnerPrefix).name));
            }

            if(isStatic && !method.isStatic){
                errors.add(
                        new Exception("Trying to call a nonstatic method with a static reference " + toCheck.name + " in class " + toCheck.methodOwnerPrefix.getType()));
                return new TypeCheckResult(false, null);
            }

            toCheck.type = method.type;
            toCheck.isStatic = method.isStatic;
            return new TypeCheckResult(valid, method.type);

        } catch (java.lang.Exception e) {
            errors.add(new Exception(e.getMessage()));
            return new TypeCheckResult(false, null);
        }
    }

    @Override
    public TypeCheckResult typeCheck(Crement toCheck) { //Erweitern
        boolean valid = true;
        var typeCheckResult = toCheck.expression.accept(this);
        Type expressionType = toCheck.expression.getType();

        if(toCheck.expression instanceof LocalOrFieldVar){
            String varName = ((LocalOrFieldVar) toCheck.expression).name;
            var scope = currentScope.getLocalVar(varName);
            if(scope == null){
                errors.add(new Exception("Local or Field Variable " + varName + " doesn't exist"));
                valid = false;
            }else if(scope.isInitialized == false){
                valid = false;
            }
        }

        if (expressionType instanceof BasicType && (((BasicType) expressionType) == INT
                || ((BasicType) expressionType) == CHAR)) {
            toCheck.type = toCheck.expression.getType();
        } else {
            valid = false;
            errors.add(new Exception("The Operator: " + toCheck.operator
                    + " is not defined for the argument type: " + toCheck.expression.getType()));
        }

        valid = valid && typeCheckResult.isValid();
        return new TypeCheckResult(valid, null);
    }

    @Override
    public TypeCheckResult typeCheck(Unary toCheck) { //erweitern
        var valid = true;

        valid = valid && toCheck.expression.accept(this).isValid();

        var thrownError = new Exception("The Operator: " + toCheck.operator
                + " is undefined for the argument type: " + toCheck.expression.getType());

        boolean isBoolOperator = toCheck.operator == Operator.NOT;
        boolean isIntOperator = false;
        // schauen ob unary valid
        if (toCheck.expression.getType() instanceof ReferenceType) {
            errors.add(thrownError);
            valid = false;
        } else {
            var expressionType = ((BasicType) toCheck.expression.getType());
            switch (expressionType) {
                case BOOL -> {
                    if (!isBoolOperator) {
                        errors.add(thrownError);
                        valid = false;
                    }
                }
                case INT -> {
                    if (!isIntOperator) {
                        errors.add(thrownError);
                        valid = false;
                    }
                }
                default -> {
                    errors.add(thrownError);
                    valid = false;
                }
            }
        }

        toCheck.type = toCheck.expression.getType();

        return new TypeCheckResult(valid, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(This toCheck) { //nochmal schauen
        if(methodIsStatic){
            errors.add(new Exception("non-static variable this cannot be referenced from a static context"));
            return new TypeCheckResult(false, null);
        }
        toCheck.setType(getClass.name);
        return new TypeCheckResult(true, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(JNull toCheck) {
        if (currentNullType != null) {
            toCheck.type = currentNullType;
        } else {
            toCheck.type = null;
        }
        return new TypeCheckResult(true, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(LocalOrFieldVar toCheck) {

        //Muss erstmal schauen ob sie im Scope deklariert ist
        var localVar = currentScope.getLocalVar(toCheck.name);

        if (localVar != null) {
            if(!localVar.isInitialized && !assign){
                errors.add(new Exception("Error in line " + toCheck.startLine + ": local variable "+ toCheck.name + " might not have been initialized"));
                toCheck.type = localVar.type;
                return new TypeCheckResult(false, localVar.type);
            }
            toCheck.type = localVar.type;
            return new TypeCheckResult(true, localVar.type);
        }

        // Schauen ob sie in der Klasse deklariert ist, Feld bekommen welches aufgerufen wird
        try {
            var fieldVar = CheckType.getFieldInType(toCheck.name,
                    new ReferenceType(getClass.name), programEnvironment, getClass, toCheck.startLine);

            if (fieldVar != null) {
                if(!fieldVar.isStatic && methodIsStatic){
                    errors.add(new Exception("Error in line " + toCheck.startLine + ": non-static field variable " + toCheck.name + " cannot be referenced from a static context"));
                    return new TypeCheckResult(false, null);
                }
                //Schauen ob drauf zugreifen
                if (fieldVar.accessModifier == AccessModifier.PRIVATE) {
                    Type type = new ReferenceType(getClass.name);
                    var objectClass = (ReferenceType) type;
                    if (!(objectClass.getType().equals(getClass.name))) {
                        errors.add(new Exception("Error in line " + toCheck.startLine + ": the field " + objectClass.getType() + "." + toCheck.name + " is not visible"));
                        return new TypeCheckResult(false, null);
                    }
                }
                toCheck.type = fieldVar.type;
                toCheck.isStatic = fieldVar.isStatic;
                return new TypeCheckResult(true, fieldVar.type);
            }
        } catch (java.lang.Exception e) {
            errors.add(new Exception(e.getMessage()));
            return new TypeCheckResult(false, null);
        }
        try {
            var progEnvironment = programEnvironment.getClass(toCheck);
            toCheck.type = new ReferenceType(toCheck.name);
            toCheck.isStatic = true;
            return new TypeCheckResult(true, new ReferenceType(toCheck.name));
        }catch (java.lang.Exception i) {
            errors.add(new Exception(i.getMessage()));
            return new TypeCheckResult(false, null);
        }
    }


    @Override
    public TypeCheckResult typeCheck(InstVar toCheck) {
        var valid = true;

        //wenn weder Feld noch lokale Variable
        if(toCheck.expression instanceof LocalOrFieldVar l){
            if(currentScope.getLocalVar(l.name) == null && !getFields.contains(l.name)){ //If LocalOrFieldVar is no fieldvar and no localvar it could be a class name
                if(programEnvironment.getClasses().get(l.name) != null){
                    toCheck.expression = new Class(l.name, new ReferenceType(l.name)); //Replace LocalOrFieldVar with Class in AST
                }
                else{ // The provided identifier is none of the above: wrong input
                    errors.add(new Exception("Error in line " + toCheck.startLine + ": cannot find symbol " + l.name));
                    return new TypeCheckResult(false, null);
                }
            }
        }

        //Typ herausfinden
        var checkResult = toCheck.expression.accept(this);
        var type = checkResult.getType();
        if (type instanceof BasicType) {
            errors.add(new Exception("Error in line " + toCheck.startLine +
                    ": type " + type + " is a base type and does not offer any instance variables or methods"));
            valid = false;
        }
        try {
            var nextInstVar = CheckType.getFieldInType(toCheck.name, type,programEnvironment, this.getClass, toCheck.startLine);

            // Schauen ob es den Typ als Klasse gibt
            if (nextInstVar == null) {
                errors.add(
                        new Exception("Error in line " + toCheck.startLine + ": field variable " + toCheck.name + " not found in Class: " + type));
                valid = false;
            }
            //Schauen ob drauf zugreifen
            if (nextInstVar.accessModifier == AccessModifier.PRIVATE) {
                var objectClass = (ReferenceType) type;
                if (!(objectClass.getType().equals(getClass.name))) {
                    errors.add(new Exception("Error in line " + toCheck.startLine + ": the field " + objectClass.getType() + "." + toCheck.name + " is not visible"));
                    valid = false;
                }
            }

            if(toCheck.expression instanceof Class c && !nextInstVar.isStatic){
                errors.add(
                        new Exception("Error in line " + toCheck.startLine + ": non-static instance variable " + toCheck.name + " in class " + c.name + " cannot be referenced from a static context"));
                return new TypeCheckResult(false, null);
            }



            toCheck.isStatic = nextInstVar.isStatic;

            valid = valid && checkResult.isValid();
            var newType = nextInstVar == null ? null : nextInstVar.type;
            toCheck.type = newType;
            return new TypeCheckResult(valid, newType);
        } catch (java.lang.Exception e) {
            errors.add(new Exception(e.getMessage()));
            valid = false;
            return new TypeCheckResult(false, null);
        }
    }

    @Override
    public TypeCheckResult typeCheck(Binary toCheck) { //einfaches und und oder einfügen hier

        var valid = true;

        var lResult = toCheck.expression1.accept(this);
        currentNullType = toCheck.expression1.getType();
        var rResult = toCheck.expression2.accept(this);

        Type lType = toCheck.expression1.getType();
        Type rType = toCheck.expression2.getType();

        if (!lResult.isValid() || !rResult.isValid()) {
            return new TypeCheckResult(false, null); //Hat keine Typ deswegen null zurück geben
        }

        boolean sameType = lType.equals(rType); //Haben gleichen Typ
        boolean lIsReference = lType instanceof ReferenceType;
        boolean oneIsNull = lResult.getType() == null ^ rResult.getType() == null; //XOR wenn einer davon null;

        var errorToThrow = new Exception("Error in line " + toCheck.startLine +
                ": the operator: " + toCheck.operator + " is not defined for the argument types: "
                        + lType + ", " + rType);

        //Die Operatoren, welche wir unterstützen
        Operator operator = toCheck.operator;

        boolean isCompareOperator = (operator == Operator.EQUAL
                || operator == Operator.NOTEQUAL || operator == Operator.LESS
                || operator == Operator.LESSEQUAL || operator == Operator.GREATER
                || operator == Operator.GREATEREQUAL);

        boolean isLogicalOperator = (operator == Operator.AND || operator == Operator.OR);
        boolean isBinaryOperator = (operator == Operator.SINGLEAND || operator == Operator.SINGLEOR);
        boolean isArithmeticOperator = (operator == Operator.PLUS || operator == Operator.MINUS
                || operator == Operator.MULT || operator == Operator.DIV || operator == Operator.MOD);


        //Nur zwei gleiche Typen vergleichen
        if (sameType && !lIsReference) { // Wenn 2 gleiche BaseTypes miteinander verglichen werden
            var lBaseType = (BasicType) lType;
            switch (lBaseType) {
                case BOOL -> {
                    if (!isLogicalOperator && !isCompareOperator && !isBinaryOperator) {
                        errors.add(errorToThrow);
                        valid = false;
                    } else {
                        toCheck.type = BOOL;
                    }
                }
                case INT -> {
                    if (!isArithmeticOperator && !isCompareOperator && !isBinaryOperator) {
                        errors.add(errorToThrow);
                        valid = false;
                    } else {
                        if(isArithmeticOperator){
                            //variable = (condition ? valueIfTrue : valueIfFalse);
                            toCheck.type = INT;
                        }else if(isBinaryOperator){
                            toCheck.type = INT;
                        }else if(isCompareOperator){
                            toCheck.type = BOOL;
                        }
                    }
                }
                default -> {
                    errors.add(errorToThrow);
                    toCheck.type = VOID;
                    valid = false;
                }
            }
        } else if ((sameType || oneIsNull) && lIsReference) {// String usw vergleichen
            if (operator == Operator.EQUAL || operator == Operator.NOTEQUAL) {
                toCheck.type = BOOL;
            } else {
                errors.add(errorToThrow);
                valid = false;
            }
        }
        // 1=='a'
        else if (isCompareOperator && (Objects.equals(lType, CHAR)
                && Objects.equals(rType, INT)
                || Objects.equals(rType, CHAR)
                && Objects.equals(lType, INT))) {
            toCheck.type = BOOL;
        } else {
            errors.add(errorToThrow);
            toCheck.type = VOID;
            valid = false;
        }

        valid = valid && lResult.isValid() && rResult.isValid();

        return new TypeCheckResult(valid, toCheck.getType());


    }


    @Override
    public TypeCheckResult typeCheck(IntExpr toCheck) {
        return new TypeCheckResult(true, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(CharExpr charExpr) {
        return new TypeCheckResult(true, charExpr.getType());
    }

    @Override
    public TypeCheckResult typeCheck(BoolExpr boolExpr) {
        return new TypeCheckResult(true, boolExpr.getType());
    }

    @Override
    public TypeCheckResult typeCheck(StringExpr toCheck) {
        return new TypeCheckResult(true, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(Class toCheck) {
        if(programEnvironment.getClasses().get(toCheck.name) != null){
            return new TypeCheckResult(true, toCheck.getType());
        }
        errors.add(new Exception("There is no class with the name " + toCheck.name));
        return new TypeCheckResult(false, null);
    }
}
