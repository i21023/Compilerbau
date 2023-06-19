package mmc.ast;

public enum BasicType implements Type{
    INT("int"),
    CHAR("char"),
    BOOL("boolean"),
    VOID("void");

    private final String description;

    private BasicType(String description) {
        this.description = description;
    }

    public String toString(){
        return description;
    }
}
