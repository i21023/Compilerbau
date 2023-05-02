package mmc.ast.statementexpression;

import mmc.ast.Operator;
import mmc.ast.Type;
import mmc.ast.expressions.Expression;
import mmc.ast.expressions.IExpression;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class Assign implements IStatementExpression {
    public IExpression leftExpr;
    public Operator operator;
    public IExpression rightExpr;

    public Assign(IExpression pLeftExpr, Operator pOperator, IExpression pRightExpr)
    {
        leftExpr=pLeftExpr;
        operator=pOperator;
        rightExpr=pRightExpr;
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
