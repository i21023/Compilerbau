package mmc.parser.adapter.statements;

import mmc.ast.expressions.IExpression;
import mmc.ast.statementexpression.IStatementExpression;
import mmc.ast.statements.Block;
import mmc.ast.statements.For;
import mmc.ast.statements.IStatement;
import mmc.parser.adapter.expressions.ExpressionAdapter;
import mmc.parser.adapter.statementexpressions.StatementExprAdapter;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class ForStatementAdapter {
    public static For adapt(MiniJavaParser.For_statementContext forStatement) {

        List<IStatement> initStatements = new ArrayList<>();
        if (forStatement.for_init() != null) {
            if (forStatement.for_init().for_statement_expr() != null) {
                if (forStatement.for_init().for_statement_expr().COMMA() != null
                        && forStatement.for_init().for_statement_expr().COMMA().size() > 0) {
                    for (int i = 0; i <= forStatement.for_init().for_statement_expr().COMMA().size(); i++) {
                        initStatements.add(StatementExprAdapter.adapt(forStatement.for_init().for_statement_expr().statement_expr(i)));
                    }
                } else {
                    initStatements.add(StatementExprAdapter.adapt(forStatement.for_init().for_statement_expr().statement_expr(0)));
                }
            } else if (forStatement.for_init().local_var_decl() != null) {
                initStatements.addAll(LocalVarDeclAdapter.adapt(forStatement.for_init().local_var_decl()));
            }
        }

        IExpression expr = null;
        if (forStatement.expr() != null) {
            expr = ExpressionAdapter.adapt(forStatement.expr());
        }

        List<IStatementExpression> updateStatements = new ArrayList<>();
        if (forStatement.for_statement_expr() != null) {
            if (forStatement.for_statement_expr().COMMA() != null
                    && forStatement.for_statement_expr().COMMA().size() > 0) {
                for (int i = 0; i <= forStatement.for_statement_expr().COMMA().size(); i++) {
                    updateStatements.add(StatementExprAdapter.adapt(forStatement.for_statement_expr().statement_expr(i)));
                }
            } else {
                updateStatements.add(StatementExprAdapter.adapt(forStatement.for_statement_expr().statement_expr(0)));
            }
        }

        Block block = StatementBlockAdapter.adapt(forStatement.block());

        return new For(initStatements, expr, updateStatements, block);
    }

}
