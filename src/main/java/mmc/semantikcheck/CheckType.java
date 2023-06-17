package mmc.semantikcheck;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.ast.expressions.*;
import mmc.ast.main.*;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.LocalVarDecl;
import mmc.semantikcheck.Environment.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CheckType {
/*    public static FieldEnvironment getFieldInType(String identifier, Type type, ProgramEnvironment context, ClassDecl currentClass, boolean isStatic) {
        if (type instanceof ReferenceType) { //Wenn mein Typ kein BasicType ist
            var objectClass = (ReferenceType) type;
            var declaredClassnames = context.getClasses(); //Alle Klassen holen
            var classContext = declaredClassnames.get(objectClass.type); //Schauen ob es den Typ als Klasse gibt
            var field = classContext.getFields().get(identifier);
            if (field == null) {
                return null;
            }
            if(field.getIsStatic() != isStatic){
                if(isStatic || SemanticCheck.methodIsStatic){
                    throw new Exception(
                            "Cannot make a static reference to the non-static field " + objectClass.type + "." + identifier);
                }else{
                    throw new Exception(
                            "The static field " + identifier + " should be accessed in a static way" );
                }
            }
            var am = field.getAccessModifier();
            if (am == AccessModifier.PRIVATE) {
                if (objectClass.type.equals(currentClass.name)) {
                    return field;
                } else {
                    throw new Exception(
                            "The Field " + objectClass.type + "." + identifier + " is not visible");
                }
            } else {
                return field;
            }
        } else {
            throw new Exception("Field " + identifier + " is missing in Type " + type);

        }

    }*/

    public static FieldEnvironment getFieldInType(String identifier, Type type, ProgramEnvironment context, ClassDecl currentClass) {
        if (type instanceof ReferenceType) {
            var objectClass = (ReferenceType) type;
            var declaredClassnames = context.getClasses();
            var classContext = declaredClassnames.get(objectClass.getType());
            var field = classContext.getFields().get(identifier);
            if (field == null) {
                return null;
            }

            if (field.getAccessModifier() == AccessModifier.PRIVATE) {
                if (objectClass.getType().equals(currentClass.name)) {
                    return field;
                } else {
                    throw new Exception(
                            "The Field " + objectClass.getType() + "." + identifier + " is not visible");
                }
            } else {
                return field;
            }
        } else {
            throw new Exception("Field " + identifier + " is missing in Type " + type);

        }

    }



    public static ConstructorEnvironment getConstructor(New newDecl, ProgramEnvironment ev) {
        var objectClass = (ReferenceType) newDecl.getType();
        var declaredClassnames = ev.getClasses();
        var classContext = declaredClassnames.get(objectClass.type);
        var constructors = classContext.getConstructors();
        if(constructors.isEmpty()){
            ConstructorEnvironment constructorEnvironment = new ConstructorEnvironment(new Constructor());
            constructors.add(constructorEnvironment);
        }
        for (var constructor : constructors) {
            if (constructor.getParameterTypes().size() == newDecl.arguments.size()) {
                boolean isSame = true;
                for (int i = 0; i < constructor.getParameterTypes().size(); i++) {
                    var parameterType = constructor.getParameterTypes().get(i);
                    var argument = newDecl.arguments.get(i);
                    if (!parameterType.equals(argument.getType())) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    return constructor;
                }
            }
        }
        throw new Exception("No declared Constructor with Arguments for this Type " + newDecl.getType());
    }

    public static MethodEnvironment getMethodInType(MethodCall toCheck, Type type, ProgramEnvironment ev, ClassDecl currentClass) {
        boolean failedBecauseNotVisible = false;

        if (type instanceof ReferenceType referenceType) {

            var declaredClassnames = ev.getClasses(); //ProgramEnvironment Classes holen
            var classContext = declaredClassnames.get(referenceType.type); //Hashmap den typ heraus filtern
            if (classContext == null) { //Wenn Typ nicht enthalten
                throw new Exception("No declared Class " + toCheck.name + " with Arguments: "
                        + toCheck.type + " in Type " + type);
            }

            //Schauen ob Methoden enthalten
            var foundMethods = new ArrayList<MethodEnvironment>();
            var methods = classContext.getMethods().get(toCheck.name);
            if (methods == null) {
                throw new Exception("Error in line " + toCheck.startLine + ": no declared method " + generateMethodCallString(toCheck) + " in class " + type);
            }
            for (var method : methods) { //Für jede Methode Parameter checken Polymorphy
                if (method.getParameterTypes().size() == toCheck.arguments.size()) { //Schauen ob beim Methode Call alle Parameter mitgegeben wurden
                    boolean isSame = true;
                    for (int i = 0; i < method.getParameterTypes().size(); i++) {
                        Type parameterType = method.getParameterTypes().get(i);
                        IExpression argument = toCheck.arguments.get(i);
                        if (!((argument instanceof JNull && parameterType instanceof ReferenceType)
                                || (!(argument instanceof JNull) && parameterType.equals(argument.getType())))) {
                            isSame = false;
                            break;
                        }
                    }
                    if (isSame) {  //Access überprüfen
                        var accessModifier = method.getAccessModifier();
                        boolean canAccess;
                        if (accessModifier == AccessModifier.PRIVATE) {
                            canAccess = referenceType.type.equals(currentClass.name); //Gleiche bezeichnung suchen
                            if (!canAccess) {
                                failedBecauseNotVisible = true;
                            }
                        } else {
                            canAccess = true;
                        }
                        if (canAccess) {
                            foundMethods.add(method);
                        }
                    }
                }
            }
            if (foundMethods.size() == 0) {
                if (failedBecauseNotVisible) {

                    throw new Exception(
                            "The Method " + referenceType.type + "." + toCheck.name
                                    + toCheck.type + " is not visible");

                } else {

                    throw new Exception(
                            "No declared Method " + toCheck.name + " with Arguments: "
                                    + toCheck.type + " in Type " + type);
                }
            } else if (foundMethods.size() == 1) {
                for (int i = 0; i < foundMethods.get(0).getParameterTypes().size(); i++) {
                    var parameterType = foundMethods.get(0).getParameterTypes().get(i);
                    var argument = toCheck.arguments.get(i);
                    if (argument instanceof JNull) {
                        ((JNull)argument).type = parameterType;
                    }
                }
                return foundMethods.get(0);
            } else {
                throw new Exception("Cannot resolve Method-Call with Arguments: " + toCheck.type
                        + " in Type " + type + ". Multiple Methods found: \n" + foundMethods);
            }
        } else {
            throw new Exception("Base Type " + type + " does not have Methods");
        }
    }

    public static ClassEnvironment getClassInType(LocalVarDecl localVarDecl, ProgramEnvironment ev){
        var objectClass = (ReferenceType) localVarDecl.type;
        var declaredClassnames = ev.getClasses(); //Alle Klassen holen

        var classContext = declaredClassnames.get(objectClass.type); //Schauen ob es den Typ als Klasse gibt
        if(classContext == null){
            throw new Exception(
                    "Class: " + ((ReferenceType) localVarDecl.type).type + " not found in ");
        }
        return classContext;
    }

    public static boolean isInitalised(ScopeEnvironment currentScope, IExpression rExpr,IExpression lExpr ){
        boolean valid = true;

        boolean baseType = (rExpr instanceof IntExpr || rExpr instanceof StringExpr
                || rExpr instanceof BoolExpr || rExpr instanceof CharExpr );

        if(lExpr instanceof LocalOrFieldVar && baseType) {
            String varName = ((LocalOrFieldVar) lExpr).name;
            if (!SemanticCheck.getFields.contains(varName)) {
                var scope = currentScope.getLocalVar(varName);
                if (scope == null) {
                    SemanticCheck.errors.add(new Exception("Local or Field Variable " + varName + " doesn't exist"));
                    valid = false;
                } else {
                    scope.isInitialized = true;
                }
            }

        }else if (lExpr instanceof LocalOrFieldVar && rExpr instanceof Binary){
            String varName = ((LocalOrFieldVar) lExpr).name;
            if (!SemanticCheck.getFields.contains(varName)) {
                var scope = currentScope.getLocalVar(varName);
                if (scope == null && !SemanticCheck.getFields.contains(varName)) {
                    SemanticCheck.errors.add(new Exception("Local or Field Variable " + varName + " doesn't exist"));
                    valid = false;
                } else if (scope.isInitialized == false) {
                    valid = false;
                }
            }
        }
        //Feld schauen ob dieses initialisiert wurde
        return valid;
    }


    private static String generateMethodCallString(MethodCall methodcall){
        StringBuilder s = new StringBuilder();
        s.append(methodcall.type);
        s.append(" ");
        s.append(methodcall.name);
        s.append("(");
        for(int i = 0; i < methodcall.arguments.size(); i++){

            s.append(methodcall.arguments.get(i).getType().toString());
            if(i > methodcall.arguments.size() - 1){
                s.append(",");
            }

        }
        s.append(")");
        return s.toString();
    }
}
