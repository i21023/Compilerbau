package mmc.parser.adapter.statementexpressions;

import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.statementexpression.Assign;
import mmc.parser.adapter.InstVarAdapter;
import mmc.parser.adapter.expressions.ExpressionAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class AssignStatementAdapter {
    public static Assign adapt(MiniJavaParser.Assign_statementContext assignStatement) {

        IExpression leftExpr;
        if (assignStatement.inst_var() != null) {
            leftExpr = InstVarAdapter.adapt(assignStatement.inst_var());
        } else {
            leftExpr = new LocalOrFieldVar(assignStatement.ID().getText());
        }

        IExpression rightExpr = ExpressionAdapter.adapt(assignStatement.expr());

        switch (assignStatement.assign_op().getText()) {
            case "=":
                break;
            case "+=":
                rightExpr = new Binary(Operator.PLUS, leftExpr, rightExpr);
                break;
            case "-=":
                rightExpr = new Binary(Operator.MINUS, leftExpr, rightExpr);
                break;
            case "*=":
                rightExpr = new Binary(Operator.MULT, leftExpr, rightExpr);
                break;
            case "/=":
                rightExpr = new Binary(Operator.DIV, leftExpr, rightExpr);
                break;
            case "%=":
                rightExpr = new Binary(Operator.MOD, leftExpr, rightExpr);
                break;
            default:
                break;
        }

        return new Assign(leftExpr, rightExpr);
    }
}
