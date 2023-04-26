package mmc.ast.statementexpression;


import mmc.ast.expressions.Expression;

import java.util.List;

public class MethodCall extends StatementExpression {
    public Expression expression;
    public String name;
    public List<Expression> expressions;
}
