package mmc.ast;

public class ReferenceType implements Type {
    public String type;

    public ReferenceType(String pType) {
        type = pType;
    }

    public String getType() {
        return (String) type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) ;
        ReferenceType RT = (ReferenceType) o;
        return type.equals(RT.type);
    }
}

