package mmc.parser.adapter;

import mmc.ast.Type;
import mmc.ast.statements.Return;
import mmc.parser.antlr.MiniJavaParser;

public class ReturnStatementAdapter {
    public static Return adapt(MiniJavaParser.Return_statementContext returnStatement) {

        if (returnStatement.expr() != null) {
            return new Return(ExpressionAdapter.adapt(returnStatement.expr()));
        } else {
            return new Return();
        }
    }
}
