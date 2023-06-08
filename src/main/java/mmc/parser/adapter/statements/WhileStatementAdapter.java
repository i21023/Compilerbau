package mmc.parser.adapter.statements;

import mmc.ast.expressions.IExpression;
import mmc.ast.statements.IStatement;
import mmc.ast.statements.While;
import mmc.parser.adapter.expressions.LogicalExprAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class WhileStatementAdapter {

    public static While adapt(MiniJavaParser.While_statementContext whileStatement) {

        IExpression logicalExpression = LogicalExprAdapter.adapt(whileStatement.logical_expr());

        IStatement iStatement = StatementBlockAdapter.adapt(whileStatement.statement_block());

        return new While(logicalExpression, iStatement);

    }
}
