package mmc.ast.expressions;

import mmc.ast.Type;
import mmc.ast.statementexpression.StatementExpression;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class StmtExpExp implements IExpression{
    public StatementExpression statementExpression;

    public StmtExpExp(StatementExpression pStatementExpression)
    {
        statementExpression=pStatementExpression;
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
