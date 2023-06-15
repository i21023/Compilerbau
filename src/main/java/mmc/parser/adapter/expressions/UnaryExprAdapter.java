package mmc.parser.adapter.expressions;

import mmc.ast.expressions.IExpression;
import mmc.parser.adapter.statementexpressions.CrementStatementAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class UnaryExprAdapter {

    public static IExpression adapt(MiniJavaParser.Unary_exprContext unaryExpr) {

        if (unaryExpr.crement_statement() != null) {
            return CrementStatementAdapter.adapt(unaryExpr.crement_statement());
        } else {
            return PrimaryExprAdapter.adapt(unaryExpr.primary_expr());
        }
    }

}
