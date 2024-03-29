package mmc.ast.statements;

import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

import java.util.ArrayList;
import java.util.List;

public class Block implements IStatement {
    public List<IStatement> statements;
    public Type type;
    public int startLine;
    public int stopLine;

    public Block(List<IStatement> statements, int pStartLine, int pStopLine) {
        this.statements = statements;
        startLine = pStartLine;
        stopLine = pStopLine;
    }

    public Block(List<IStatement> statements) {
        this.statements = statements;
    }

    public Block(List<IStatement> statements, Type pType) {
        this.statements = statements;
        type = pType;
    }

    public Block() {
        statements = new ArrayList<>();
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        if (type == null && block.type == null) {
            typeIsEqual = true;
        } else if (type.equals(block.type)) {
            typeIsEqual = true;
        }
        return statements.equals(block.statements) && typeIsEqual;
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
