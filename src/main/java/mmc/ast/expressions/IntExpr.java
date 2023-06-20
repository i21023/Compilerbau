package mmc.ast.expressions;

import mmc.ast.BasicType;
import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class IntExpr implements IExpression {
    public int value;
    public Type type;
    public int startLine;
    public int stopLine;

    public IntExpr(int pValue, int pStartLine, int pStopLine) {
        value = pValue;
        type = BasicType.INT;
        startLine = pStartLine;
        stopLine = pStopLine;
    }

    public IntExpr(int pValue) {
        value = pValue;
        type = BasicType.INT;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntExpr intExpr = (IntExpr) o;
        if (type == null && intExpr.type == null) {
            typeIsEqual = true;
        } else if (type.equals(intExpr.type)) {
            typeIsEqual = true;
        }
        return value == intExpr.value && typeIsEqual;
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public int getStartLine() {
        return startLine;
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
