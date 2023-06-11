package mmc.parser.adapter.statements;

import mmc.ast.expressions.IExpression;
import mmc.ast.statements.Block;
import mmc.ast.statements.For;
import mmc.ast.statements.IStatement;
import mmc.parser.adapter.expressions.LogicalExprAdapter;
import mmc.parser.adapter.statementexpressions.StatementExprAdapter;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class ForStatementAdapter {
    //ToDo: Parser: Habe nochmal was im Parser gefunden ForLoopTest AstTests Zeile 279 da wird in dem For aus ClassFor das i++ in UpdateStatement als Cremet(LocalOrFieldVar("i"),DECSUF,INT) geparsed aber es sollte ja ein INCSUF sein oder?
    public static For adapt(MiniJavaParser.For_statementContext forStatement) {

        List<IStatement> initStatements = new ArrayList<>();
        if (forStatement.for_init().for_statement_expr() != null) {
            if (forStatement.for_init().for_statement_expr().COMMA() != null
                    && forStatement.for_init().for_statement_expr().COMMA().size() > 0) {
                for (int i = 0; i < forStatement.for_init().for_statement_expr().COMMA().size(); i++) {
                    initStatements.add(StatementExprAdapter.adapt(forStatement.for_init().for_statement_expr().statement_expr(i)));
                }
            } else {
                initStatements.add(StatementExprAdapter.adapt(forStatement.for_init().for_statement_expr().statement_expr(0)));
            }
        } else if (forStatement.for_init().local_var_decl() != null) {
            initStatements.addAll(LocalVarDeclAdapter.adapt(forStatement.for_init().local_var_decl()));
        }
        Block initStatement = new Block(initStatements);

        IExpression logicalExpression = null;
        if (forStatement.logical_expr() != null) {
            logicalExpression = LogicalExprAdapter.adapt(forStatement.logical_expr());
        }

        List<IStatement> updateStatements = new ArrayList<>();
        if (forStatement.for_statement_expr() != null) {
            if (forStatement.for_statement_expr().COMMA() != null
                    && forStatement.for_statement_expr().COMMA().size() > 0) {
                for (int i = 0; i < forStatement.for_statement_expr().COMMA().size(); i++) {
                    updateStatements.add(StatementExprAdapter.adapt(forStatement.for_statement_expr().statement_expr(i)));
                }
            } else {
                updateStatements.add(StatementExprAdapter.adapt(forStatement.for_statement_expr().statement_expr(0)));
            }
        }
        Block updateStatement = new Block(updateStatements);

        IStatement statement = StatementAdapter.adapt(forStatement.statement());

        return new For(initStatement, logicalExpression, updateStatement, new Block(List.of(statement)));
    }

}
