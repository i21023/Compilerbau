package mmc.ast.expressions;

import mmc.ast.Operator;
import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class Unary implements IExpression{
    public Operator operator;
    public IExpression expression;
    public Type type;

    public Unary(Operator pOperator, IExpression pExpression)
    {
        operator=pOperator;
        expression=pExpression;
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
