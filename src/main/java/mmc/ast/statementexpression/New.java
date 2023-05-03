package mmc.ast.statementexpression;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;


import java.util.List;

public class New implements IStatementExpression {
    public List<IExpression> expressions;
    public Type type;
    public New(List<IExpression> pExpressions, Type pType)
    {
        type = pType;
        expressions=pExpressions;
    }

 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void accept(IMethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
