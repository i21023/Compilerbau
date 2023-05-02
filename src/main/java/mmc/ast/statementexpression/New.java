package mmc.ast.statementexpression;

import mmc.ast.Type;
import mmc.ast.expressions.Expression;
import mmc.ast.expressions.IExpression;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;


import java.util.List;

public class New implements IStatementExpression {
    public List<IExpression> expressions;
    public New(List<IExpression> pExpressions)
    {
        expressions=pExpressions;
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
