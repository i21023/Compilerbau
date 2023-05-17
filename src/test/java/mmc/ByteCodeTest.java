package mmc;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.expressions.IntExpr;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statements.Block;
import mmc.ast.statements.IStatement;
import mmc.ast.statements.LocalVarDecl;
import mmc.ast.statements.Return;
import mmc.codegen.visitors.ProgramCodeGenerator;
import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ressources.helpers.Classwriter;
import ressources.helpers.Resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static mmc.semantikcheck.SemanticCheck.generateTypedast;

public class ByteCodeTest {

    @Test
    @DisplayName("Empty Class")
    public void EmptyClassTest() throws IOException {
        CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/EmptyClass.java");

        //Program tast = Compiler.getAst(file);
        //List<Constructor> constructors = new List<Constructor>(1);
        ClassDecl classDecl = new ClassDecl("EmptyClass", new ArrayList<Field>(),
                new ArrayList<Method>(), new ArrayList<Constructor>(), AccessModifier.PUBLIC);
        ArrayList<ClassDecl> classDecls = new ArrayList<ClassDecl>();
        classDecls.add(classDecl);
        Program testTast = new Program(classDecls);

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(testTast);

        Classwriter.WriteClassFile("EmptyClass", "C:/Users/Micha/Documents/GitHub/Tests", code);

    }

    @Test
    @DisplayName("Constructor with Parameter")
    public void ContructorWithParamTest() {
        ArrayList<Constructor> con = new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(new ArrayList<IStatement>()),
                new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "x"))),
                AccessModifier.PUBLIC)));

        ClassDecl classDecl = new ClassDecl("ContructorWithParam", new ArrayList<Field>(), new ArrayList<Method>(),
                con, AccessModifier.PUBLIC);
        Program prog = new Program(Arrays.asList(classDecl));

        //(Block pStatement, List<Parameter> pParameters, AccessModifier pAccessModifier, Block pBlock)
        Program test = new Program(Arrays.asList(new ClassDecl("ContructorWithParam", new ArrayList<Field>(), new ArrayList<Method>(),
                new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(new ArrayList<IStatement>()),
                        new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "x"))),
                        AccessModifier.PUBLIC))), AccessModifier.PUBLIC)));
    }

    @Test
    @DisplayName("Constructor with Parameter")
    public void ContructorWithVarTest() {
        ArrayList<Constructor> con = new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(new ArrayList<IStatement>(Arrays.asList(
                new LocalVarDecl("x", BasicType.INT, new IntExpr(5))))),
                new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "x"))),
                AccessModifier.PUBLIC)));

        ClassDecl classDecl = new ClassDecl("ContructorWithParam", new ArrayList<Field>(), new ArrayList<Method>(),
                con, AccessModifier.PUBLIC);
        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("ContructorWithParam", "C:/Users/Micha/Documents/GitHub/Tests", code);


        //(Block pStatement, List<Parameter> pParameters, AccessModifier pAccessModifier, Block pBlock)
        /*Program test = new Program(Arrays.asList(new ClassDecl("ContructorWithParam", new ArrayList<Field>(), new ArrayList<Method>(),
                new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(new ArrayList<IStatement>()),
                        new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT,"x"))),
                        AccessModifier.PUBLIC))), AccessModifier.PUBLIC)));*/
    }

    @Test
    @DisplayName("Class with FieldVars")
    public void FieldVarClassTest() {
        ClassDecl classDecl = new ClassDecl("FieldVarClass", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT,
                "x", AccessModifier.PUBLIC, new IntExpr(5), false))), new ArrayList<Method>(),
                new ArrayList<Constructor>(), AccessModifier.PUBLIC);

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("FieldVarClass", "C:/Users/Micha/Documents/GitHub/Tests", code);

    }

    @Test
    @DisplayName("Class with FieldVars and Method")
    public void FieldVarClassMutableTest() {

        Method method = new Method(BasicType.VOID, "changeX", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(
                        Arrays.asList(new Assign(new LocalOrFieldVar("x"),
                                new IntExpr(30), null)))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("FieldVarClassMutable", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT,
                "x", AccessModifier.PUBLIC, new IntExpr(10), false))), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>(), AccessModifier.PUBLIC);

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("FieldVarClassMutable", "C:/Users/Micha/Documents/GitHub/Tests", code);

    }

    @Test
    @DisplayName("Class with FieldVars and Method")
    public void LocalVarGetTest() {
        Method method = new Method(BasicType.INT, "getY", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(
                        Arrays.asList(new LocalVarDecl("y",
                                BasicType.INT, new IntExpr(30)), new Return(BasicType.INT, new LocalOrFieldVar("y"))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>(), AccessModifier.PUBLIC);

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("LocalVarGet", "/Users/julian/IdeaProjects/Compilerbau/Compilerbau/src/test/java/mmc", code);
    }
}

