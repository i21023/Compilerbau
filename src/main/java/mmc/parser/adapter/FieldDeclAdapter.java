package mmc.parser.adapter;

import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.ast.main.Field;
import mmc.parser.antlr.MiniJavaParser;

public class FieldDeclAdapter {
    public static Field adapt(MiniJavaParser.Field_declContext fieldDeclContext) {
        AccessModifier accessModifier = AccessModifier.PUBLIC;
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
                    accessModifier = AccessModifier.PUBLIC;
                    break;
            }
        }

        boolean staticFlag = false;
        if (fieldDeclContext.STATIC() != null) {
            staticFlag = true;
        }



        Type type = TypeAdapter.adapt(fieldDeclContext.type());

        String name = fieldDeclContext.ID().toString();




    }
}
