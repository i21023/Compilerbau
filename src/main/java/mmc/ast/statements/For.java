package mmc.ast.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.IntExpr;
import mmc.ast.statementexpression.IStatementExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class For implements IStatement{

    public IStatement initStatement;
    public IExpression condition;
    public IStatement updateStatement;
    public Block statementBlock;
    public Type type;

    public For (IStatement initExpr, IExpression logicalCondition, IStatement updateExpr, Block statementBlock) {
        this.initStatement = initExpr;
        this.condition = logicalCondition;
        this.updateStatement = updateExpr;
        this.statementBlock = statementBlock;
    }

    public For (IStatement initExpr, IExpression logicalCondition, IStatement updateExpr, Block statementBlock, Type pType) {
        this.initStatement = initExpr;
        this.condition = logicalCondition;
        this.updateStatement = updateExpr;
        this.statementBlock = statementBlock;
        this.type = pType;
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
