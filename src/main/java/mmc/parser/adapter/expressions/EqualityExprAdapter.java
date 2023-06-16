package mmc.parser.adapter.expressions;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.IExpression;
import mmc.parser.antlr.MiniJavaParser;

public class EqualityExprAdapter {

    public static IExpression adapt(MiniJavaParser.Equality_exprContext equalityExpr) {

        if (equalityExpr.equality_expr() != null) {
            return new Binary(getOperator(equalityExpr.equality_op().getText()),
                    EqualityExprAdapter.adapt(equalityExpr.equality_expr()),
                    RelationalExprAdapter.adapt(equalityExpr.relational_expr()),
                    equalityExpr.getStart().getLine(),
                    equalityExpr.getStop().getLine());
        } else {
            return RelationalExprAdapter.adapt(equalityExpr.relational_expr());
        }
    }


    public static Operator getOperator(String operator) {

        return switch (operator) {
            case "==" -> Operator.EQUAL;
            case "!=" -> Operator.NOTEQUAL;
            default -> null;
        };
    }

}
