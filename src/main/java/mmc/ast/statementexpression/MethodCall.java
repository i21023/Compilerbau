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
    public boolean isStatic;
    public int startLine;
    public int stopLine;

    public MethodCall(IExpression pExpression, String pName, List<IExpression> pExpressions, int pStartLine, int pStopLine) {
        methodOwnerPrefix = pExpression;
        name = pName;
        arguments = pExpressions;
        startLine = pStartLine;
        stopLine = pStopLine;
    }

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

    public MethodCall(IExpression pExpression, String pName, List<IExpression> pExpressions, Type pType, boolean pIsStatic) {
        methodOwnerPrefix = pExpression;
        name = pName;
        arguments = pExpressions;
        type = pType;
        isStatic = pIsStatic;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        boolean methodOwnerPrefixIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodCall methodCall = (MethodCall) o;
        if (type == null && methodCall.type == null) {
            typeIsEqual = true;
        } else if (type.equals(methodCall.type)) {
            typeIsEqual = true;
        }
        if (methodOwnerPrefix == null && methodCall.methodOwnerPrefix == null) {
            methodOwnerPrefixIsEqual = true;
        } else if (methodOwnerPrefix.equals(methodCall.methodOwnerPrefix)) {
            methodOwnerPrefixIsEqual = true;
        }
        return methodOwnerPrefixIsEqual && name.equals(methodCall.name)
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

    @Override
    public int getStartLine() {
        return startLine;
    }
}
