package mmc.parser.adapter.main;

import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.ast.main.Field;
import mmc.parser.adapter.expressions.ExpressionAdapter;
import mmc.parser.adapter.TypeAdapter;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class FieldDeclAdapter {

    public static List<Field> adapt(MiniJavaParser.Field_declContext fieldDeclContext) {

        AccessModifier accessModifier = AccessModifier.DEFAULT;
        if (fieldDeclContext.access_mod() != null) {
            switch (fieldDeclContext.access_mod().getText()) {
                case "public":
                    accessModifier = AccessModifier.PUBLIC;
                    break;
                case "private":
                    accessModifier = AccessModifier.PRIVATE;
                    break;
                case "protected":
                    accessModifier = AccessModifier.PROTECTED;
                    break;
                default:
                    break;
            }
        }

        boolean staticFlag = false;
        if (fieldDeclContext.STATIC() != null) {
            staticFlag = true;
        }

        Type type = TypeAdapter.adapt(fieldDeclContext.type());

        List<Field> fieldDecls = new ArrayList<>();

        String name = fieldDeclContext.ID().getText();

        IExpression expression = null;
        if (fieldDeclContext.ASSIGN() != null) {
            expression = ExpressionAdapter.adapt(fieldDeclContext.expr());
        }

        fieldDecls.add(new Field(type, name, accessModifier, expression, staticFlag,
                fieldDeclContext.getStart().getLine(),fieldDeclContext.getStop().getLine()));

        if (fieldDeclContext.field_decl_concat() != null && fieldDeclContext.field_decl_concat().size() > 0) {

            for (int i = 0; i < fieldDeclContext.field_decl_concat().size(); i++) {

                name = fieldDeclContext.field_decl_concat(i).ID().getText();

                expression = null;
                if (fieldDeclContext.field_decl_concat(i).ASSIGN() != null) {
                    expression = ExpressionAdapter.adapt(fieldDeclContext.field_decl_concat(i).expr());
                }

                fieldDecls.add(new Field(type, name, accessModifier, expression, staticFlag,
                        fieldDeclContext.getStart().getLine(),
                        fieldDeclContext.getStop().getLine()));

            }
        }

        return fieldDecls;
    }
}
