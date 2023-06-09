package mmc.ast.statementexpression;

import mmc.ast.Operator;
import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class Crement implements IStatementExpression {

    public IExpression expression;
    public Operator operator;
    public Type type;

    public Crement(Type pType, IExpression pExpression, Operator pOperator) {
        expression = pExpression;
        operator = pOperator;
        type = pType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crement crement = (Crement) o;
        return expression.equals(crement.expression) && operator.equals(crement.operator) && type.equals(crement.type);
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return null;
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
