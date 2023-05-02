package mmc.ast.statementexpression;

import mmc.ast.Type;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class StatementExpression {
    public Type type;
    public StatementExpression(){}

    public StatementExpression(Type pType)
    {
        type=pType;
    }

}
