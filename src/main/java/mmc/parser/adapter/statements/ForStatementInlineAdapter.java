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

public class ForStatementInlineAdapter {
    public static For adapt(MiniJavaParser.For_statement_inlineContext forStatementInline, MiniJavaParser.StatementContext statement) {

        List<IStatement> initStatements = new ArrayList<>();
        if (forStatementInline.for_init() != null) {
            if (forStatementInline.for_init().for_statement_expr() != null) {
                if (forStatementInline.for_init().for_statement_expr().COMMA() != null
                        && forStatementInline.for_init().for_statement_expr().COMMA().size() > 0) {
                    for (int i = 0; i <= forStatementInline.for_init().for_statement_expr().COMMA().size(); i++) {
                        initStatements.add(StatementExprAdapter.adapt(forStatementInline.for_init().for_statement_expr().statement_expr(i)));
                    }
                } else {
                    initStatements.add(StatementExprAdapter.adapt(forStatementInline.for_init().for_statement_expr().statement_expr(0)));
                }
            } else if (forStatementInline.for_init().local_var_decl() != null) {
                initStatements.addAll(LocalVarDeclAdapter.adapt(forStatementInline.for_init().local_var_decl()));
            }
        }

        IExpression expr = null;
        if (forStatementInline.expr() != null) {
            expr = ExpressionAdapter.adapt(forStatementInline.expr());
        }

        List<IStatementExpression> updateStatements = new ArrayList<>();
        if (forStatementInline.for_statement_expr() != null) {
            if (forStatementInline.for_statement_expr().COMMA() != null
                    && forStatementInline.for_statement_expr().COMMA().size() > 0) {
                for (int i = 0; i <= forStatementInline.for_statement_expr().COMMA().size(); i++) {
                    updateStatements.add(StatementExprAdapter.adapt(forStatementInline.for_statement_expr().statement_expr(i)));
                }
            } else {
                updateStatements.add(StatementExprAdapter.adapt(forStatementInline.for_statement_expr().statement_expr(0)));
            }
        }

        IStatement iStatement = null;
        if (forStatementInline.statement_inline() != null) {
            iStatement = StatementInlineAdapter.adapt(forStatementInline.statement_inline(), statement);
        }
        if (iStatement == null && statement != null) {
            iStatement = StatementAdapter.adapt(statement);
        }

        if (iStatement == null) {
            return new For(initStatements, expr, updateStatements, new Block(new ArrayList<>()),
                    forStatementInline.getStart().getLine(),
                    forStatementInline.getStop().getLine());
        } else {
            return new For(initStatements, expr, updateStatements, new Block(List.of(iStatement)),
                    forStatementInline.getStart().getLine(),
                    forStatementInline.getStop().getLine());
        }
    }
}
