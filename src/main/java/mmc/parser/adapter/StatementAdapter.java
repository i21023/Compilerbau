package mmc.parser.adapter;

import mmc.ast.statements.IStatement;
import mmc.ast.statements.Return;
import mmc.parser.antlr.MiniJavaParser;

import java.util.List;

public class StatementAdapter {

    public static List<IStatement> adapt(MiniJavaParser.StatementContext statement) {

        if (statement.statement_block() != null) {
            return List.of(StatementBlockAdapter.adapt(statement.statement_block()));
        } else if (statement.local_var_decl() != null) {
            return LocalVarDeclAdapter.adapt(statement.local_var_decl());
        } else if (statement.if_else_statement() != null) {
            return List.of(IfElseStatementAdapter.adapt(statement.if_else_statement()));
        } else if (statement.while_statement() != null) {
            return List.of(WhileStatementAdapter.adapt(statement.while_statement()));
        } else if (statement.for_statement() != null) {
            return List.of(ForStatementAdapter.adapt(statement.for_statement()));
        } else if (statement.return_statement() != null) {
            return List.of(ReturnStatementAdapter.adapt(statement.return_statement()));
        } else {
            return List.of(StatementExprAdapter.adapt(statement.statement_expr()));
        }
    }
}
