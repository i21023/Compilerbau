package mmc.parser.adapter.expressions;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class LogicalAndExprAdapter {

    public static IExpression adapt(MiniJavaParser.Logical_and_exprContext logicalAndExpr) {

        if (logicalAndExpr.logical_and_expr() != null) {
            return new Binary(Operator.AND,
                    LogicalAndExprAdapter.adapt(logicalAndExpr.logical_and_expr()),
                    BitwiseOrExprAdapter.adapt(logicalAndExpr.bitwise_or_expr()),
                    logicalAndExpr.getStart().getLine(),
                    logicalAndExpr.getStop().getLine());
        } else {
            return BitwiseOrExprAdapter.adapt(logicalAndExpr.bitwise_or_expr());
        }
    }
}

