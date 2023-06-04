package mmc.ast.statementexpression;


import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

import java.util.List;

public class MethodCall implements IStatementExpression  {
    public IExpression methodOwnerPrefix;
    public String name;
    public List<IExpression> arguments;
    public Type type;

    public MethodCall(IExpression pExpression, String pName, List<IExpression> pExpressions)
    {
        methodOwnerPrefix =pExpression;
        name=pName;
        arguments=pExpressions;
    }

    public MethodCall(IExpression pExpression, String pName, List<IExpression> pExpressions, Type pType)
    {
        methodOwnerPrefix =pExpression;
        name=pName;
        arguments=pExpressions;
        type=pType;
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
