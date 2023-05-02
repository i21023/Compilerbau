package mmc.ast.expressions;

import mmc.ast.Type;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class BoolExpr implements IExpression{
    public boolean value;
    public BoolExpr(boolean pValue)
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
