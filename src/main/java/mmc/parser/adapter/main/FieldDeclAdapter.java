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
        if (fieldDeclContext.ACCES_MOD() != null) {
            switch (fieldDeclContext.ACCES_MOD().getText()) {
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

        if (fieldDeclContext.COMMA() != null && fieldDeclContext.COMMA().size() > 0) {
            List<Field> fieldDecls = new ArrayList<>();
            for (int i = 0; i < fieldDeclContext.COMMA().size(); i++) {

                String name = fieldDeclContext.ID(i).getText();

                IExpression expression = null;
                if (fieldDeclContext.ASSIGN() != null && fieldDeclContext.ASSIGN().size() > 0) {
                    expression = ExpressionAdapter.adapt(fieldDeclContext.expr(i));
                }

                fieldDecls.add(new Field(type, name, accessModifier, expression, staticFlag));

            }
            return fieldDecls;
        } else {

            String name = fieldDeclContext.ID(0).getText();

            IExpression expression = null;
            if (fieldDeclContext.ASSIGN() != null && fieldDeclContext.ASSIGN().size() > 0) {
                expression = ExpressionAdapter.adapt(fieldDeclContext.expr(0));
            }

            return List.of(new Field(type, name, accessModifier, expression, staticFlag));
        }
    }
}
