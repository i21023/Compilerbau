package mmc.parser.adapter.main;

import mmc.ast.main.ClassDecl;
import mmc.ast.main.Program;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class ProgramAdapter {

    public static Program adapt(MiniJavaParser.ProgramContext programContext) {

        List<ClassDecl> classes = new ArrayList<>();
        if (programContext.public_class_decl().ID() != null) {
            classes.add(PublicClassDeclAdapter.adapt(programContext.public_class_decl()));
            if (programContext.public_class_decl().class_decl() != null && !programContext.public_class_decl().class_decl().isEmpty()) {
                programContext.public_class_decl().class_decl().forEach(classContext ->
                        classes.add(ClassDeclAdapter.adapt(classContext)));
            }
        } else {
            programContext.public_class_decl().class_decl().forEach(classContext ->
                    classes.add(ClassDeclAdapter.adapt(classContext)));
        }

        return new Program(classes);
    }
}
