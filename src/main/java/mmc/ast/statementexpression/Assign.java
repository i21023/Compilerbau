package mmc.ast.statementexpression;

import mmc.ast.Operator;
import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class Assign implements IStatementExpression {
    public IExpression leftExpr;
    public Operator operator;
    public IExpression rightExpr;
    public Type type;

    public Assign(IExpression pLeftExpr, Operator pOperator, IExpression pRightExpr, Type pType)
    {
        leftExpr=pLeftExpr;
        operator=pOperator;
        rightExpr=pRightExpr;
        type = pType;
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
