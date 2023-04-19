package mmc.ast.statementexpression;


import mmc.ast.expressions.Expression;

import java.util.List;

public class MethodCall extends StatementExpression {
    Expression expression;
    String name;
    List<Expression> expressions;
}
