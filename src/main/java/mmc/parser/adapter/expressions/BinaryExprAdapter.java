package mmc.parser.adapter.expressions;

import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class BinaryExprAdapter {

    public static IExpression adapt(MiniJavaParser.Binary_exprContext binaryExprContext) {

        if (binaryExprContext.logical_expr() != null) {
            return LogicalExprAdapter.adapt(binaryExprContext.logical_expr());
        } else { // if (binaryExprContext.calculate_expr() != null){
            return CalculateExprAdapter.adapt(binaryExprContext.calculate_expr());
        }
        /* } else {
            return StringConcatAdapter.adapt(binaryExprContext.string_concat_expr());
        }*/
    }
}
