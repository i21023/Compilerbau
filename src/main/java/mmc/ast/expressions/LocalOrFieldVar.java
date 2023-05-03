package mmc.ast.expressions;

import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class LocalOrFieldVar implements IExpression{
    public String name;

    public LocalOrFieldVar(String pName)
    {
        name=pName;
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
