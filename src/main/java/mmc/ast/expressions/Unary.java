package mmc.ast.expressions;

import mmc.ast.Operator;
import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class Unary implements IExpression {
    public Operator operator;
    public IExpression expression;
    public Type type;
    public int startLine; public int stopLine;

    public Unary(Operator pOperator, IExpression pExpression) {
        operator = pOperator;
        expression = pExpression;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unary unary = (Unary) o;
        if (type == null && unary.type == null) {
            typeIsEqual = true;
        } else if (type.equals(unary.type)) {
            typeIsEqual = true;
        }
        return operator.equals(unary.operator) && expression.equals(unary.expression) && typeIsEqual;
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
