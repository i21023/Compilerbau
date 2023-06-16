package mmc.parser.adapter.statements;

import mmc.ast.expressions.IExpression;
import mmc.ast.statements.IStatement;
import mmc.ast.statements.If;
import mmc.parser.adapter.expressions.ExpressionAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class IfElseStatementAdapter {

    public static If adapt(MiniJavaParser.If_else_statementContext ifElseStatement) {

        IExpression expr = ExpressionAdapter.adapt(ifElseStatement.expr());

        IStatement iStatement = StatementBlockAdapter.adapt(ifElseStatement.block());

        IStatement elseIStatement = null;
        if (ifElseStatement.else_statement() != null) {
            if (ifElseStatement.else_statement().statement_block_inline() != null) {
                elseIStatement = StatementBlockInlineAdapter.adapt(ifElseStatement.else_statement().statement_block_inline());
            } else if (ifElseStatement.else_statement().block() != null) {
                elseIStatement = StatementBlockAdapter.adapt(ifElseStatement.else_statement().block());
            } else if (ifElseStatement.else_statement().statement() != null) {
                elseIStatement = StatementAdapter.adapt(ifElseStatement.else_statement().statement());
            }
        }

        return new If(iStatement, elseIStatement, expr);
    }
}
