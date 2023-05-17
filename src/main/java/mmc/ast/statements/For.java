package mmc.ast.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.ast.statementexpression.IStatementExpression;

public class For {

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

}
