package mmc.ast.statementexpression;

import mmc.ast.Operator;
import mmc.ast.expressions.Expression;

public class Assign extends StatementExpression {
    public Expression leftExpr;
    public Operator operator;
    public Expression rightExpr;

    public Assign(Expression pLeftExpr, Operator pOperator, Expression pRightExpr)
    {
        leftExpr=pLeftExpr;
        operator=pOperator;
        rightExpr=pRightExpr;
    }
}
