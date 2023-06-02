package mmc.ast.expressions;

import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class LocalOrFieldVar implements IExpression{
    public String name;
    public Type type;

    public LocalOrFieldVar(String pName)
    {
        name=pName;
    }
    public LocalOrFieldVar(Type pType, String pName) {
        name = pName;
        type = type;
    }

    public LocalOrFieldVar(String pName, Type pType)
    {
        name=pName;
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
