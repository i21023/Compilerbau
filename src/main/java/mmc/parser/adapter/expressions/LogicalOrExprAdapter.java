package mmc.parser.adapter.expressions;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class LogicalOrExprAdapter {
    public static IExpression adapt(MiniJavaParser.Logical_or_exprContext logicalOrExpr) {

        if (logicalOrExpr.logical_or_op() != null) {
            return new Binary(Operator.OR,
                    LogicalOrExprAdapter.adapt(logicalOrExpr.logical_or_expr()),
                    LogicalAndExprAdapter.adapt(logicalOrExpr.logical_and_expr()),
                    logicalOrExpr.getStart().getLine(),
                    logicalOrExpr.getStop().getLine());
        } else {
            return LogicalAndExprAdapter.adapt(logicalOrExpr.logical_and_expr());
        }
    }

}
