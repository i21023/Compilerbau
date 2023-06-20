package mmc.ast.expressions;

import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class LocalOrFieldVar implements IExpression {
    public String name;
    public Type type;
    public boolean isStatic;
    public int startLine;
    public int stopLine;

    public LocalOrFieldVar(String pName, int pStartLine, int pStopLine)
    {
        name = pName;
        startLine = pStartLine;
        stopLine = pStopLine;
    }
    public LocalOrFieldVar(String pName)
    {
        name = pName;
    }

    public LocalOrFieldVar(String pName, Type pType) {
        name = pName;
        type = pType;
    }

    public LocalOrFieldVar(String pName, Type pType, boolean pisStatic) {
        name = pName;
        type = pType;
        isStatic = pisStatic;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalOrFieldVar LOFV = (LocalOrFieldVar) o;
        if (type == null && LOFV.type == null) {
            typeIsEqual = true;
        } else if (type.equals(LOFV.type)) {
            typeIsEqual = true;
        }

        return name.equals(LOFV.name) && typeIsEqual && isStatic == LOFV.isStatic;
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void accept(IMethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
