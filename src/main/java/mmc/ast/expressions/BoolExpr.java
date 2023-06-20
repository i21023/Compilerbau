package mmc.ast.expressions;

import mmc.ast.BasicType;
import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class BoolExpr implements IExpression {
    public boolean value;
    public Type type;
    public int startLine;
    public int stopLine;

    public BoolExpr(boolean pValue, int pStartLine, int pStopLine) {
        type = BasicType.BOOL;
        value = pValue;
        startLine = pStartLine;
        stopLine = pStopLine;
    }
    public BoolExpr(boolean pValue) {
        type = BasicType.BOOL;
        value = pValue;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoolExpr boolExpr = (BoolExpr) o;
        if (type == null && boolExpr.type == null) {
            typeIsEqual = true;
        } else if (type.equals(boolExpr.type)) {
            typeIsEqual = true;
        }
        return value == boolExpr.value && type.equals(boolExpr.type);
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
