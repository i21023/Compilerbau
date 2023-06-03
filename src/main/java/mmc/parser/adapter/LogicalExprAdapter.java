package mmc.parser.adapter;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.parser.antlr.MiniJavaParser;

public class LogicalExprAdapter {

    public static Binary adapt(MiniJavaParser.Logical_exprContext logicalExpr) {

        return new Binary(
                getOperator(logicalExpr.logical_op().getText()),
                BasicExprAdapter.adapt(logicalExpr.basic_expr()),
                ExpressionAdapter.adapt(logicalExpr.expr()));
    }

    public static Operator getOperator(String operator) {

        return switch (operator) {
            case "==" -> Operator.EQUAL;
            case "!=" -> Operator.NOTEQUAL;
            case "<" -> Operator.LESS;
            case ">" -> Operator.GREATER;
            case "<=" -> Operator.LESSEQUAL;
            case ">=" -> Operator.GREATEREQUAL;
            default -> null;
        };
    }
}
