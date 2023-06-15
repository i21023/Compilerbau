package mmc.parser.adapter.expressions;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class BitwiseOrExprAdapter {
    public static IExpression adapt(MiniJavaParser.Bitwise_or_exprContext bitwiseOrExpr) {

        if (bitwiseOrExpr.bitwise_or_expr() != null) {
            return new Binary(Operator.SINGLEOR,
                    BitwiseOrExprAdapter.adapt(bitwiseOrExpr.bitwise_or_expr()),
                    BitwiseAndExprAdapter.adapt(bitwiseOrExpr.bitwise_and_expr()));
        } else {
            return BitwiseAndExprAdapter.adapt(bitwiseOrExpr.bitwise_and_expr());
        }
    }
}
