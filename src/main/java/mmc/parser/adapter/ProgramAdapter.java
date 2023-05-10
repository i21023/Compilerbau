package mmc.parser.adapter;

import mmc.ast.main.ClassDecl;
import mmc.ast.main.Program;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class ProgramAdapter {

    public static Program adapt(MiniJavaParser.ProgramContext programContext) {

        List<ClassDecl> classes = new ArrayList<>();
        programContext.class_decl().forEach(classContext ->
                classes.add(ClassDeclAdapter.adapt(classContext)));

        return new Program(classes);
    }
}
