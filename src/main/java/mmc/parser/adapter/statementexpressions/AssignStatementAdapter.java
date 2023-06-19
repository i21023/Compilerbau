package mmc.parser.adapter.statementexpressions;

import mmc.ast.Operator;
import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.statementexpression.Assign;
import mmc.parser.adapter.expressions.ExpressionAdapter;
import mmc.parser.adapter.expressions.InstVarAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class AssignStatementAdapter {
    public static Assign adapt(MiniJavaParser.Assign_statementContext assignStatement) {

        IExpression leftExpr;
        if (assignStatement.inst_var() != null) {
            leftExpr = InstVarAdapter.adapt(assignStatement.inst_var());
        } else {
            leftExpr = new LocalOrFieldVar(assignStatement.ID().getText(),
                    assignStatement.getStart().getLine(),
                    assignStatement.getStop().getLine());
        }

        IExpression rightExpr = ExpressionAdapter.adapt(assignStatement.expr());

        Operator assignOperator = null;
        switch (assignStatement.assign_op().getText()) {
            case "=":
                assignOperator = Operator.ASSIGN;
                break;
            case "+=":
                //rightExpr = new Binary(Operator.PLUS, leftExpr, rightExpr, assignStatement.getStart().getLine(), assignStatement.getStop().getLine());
                assignOperator = Operator.PLUSASSIGN;
                break;
            case "-=":
                //rightExpr = new Binary(Operator.MINUS, leftExpr, rightExpr, assignStatement.getStart().getLine(), assignStatement.getStop().getLine());
                assignOperator = Operator.MINUSASSIGN;
                break;
            case "*=":
                //rightExpr = new Binary(Operator.MULT, leftExpr, rightExpr, assignStatement.getStart().getLine(), assignStatement.getStop().getLine());
                assignOperator = Operator.MULTASSIGN;
                break;
            case "/=":
                //rightExpr = new Binary(Operator.DIV, leftExpr, rightExpr, assignStatement.getStart().getLine(), assignStatement.getStop().getLine());
                assignOperator = Operator.DIVASSIGN;
                break;
            case "%=":
                //rightExpr = new Binary(Operator.MOD, leftExpr, rightExpr, assignStatement.getStart().getLine(), assignStatement.getStop().getLine());
                assignOperator = Operator.MODASSIGN;
                break;
            default:
                break;
        }

        return new Assign(assignOperator, leftExpr, rightExpr,
                assignStatement.getStart().getLine(),
                assignStatement.getStop().getLine());
    }
}
