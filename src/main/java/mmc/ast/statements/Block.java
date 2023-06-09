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

    public Block(List<IStatement> statements) {
        this.statements = statements;
    }

    public Block() {
        statements = new ArrayList<>();
    }
    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this==o)return true;
        if(o==null||getClass()!=o.getClass())return false;
        Block block = (Block) o;
        return statements.equals(block.statements)&& type.equals(block.type);
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
