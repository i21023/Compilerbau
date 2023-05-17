package mmc.semantikcheck;

import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.ast.expressions.*;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.*;

import java.util.*;

import static mmc.ast.BasicType.*;

public class SemanticCheck implements SemanticVisitor {

    public ClassDecl getClass;
    public String fileName;
    public Type currentMethodReturnType;
    private Type currentNullType;
    public ArrayList<Exception> errors = new ArrayList<>();
    public ArrayList<String> getFields = new ArrayList<>();

    public List<Field> classContainField = new ArrayList<>();
    public List<ClassDecl> getClasses = new ArrayList<>();
    private InScope isInScope;

    /*public static void main(String[] args) {
        ArrayList<ClassDecl> classDeclList = new ArrayList<>();
        var program = new Program(classDeclList);
        SemanticCheck semanticVisitor = new SemanticCheck();
        TypeCheckResult typeCheck = program.accept(semanticVisitor); //TypeCheckResult als rückgabe
    }*/

    public static Program generateTypedast(Program program) { //Erstelle getypter Baum
        SemanticCheck semanticCheck = new SemanticCheck();
        var result = program.accept(semanticCheck);
        if (result.isValid()) {
            return program;
        } else {
            String ANSI_RESET = "\u001B[0m";
            String ANSI_RED = "\u001B[31m";
            var errorString = "\n" + ANSI_RED;
            for (int i = semanticCheck.errors.size() - 1; i >= 0; i--) {
                errorString += semanticCheck.errors.get(i).getMessage() + "\n";
            }
            throw new Exception(errorString + ANSI_RESET);
        }
    }

    @Override
    public TypeCheckResult typeCheck(Program toCheck) {
        boolean valid = true;
        getClasses = toCheck.classes;
        //Nur auf Programm konzentrieren
        for (var classes : toCheck.classes) { //Geht durch alle Klassen und checkt sie
            valid = classes.accept(this).isValid() && valid;
        }
        return new TypeCheckResult(valid, null);
    }

    @Override
    public TypeCheckResult typeCheck(ClassDecl toCheck) {
        this.getClass = toCheck; // For the Class-Context
        if (fileName == null) {
            this.fileName = toCheck.name + ".java";
        }
        List<String> identifiers = new ArrayList<>();
        var valid = true;
        getFields.clear();
        classContainField = toCheck.fields;
        for (Field field : toCheck.fields) {
            var result = field.accept(this);
            valid = valid && result.isValid();
            if (valid) {
                identifiers.add(field.name);
            }
        }

        if (toCheck.constructors.isEmpty()) {
            new Constructor().accept(this);
        } else {
            for (Constructor constructor : toCheck.constructors) {
                valid = constructor.accept(this).isValid() && valid;
            }
        }
        for (Method method : toCheck.methods) {
            valid = method.accept(this).isValid() && valid;
        }

        return new TypeCheckResult(valid, new ReferenceType(toCheck.name));
    }


    @Override
    public TypeCheckResult typeCheck(Field toCheck) {
        var valid = true;
        if (getFields.contains(toCheck.name)) { //Schaut ob der Feldname schon existiert
            errors.add(new Exception("Field " + toCheck.name + " is already defined in class "));
            valid = false;
        } else {
            getFields.add(toCheck.name); //Wenn nein fügt er in zur Liste
        }
        var result = toCheck.accept(this);
        valid = valid && result.isValid();
        return new TypeCheckResult(valid, toCheck.getType());
    }


