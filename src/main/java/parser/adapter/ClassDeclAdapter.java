package parser.adapter;

import mmc.ast.AccessModifier;
import mmc.ast.main.ClassDecl;
import mmc.ast.main.Constructor;
import parser.ANTLR.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class ClassDeclAdapter {

    public static ClassDecl adapt(MiniJavaParser.Class_declContext classdeclContext) {
        List<Constructor> constructorDecls = new ArrayList<>();


        AccessModifier accessModifier = AccessModifier.PRIVATE;
        if (classdeclContext.ACCES_MOD() != null) {
            switch (classdeclContext.ACCES_MOD().getText()) {
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
                    accessModifier = AccessModifier.PRIVATE;
                    break;
            }
        }

        return new ClassDecl(classdeclContext.ID().getText(), null, null, constructorDecls, accessModifier);
    }
}