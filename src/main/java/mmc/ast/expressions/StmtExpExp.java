package mmc.ast.expressions;

import mmc.ast.statementexpression.StatementExpression;

public class StmtExpExp extends Expression{
    public StatementExpression statementExpression;

    public StmtExpExp(StatementExpression pStatementExpression)
    {
        statementExpression=pStatementExpression;
    }
}
