package mmc.semantikcheck;

import mmc.ast.Type;

public class TypeCheckResult {
    private boolean valid;
    private Type type;

    public TypeCheckResult(boolean valid, Type type) {
        this.valid = valid;
        this.type = type;
    }

    public boolean isValid() { return valid;}

    public Type getType(){return type;}
}
