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

    public static FieldEnvironment getFieldType(String identifier, Type type, ProgramEnvironment context, ClassDecl currentClass, int line) {
        if (type instanceof ReferenceType) {
            var objectClass = (ReferenceType) type;
            var declaredClassnames = context.getClasses();
            var classContext = declaredClassnames.get(objectClass.getType());
            var field = classContext.fields.get(identifier);
            if (field == null) {
                return null;
            }
            return field;
        } else {
            throw new Exception("Error in line " + line + ": the field " + identifier + " is missing in class " + type);

        }
    }

    public static ConstructorEnvironment getConstructor(New newDecl, ProgramEnvironment ev) {
        var newObjectClass = (ReferenceType) newDecl.getType();
        var declaredClassnames = ev.getClasses();
        var classContext = declaredClassnames.get(newObjectClass.type);
        var constructors = classContext.constructors;
        if(constructors.isEmpty()){
            ConstructorEnvironment constructorEnvironment = new ConstructorEnvironment(new Constructor()); //Automatisch Konstruktor einfügen wenn keiner vorhanden
            constructors.add(constructorEnvironment);
        }
        for (var constructor : constructors) {
            if (constructor.parameterTypes.size() == newDecl.arguments.size()) {
                boolean isSame = true;
                for (int i = 0; i < constructor.parameterTypes.size(); i++) {
                    var parameterType = constructor.parameterTypes.get(i);
                    var argument = newDecl.arguments.get(i);
                    if (!parameterType.equals(argument.getType())) {
                        isSame = false; //Schauen ob die Parameter gleich sind
                        break;
                    }
                }
                if (isSame) {
                    return constructor;
                }
            }
        }
        throw new Exception("Error in line " + newDecl.startLine + ": no declared constructor " + generateConstructorCallString(newDecl) + " in class " + newDecl.getType());
    }

    public static boolean isInitalised(ScopeEnvironment currentScope, IExpression rExpr,IExpression lExpr ){
        boolean valid = true;

        boolean baseType = (rExpr instanceof IntExpr || rExpr instanceof StringExpr
                || rExpr instanceof BoolExpr || rExpr instanceof CharExpr );

        if(lExpr instanceof LocalOrFieldVar l && baseType) {
            String varName = ((LocalOrFieldVar) lExpr).name;
            if (!SemanticCheck.getFields.contains(varName)) {

                var scope = currentScope.getLocalVar(varName);
                if (scope == null) {
                    SemanticCheck.errors.add(new Exception("Error in line " + l.startLine + ": variable " + varName + " doesn't exist"));
                    valid = false;
                } else {
                    scope.isInitialized = true;
                }
            }
        }else if (lExpr instanceof LocalOrFieldVar l && rExpr instanceof Binary){
            String varName = ((LocalOrFieldVar) lExpr).name;
            if (!SemanticCheck.getFields.contains(varName)) {
                var scope = currentScope.getLocalVar(varName);
                if (scope == null && !SemanticCheck.getFields.contains(varName)) {
                    SemanticCheck.errors.add(new Exception("Error in line " + l.startLine + ": variable " + varName + " doesn't exist"));
                    valid = false;
                } else if (!scope.isInitialized) {
                    valid = false;
                }
            }
        }
        return valid;
    }

    public static ClassEnvironment getClassType(LocalVarDecl localVarDecl, ProgramEnvironment ev){
        var objectClass = (ReferenceType) localVarDecl.type;
        var declaredClassnames = ev.getClasses(); //Alle Klassen holen

        var classContext = declaredClassnames.get(objectClass.type); //Schauen ob es den Typ als Klasse gibt
        if(classContext == null){
            throw new Exception(
                    "Error in line " + localVarDecl.startLine + ": class " + localVarDecl.getType() + " not found");
        }
        return classContext;
    }

    public static MethodEnvironment getMethodType(MethodCall toCheck, Type type, ProgramEnvironment ev, ClassDecl currentClass) {
        boolean notVisible = false;
        //Möchte schauen ob Methode visible
        //Und Polymorphie, Methoden ohne Parameter können nicht gleich heißen mit unterschiedlichen schon
        if (type instanceof ReferenceType referenceType) {
            var declaredClasses = ev.getClasses();
            var classContext = declaredClasses.get(referenceType.type);
            if (classContext == null) { //Typ als KLasse existiert nicht
                throw new Exception("Error in line: "+ toCheck.startLine + " Class " + toCheck.name + " with Arguments: " + toCheck.type + " in Type " + type + " not found.");
            }
            var foundMethods = new ArrayList<MethodEnvironment>();
            var methods = classContext.methods.get(toCheck.name);
            if (methods == null) {
                throw new Exception("Error in line: "+ toCheck.startLine + " No method " + generateMethodCallString(toCheck) + " declared in class " + type + ".");
            }
            //Schauen ob Methoden enthalten, mit unterschiedlichen Parameter --> Polymorphie
            for (var method : methods) {
                if (method.parameterTypes.size() == toCheck.arguments.size()) {
                    boolean same = true;
                    for (int i = 0; i < method.parameterTypes.size(); i++) {
                        var parameterType = method.parameterTypes.get(i);
                        var expression = toCheck.arguments.get(i);

                        if (!((expression instanceof JNull && parameterType instanceof ReferenceType) || (!(expression instanceof JNull) && parameterType.equals(expression.getType())))) {
                            same = false;
                            break;
                        }
                    }
                    if (same) {
                        boolean canAccess;
                        if (method.accessModifier == AccessModifier.PRIVATE) {
                            canAccess = referenceType.type.equals(currentClass.name);
                            if (!canAccess) {
                                notVisible = true;
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
                if (notVisible) {
                    throw new Exception("Error in line: " + toCheck.startLine + " Method " + generateMethodCallString(toCheck) + " in class " + type + " is not visible.");
                }else {
                    throw new Exception("Error in line: " + toCheck.startLine + " No method " + generateMethodCallString(toCheck) + " declared in class " + type + ".");
                }
            } else if (foundMethods.size() == 1) {
                for (int i = 0; i < foundMethods.get(0).parameterTypes.size(); i++) {
                    var parameterType = foundMethods.get(0).parameterTypes.get(i);
                    var argument = toCheck.arguments.get(i);

                    if (argument instanceof JNull) {
                        ((JNull)argument).type = parameterType;
                    }
                }
                return foundMethods.get(0);
            } else {
                throw new Exception("Error in line: "+ toCheck.startLine + " Unable to resolve method call " + generateMethodCallString(toCheck) + " in class " + type + ". Multiple methods found.");
            }
        } else {
            throw new Exception("Error in line: "+ toCheck.startLine + " Base type " + type + " does not have methods.");
        }
    }

    private static String generateMethodCallString(MethodCall methodcall){
        StringBuilder s = new StringBuilder();
        s.append(methodcall.name);
        s.append("(");
        for(int i = 0; i < methodcall.arguments.size(); i++){

            s.append(methodcall.arguments.get(i).getType().toString());
            if(i < methodcall.arguments.size() - 1){
                s.append(",");
            }

        }
        s.append(")");
        return s.toString();
    }

    private static String generateConstructorCallString(New constructor){
        StringBuilder s = new StringBuilder();
        s.append(constructor.name);
        s.append("(");
        for(int i = 0; i < constructor.arguments.size(); i++){

            s.append(constructor.arguments.get(i).getType().toString());
            if(i < constructor.arguments.size() - 1){
                s.append(",");
            }

        }
        s.append(")");
        return s.toString();
    }

    public static String generateMethodString(Method method){
        StringBuilder s = new StringBuilder();
        s.append(method.type);
        s.append(" ");
        s.append(method.name);
        s.append("(");
        for(int i = 0; i < method.parameters.size(); i++){

            s.append(method.parameters.get(i).getType().toString());
            s.append(" ");
            s.append(method.parameters.get(i).name);
            if(i < method.parameters.size() - 1){
                s.append(",");
            }

        }
        s.append(")");
        return s.toString();
    }
}
