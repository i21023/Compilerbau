package mmc.parser.adapter.statementexpressions;

import mmc.ast.statementexpression.IStatementExpression;
import mmc.parser.adapter.statementexpressions.AssignStatementAdapter;
import mmc.parser.adapter.statementexpressions.CrementStatementAdapter;
import mmc.parser.adapter.statementexpressions.MethodCallStatementAdapter;
import mmc.parser.adapter.statementexpressions.NewStatementAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class StatementExprAdapter {

    public static IStatementExpression adapt(MiniJavaParser.Statement_exprContext statementExpr) {

        if (statementExpr.method_call_statement() != null) {
            return MethodCallStatementAdapter.adapt(statementExpr.method_call_statement());
        } else if (statementExpr.new_statement() != null) {
            return NewStatementAdapter.adapt(statementExpr.new_statement());
        } else if (statementExpr.assign_statement() != null) {
            return AssignStatementAdapter.adapt(statementExpr.assign_statement());
        } else {
            return CrementStatementAdapter.adapt(statementExpr.crement_statement());
        }
    }
}
