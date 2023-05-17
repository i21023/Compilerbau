package mmc.parser.adapter;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.ast.main.Field;
import mmc.ast.statements.IStatement;
import mmc.ast.statements.LocalVarDecl;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class LocalVarDeclAdapter {
    public static List<IStatement> adapt(MiniJavaParser.Local_var_declContext localVarDecl) {

        Type type = TypeAdapter.adapt(localVarDecl.type());

        if (localVarDecl.COMMA() != null && localVarDecl.COMMA().size() > 0) {
            List<IStatement> localVarDecls = new ArrayList<>();

            for (int i = 0; i < localVarDecl.COMMA().size(); i++) {

                String name = localVarDecl.ID(i).getText();

                IExpression expression = null;
                if (localVarDecl.ASSIGN() != null) {
                    expression = ExpressionAdapter.adapt(localVarDecl.expr(i));
                }

                localVarDecls.add(new LocalVarDecl(name, type, expression));

            }
            return localVarDecls;
        } else {

            String name = localVarDecl.ID(0).getText();

            IExpression expression = null;
            if (localVarDecl.ASSIGN() != null) {
                expression = ExpressionAdapter.adapt(localVarDecl.expr(0));
            }

            return List.of(new LocalVarDecl(name, type, expression));
        }
    }
}
