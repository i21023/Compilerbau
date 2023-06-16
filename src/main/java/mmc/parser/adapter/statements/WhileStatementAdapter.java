package mmc.parser.adapter.statements;

import mmc.ast.expressions.IExpression;
import mmc.ast.statements.IStatement;
import mmc.ast.statements.While;
import mmc.parser.adapter.expressions.ExpressionAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class WhileStatementAdapter {

    public static While adapt(MiniJavaParser.While_statementContext whileStatement) {

        IExpression expr = ExpressionAdapter.adapt(whileStatement.expr());

        IStatement iStatement = StatementBlockAdapter.adapt(whileStatement.block());

        return new While(expr, iStatement);

    }
}
