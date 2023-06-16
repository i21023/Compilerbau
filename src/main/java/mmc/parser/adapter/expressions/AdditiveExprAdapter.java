package mmc.parser.adapter.expressions;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class AdditiveExprAdapter {

    public static IExpression adapt(MiniJavaParser.Additive_exprContext additiveExpr) {

        if (additiveExpr.additive_expr() != null) {
            return new Binary(getOperator(additiveExpr.add_sub_op().getText()),
                    AdditiveExprAdapter.adapt(additiveExpr.additive_expr()),
                    MultiplicativeExprAdapter.adapt(additiveExpr.multiplicative_expr()),
                    additiveExpr.getStart().getLine(),
                    additiveExpr.getStop().getLine());
        } else {
            return MultiplicativeExprAdapter.adapt(additiveExpr.multiplicative_expr());
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
