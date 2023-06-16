package mmc.parser.adapter.expressions;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class MultiplicativeExprAdapter {

    public static IExpression adapt(MiniJavaParser.Multiplicative_exprContext multiplicativeExpr) {

        if (multiplicativeExpr.multiplicative_expr() != null) {
            return new Binary(getOperator(multiplicativeExpr.mul_div_op().getText()),
                    MultiplicativeExprAdapter.adapt(multiplicativeExpr.multiplicative_expr()),
                    UnaryExprAdapter.adapt(multiplicativeExpr.unary_expr()),
                    multiplicativeExpr.getStart().getLine(),
                    multiplicativeExpr.getStop().getLine());
        } else {
            return UnaryExprAdapter.adapt(multiplicativeExpr.unary_expr());
        }
    }


    public static Operator getOperator(String operator) {

        return switch (operator) {
            case "*" -> Operator.MULT;
            case "/" -> Operator.DIV;
            default -> null;
        };
    }

}
