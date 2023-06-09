package mmc.ast.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class While implements IStatement {
    public IExpression expression;
    public IStatement statement;
    public Type type;

    public While(IExpression pExpression, IStatement pStatement) {
        expression = pExpression;
        statement = pStatement;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        While loop = (While) o;
        if (type == null && loop.type == null) {
            typeIsEqual = true;
        } else if (type.equals(loop.type)) {
            typeIsEqual = true;
        }

        return expression.equals(loop.expression) && statement.equals(loop.statement) && typeIsEqual;
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
