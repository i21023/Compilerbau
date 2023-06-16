package mmc.parser.adapter.statements;

import mmc.ast.expressions.IExpression;
import mmc.ast.statements.Block;
import mmc.ast.statements.IStatement;
import mmc.ast.statements.If;
import mmc.parser.adapter.expressions.ExpressionAdapter;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;

public class IfStatementInlineAdapter {

    public static If adapt(MiniJavaParser.If_statement_inlineContext ifStatementInline, MiniJavaParser.StatementContext statement) {

        IExpression expr = ExpressionAdapter.adapt(ifStatementInline.expr());

        IStatement iStatement = null;
        if (ifStatementInline.statement_inline() != null) {
            iStatement = StatementInlineAdapter.adapt(ifStatementInline.statement_inline(), statement);
        }
        if (iStatement == null && statement != null) {
            iStatement = StatementAdapter.adapt(statement);
        }

        IStatement elseIStatement = null;

        return new If(iStatement, elseIStatement, expr);
    }

}
