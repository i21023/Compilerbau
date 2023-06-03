package mmc.parser.adapter;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class MulDivExprAdapter {

    public static IExpression adapt(MiniJavaParser.Mul_div_exprContext mulDivExpr) {
        if (mulDivExpr.mul_div_op() != null) {
            return new Binary(
                    getOperator(mulDivExpr.mul_div_op().getText()),
                    MulDivExprAdapter.adapt(mulDivExpr.mul_div_expr()),
                    ValueCalculateExprAdapter.adapt(mulDivExpr.value_calculate_expr()));
        }
        else {
            return ValueCalculateExprAdapter.adapt(mulDivExpr.value_calculate_expr());
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
