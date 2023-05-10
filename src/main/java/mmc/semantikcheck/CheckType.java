package mmc.semantikcheck;

import mmc.ast.AccessModifier;
import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.ast.main.ClassDecl;
import mmc.ast.main.Field;
import mmc.ast.main.Method;
import mmc.ast.statementexpression.MethodCall;

public class CheckType {
    public static Field getFieldInType(String identifier, Type type, ClassDecl currentClass) {
        if (type instanceof ReferenceType) {
            var objectClass = (ReferenceType) type;
            var declaredClassnames = currentClass.name;
            var fields = currentClass.fields;
            for (var field : fields) {
                if (field == null) {
                    return null;
                }
                var am = field.accessModifier == null ? AccessModifier.PRIVATE : field.accessModifier;
                if (am == AccessModifier.PRIVATE) {
                    if (objectClass.type.equals(currentClass.name)) {
                        return field;
                    } else {
                        throw new Exception("The Field" + identifier + "is not visible");
                    }
                } else {
                    return field;
                }
            }
        } else {
            throw new Exception("Field " + identifier + " is missing in Type " + type);
        }
        return null;
    }
}
