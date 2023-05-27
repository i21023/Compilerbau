package mmc.ast.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.ast.statementexpression.IStatementExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class For implements IStatement{

    public IStatementExpression initExpr;
    public IExpression logicalCondition;
    public IStatementExpression updateExpr;
    public Block statementBlock;
    public Type type;

    public For (IStatementExpression initExpr, IExpression logicalCondition, IStatementExpression updateExpr, Block statementBlock, Type pType) {
        this.initExpr = initExpr;
        this.logicalCondition = logicalCondition;
        this.updateExpr = updateExpr;
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
