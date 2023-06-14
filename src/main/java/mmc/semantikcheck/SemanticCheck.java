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

import java.util.*;

import static mmc.ast.BasicType.*;

public class SemanticCheck implements SemanticVisitor {

    public ProgramEnvironment programEnvironment;
    public ClassDecl getClass;
    public String fileName;
    public Type currentMethodReturnType;
    private Type currentNullType;
    private ScopeEnvironment currentScope;
    public ArrayList<Exception> errors = new ArrayList<>(); //Alle errors in einer Liste sammeln und am schluss raus geben
    public ArrayList<String> getFields = new ArrayList<>();

    public static boolean methodIsStatic;


    public static void main(String[] args) {
        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(
                Arrays.asList(new Field(new ReferenceType("java/lang/String"), "a", AccessModifier.PUBLIC, new StringExpr("Test"), false))
        ), new ArrayList<Method>(),
                new ArrayList<Constructor>());

        Program program = new Program(Arrays.asList(classDecl));
        generateTypedast(program);
    }

    public static Program generateTypedast(Program program) { //Erstelle getypter Baum
        SemanticCheck semanticCheck = new SemanticCheck();
        var result = program.accept(semanticCheck);
        if (result.isValid()) {
            return program; //Programm an ByteCode weitergeben
        } else { //Wenn nicht valide dann alle error Messages zurückgeben
            var errorString = "\n" + "\u001B[31m";
            for (int i = semanticCheck.errors.size() - 1; i >= 0; i--) {
                errorString += semanticCheck.errors.get(i).getMessage() + "\n";
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
        var valid = true;
        boolean typeExist;

        //Erst schauen ob Feldname schon existiert
        if (getFields.contains(toCheck.name)) {
            errors.add(new Exception("Field" + toCheck.name + " is already defined in" + getClass.name));
            valid = false;
        } else {
            getFields.add(toCheck.name); //Wenn nein zur Liste hinzufügen
        }

        //schauen ob Datentyp eine andere Klasse ist oder die BasicTypes
        if (toCheck.getType() instanceof BasicType) {
            typeExist = true;
        }
        else{
            var fieldType = (ReferenceType) toCheck.getType();
            var programmClasses = programEnvironment.getClasses();
            typeExist = programmClasses.containsKey(fieldType.type);
        }

        //Für Zuweisungen, schauen ob Zuweisung zum DatenTyp passt
        if(toCheck.expression != null && toCheck.type instanceof BasicType){ //TODO: Bitte auch referenz Typen checken, z.B. darf bei Objekten nur new mit dem gleichen Typ wie auf der variablentyp stehen, bei Strings darf außerdem noch eine StringExpr stehen
            var expressionResult = toCheck.expression.accept(this);
            if(toCheck.type != expressionResult.getType()){
                errors.add(new Exception("Field expected " + toCheck.type + " but got " + expressionResult.getType()));
                valid = false;
            }
        }else if(toCheck.expression != null && toCheck.type instanceof ReferenceType){
            var expressionResult = toCheck.expression.accept(this);
            if(!Objects.equals(((ReferenceType) toCheck.type).type, ((ReferenceType) expressionResult.getType()).type)){
                errors.add(new Exception("Field expected " + ((ReferenceType) toCheck.type).type + " but got " + ((ReferenceType) expressionResult.getType()).type));
                valid = false;
            }
        }
        valid = valid && typeExist;
        return new TypeCheckResult(valid, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(Constructor toCheck) {
        boolean valid = true;

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
            errors.add(new Exception(
                    "Constructor have no return Type"));
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
                errors.add(new Exception("Method " + toCheck.name + " is already defined in class "+ getClass.name));
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
            errors.add(new Exception("Method-Declaration " + toCheck.name + " with type "
                    + toCheck.getType() + " has at least one Mismatching return Type"));
            valid = false;
        }
        return new TypeCheckResult(valid, resultType);
    }

    @Override
    public TypeCheckResult typeCheck(Assign toCheck) { //int a = 5;
        boolean valid = true;

        IExpression lExpr = toCheck.leftExpr;
        IExpression rExpr = toCheck.rightExpr;

        //a = a;
        if (lExpr.equals(rExpr)) {
            errors.add(new Exception("Cannot assign to self"));
            valid = false;
        }

        var leftExpr = lExpr.accept(this);
        currentNullType = leftExpr.getType();
        var rightExpr = rExpr.accept(this);

        //int a += a; a -= a; a *= a; a /= a, nur auf Integer anwenden
        if(toCheck.operator != Operator.ASSIGN){
            if(leftExpr.getType() != INT && rightExpr.getType() != INT){
                errors.add(new Exception("Mismatch types in Assign-Statement: Both Types need to be Integer and not"
                        + leftExpr.getType() + " and "
                        + rightExpr.getType()));
                valid = false;
            }
        }
        else{
            toCheck.type = lExpr.getType();
        }

        //int a = "Hello";
        if (!Objects.equals(lExpr.getType(), rExpr.getType())) {
            errors.add(new Exception("Mismatch types in Assign-Statement: cannot convert from "
                    + leftExpr.getType() + " to "
                    + rightExpr.getType()));
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
            errors.add(new Exception("Type: " + toCheck.getType() + " is unknown"));
            return new TypeCheckResult(false, toCheck.getType());
        }
    }

    @Override
    public TypeCheckResult typeCheck(While toCheck) {
        var valid = true;
        var isConditionBool = toCheck.expression.accept(this);

        valid = valid && isConditionBool.isValid();

        //Schauen ob das in der While Schleife ein Bool ist
        boolean isBool = Objects.equals(BOOL, isConditionBool.getType());

        if (!isBool) { //Wenn kein bool enthalten ist
            errors.add(
                    new Exception(
                            "While Condition expected " + BOOL + " but got " + isConditionBool.getType()));
            valid = false;
        }

        //Check Block/Statement
        var statementResult = toCheck.statement.accept(this);
        toCheck.type = statementResult.getType();
        valid = valid && isConditionBool.isValid() && statementResult.isValid() && isBool;
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

        var conditionResult = toCheck.condition.accept(this);
        valid = valid && conditionResult.isValid();

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
            toCheck.type = toCheck.expression.getType();
        }
        if (currentMethodReturnType != null && !currentMethodReturnType.equals(toCheck.getType())) {
            //Wenn die aktuelle Methode einen Return Type hat aber nicht zu dem Return Typ passt exception
            errors.add(
                    new Exception("Return-Type mismatch:  cannot convert from " + returnExpression.getType()
                            + " to " + currentMethodReturnType));
            valid = false;
            return new TypeCheckResult(valid, returnExpression.getType());
        }

        return new TypeCheckResult(valid, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(LocalVarDecl toCheck) {
        //int x;
        var valid = true;
        //public void foo(){
        //		doodlesack i; //Type Doodlesack, i name, expression null
        //		return;
        //	}
        if (toCheck.expression != null) {
            var checkResult = toCheck.expression.accept(this);
            var resultType = toCheck.expression.getType();
            valid = checkResult.isValid() && valid;

            if (!Objects.equals(resultType, toCheck.getType())) { //Expression muss zum LocalVar Typ passen
                errors.add(new Exception(
                        "Type mismatch: cannot convert from " + resultType + " to " + toCheck.getType()));
                valid = false;
            }
        }

        try {
            if(toCheck.type instanceof ReferenceType) {
                CheckType.getClassInType(toCheck, programEnvironment); //schauen ob es den Typ überhaupt gibt
            }
            currentScope.addLocalVar(toCheck);
        } catch (java.lang.Exception e) {
            errors.add(new Exception(e.getMessage() +  fileName));
            valid = false;
        }
        return new TypeCheckResult(valid, null);
    }

    @Override
    public TypeCheckResult typeCheck(If toCheck) {
        var valid = true;

        //if Block überprüfen
        var ifResult = toCheck.blockIf.accept(this);
        var ifBlockType = ifResult.getType();
        valid = valid && ifResult.isValid();

        // Condition überprüfen
        var expressionResult = toCheck.expression.accept(this);
        valid = valid && expressionResult.isValid();
        boolean isBool = Objects.equals(BasicType.BOOL,toCheck.expression.getType());
        if (!isBool) {
            errors.add(
                    new Exception(
                            "If Condition expected " + BasicType.BOOL + " but got " + expressionResult.getType()));
            valid = false;
        }

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

            } else if (ifBlockType != null && elseBlockType != null) {
                // Typen müssen übereinstimmen
                if (!Objects.equals(elseBlockType, ifBlockType)) {
                    errors.add(new Exception(
                            "Type mismatch: cannot convert from " + elseBlockType + " to " + ifBlockType));
                    valid = false;
                } else {
                    toCheck.type = ifBlockType;
                    //Falls der Typ gleich ist, wählt er den Typ vom if Block
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

            TypeCheckResult checkResult = statement.accept(this);
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

        var receiver = toCheck.methodOwnerPrefix.accept(this);

        valid = valid && receiver.isValid();

        for (var parameter : toCheck.arguments) {
            valid = valid && parameter.accept(this).isValid();
        }
        try {
            boolean isStatic = false;
            if(toCheck.methodOwnerPrefix instanceof LocalOrFieldVar) {
                isStatic = ((LocalOrFieldVar) toCheck.methodOwnerPrefix).isStatic;
            }
            var method = CheckType.getMethodInType(toCheck, toCheck.methodOwnerPrefix.getType(), programEnvironment, getClass, isStatic);
            toCheck.type = method.getType();
            toCheck.isStatic = method.getIsStatic();
            return new TypeCheckResult(valid, null);

        } catch (java.lang.Exception e) {
            errors.add(new Exception(e.getMessage()));
            return new TypeCheckResult(false, null);
        }
    }

    @Override
    public TypeCheckResult typeCheck(Crement toCheck) { //Erweitern
        boolean valid = true;
        toCheck.expression.accept(this);
        Type expressionType = toCheck.expression.getType();

        if (expressionType instanceof BasicType && (((BasicType) expressionType) == INT
                || ((BasicType) expressionType) == CHAR)) {
            toCheck.type = toCheck.expression.getType();
        } else {
            valid = false;
            errors.add(new Exception("The Operator: " + toCheck.operator
                    + " is undefined for the argument type: " + toCheck.expression.getType()));
        }
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
            errors.add(new Exception("Cannot use this in a static context"));
            return new TypeCheckResult(false, toCheck.getType());
        }
        toCheck.setType(getClass.name);
        return new TypeCheckResult(true, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(JNull toCheck) {
        if (currentNullType != null) {
            var assignType = currentNullType;
            if (assignType != null) {
                toCheck.type = assignType;
            }
        } else {
            toCheck.type = null;
        }
        return new TypeCheckResult(true, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(LocalOrFieldVar toCheck) {

        //Muss erstmal schauen ob sie im Scope deklariert ist
        Type localVar = currentScope.getLocalVar(toCheck.name);

        if (localVar != null) {
            toCheck.type = localVar;
            return new TypeCheckResult(true, localVar);
        }

        // Schauen ob sie in der Klasse deklariert ist, Feld bekommen welches aufgerufen wird
        try {
            var fieldVar = CheckType.getFieldInType(toCheck.name,
                    new ReferenceType(getClass.name), programEnvironment, getClass, false);

            if (fieldVar != null) {
                toCheck.type = fieldVar.getType();
                toCheck.isStatic = fieldVar.getIsStatic();
                return new TypeCheckResult(true, fieldVar.getType());
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

        //Typ herausfinden
        var checkResult = toCheck.expression.accept(this);
        var type = checkResult.getType();
        if (type instanceof BasicType) {
            errors.add(new Exception(
                    "Type: " + type + ", is a BaseType and does not offer any Instance Variables or Methods"));
            valid = false;
        }
        try {
            boolean isStatic = false;
            if(toCheck.expression instanceof LocalOrFieldVar) {
                isStatic = ((LocalOrFieldVar) toCheck.expression).isStatic;
            }
            var nextInstVar = CheckType.getFieldInType(toCheck.name, type,programEnvironment, this.getClass, isStatic);

            // Schauen ob es den Typ als Klasse gibt
            if (nextInstVar == null) {
                errors.add(
                        new Exception("Field: " + toCheck.name + " not found in Class: " + type));
                valid = false;
            }

            toCheck.isStatic = nextInstVar.getIsStatic();

            valid = valid && checkResult.isValid();
            var newType = nextInstVar == null ? null : nextInstVar.getType();
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

        if (lType == null || rType == null) {
            return new TypeCheckResult(false, null); //Hat keine Typ deswegen null zurück geben
        }

        boolean isSame = lType.equals(rType);
        boolean lIsReference = lType instanceof ReferenceType;
        boolean oneIsNull = lResult.getType() == null ^ rResult.getType() == null;

        var errorToThrow = new Exception(
                "The Operator: " + toCheck.operator + " is undefined for the argument types: "
                        + lType + ", " + rType);

        //Die Operatoren, welche wir unterstützen
        Operator operator = toCheck.operator;

        boolean isCompareOperator = (toCheck.operator == Operator.EQUAL
                || operator == Operator.NOTEQUAL || operator == Operator.LESS
                || operator == Operator.LESSEQUAL || operator == Operator.GREATER
                || operator == Operator.GREATEREQUAL);

        boolean isLogicalOperator = (operator == Operator.AND || operator == Operator.OR);
        boolean isBinaryOperator = (operator == Operator.SINGLEAND || operator == Operator.SINGLEOR);
        boolean isArithmeticOperator = (operator == Operator.PLUS || operator == Operator.MINUS
                || operator == Operator.MULT || operator == Operator.DIV || operator == Operator.MOD);


        //Nur zwei gleiche Typen vergleichen
        if (isSame && !lIsReference) { // Wenn 2 gleiche BaseTypes miteinander verglichen werden
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
        } else if ((isSame || oneIsNull) && lIsReference) {// Wenn 2 Objekte miteinander verglichen werden
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
        return new TypeCheckResult(true, toCheck.getType());
    }
}
