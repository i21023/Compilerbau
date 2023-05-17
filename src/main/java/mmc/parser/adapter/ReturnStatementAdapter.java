package mmc.parser.adapter;

import mmc.ast.Type;
import mmc.ast.statements.Return;
import mmc.parser.antlr.MiniJavaParser;

public class ReturnStatementAdapter {
    public static Return adapt(MiniJavaParser.Return_statementContext returnStatement) {
        return null;
    }
}
