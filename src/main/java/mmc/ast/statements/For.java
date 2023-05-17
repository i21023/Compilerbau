package mmc.ast.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.ast.statementexpression.IStatementExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class For implements IStatement{

    private IStatementExpression initExpr;
    private IExpression logicalCondition;
    private IStatementExpression updateExpr;
    private Block statementBlock;
    private Type type;

    public For (IStatementExpression initExpr, IExpression logicalCondition, IStatementExpression updateExpr, Block statementBlock) {
        this.initExpr = initExpr;
        this.logicalCondition = logicalCondition;
        this.updateExpr = updateExpr;
        this.statementBlock = statementBlock;
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
