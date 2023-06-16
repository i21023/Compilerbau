package mmc.parser.adapter.statements;

import mmc.ast.statements.IStatement;
import mmc.parser.antlr.MiniJavaParser;

public class StatementBlockInlineAdapter {
    public static IStatement adapt(MiniJavaParser.Statement_block_inlineContext blockInline) {

        if (blockInline.statement() != null) {
            return StatementInlineAdapter.adapt(blockInline.statement_inline(), blockInline.statement());
        } else {
            return StatementInlineAdapter.adapt(blockInline.statement_inline(), null);
        }
    }
}