    @Override
    public TypeCheckResult typeCheck(Constructor toCheck) { //TypeCheck(Parameter) { Expression }
        boolean valid = true;
        isInScope.pushScope();
        for (Parameter parameter : toCheck.parameters) { //Für jeden Parameter durchgehen
            var result = parameter.accept(this);
            valid = valid && result.isValid();
            isInScope.addLocalVar(parameter);
        }
        var result = toCheck.statement.accept(this);
        isInScope.popScope();
        if (result.getType() != null) { //Wenn der Konstruktor einen Typ mitgegeben bekommt
            errors.add(new Exception(
                    "Constructor have no return - Type "));
            valid = false;
        }
        valid = valid && result.isValid();
        return new TypeCheckResult(valid, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(Method toCheck) {
        var valid = true;

        for (var otherMethod : this.getClass.methods) {
            if (otherMethod.equals(toCheck))
                break;
            if (otherMethod.isSameDeclaration(toCheck)) {
                errors.add(new Exception(
                        "Method " + toCheck.name + " is already defined in class "
                                + getClass.name));
                valid = false;
            }
        }

        isInScope.pushScope();

        for (var parameter : toCheck.parameters) {
            var result = parameter.accept(this);
            valid = valid && result.isValid();
            isInScope.addLocalVar(parameter);
        }

        currentMethodReturnType = toCheck.getType();
        currentNullType = currentMethodReturnType; // Solange nicht in einem Assign oder Methoden-Aufruf dieser Typ
        // gesetzt ist, ist dieser der Rückgabewert der Methode
        var result = toCheck.statement.accept(this);
        valid = valid && result.isValid();
        isInScope.popScope();
        var resultType = result.getType();
        if (!resultType.equals(toCheck.getType())) {
            errors.add(new Exception("Method-Declaration " + toCheck.name + " with type "
                    + toCheck.getType() + " has at least one Mismatching return Type:"));
            valid = false;
        }
        return new TypeCheckResult(valid, resultType);
    }

    @Override
    public TypeCheckResult typeCheck(Assign toCheck) {
        boolean valid = true;
        var leftExpr = toCheck.leftExpr.accept(this);
        var rightExpr = toCheck.rightExpr.accept(this);

        if (leftExpr.equals(rightExpr)) {
            errors.add(new Exception("Cannot assign to self"));
            valid = false;
        }

        if (!Objects.equals(leftExpr.getType(), rightExpr.getType())) {
            errors.add(new Exception("Mismatch types in Assign-Statement: cannot convert from \"" + leftExpr.getType() + "\" to \""
                    + rightExpr.getType() + "\""));
            valid = false;
        } else {
            toCheck.type = leftExpr.getType();
        }
        valid = leftExpr.isValid() && rightExpr.isValid();
        valid = valid && Objects.equals(leftExpr, rightExpr);
        return new TypeCheckResult(valid, null);
    }

    @Override
    public TypeCheckResult typeCheck(Parameter toCheck) { // nochmal anschauen
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(While toCheck) {
        // check type in the while expression/condition
        var valid = true;
        var conditionBool = toCheck.expression.accept(this);
        valid = valid && conditionBool.isValid();
        if (!valid) { //Wenn kein bool zurück kam ist valid false und geht hier rein
            errors.add(
                    new Exception(
                            "While Condition expected " + BOOL + " but got " + conditionBool.getType()));
            valid = false;
        }
        var blockResult = toCheck.statement.accept(this);
        toCheck.type = blockResult.getType();
        valid = valid && conditionBool.isValid() && blockResult.isValid() && conditionBool.isValid();
        return new TypeCheckResult(valid, blockResult.getType());
    }

    @Override
    public TypeCheckResult typeCheck(For forStmt) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(Return toCheck) {
        TypeCheckResult returnExpression;

        // Following check is needed for a void return (void foo(){return;})
        if (toCheck.expression == null) {
            returnExpression = new TypeCheckResult(true, BasicType.VOID);
            toCheck.type = BasicType.VOID;
        } else {
            returnExpression = toCheck.expression.accept(this);
            toCheck.type = toCheck.expression.getType();
        }
        if (currentMethodReturnType != null && !currentMethodReturnType.equals(toCheck.getType())) {
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

            var resultType = toCheck.expression.getType();
            valid = result.isValid() && valid;

            if (!Objects.equals(resultType, toCheck.getType())) {
                errors.add(new Exception(
                        "Type mismatch: cannot convert from " + resultType + " to " + toCheck.getType()));
                valid = false;
            }

        }

        try {
            isInScope.addLocalVar(toCheck);
        } catch (java.lang.Exception e) {
            errors.add(new Exception(e.getMessage() + fileName));
            valid = false;
        }
        return new TypeCheckResult(valid, null);
    }

    @Override
    public TypeCheckResult typeCheck(If toCheck) {

        var valid = true;
        // check the Condition
        var conditionResult = toCheck.expression.accept(this);
        valid = valid && conditionResult.isValid();
        if (BOOL != toCheck.expression.getType()) {
            errors.add(
                    new Exception(
                            "If Condition expected " + BOOL + " but got " + conditionResult.getType()));
            valid = false;
        }

        // check the if block
        var ifBlockResult = toCheck.blockIf.accept(this);
        valid = valid && ifBlockResult.isValid();

        // check the else block
        if (toCheck.blockElse != null) {
            var elseBlockResult = toCheck.blockElse.accept(this);
            valid = valid && elseBlockResult.isValid();
            var elseType = elseBlockResult.getType();

            // Folgendes if else ist für die Bestimmung des Rückgabetyps
            if (ifBlockResult.getType() == null && elseType != null) { // Falls einer der Blöcke keinen return type hat,
                // dann wird der Rückgabetyp des anderen gewählt
                toCheck.type = elseType;
            } else if (ifBlockResult.getType() != null && elseType == null) {
                toCheck.type = ifBlockResult.getType();
            } else if (ifBlockResult.getType() != null && elseType != null) { // Typen sollen übereinstimmen
                if (!Objects.equals(elseType, ifBlockResult.getType())) {
                    errors.add(new Exception(
                            "Type mismatch: cannot convert from " + elseType + " to " + ifBlockResult.getType()));
                    valid = false;
                } else {
                    toCheck.type = ifBlockResult.getType(); // Falls der Typ gleich ist, wähle einen der beiden Typen
                    // als Rückgabetyp aus
                }
            }
        } else {
            toCheck.type = ifBlockResult.getType();
        }

        return new TypeCheckResult(valid, toCheck.getType());
    }

    @Override
    public TypeCheckResult typeCheck(Block toCheck) {
        var valid = true;
        Type blockReturnType = null;
        isInScope.pushScope();
        for (var statement : toCheck.statements) {
            var result = statement.accept(this);
            var statementReturnType = result.getType();
            if (statementReturnType != null) { // Wenn StatmentReturnType null ist, dann ändert sich der Block return
                // type nicht
                if (blockReturnType == null) { // Initiale setzen des Return type
                    blockReturnType = result.getType();
                } else {
                    if (!blockReturnType.equals(result.getType())) { // wenn es 2 verschiedene return types gibt, dann
                        // ist es
                        // fehlerhaft
                        errors.add(new Exception(
                                "Return types are mismatching in a single Block, got:" + blockReturnType
                                        + " and " + result.getType()));
                        valid = false;
                    }
                }
            }
            valid = valid && result.isValid();

        }
        isInScope.popScope();
        toCheck.type = blockReturnType;
        return new TypeCheckResult(valid, blockReturnType);
    }

    @Override
    public TypeCheckResult typeCheck(New toCheck) { //Nochmal schauen

        var valid = true;

        var newClass = toCheck.getType();

        if (!getClasses.contains(newClass)) {
            errors.add(new Exception("Type: " + newClass + " is unknown"));
            valid = false;
        }

        for (var arguments : toCheck.expressions) {
            var result = arguments.accept(this);
            valid = valid && result.isValid();
        }

        /*try {
            TypeHelper.getConstructor(newDecl, this.context);
        } catch (TypeMismatchException e) {
            errors.add(new SemanticError(e.getMessage() + TypeHelper.generateLocationString(newDecl.line,
                    newDecl.column, fileName)));
            valid = false;
        } */

        return new TypeCheckResult(valid, null);
    }

    @Override
    public TypeCheckResult typeCheck(MethodCall toCheck) { //nochmal drüber schauen
        var valid = true;

        var receiver = toCheck.receiver.accept(this);

        valid = valid && receiver.isValid();

        for (var parameter : toCheck.arguments) {
            var parameterResult = parameter.accept(this);
            valid = valid && parameterResult.isValid();
        }


        //Hier schauen ob es die Methode überhaupt gibt, receiver hat Typ und in klasse schauen wo dieser drin is
        for (var clas : getClasses) {
            for (var metho : clas.methods) {
                if (metho.name != toCheck.name) {
                    errors.add(new Exception("Methode: " + metho.name + " is unknown"));
                    valid = false;
                }
            }
        }

        //schauen ob Methode aufgerufen werden kann

        return null;
    }

    @Override
    public TypeCheckResult typeCheck(Unary toCheck) {
        var valid = true;

        var result = toCheck.expression.accept(this);
        valid = valid && result.isValid();

        var thrownError = new Exception("The Operator: " + toCheck.operator
                + " is undefined for the argument type: " + toCheck.expression.getType());

        final boolean isBoolOperator = toCheck.operator == Operator.NOT;
        final boolean isIntOperator = false;
        // Check if the unary is valid
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
        //toCheck.type = (Type)getClass.name;
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

        // check if the variable is declared in the current class
        if (!classContainField.contains(toCheck.name)) {
            var thrownError = new Exception("The Field: " + toCheck.name
                    + " is not defined in class");
        }

        // check if the variable is declared in the current scope
        Type localVar = isInScope.getLocalVar(toCheck.name);

        if (localVar != null) {
            toCheck.type = localVar;
            return new TypeCheckResult(true, localVar);
        } else {
            errors.add(new Exception(
                    "Variable: " + toCheck.name + " is not declared in this scope"));
            return new TypeCheckResult(false, null);
        }
    }


    @Override
    public TypeCheckResult typeCheck(InstVar instVar) {
        var valid = true;

        var result = instVar.expression.accept(this); // Hier steht der typ drinne von dem der identifier ist...
        var type = result.getType();
        if (type instanceof BasicType) {
            errors.add(new Exception(
                    "Type: " + type + ", is a BaseType and does not offer any Instance Variables or Methods"));
            valid = false;
        }
        try {

            var nextInstVar = CheckType.getFieldInType(instVar.name, type, this.getClass);

            // Check if the identifier exists in current Type
            if (nextInstVar == null) {
                errors.add(
                        new Exception("Field: " + instVar.name + " not found in Class: " + type));
                valid = false;
            }
            valid = valid && result.isValid();
            var newType = nextInstVar == null ? null : nextInstVar.getType();
            instVar.type = newType;
            instVar.setAccessModifier(nextInstVar == null ? null : nextInstVar.accessModifier);
            return new TypeCheckResult(valid, newType);
        } catch (java.lang.Exception e) {
            errors.add(new Exception(e.getMessage()));
            return new TypeCheckResult(false, null);
        }
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
                        binary.type = isArithmeticOperator ? BasicType.INT : BasicType.BOOL;
                    }
                }
                default -> {
                    errors.add(errorToThrow);
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
            valid = false;
        }

        valid = valid && lResult.isValid() && rResult.isValid();

        return new TypeCheckResult(valid, binary.getType());
    }
}
