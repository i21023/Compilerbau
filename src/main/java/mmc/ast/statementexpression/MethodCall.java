package mmc.ast.statementexpression;


import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

import java.util.List;

public class MethodCall implements IStatementExpression  {
    public IExpression expression;
    public String name;
    public List<IExpression> expressions;

    public MethodCall(IExpression pExpression, String pName, List<IExpression> pExpressions)
    {
        expression=pExpression;
        name=pName;
        expressions=pExpressions;
    }

 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public void accept(IMethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
