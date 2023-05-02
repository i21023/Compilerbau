package mmc.ast.expressions;

import mmc.ast.Type;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class IntExpr implements IExpression{
    public int value;
    public IntExpr(int pValue)
    {
        value=pValue;
    }

 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public Type getType() {
        return null;
    }
}
