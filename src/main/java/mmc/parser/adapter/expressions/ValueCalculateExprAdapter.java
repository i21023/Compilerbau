package mmc.parser.adapter.expressions;

import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.IntExpr;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.parser.adapter.statementexpressions.CrementStatementAdapter;
import mmc.parser.adapter.statementexpressions.MethodCallStatementAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class ValueCalculateExprAdapter {


    public static IExpression adapt(MiniJavaParser.Value_calculate_exprContext valueCalculateExpr) {

        if (valueCalculateExpr.INT() != null) {
            return new IntExpr(Integer.parseInt(valueCalculateExpr.INT().getText()));
        } else if (valueCalculateExpr.ID() != null) {
            return new LocalOrFieldVar(valueCalculateExpr.ID().getText());
        } else if (valueCalculateExpr.inst_var() != null) {
            return InstVarAdapter.adapt(valueCalculateExpr.inst_var());
        } else if (valueCalculateExpr.method_call_statement() != null) {
            return MethodCallStatementAdapter.adapt(valueCalculateExpr.method_call_statement());
        } else if (valueCalculateExpr.LEFT_BRACKET() != null && valueCalculateExpr.RIGHT_BRACKET() != null) {
            return CalculateExprAdapter.adapt(valueCalculateExpr.calculate_expr());
        } else {
            return CrementStatementAdapter.adapt(valueCalculateExpr.crement_statement());
        }
    }
}

