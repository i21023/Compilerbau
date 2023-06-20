package mmc.ast.main;

import mmc.Visitable;
import mmc.ast.Type;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;


public class Parameter implements Visitable {
    public Type type;
    public String name;
    public int startLine;
    public int stopLine;

    public Parameter(Type pType, String pName, int pStartLine, int pStopLine) {
        type = pType;
        name = pName;
        startLine = pStartLine;
        stopLine = pStopLine;
    }

    public Parameter(Type pType, String pName) {
        type = pType;
        name = pName;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        if (type == null && parameter.type == null) {
            typeIsEqual = true;
        } else if (type.equals(parameter.type)) {
            typeIsEqual = true;
        }
        return typeIsEqual && name.equals(parameter.name);
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public int getStartLine() {
        return startLine;
    }

}
