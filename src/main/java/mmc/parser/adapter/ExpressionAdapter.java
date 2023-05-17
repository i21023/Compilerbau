package mmc.parser.adapter;

import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class ExpressionAdapter {

    public static IExpression adapt(MiniJavaParser.ExprContext exprContext) {

        if (exprContext.basic_expr() != null) {
            return BasicExprAdapter.adapt(exprContext.basic_expr());
        } else {
            return null;
        }
    }
}
