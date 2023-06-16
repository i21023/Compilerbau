package mmc.parser.adapter.statements;

import mmc.ast.expressions.IExpression;
import mmc.ast.statements.IStatement;
import mmc.ast.statements.While;
import mmc.parser.adapter.expressions.ExpressionAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class WhileStatementInlineAdapter {

    public static While adapt(MiniJavaParser.While_statement_inlineContext whileStatementInline, MiniJavaParser.StatementContext statement) {

        IExpression expr = ExpressionAdapter.adapt(whileStatementInline.expr());

        IStatement iStatement = null;
        if (whileStatementInline.statement_inline() != null) {
            iStatement = StatementInlineAdapter.adapt(whileStatementInline.statement_inline(), statement);
        }
        if (iStatement == null && statement != null) {
            iStatement = StatementAdapter.adapt(statement);
        }
        return new While(expr, iStatement,
                whileStatementInline.getStart().getLine(),
                whileStatementInline.getStop().getLine());

    }

}
