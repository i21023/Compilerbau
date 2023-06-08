package mmc.parser.adapter.statements;

import mmc.ast.statements.Block;
import mmc.ast.statements.IStatement;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class StatementBlockAdapter {
    public static Block adapt(MiniJavaParser.Statement_blockContext statementBlock) {

        List<IStatement> statementList = new ArrayList<>();

        if(statementBlock.statement()!= null){
            statementBlock.statement().forEach(statement -> {
                statementList.addAll(StatementAdapter.adapt(statement));
            });
        }

        return new Block(statementList);
    }
}
