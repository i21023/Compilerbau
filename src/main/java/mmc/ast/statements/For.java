package mmc.ast.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.IntExpr;
import mmc.ast.statementexpression.IStatementExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

import java.util.List;

public class For implements IStatement {

    public List<IStatement> initStatements;
    public IExpression condition;
    public List<IStatementExpression> updateStatements;
    public Block statementBlock;
    public Type type;
    public int startLine; public int stopLine;

    public For(List<IStatement> initExpr, IExpression logicalCondition, List<IStatementExpression> updateExpr, Block statementBlock,
               int pStartLine, int pStopLine) {
        this.initStatements = initExpr;
        this.condition = logicalCondition;
        this.updateStatements = updateExpr;
        this.statementBlock = statementBlock;
        this.startLine = pStartLine;
        this.stopLine = pStopLine;
    }

    public For(List<IStatement> initExpr, IExpression logicalCondition, List<IStatementExpression> updateExpr, Block statementBlock) {
        this.initStatements = initExpr;
        this.condition = logicalCondition;
        this.updateStatements = updateExpr;
        this.statementBlock = statementBlock;
    }

    public For(List<IStatement> initExpr, IExpression logicalCondition, List<IStatementExpression> updateExpr, Block statementBlock, Type pType) {
        this.initStatements = initExpr;
        this.condition = logicalCondition;
        this.updateStatements = updateExpr;
        this.statementBlock = statementBlock;
        this.type = pType;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        For oFor = (For) o;
        if (type == null && oFor.type == null) {
            typeIsEqual = true;
        } else if (type.equals(oFor.type)) {
            typeIsEqual = true;
        }
        return initStatements.equals(oFor.initStatements) && condition.equals(oFor.condition) && updateStatements.equals((oFor.updateStatements))
                && statementBlock.equals(oFor.statementBlock) && typeIsEqual;
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
