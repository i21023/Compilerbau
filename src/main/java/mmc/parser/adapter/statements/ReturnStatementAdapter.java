package mmc.parser.adapter.statements;

import mmc.ast.statements.Return;
import mmc.parser.adapter.expressions.ExpressionAdapter;
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
