package mmc.ast.statementexpression;

import mmc.ast.Operator;
import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

import javax.management.openmbean.OpenMBeanAttributeInfo;

public class Assign implements IStatementExpression {
    public IExpression leftExpr;
    public IExpression rightExpr;
    public Operator operator;
    public Type type;
    public int startLine; public int stopLine;

    public Assign(IExpression pLeftExpr, IExpression pRightExpr, int pStartLine, int pStopLine) {
        leftExpr = pLeftExpr;
        rightExpr = pRightExpr;
        operator = Operator.ASSIGN;
        startLine = pStartLine;
        stopLine = pStopLine;
    }

    public Assign(IExpression pLeftExpr, IExpression pRightExpr, Type pType) {
        leftExpr = pLeftExpr;
        rightExpr = pRightExpr;
        type = pType;
        operator = Operator.ASSIGN;
    }

    public Assign(IExpression pLeftExpr, IExpression pRightExpr) {
        leftExpr = pLeftExpr;
        rightExpr = pRightExpr;
        operator = Operator.ASSIGN;
    }

    public Assign(IExpression pLeftExpr, Operator pOperator, IExpression pRightExpr, Type pType) {
        leftExpr = pLeftExpr;
        rightExpr = pRightExpr;
        type = pType;
        operator = pOperator;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assign assign = (Assign) o;
        if (type == null && assign.type == null) {
            typeIsEqual = true;
        } else if (type.equals(assign.type)) {
            typeIsEqual = true;
        }
        return leftExpr.equals(assign.leftExpr) && rightExpr.equals(assign.rightExpr) && operator.equals(assign.operator) && typeIsEqual;
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
