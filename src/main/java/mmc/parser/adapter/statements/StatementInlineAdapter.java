package mmc.parser.adapter.statements;

import mmc.ast.statements.IStatement;
import mmc.parser.antlr.MiniJavaParser;

public class StatementInlineAdapter {

    public static IStatement adapt(MiniJavaParser.Statement_inlineContext statementInline, MiniJavaParser.StatementContext statement) {

        if (statementInline.for_statement_inline() != null) {
            return ForStatementInlineAdapter.adapt(statementInline.for_statement_inline(), statement);
        } else if (statementInline.if_statement_inline() !=null) {
            return IfStatementInlineAdapter.adapt(statementInline.if_statement_inline(), statement);
        } else {
            return WhileStatementInlineAdapter.adapt(statementInline.while_statement_inline(),statement);
        }
    }

}
