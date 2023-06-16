package mmc.parser.adapter.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.ast.statements.IStatement;
import mmc.ast.statements.LocalVarDecl;
import mmc.parser.adapter.TypeAdapter;
import mmc.parser.adapter.expressions.ExpressionAdapter;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class LocalVarDeclAdapter {
    public static List<IStatement> adapt(MiniJavaParser.Local_var_declContext localVarDecl) {

        Type type = TypeAdapter.adapt(localVarDecl.type());

        List<IStatement> localVarDecls = new ArrayList<>();

        String name = localVarDecl.ID().getText();

        IExpression expression = null;
        if (localVarDecl.ASSIGN() != null) {
            expression = ExpressionAdapter.adapt(localVarDecl.expr());
        }

        localVarDecls.add(new LocalVarDecl(name, type, expression,
                localVarDecl.getStart().getLine(),
                localVarDecl.getStop().getLine()));

        if (localVarDecl.local_var_decl_concat() != null && localVarDecl.local_var_decl_concat().size() > 0) {

            for (int i = 0; i < localVarDecl.local_var_decl_concat().size(); i++) {

                name = localVarDecl.local_var_decl_concat(i).ID().getText();

                expression = null;
                if (localVarDecl.local_var_decl_concat(i).ASSIGN() != null) {
                    expression = ExpressionAdapter.adapt(localVarDecl.local_var_decl_concat(i).expr());
                }

                localVarDecls.add(new LocalVarDecl(name, type, expression,
                        localVarDecl.local_var_decl_concat(i).getStart().getLine(),
                        localVarDecl.local_var_decl_concat(i).getStop().getLine()));
            }
        }

        return localVarDecls;
    }
}
