package mmc.ast.expressions;

import mmc.ast.Operator;

public class Binary extends Expression{
    public Operator operator;
    public Expression expression1;
    public Expression expression2;

    public Binary(Operator pOperator, Expression pExpression1, Expression pExpression2)
    {
        operator=pOperator;
        expression1=pExpression1;
        expression2=pExpression2;
    }
}
