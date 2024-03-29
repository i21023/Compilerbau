package mmc.parser.adapter.statementexpressions;

import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.statementexpression.Crement;
import mmc.parser.adapter.expressions.InstVarAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class CrementStatementAdapter {
    public static Crement adapt(MiniJavaParser.Crement_statementContext crementStatement) {

        IExpression expression;
        if (crementStatement.inst_var() != null) {
            expression = InstVarAdapter.adapt(crementStatement.inst_var());
        } else {
            expression = new LocalOrFieldVar(crementStatement.ID().getText(),
                    crementStatement.getStart().getLine(),
                    crementStatement.getStop().getLine());
        }

        Operator operator;
        if (crementStatement.pre_cre_op() != null) {
            if (crementStatement.pre_cre_op().getText().equals("++")) {
                operator = Operator.INCPRE;
            } else {
                operator = Operator.DECPRE;
            }
        } else {
            if (crementStatement.suf_cre_op().getText().equals("++")) {
                operator = Operator.INCSUF;
            } else {
                operator = Operator.DECSUF;
            }
        }

        return new Crement(BasicType.INT, expression, operator,
                crementStatement.getStart().getLine(),
                crementStatement.getStop().getLine());

    }

}
