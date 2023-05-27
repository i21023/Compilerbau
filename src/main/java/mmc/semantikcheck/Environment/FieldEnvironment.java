package mmc.semantikcheck.Environment;

import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.ast.main.Field;

public class FieldEnvironment {

    private AccessModifier accessModifier;
    private Type type;

    public FieldEnvironment(Field field) {
        accessModifier = field.accessModifier;
        type = field.getType();
    }

    /**
     * @return AccessModifier
     */
    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    /**
     * @return Type
     */
    public Type getType() {
        return type;
    }
}
