package mmc.parser.adapter;

import mmc.ast.statements.Block;
import mmc.parser.antlr.MiniJavaParser;

public class StatementBlockAdapter {
    public static Block adapt(MiniJavaParser.Statement_blockContext statementBlock) {

        return new Block();
    }
}
