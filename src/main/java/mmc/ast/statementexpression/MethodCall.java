package mmc.ast.statementexpression;


import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

import java.util.List;

public class MethodCall implements IStatementExpression {
    public IExpression methodOwnerPrefix;
    public String name;
    public List<IExpression> arguments;
    public Type type;
    public boolean isStatic; //TODO: @Emma bitte im Semantikcheck setzen :)

    public MethodCall(IExpression pExpression, String pName, List<IExpression> pExpressions) {
        methodOwnerPrefix = pExpression;
        name = pName;
        arguments = pExpressions;
    }

    public MethodCall(IExpression pExpression, String pName, List<IExpression> pExpressions, Type pType) {
        methodOwnerPrefix = pExpression;
        name = pName;
        arguments = pExpressions;
        type = pType;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodCall methodCall = (MethodCall) o;
        if (type == null && methodCall.type == null) {
            typeIsEqual = true;
        } else if (type.equals(methodCall.type)) {
            typeIsEqual = true;
        }
        return methodOwnerPrefix.equals(methodCall.methodOwnerPrefix) && name.equals(methodCall.name)
                && arguments.equals(methodCall.arguments) && typeIsEqual && isStatic == methodCall.isStatic;
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
