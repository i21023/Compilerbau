package mmc.ast.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class While implements IStatement{
    public IExpression expression;
    public IStatement statement;
    public Type type;

    public While(IExpression pExpression, IStatement pStatement){
        expression = pExpression;
        statement = pStatement;
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
