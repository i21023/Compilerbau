package mmc.ast.expressions;

import mmc.ast.Operator;

public class Unary extends Expression{
    public Operator operator;
    public Expression expression;

    public Unary(Operator pOperator, Expression pExpression)
    {
        operator=pOperator;
        expression=pExpression;
    }
}
