package mmc.ast.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class LocalVarDecl implements IStatement {
    public String name;
    public Type type;
    public IExpression expression;
    public int startLine;
    public int stopLine;

    public LocalVarDecl(String pName, Type pType, IExpression pExpression, int pStartLine, int pStopLine) {
        type = pType;
        name = pName;
        expression = pExpression;
        startLine = pStartLine;
        stopLine = pStopLine;
    }

    public LocalVarDecl(String pName, Type pType, IExpression pExpression) {
        type = pType;
        name = pName;
        expression = pExpression;
    }

    public LocalVarDecl(String pName) {
        name = pName;
    }

    public LocalVarDecl(String pName, Type pType) {
        type = pType;
        name = pName;
        expression = null;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalVarDecl LVD = (LocalVarDecl) o;
        if (type == null && LVD.type == null) {
            typeIsEqual = true;
        } else if (type.equals(LVD.type)) {
            typeIsEqual = true;
        }
        return typeIsEqual && name.equals(LVD.name) && expression.equals(LVD.expression);
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
