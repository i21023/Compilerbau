package mmc.parser.adapter.statements;

import mmc.ast.statements.Block;
import mmc.ast.statements.IStatement;
import mmc.parser.adapter.statementexpressions.StatementExprAdapter;
import mmc.parser.antlr.MiniJavaParser;

import java.util.List;

public class StatementAdapter {

    public static IStatement adapt(MiniJavaParser.StatementContext statement) {

        if (statement.block() != null) {
            return StatementBlockAdapter.adapt(statement.block());
        } else if (statement.if_else_statement() != null) {
            return IfElseStatementAdapter.adapt(statement.if_else_statement());
        } else if (statement.while_statement() != null) {
            return WhileStatementAdapter.adapt(statement.while_statement());
        } else if (statement.for_statement() != null) {
            return ForStatementAdapter.adapt(statement.for_statement());
        } else if (statement.return_statement() != null) {
            return ReturnStatementAdapter.adapt(statement.return_statement());
        } else {
            return StatementExprAdapter.adapt(statement.statement_expr());
        }
    }
}
