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
                else if (statement.statement() != null){
                    statementList.add(StatementAdapter.adapt(statement.statement()));
                }
                else {
                    statementList.add(StatementBlockInlineAdapter.adapt(statement.statement_block_inline()));
                }
            });
        }

        return new Block(statementList,
                block.getStart().getLine(),
                block.getStop().getLine());
    }
}
