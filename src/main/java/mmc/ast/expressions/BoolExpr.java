package mmc.ast.expressions;

import mmc.ast.BasicType;
import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class BoolExpr implements IExpression{
    public boolean value;
    public Type type;

    public BoolExpr(boolean pValue)
    {
        type = BasicType.BOOL;
        value=pValue;
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
