package mmc.parser.adapter.expressions;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class RelationalExprAdapter {

    public static IExpression adapt(MiniJavaParser.Relational_exprContext relationalExpr) {

        if (relationalExpr.relational_expr() != null) {
            return new Binary(getOperator(relationalExpr.relational_op().getText()),
                    RelationalExprAdapter.adapt(relationalExpr.relational_expr()),
                    AdditiveExprAdapter.adapt(relationalExpr.additive_expr()));
        } else {
            return AdditiveExprAdapter.adapt(relationalExpr.additive_expr());
        }
    }


    public static Operator getOperator(String operator) {

        return switch (operator) {
            case "<" -> Operator.LESS;
            case ">" -> Operator.GREATER;
            case "<=" -> Operator.LESSEQUAL;
            case ">=" -> Operator.GREATEREQUAL;
            default -> null;
        };
    }

}
