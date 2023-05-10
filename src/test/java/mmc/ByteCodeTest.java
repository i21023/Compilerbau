package mmc;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.expressions.IntExpr;
import mmc.ast.main.*;
import mmc.ast.statements.Block;
import mmc.ast.statements.IStatement;
import mmc.ast.statements.LocalVarDecl;
import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ressources.helpers.Resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ByteCodeTest {

    @Test
    @DisplayName("Empty Class")
    public void EmptyClassTest() throws IOException {
        CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/EmptyClass.java");

        //Program tast = Compiler.getAst(file);
        //List<Constructor> constructors = new List<Constructor>(1);
        ClassDecl classDecl = new ClassDecl("EmptyClass",new ArrayList<Field>(),
                new ArrayList<Method>(),new ArrayList<Constructor>(),  AccessModifier.PUBLIC);
        ArrayList<ClassDecl> classDecls = new ArrayList<ClassDecl>();
        classDecls.add(classDecl);
        Program testTast = new Program(classDecls);

    }

    @Test
    @DisplayName("Constructor with Parameter")
    public void ContructorWithParamTest(){
        ArrayList<Constructor> con = new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(new ArrayList<IStatement>()),
                new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT,"x"))),
                AccessModifier.PUBLIC,new Block(new ArrayList<IStatement>()))));

        ClassDecl classDecl = new ClassDecl("ContructorWithParam", new ArrayList<Field>(), new ArrayList<Method>(),
                        con, AccessModifier.PUBLIC);
        Program prog = new Program(Arrays.asList(classDecl));

        //(Block pStatement, List<Parameter> pParameters, AccessModifier pAccessModifier, Block pBlock)
       Program test = new Program(Arrays.asList(new ClassDecl("ContructorWithParam", new ArrayList<Field>(), new ArrayList<Method>(),
                new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(new ArrayList<IStatement>()),
                        new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT,"x"))),
                        AccessModifier.PUBLIC,new Block(new ArrayList<IStatement>())))), AccessModifier.PUBLIC)));
    }

    @Test
    @DisplayName("Constructor with Parameter")
    public void ContructorWithVarTest(){
        ArrayList<Constructor> con = new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(new ArrayList<IStatement>(Arrays.asList(
                new LocalVarDecl("x", BasicType.INT, new IntExpr(5))))),
                new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT,"x"))),
                AccessModifier.PUBLIC,new Block(new ArrayList<IStatement>()))));

        ClassDecl classDecl = new ClassDecl("ContructorWithParam", new ArrayList<Field>(), new ArrayList<Method>(),
                con, AccessModifier.PUBLIC);
        Program prog = new Program(Arrays.asList(classDecl));

        //(Block pStatement, List<Parameter> pParameters, AccessModifier pAccessModifier, Block pBlock)
        Program test = new Program(Arrays.asList(new ClassDecl("ContructorWithParam", new ArrayList<Field>(), new ArrayList<Method>(),
                new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(new ArrayList<IStatement>()),
                        new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT,"x"))),
                        AccessModifier.PUBLIC,new Block(new ArrayList<IStatement>())))), AccessModifier.PUBLIC)));
    }
}

