package mmc.ast.expressions;

import mmc.ast.Type;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class InstVar implements IExpression{
    public String name;
    public IExpression expression;

    public InstVar(String pName, IExpression pExpression)
    {
        name=pName;
        expression=pExpression;
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
