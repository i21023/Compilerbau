package mmc.ast.expressions;

import mmc.ast.Type;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class CharExpr implements IExpression{
    public char value;

    public CharExpr(char pValue)
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
