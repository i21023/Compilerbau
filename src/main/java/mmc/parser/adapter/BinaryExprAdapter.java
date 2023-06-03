package mmc.parser.adapter;

import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class BinaryExprAdapter {

    public static IExpression adapt(MiniJavaParser.Binary_exprContext binaryExprContext) {

        if (binaryExprContext.logical_expr() != null) {
            return LogicalExprAdapter.adapt(binaryExprContext.logical_expr());
        } else {
            return CalculateExprAdapter.adapt(binaryExprContext.calculate_expr());
        }
    }
}
