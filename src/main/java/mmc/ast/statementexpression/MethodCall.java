package mmc.ast.statementexpression;


import mmc.ast.expressions.Expression;

import java.util.List;

public class MethodCall extends StatementExpression {
    public Expression expression;
    public String name;
    public List<Expression> expressions;

    public MethodCall(Expression pExpression, String pName, List<Expression> pExpressions)
    {
        expression=pExpression;
        name=pName;
        expressions=pExpressions;
    }
}
