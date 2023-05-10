package mmc;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.main.*;
import mmc.ast.statements.Block;
import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ressources.helpers.Resources;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AstTests {

    @Test
    @DisplayName("Empty Class")
    public void EmptyClassTest() throws IOException {
        CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/EmptyClass.java");

        //Program ast = Compiler.getAst(file);
        //List<Constructor> constructors = new List<Constructor>(1);
        ClassDecl classDecl = new ClassDecl("EmptyClass",new ArrayList<Field>(),
                new ArrayList<Method>(),new ArrayList<Constructor>(),  AccessModifier.PUBLIC);
        ArrayList<ClassDecl> classDecls = new ArrayList<ClassDecl>();
        classDecls.add(classDecl);
        Program testAst = new Program(classDecls);
        //assertEquals(testAst,ast);
    }

    @Test
    @DisplayName("")
    public void ClassWithMethodTest(){
        ClassDecl classDecl = new ClassDecl("ClassMethod", new ArrayList<Field>(),new ArrayList<Method>(Arrays.asList(
                new Method(BasicType.VOID,"testMethod",new ArrayList<Parameter>(),new Block(), AccessModifier.PUBLIC,
                        false))), new ArrayList<Constructor>(), AccessModifier.PUBLIC);
    }

    @Test
    @DisplayName("Constructor")
    public void ClassConstructorTest() throws IOException {
        CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ClassConstructor.java");
        //aufruf Compiler
        //ClassDecl classDecl = new ClassDecl("EmptyClass", )
        ClassDecl classDecl;


    }
}
