package mmc.ast.statements;

import mmc.ast.expressions.Expression;
import mmc.ast.expressions.IExpression;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class Return implements IStatement{
    public IExpression expression;

 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }
}
