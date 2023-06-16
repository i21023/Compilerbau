package mmc.parser.adapter.expressions;

import mmc.ast.expressions.BoolExpr;
import mmc.ast.expressions.CharExpr;
import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.IntExpr;
import mmc.ast.expressions.JNull;
import mmc.ast.expressions.StringExpr;
import mmc.parser.antlr.MiniJavaParser;

public class LiteralAdapter {

    public static IExpression adapt(MiniJavaParser.LiteralContext literal) {
        int startLine = literal.getStart().getLine();
        int stopLine = literal.getStop().getLine();
        if (literal.int_() != null) {
            if (literal.int_().add_sub_op() != null) {
                if (literal.int_().add_sub_op().getText().equals("+")) {
                    return new IntExpr(Integer.parseInt(literal.int_().INT().getText()), startLine, stopLine);
                } else {
                    return new IntExpr(-Integer.parseInt(literal.int_().INT().getText()), startLine, stopLine);
                }
            }
            else {
                return new IntExpr(Integer.parseInt(literal.int_().INT().getText()), startLine, stopLine);
            }
        } else if (literal.BOOLEAN() != null) {
            if (literal.BOOLEAN().getText().equals("true")) {
                return new BoolExpr(true, startLine, stopLine);
            } else {
                return new BoolExpr(false, startLine, stopLine);
            }
        } else if (literal.CHAR() != null) {
            return new CharExpr(literal.CHAR().getText().charAt(1), startLine, stopLine);
        } else if (literal.STRING() != null) {
            {
                return new StringExpr(literal.STRING().getText().substring(1,
                        literal.STRING().getText().length() - 1), startLine, stopLine);
            }
        } else {
            return new JNull(startLine, stopLine);
        }
    }
}
