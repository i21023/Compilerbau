/*
package mmc.parser.adapter.expressions;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.CharExpr;
import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.expressions.StringExpr;
import mmc.parser.adapter.expressions.InstVarAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class StringConcatAdapter {
    public static IExpression adapt(MiniJavaParser.String_concat_exprContext stringConcatExpr) {

        if (stringConcatExpr.string_concat_expr() != null && stringConcatExpr.string_concat_expr().size() > 1) {
            return new Binary(Operator.PLUS, StringConcatAdapter.adapt(stringConcatExpr.string_concat_expr(0)), StringConcatAdapter.adapt(stringConcatExpr.string_concat_expr(1)));
        }
        else if (stringConcatExpr.ID() != null) {
            return new Binary(Operator.PLUS, StringConcatAdapter.adapt(stringConcatExpr.string_concat_expr(0)), new LocalOrFieldVar(stringConcatExpr.ID().getText()));
        }
        else if (stringConcatExpr.inst_var() != null) {
            return new Binary(Operator.PLUS, StringConcatAdapter.adapt(stringConcatExpr.string_concat_expr(0)), InstVarAdapter.adapt(stringConcatExpr.inst_var()));
        }
        else {
            if (stringConcatExpr.STRING()!= null){
                return new StringExpr(stringConcatExpr.STRING().getText());
            }
            else {
                return new CharExpr(stringConcatExpr.CHAR().getText().charAt(1));
            }
        }
    }
}*/
