package mmc.parser.adapter.expressions;

import mmc.ast.Operator;
import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.IntExpr;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.expressions.This;
import mmc.ast.expressions.Unary;
import mmc.parser.adapter.InstVarAdapter;
import mmc.parser.adapter.LiteralAdapter;
import mmc.parser.adapter.statementexpressions.StatementExprAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class BasicExprAdapter {

    public static IExpression adapt(MiniJavaParser.Basic_exprContext basicExpr) {

        if (basicExpr.THIS() != null) {
            return new This();
        } else if (basicExpr.ID() != null) {
            return new LocalOrFieldVar(basicExpr.ID().getText());
        } else if (basicExpr.inst_var() != null) {
            return InstVarAdapter.adapt(basicExpr.inst_var());
        } else if (basicExpr.statement_expr() != null) {
            return StatementExprAdapter.adapt(basicExpr.statement_expr());
        } else if (basicExpr.NOT() != null) {
            return new Unary(Operator.NOT, ExpressionAdapter.adapt(basicExpr.expr()));
        } else if (basicExpr.LEFT_BRACKET() != null && basicExpr.RIGHT_BRACKET() != null) {
            return ExpressionAdapter.adapt(basicExpr.expr());
        } else if (basicExpr.add_sub_op() != null) {
            if (basicExpr.add_sub_op().getText().equals("+")) {
                return new IntExpr(Integer.parseInt(basicExpr.INT().getText()));
            } else {
                return new IntExpr(-Integer.parseInt(basicExpr.INT().getText()));
            }
        } else { //literal  (basicExpr.literal() != null)
            return LiteralAdapter.adapt(basicExpr.literal());
        }

    }

}
