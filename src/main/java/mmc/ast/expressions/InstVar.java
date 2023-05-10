package mmc.ast.expressions;

import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class InstVar implements IExpression{
    public String name;
    public IExpression expression;
    public Type type;
    private boolean _static = false;

    public InstVar(String pName, IExpression pExpression)
    {
        name=pName;
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
    public boolean isStatic() {
        return _static;
    }
    public void setAccessModifier(AccessModifier accessModifier) {
        if (accessModifier == null) {
            _static = false;
            return;
        }
        switch (accessModifier) {
            case PRIVATE_STATIC, PUBLIC_STATIC -> {
                this._static = true;
            }
            default -> {
                this._static = false;
            }
        }
    }
}
