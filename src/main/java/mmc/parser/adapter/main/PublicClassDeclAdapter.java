package mmc.parser.adapter.main;

import mmc.ast.AccessModifier;
import mmc.ast.main.ClassDecl;
import mmc.ast.main.Constructor;
import mmc.ast.main.Field;
import mmc.ast.main.Method;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class PublicClassDeclAdapter {

    public static ClassDecl adapt(MiniJavaParser.Public_class_declContext classdeclContext) {

        List<Constructor> constructorDecls = new ArrayList<>();
        List<Method> methodDecls = new ArrayList<>();
        List<Field> fieldDecls = new ArrayList<>();

        classdeclContext.const_decl().forEach(constDecl -> constructorDecls
                .add(ConstDeclAdapter.adapt(constDecl)));
        classdeclContext.field_decl()
                .forEach(fieldDecl -> fieldDecls.addAll(FieldDeclAdapter.adapt(fieldDecl)));
        classdeclContext.method_decl().forEach(
                methodDecl -> methodDecls.add(MethodDeclAdapter.adapt(methodDecl)));

        AccessModifier accessModifier = AccessModifier.PUBLIC;

        return new ClassDecl(classdeclContext.ID().getText(), fieldDecls, methodDecls, constructorDecls, accessModifier,
                classdeclContext.getStart().getLine(), classdeclContext.getStop().getLine());
    }
}
