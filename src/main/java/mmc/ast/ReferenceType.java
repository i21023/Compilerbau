package mmc.ast;

public class ReferenceType implements Type {
    public String type;
    public int startLine;
    public int stopLine;

    public ReferenceType(String pType, int pStartLine, int pStopLine) {
        type = pType;
        startLine = pStartLine;
        stopLine = pStopLine;
    }

    public ReferenceType(String pType) {
        type = pType;
    }

    public String getType() {
        return (String) type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ReferenceType)) {
            return false;
        }
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) ;
        ReferenceType RT = (ReferenceType) o;
        if (type == null && RT.type == null) {
            typeIsEqual = true;
        } else if (type.equals(RT.type)) {
            typeIsEqual = true;
        }

        return typeIsEqual;
    }

    @Override
    public String toString(){
        return type;
    }
}

