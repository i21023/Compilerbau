package mmc.ast.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class Return implements IStatement {
    public IExpression expression;
    public Type type;

    public Return(Type pType,IExpression pExpression) {
        expression = pExpression;
        type = pType;
    }
    public Return(IExpression pExpression) {
        expression = pExpression;
    }

    public Return() {
    }

    public Type getType() {
        return type;
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public void accept(IMethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
