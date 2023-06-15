package mmc.parser.adapter.expressions;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class BitwiseAndExprAdapter {

    public static IExpression adapt(MiniJavaParser.Bitwise_and_exprContext bitwiseAndExpr) {

        if (bitwiseAndExpr.bitwise_and_expr() != null) {
            return new Binary(Operator.SINGLEAND,
                    BitwiseAndExprAdapter.adapt(bitwiseAndExpr.bitwise_and_expr()),
                    EqualityExprAdapter.adapt(bitwiseAndExpr.equality_expr()));
        } else {
            return EqualityExprAdapter.adapt(bitwiseAndExpr.equality_expr());
        }
    }

}
