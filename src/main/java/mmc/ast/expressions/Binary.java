package mmc.ast.expressions;

import mmc.ast.Operator;
import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class Binary implements IExpression{
    public Operator operator;
    public IExpression expression1;
    public Type type;
    public IExpression expression2;

    public Binary(Operator pOperator, IExpression pExpression1, IExpression pExpression2)
    {
        operator=pOperator;
        expression1=pExpression1;
        expression2=pExpression2;
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
