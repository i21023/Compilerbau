package mmc.ast;

public class ReferenceType implements Type {
    public String type;

    public ReferenceType(String pType) {
        type = pType;
    }
    public String getType(){
        return (String) type;
    }
}

