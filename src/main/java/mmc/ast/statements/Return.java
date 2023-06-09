package mmc.ast.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class Return implements IStatement {
    public IExpression expression;
    public Type type;

    public Return(Type pType, IExpression pExpression) {
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
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Return oReturn = (Return) o;
        if (type == null && oReturn.type == null) {
            typeIsEqual = true;
        } else if (type.equals(oReturn.type)) {
            typeIsEqual = true;
        }

        return expression.equals(oReturn.expression) && typeIsEqual;
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
