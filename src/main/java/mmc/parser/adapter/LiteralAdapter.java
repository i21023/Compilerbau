package mmc.parser.adapter;

import mmc.ast.expressions.BoolExpr;
import mmc.ast.expressions.CharExpr;
import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.IntExpr;
import mmc.ast.expressions.JNull;
import mmc.ast.expressions.StringExpr;
import mmc.parser.antlr.MiniJavaParser;

public class LiteralAdapter {

    public static IExpression adapt(MiniJavaParser.LiteralContext literal) {
        if (literal.INT() != null) {
            return new IntExpr(Integer.parseInt(literal.INT().getText()));
        } else if (literal.BOOLEAN() != null) {
            if (literal.BOOLEAN().getText().equals("true")) {
                return new BoolExpr(true);
            } else {
                return new BoolExpr(false);
            }
        } else if (literal.CHAR() != null) {
            return new CharExpr(literal.CHAR().getText().charAt(1));
        } else if (literal.STRING() != null) {
            {
                return new StringExpr(literal.STRING().getText().substring(1,
                        literal.STRING().getText().length() - 1));
            }
        } else {
            return new JNull();
        }
    }
}
