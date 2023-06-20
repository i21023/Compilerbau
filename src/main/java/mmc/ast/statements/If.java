package mmc.ast.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class If implements IStatement {
    public IExpression expression;
    public IStatement blockIf;
    public IStatement blockElse;
    public Type type;
    public int startLine;
    public int stopLine;

    public If(IStatement pIf, IStatement pElse, IExpression pExpression, int pStartLine, int pStopLine) {
        blockIf = pIf;
        blockElse = pElse;
        expression = pExpression;
        startLine = pStartLine;
        stopLine = pStopLine;
    }

    public If(IStatement pIf, IStatement pElse, IExpression pExpression) {
        blockIf = pIf;
        blockElse = pElse;
        expression = pExpression;
    }

    public If(IStatement pIf, IStatement pElse, IExpression pExpression, Type pType) {
        blockIf = pIf;
        blockElse = pElse;
        expression = pExpression;
        type = pType;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        If oIf = (If) o;
        if (type == null && oIf.type == null) {
            typeIsEqual = true;
        } else if (type.equals(oIf.type)) {
            typeIsEqual = true;
        }
        boolean elseBlockIsEqual = false;
        if (this.blockElse == null && oIf.blockElse == null) {
            elseBlockIsEqual = true;
        } else if (blockElse.equals(oIf.blockElse)) {
            elseBlockIsEqual = true;
        }
        return expression.equals(oIf.expression) && blockIf.equals(oIf.blockIf) && elseBlockIsEqual && typeIsEqual;
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
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
