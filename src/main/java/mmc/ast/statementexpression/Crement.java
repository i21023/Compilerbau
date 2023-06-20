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
    public int startLine; public int stopLine;

    public Crement(Type pType, IExpression pExpression, Operator pOperator, int pStartLine, int pStopLine) {
        expression = pExpression;
        operator = pOperator;
        type = pType;
        startLine = pStartLine;
        stopLine = pStopLine;
    }

    public Crement(Type pType, IExpression pExpression, Operator pOperator) {
        expression = pExpression;
        operator = pOperator;
        type = pType;
    }
    public Crement(IExpression expression, Operator operator) {
        this.expression = expression;
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crement crement = (Crement) o;
        if (type == null && crement.type == null) {
            typeIsEqual = true;
        } else if (type.equals(crement.type)) {
            typeIsEqual = true;
        }
        return expression.equals(crement.expression) && operator.equals(crement.operator) && typeIsEqual;
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
