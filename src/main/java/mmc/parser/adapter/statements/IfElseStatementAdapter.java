package mmc.parser.adapter.statements;

import mmc.ast.expressions.IExpression;
import mmc.ast.statements.IStatement;
import mmc.ast.statements.If;
import mmc.parser.adapter.expressions.LogicalExprAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class IfElseStatementAdapter {

    public static If adapt(MiniJavaParser.If_else_statementContext ifElseStatement) {

        IExpression logicalExpression = LogicalExprAdapter.adapt(ifElseStatement.logical_expr());

        IStatement iStatement = StatementBlockAdapter.adapt(ifElseStatement.statement_block());

        IStatement elseIStatement = null;
        if (ifElseStatement.else_statement() != null) {
            elseIStatement = StatementBlockAdapter.adapt(ifElseStatement.else_statement().statement_block());
        }

        return new If(iStatement, elseIStatement, logicalExpression);
    }
}
