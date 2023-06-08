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


    public static void main(String[] args) {
        Method method = new Method(BasicType.INT, "loop", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("x", BasicType.INT, new IntExpr(5)),
                        new While(new Binary(Operator.LESS, new LocalOrFieldVar("x"), new IntExpr(0)),
                                new Assign(new LocalOrFieldVar("x"), new Binary(Operator.MINUS, new LocalOrFieldVar("x"), new IntExpr(1)), null)
                        ), new Return(BasicType.INT, new LocalOrFieldVar("x"))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT, "f", AccessModifier.PUBLIC, new IntExpr(0), false))), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));
        Program pr = generateTypedast(prog);
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
        toCheck.programEnvironment = programEnvironment;

        currentScope = new ScopeEnvironment();

        for (var classes : toCheck.classes) { //Geht durch alle Klassen und checkt ob sie valide sind
            valid = classes.accept(this).isValid() && valid;
        }
        return new TypeCheckResult(valid, null);
    }

    @Override
    public TypeCheckResult typeCheck(ClassDecl toCheck) {
        var valid = true;

        this.getClass = toCheck; //Für die Umgebung merken welche Klasse gerade

        if (fileName == null) {
            this.fileName = toCheck.name + ".java";
        }

        if (toCheck.constructors.isEmpty()) { //Konstruktoren überprüfen
            new Constructor().accept(this);
        } else {
            for (Constructor constructor : toCheck.constructors) { //Für jede Klasse Konstruktor überprüfen
                valid = constructor.accept(this).isValid() && valid;
            }
        }

        //Felder überprüfen
        List<String> fieldNames = new ArrayList<>();
        getFields.clear(); //Einmal Liste leeren
        for (Field field : toCheck.fields) {
            var result = field.accept(this);
            valid = valid && result.isValid();
            if (valid) {
                fieldNames.add(field.name); //Wenn feld valid in identifier speichern
            }
        }

        //Methoden überprüfen
        for (Method method : toCheck.methods) {
            valid = method.accept(this).isValid() && valid; //Für jede Methode durchgehen und schauen
        }

        return new TypeCheckResult(valid, new ReferenceType(toCheck.name));
    }


    @Override
    public TypeCheckResult typeCheck(Field toCheck) {
        var valid = true;
        boolean typeExist;

        if (getFields.contains(toCheck.name)) { //Schaut ob der Feldname schon existiert
            errors.add(new Exception("Field" + toCheck.name + " is already defined"));
            valid = false;
        } else {
            getFields.add(toCheck.name); //Wenn nein fügt er ihn zur Liste
        }
        if (toCheck.getType() instanceof BasicType) {
            typeExist = true;
        }
        else{
            var objectClass = (ReferenceType) toCheck.getType();
            var declaredClassnames = programEnvironment.getClasses();
            typeExist = declaredClassnames.containsKey(objectClass.type);
        }
        valid = valid && typeExist;
        return new TypeCheckResult(valid, toCheck.getType());
    }


    @Override
    public TypeCheckResult typeCheck(Constructor toCheck) {
        boolean valid = true;

        currentScope.pushScope();

        for (Parameter parameter : toCheck.parameters) { //Für jeden Parameter im Konstruktor durchgehen
            var result = parameter.accept(this);
            valid = valid && result.isValid();
            currentScope.addLocalVar(parameter); //Schauen ob im Scope
        }

        currentMethodReturnType = BasicType.VOID;
        var result = toCheck.statement.accept(this);
        currentScope.popScope();
        if (result.getType() != null && result.getType() != VOID) { //Wenn der Konstruktor einen Typ mitgegeben bekommt
            errors.add(new Exception(
                    "Constructor have no return Type"));
            valid = false;
        }
        valid = valid && result.isValid();
        return new TypeCheckResult(valid, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(Method toCheck) {
        var valid = true;

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

        currentScope.pushScope(); //Auf Stack tun

        for (var parameter : toCheck.parameters) { //Alle Parameter in einer Methode durchgehen
            var result = parameter.accept(this);
            valid = valid && result.isValid();
            currentScope.addLocalVar(parameter);
        }

        currentMethodReturnType = toCheck.getType();
        currentNullType = currentMethodReturnType; // Solange nicht in Assign oder MethodCall dieser Typ
        // gesetzt ist, ist dieser der Rückgabewert der Methode
        var result = toCheck.statement.accept(this);
        valid = valid && result.isValid();
        currentScope.popScope(); //Stack runter nehmen

        var resultType = result.getType();
        if(resultType == null){
            resultType = VOID;
        }
        if (!resultType.equals(toCheck.getType())) { //Error wenn statement und Method nicht gleiche Typen haben
            errors.add(new Exception("Method-Declaration " + toCheck.name + " with type "
                    + toCheck.getType() + " has at least one Mismatching return Type:"));
            valid = false;
        }
        return new TypeCheckResult(valid, resultType);
    }

    @Override
    public TypeCheckResult typeCheck(Assign toCheck) { //int a = 5;
        boolean valid = true;
        IExpression lExpr = toCheck.leftExpr;
        var oldNullType = currentNullType;
        currentNullType = toCheck.leftExpr.getType();
        IExpression rExpr = toCheck.rightExpr;
        currentNullType = oldNullType;

        //a = a;
        if (lExpr.equals(rExpr)) {
            errors.add(new Exception("Cannot assign to self"));
            valid = false;
        }

        var leftExpr = lExpr.accept(this);
        currentNullType = leftExpr.getType();
        var rightExpr = rExpr.accept(this);

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

        var boolType = BOOL;
        var isEqual = Objects.equals(boolType, isConditionBool.getType());

        if (!isEqual) { //Wenn kein bool zurück kam ist valid false
            errors.add(
                    new Exception(
                            "While Condition expected " + BOOL + " but got " + isConditionBool.getType()));
            valid = false;
        }

        //Check Block
        var blockResult = toCheck.statement.accept(this);
        toCheck.type = blockResult.getType();
        valid = valid && isConditionBool.isValid() && blockResult.isValid() && isEqual;
        return new TypeCheckResult(valid, blockResult.getType());
    }

    @Override
    public TypeCheckResult typeCheck(For toCheck) {
        var valid = true;

        currentScope.pushScope();
        TypeCheckResult initResult = toCheck.initStatement.accept(this);
        TypeCheckResult condResult = toCheck.condition.accept(this);
        TypeCheckResult updateResult = toCheck.updateStatement.accept(this);

        valid = valid && initResult.isValid() && condResult.isValid() && updateResult.isValid();

        var bodyResult = toCheck.statementBlock.accept(this);
        currentScope.popScope();
        valid = valid && bodyResult.isValid();
        toCheck.type = bodyResult.getType();
        return new TypeCheckResult(valid, bodyResult.getType());
    }

    @Override
    public TypeCheckResult typeCheck(Return toCheck) {
        TypeCheckResult returnExpression;

        //Kein Return
        if (toCheck.expression == null) {
            returnExpression = new TypeCheckResult(true, BasicType.VOID);
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
            return new TypeCheckResult(false, returnExpression.getType());
        }

        return new TypeCheckResult(true, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(LocalVarDecl toCheck) {
        //int x;
        var valid = true;

        if (toCheck.expression != null) {
            TypeCheckResult result = toCheck.expression.accept(this);
            Type resultType = toCheck.expression.getType();
            valid = result.isValid() && valid;

            if (!Objects.equals(resultType, toCheck.getType())) { //Expression muss zum LocalVar Typ passen
                errors.add(new Exception(
                        "Type mismatch: cannot convert from " + resultType + " to " + toCheck.getType()));
                valid = false;
            }
        }

        try {
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
        valid = valid && ifResult.isValid();

        // Condition überprüfen
        valid = valid && toCheck.expression.accept(this).isValid();
        if (BOOL != toCheck.expression.getType()) {
            errors.add(
                    new Exception(
                            "If Condition expected " + BOOL + " but got " + toCheck.expression.accept(this).getType()));
            valid = false;
        }

        // else überprüfen
        if (toCheck.blockElse != null) { //Wenn es ein else block gibt dann..

            var elseBlockResult = toCheck.blockElse.accept(this);
            valid = valid && elseBlockResult.isValid();
            var elseBlockType = elseBlockResult.getType();

            // Folgendes if else ist für die Bestimmung des Rückgabetyps
            if (ifResult == null && elseBlockType != null) {
                //Falls if keinen return Typ nehmen wir den Typ von else
                toCheck.type = elseBlockType;
            } else if (ifResult != null && elseBlockType == null) {
                //Falls else keinen return Typ nehmen wir den Typ von if
                toCheck.type = ifResult.getType();

            } else if (ifResult != null && elseBlockType != null) { // Typen müssen sollen übereinstimmen
                if (!Objects.equals(elseBlockType, ifResult)) {
                    errors.add(new Exception(
                            "Type mismatch: cannot convert from " + elseBlockType + " to " + ifResult.getType()));
                    valid = false;
                } else {
                    toCheck.type = ifResult.getType(); // Falls der Typ gleich ist, wählt er den Typ vom if Block
                }
            }
        } else {
            toCheck.type = ifResult.getType(); //Wenn kein else ist if der Typ der weitergegeben wird
        }

        return new TypeCheckResult(valid, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(Block toCheck) {
        var valid = true;
        Type blockReturnType = null;
        currentScope.pushScope();

        for (var statement : toCheck.statements) { //jedes statement im Block durchgehen

            TypeCheckResult result = statement.accept(this);
            Type statementReturnType = result.getType();

            if (statementReturnType != null) { //keine änderung des Block Return Typs

                if (blockReturnType == null) { //Setzen den Return Type wenn null
                    blockReturnType = result.getType();
                } else {
                    if (!blockReturnType.equals(result.getType())) { // wenn es 2 verschiedene return Types gibt error
                        errors.add(new Exception(
                                "Return types are mismatching in a single Block, got:" + blockReturnType
                                        + " and " + result.getType()));
                        valid = false;
                    }
                }

            }
            valid = valid && result.isValid();
            toCheck.type = blockReturnType;
        }

        currentScope.popScope();
        return new TypeCheckResult(valid, blockReturnType);
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
            var objectClass = (ReferenceType) toCheck.getType();
            var declaredClassnames = programEnvironment.getClasses();
            typeExist = declaredClassnames.containsKey(objectClass.type);
        }
        if (!typeExist) {
            errors.add(new Exception("Type: " + newClass + " is unknown"));
            valid = false;
        }

        for (var arguments : toCheck.arguments) {
            var result = arguments.accept(this);
            valid = valid && result.isValid();
        }

        try {
            CheckType.getConstructor(toCheck, programEnvironment);
        } catch (java.lang.Exception e) {
            errors.add(new Exception(e.getMessage()));
            valid = false;
        }

        return new TypeCheckResult(valid, null);
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
            var parameterResult = parameter.accept(this);
            valid = valid && parameterResult.isValid();
        }
        try {
            var method = CheckType.getMethodInType(toCheck, toCheck.methodOwnerPrefix.getType(), programEnvironment, this.getClass);
            var returnType = method.getType();
            toCheck.type = returnType;
            return new TypeCheckResult(valid, null);

        } catch (java.lang.Exception e) {
            errors.add(new Exception(e.getMessage()));
            return new TypeCheckResult(false, null);

        }
    }

    @Override
    public TypeCheckResult typeCheck(Crement toCheck) {
        boolean valid = true;
        toCheck.expression.accept(this);
        Type type = toCheck.expression.getType();

        if (type instanceof BasicType && (((BasicType) type) == INT
                || ((BasicType) type) == CHAR)) {
            toCheck.type = toCheck.expression.getType();
        } else {
            valid = false;
            errors.add(new Exception("The Operator: " + toCheck.operator
                    + " is undefined for the argument type: " + toCheck.expression.getType()));
        }
        return new TypeCheckResult(valid, null);
    }

    @Override
    public TypeCheckResult typeCheck(Unary toCheck) {
        var valid = true;

        var result = toCheck.expression.accept(this);
        valid = valid && result.isValid();

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

        // Schauen ob sie in der Klasse deklariert ist
        try {
            var fieldVar = CheckType.getFieldInType(toCheck.name,
                    new ReferenceType(this.getClass.name), programEnvironment, this.getClass);

            if (fieldVar != null) {
                toCheck.type = fieldVar.getType();
                return new TypeCheckResult(true, fieldVar.getType());
            }
        } catch (java.lang.Exception e) {
            errors.add(new Exception(e.getMessage()));
            return new TypeCheckResult(false, null);
        }
        errors.add(new Exception(
                "Variable: " + toCheck.name + " is not declared in this scope"));
        return new TypeCheckResult(false, null);
    }


    @Override
    public TypeCheckResult typeCheck(InstVar toCheck) {
        var valid = true;

        var result = toCheck.expression.accept(this); // Hier steht der typ drinne von dem der identifier ist...
        var type = result.getType();
        if (type instanceof BasicType) {
            errors.add(new Exception(
                    "Type: " + type + ", is a BaseType and does not offer any Instance Variables or Methods"));
            valid = false;
        }
        try {

            var nextInstVar = CheckType.getFieldInType(toCheck.name, type,programEnvironment, this.getClass);

            // Check if the identifier exists in current Type
            if (nextInstVar == null) {
                errors.add(
                        new Exception("Field: " + toCheck.name + " not found in Class: " + type));
                valid = false;
            }
            valid = valid && result.isValid();
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
    public TypeCheckResult typeCheck(Binary binary) {

        var valid = true;

        var lResult = binary.expression1.accept(this);
        var oldNullType = currentNullType;
        currentNullType = binary.expression1.getType();
        var rResult = binary.expression2.accept(this);
        currentNullType = oldNullType;

        final Type lType = binary.expression1.getType();
        final Type rType = binary.expression2.getType();

        var errorToThrow = new Exception(
                "The Operator: " + binary.operator + " is undefined for the argument types: "
                        + lType + ", " + rType);

        // Following vars are there to determine the type of the binary expression
        final Operator operator = binary.operator;

        final boolean isCompareOperator = (binary.operator == Operator.EQUAL
                || operator == Operator.NOTEQUAL || operator == Operator.LESS
                || operator == Operator.LESSEQUAL || operator == Operator.GREATER
                || operator == Operator.GREATEREQUAL);

        final boolean isLogicalOperator = (operator == Operator.AND || operator == Operator.OR);
        final boolean isArithmeticOperator = (operator == Operator.PLUS || operator == Operator.MINUS
                || operator == Operator.MULT || operator == Operator.DIV || operator == Operator.MOD);

        final boolean isSame = lType.equals(rType);
        final boolean lIsReference = lType instanceof ReferenceType;
        final boolean oneIsNull = lResult.getType() == null ^ rResult.getType() == null;
        // Unser Compiler kann ja nur BaseType-Operatoren verarbeiten und auch nur 2
        // gleiche Typen
        if (isSame && !lIsReference) { // Wenn 2 gleiche BaseTypes miteinander verglichen werden
            var lBaseType = (BasicType) lType;
            switch (lBaseType) {
                case BOOL -> {
                    if (!isLogicalOperator && !isCompareOperator) {
                        errors.add(errorToThrow);
                        valid = false;
                    } else {
                        binary.type = BOOL;
                    }
                }
                case INT -> {
                    if (!isArithmeticOperator && !isCompareOperator) {
                        errors.add(errorToThrow);
                        valid = false;
                    } else {
                        binary.type = (isArithmeticOperator ? INT : BOOL);
                    }
                }
                default -> {
                    errors.add(errorToThrow);
                    binary.type = VOID;
                    valid = false;
                }
            }
        } else if ((isSame || oneIsNull) && lIsReference) {// Wenn 2 Objekte miteinander verglichen werden
            if (operator == Operator.EQUAL || operator == Operator.NOTEQUAL) {
                binary.type = BOOL;
            } else {
                errors.add(errorToThrow);
                valid = false;
            }
        } else if (isCompareOperator && (Objects.equals(lType, CHAR)
                && Objects.equals(rType, INT)
                || Objects.equals(rType, CHAR)
                && Objects.equals(lType, INT))) { // Wenn
            // z.B.
            // 1=='a'...
            binary.type = BOOL;
        } else {
            errors.add(errorToThrow);
            binary.type = VOID;
            valid = false;
        }

        valid = valid && lResult.isValid() && rResult.isValid();

        return new TypeCheckResult(valid, binary.getType());
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
