package mmc.parser.adapter.expressions;

import mmc.ast.Operator;
import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.expressions.This;
import mmc.ast.expressions.Unary;
import mmc.parser.adapter.statementexpressions.StatementExprAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class PrimaryExprAdapter {


    public static IExpression adapt(MiniJavaParser.Primary_exprContext primaryExpr) {

        if (primaryExpr.THIS() != null) {
            return new This();
        } else if (primaryExpr.ID() != null) {
            return new LocalOrFieldVar(primaryExpr.ID().getText());
        } else if (primaryExpr.inst_var() != null) {
            return InstVarAdapter.adapt(primaryExpr.inst_var());
        } else if (primaryExpr.statement_expr() != null) {
            return StatementExprAdapter.adapt(primaryExpr.statement_expr());
        } else if (primaryExpr.NOT() != null) {
            return new Unary(Operator.NOT, ExpressionAdapter.adapt(primaryExpr.expr()));
        } else if (primaryExpr.LEFT_BRACKET() != null && primaryExpr.RIGHT_BRACKET() != null) {
            return ExpressionAdapter.adapt(primaryExpr.expr());
        } else { //literal  (basicExpr.literal() != null)
            return LiteralAdapter.adapt(primaryExpr.literal());
        }

    }

}
