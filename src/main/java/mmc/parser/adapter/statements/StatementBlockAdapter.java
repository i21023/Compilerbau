package mmc.parser.adapter.statements;

import mmc.ast.statements.Block;
import mmc.ast.statements.IStatement;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class StatementBlockAdapter {
    public static Block adapt(MiniJavaParser.BlockContext block) {

        List<IStatement> statementList = new ArrayList<>();

        if (block.statement_block() != null) {
            block.statement_block().forEach(statement -> {
                if (statement.local_var_decl() != null) {
                    statementList.addAll(LocalVarDeclAdapter.adapt(statement.local_var_decl()));
                }
                else {
                    statementList.add(StatementAdapter.adapt(statement.statement()));
                }
            });
        }

        return new Block(statementList);
    }
}
