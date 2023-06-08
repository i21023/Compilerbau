package mmc.parser.adapter.statementexpressions;

import mmc.ast.expressions.IExpression;
import mmc.ast.statementexpression.New;
import mmc.parser.adapter.expressions.ExpressionAdapter;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class NewStatementAdapter {

    public static New adapt(MiniJavaParser.New_statementContext newStatement) {
        List<IExpression> arguments = new ArrayList<>();
        if (newStatement.argumentList() != null) {
            if (newStatement.argumentList().COMMA().size() > 0) {
                for (int i = 0; i < newStatement.argumentList().COMMA().size(); i++) {
                    arguments.add(ExpressionAdapter.adapt(newStatement.argumentList().expr(i)));
                }
            } else {
                arguments.add(ExpressionAdapter.adapt(newStatement.argumentList().expr(0)));
            }
        }

        return new New(newStatement.ID().getText(), arguments);
    }
}
