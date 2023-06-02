package mmc.semantikcheck;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.ast.expressions.JNull;
import mmc.ast.main.*;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.semantikcheck.Environment.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CheckType {
    public static FieldEnvironment getFieldInType(String identifier, Type type, ProgramEnvironment context, ClassDecl currentClass) {
        if (type instanceof ReferenceType) {
            var objectClass = (ReferenceType) type;
            var declaredClassnames = context.getClasses();
            var classContext = declaredClassnames.get(objectClass.type);
            var field = classContext.getFields().get(identifier);
            if (field == null) {
                return null;
            }
            var am = field.getAccessModifier();
            if (am == AccessModifier.PRIVATE || am == AccessModifier.PRIVATE_STATIC) {
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

    }


    public static ConstructorEnvironment getConstructor(New newDecl, ProgramEnvironment ev) {
        var objectClass = (ReferenceType) newDecl.getType();
        var declaredClassnames = ev.getClasses();
        var classContext = declaredClassnames.get(objectClass.type);
        var constructors = classContext.getConstructors();
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

    public static MethodEnvironment getMethodInType(MethodCall toCheck, Type type, ProgramEnvironment ev,
                                                    ClassDecl currentClass) {
        boolean failedBecauseNotVisible = false;
        if (type instanceof ReferenceType) {
            var objectClass = (ReferenceType) type;
            var declaredClassnames = ev.getClasses();
            var classContext = declaredClassnames.get(objectClass.type);
            if (classContext == null) {
                classContext = ev.getClasses().get(ev.getImports().get(objectClass.type));
            }
            if (classContext == null) {
                throw new Exception("No declared Method " + toCheck.name + " with Arguments: "
                        + toCheck.type + " in Type " + type);
            }
            var foundMethods = new ArrayList<MethodEnvironment>();
            var methods = classContext.getMethods().get(toCheck.name);
            if (methods == null) {
                throw new Exception("No declared Method " + toCheck.name + " with Arguments: "
                        + toCheck.type + " in Type " + type);
            }
            for (var method : methods) {
                if (method.getParameterTypes().size() == toCheck.arguments.size()) {
                    boolean isSame = true;
                    for (int i = 0; i < method.getParameterTypes().size(); i++) {
                        var parameterType = method.getParameterTypes().get(i);
                        var argument = toCheck.arguments.get(i);
                        if (!((argument instanceof JNull && parameterType instanceof ReferenceType)
                                || (!(argument instanceof JNull) && parameterType.equals(argument.getType())))) {
                            isSame = false;
                            break;
                        }
                    }
                    if (isSame) {
                        var am = method.getAccessModifier();
                        boolean canAccess;
                        if (am == AccessModifier.PRIVATE || am == AccessModifier.PRIVATE_STATIC) {
                            canAccess = objectClass.type.equals(currentClass.name);
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
                            "The Method " + objectClass.type + "." + toCheck.name
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

}
