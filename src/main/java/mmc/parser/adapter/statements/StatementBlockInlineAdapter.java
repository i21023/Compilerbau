package mmc.parser.adapter.statements;

import mmc.ast.statements.IStatement;
import mmc.ast.statements.If;
import mmc.parser.antlr.MiniJavaParser;

public class StatementBlockInlineAdapter {
    public static IStatement adapt(MiniJavaParser.Statement_block_inlineContext blockInline) {

        if (blockInline.if_statement_inline() != null) {

            If ifStatement = null;
            if (blockInline.statement() != null) {
                ifStatement = IfStatementInlineAdapter.adapt(blockInline.if_statement_inline(), blockInline.statement());
            } else {
                ifStatement = IfStatementInlineAdapter.adapt(blockInline.if_statement_inline(), null);

            }

            if (blockInline.else_statement() != null) {
                if (blockInline.else_statement().statement_block_inline() != null) {
                    ifStatement.blockElse = StatementBlockInlineAdapter.adapt(blockInline.else_statement().statement_block_inline());
                } else if (blockInline.else_statement().block() != null) {
                    ifStatement.blockElse = StatementBlockAdapter.adapt(blockInline.else_statement().block());
                } else if (blockInline.else_statement().statement() != null) {
                    ifStatement.blockElse = StatementAdapter.adapt(blockInline.else_statement().statement());
                }
            }
            return ifStatement;
        } else if (blockInline.statement() != null) {
            return StatementInlineAdapter.adapt(blockInline.statement_inline(), blockInline.statement());
        } else {
            return StatementInlineAdapter.adapt(blockInline.statement_inline(), null);
        }
    }
}
