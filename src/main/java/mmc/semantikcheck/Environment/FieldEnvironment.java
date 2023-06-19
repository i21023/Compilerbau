package mmc.semantikcheck.Environment;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.ast.main.Field;

import java.util.HashMap;

public class FieldEnvironment {

    public AccessModifier accessModifier;
    public Type type;
    public boolean isStatic;

    public FieldEnvironment(Field field) {
        accessModifier = field.accessModifier;
        type = field.getType();
        isStatic = field.isStatic;
    }

}
