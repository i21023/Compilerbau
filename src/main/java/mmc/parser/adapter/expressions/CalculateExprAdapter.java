package mmc.parser.adapter.expressions;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class CalculateExprAdapter {

    public static IExpression adapt(MiniJavaParser.Calculate_exprContext calculateExpr) {
        if (calculateExpr.add_sub_op() != null) {
            return new Binary(
                    getOperator(calculateExpr.add_sub_op().getText()),
                    CalculateExprAdapter.adapt(calculateExpr.calculate_expr()),
                    MulDivExprAdapter.adapt(calculateExpr.mul_div_expr()));
        }
        else {
            return MulDivExprAdapter.adapt(calculateExpr.mul_div_expr());
        }
    }

    public static Operator getOperator(String operator) {

        return switch (operator) {
            case "+" -> Operator.PLUS;
            case "-" -> Operator.MINUS;
            default -> null;
        };
    }
}
