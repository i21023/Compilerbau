package mmc.parser.adapter.expressions;

import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class ExpressionAdapter {

    public static IExpression adapt(MiniJavaParser.ExprContext expr) {

        return LogicalOrExprAdapter.adapt(expr.logical_or_expr());

    }
}
