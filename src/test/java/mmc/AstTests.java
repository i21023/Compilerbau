package mmc;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.expressions.*;
import mmc.ast.main.ClassDecl;
import mmc.ast.main.Constructor;
import mmc.ast.main.Field;
import mmc.ast.main.Method;
import mmc.ast.main.Parameter;
import mmc.ast.main.Program;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.Crement;
import mmc.ast.statements.*;
import mmc.compiler.ISyntaxTreeGenerator;
import mmc.compiler.SyntaxTreeGenerator;
import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ressources.helpers.Resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AstTests {

    @Test
    @DisplayName("Empty Class")
    public void EmptyClassTest() throws IOException {
        CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/EmptyClass.java");

        //Program ast = Compiler.getAst(file);
        //List<Constructor> constructors = new List<Constructor>(1);
        ClassDecl classDecl = new ClassDecl("EmptyClass", new ArrayList<Field>(),
                new ArrayList<Method>(), new ArrayList<Constructor>());
        ArrayList<ClassDecl> classDecls = new ArrayList<ClassDecl>();
        classDecls.add(classDecl);
        Program prog = new Program(classDecls);
        //try {
        //CharStream file = Resources.getFileInput("C:\\Users\\Micha\\Documents\\GitHub\\MachMalCompiler\\Compilerbau\\src\\test\\java\\ressources\\Testcases\\FieldVarClassMutable.java");
        ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

        Program program = astGenerator.generateSyntaxTree(file);


        assertEquals(prog, program);
        //} catch (IOException e) {
        //  e.printStackTrace();

        //}
    }

    /*@Test
    @DisplayName("ClassWithCommentsTest")
    public void ClassWithComments() {
        ClassDecl classDecl = new ClassDecl("ClassComments", new ArrayList<Field>(),
                new ArrayList<Method>(), new ArrayList<Constructor>());
        ArrayList<ClassDecl> classDecls = new ArrayList<ClassDecl>();
        classDecls.add(classDecl);
        Program prog = new Program(classDecls);

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ClassComments.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }*/

    @Test
    @DisplayName("ClassWithMethodTest")
    public void ClassWithMethodTest() {
        ClassDecl classDecl = new ClassDecl("ClassMethod", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(
                new Method(AccessModifier.PUBLIC, BasicType.VOID, "testMethod", new ArrayList<Parameter>(), new Block()
                ))), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classDecl));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ClassMethod.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    @DisplayName("ClassWithMethodParamTest")
    public void ClassWithMethodParamTest() {
        ArrayList<Parameter> MethodParam = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b")));
        ClassDecl classDecl = new ClassDecl("ClassMethodParam", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(
                new Method(AccessModifier.PUBLIC, BasicType.VOID, "paramMethod", MethodParam, new Block()))), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classDecl));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ClassMethodParam.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    @Test
    @DisplayName("Constructor")
    public void ClassConstructorTest() throws IOException {
        ArrayList<Constructor> con = new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(
                new ArrayList<IStatement>(Arrays.asList(new LocalVarDecl("a", BasicType.INT, new IntExpr(5))))),
                new ArrayList<Parameter>(),
                AccessModifier.PUBLIC)));

        ClassDecl classDecl = new ClassDecl("ClassContsructor", new ArrayList<Field>(), new ArrayList<Method>(),
                con);
        Program prog = new Program(Arrays.asList(classDecl));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ClassContsructor.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    @DisplayName("ClassIF")
    public void ClassWithIfTest() {
        ArrayList<Parameter> MethodParam = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b")));
        Block MethodBody = new Block(Arrays.asList(new If(new Block(Arrays.asList(new Return(new BoolExpr(true))))
                , new Block(Arrays.asList(new Return(new BoolExpr(false))))
                , new Binary(Operator.EQUAL, new LocalOrFieldVar("a"), new LocalOrFieldVar("b")))));
        ArrayList<Method> methods = new ArrayList<Method>(Arrays.asList(new Method(AccessModifier.PUBLIC, BasicType.BOOL, "isEqual", MethodParam, MethodBody)));
        ClassDecl classes = new ClassDecl("ClassIf", new ArrayList<Field>(), new ArrayList<Method>(methods), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ClassIf.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    @DisplayName("ClassWhile")
    public void ClassWhileTest() {
        ArrayList<Parameter> MethodParam = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b")));
        Block MethodBody = new Block(Arrays.asList(new LocalVarDecl("c", BasicType.INT, new IntExpr(0)),
                new If(new Block(Arrays.asList(new Return(new IntExpr(0))))
                        , null
                        , new Binary(Operator.OR,
                        new Binary(Operator.EQUAL, new LocalOrFieldVar("a"), new IntExpr(0)),
                        new Binary(Operator.EQUAL, new LocalOrFieldVar("b"), new IntExpr(0)))),
                new While(new Binary(Operator.NOTEQUAL, new LocalOrFieldVar("b"), new IntExpr(1)),
                        new Block(Arrays.asList(new Assign(new LocalOrFieldVar("c"), new Binary(Operator.PLUS, new LocalOrFieldVar("c"), new LocalOrFieldVar("a")), null),
                                new Crement(BasicType.INT, new LocalOrFieldVar("b"), Operator.DECSUF)))),
                new Return(new LocalOrFieldVar("c"))));
        ArrayList<Method> methods = new ArrayList<Method>(Arrays.asList(new Method(AccessModifier.PUBLIC, BasicType.BOOL, "mult", MethodParam, MethodBody)));
        ClassDecl classes = new ClassDecl("ClassWhile", new ArrayList<Field>(), new ArrayList<Method>(methods), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ClassWhile.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    @Test
    @DisplayName("Class with FieldVars and Method")
    public void FieldVarClassMutableTest() {

        Method method = new Method(AccessModifier.PUBLIC, BasicType.VOID, "changeX", new ArrayList<Parameter>(), new Block(new ArrayList<IStatement>(
                Arrays.asList(new Assign(new LocalOrFieldVar("x"),
                        new IntExpr(30))))));


        ClassDecl classDecl = new ClassDecl("FieldVarClassMutable", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT,
                "x", AccessModifier.PUBLIC, new IntExpr(10), false))), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        //Vergleich mit Parser muss hierhin

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/FieldVarClassMutable.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @Test
    @DisplayName("ClassWithCommentsTest")
    public void ClassWithMultipleMethods() {
        ArrayList<Method> methods = new ArrayList<Method>();
        Method method1 = new Method(AccessModifier.PUBLIC, BasicType.VOID, "method1", new ArrayList<Parameter>(), new Block());
        Method method2 = new Method(AccessModifier.PUBLIC, BasicType.INT, "method2", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(new IntExpr(1)))));
        Method method3 = new Method(AccessModifier.PUBLIC, BasicType.BOOL, "method3", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(new BoolExpr(true)))));
        Method method4 = new Method(AccessModifier.PRIVATE, BasicType.CHAR, "method4", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(new CharExpr('c')))));
        methods.add(method1);
        methods.add(method2);
        methods.add(method3);
        methods.add(method4);

        ClassDecl classDecl = new ClassDecl("ClassWithMultipleMethods", new ArrayList<Field>(),
                methods, new ArrayList<Constructor>());
        ArrayList<ClassDecl> classDecls = new ArrayList<ClassDecl>();
        classDecls.add(classDecl);
        Program prog = new Program(classDecls);

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ClassWithMultipleMethods.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    @DisplayName("For-Loop Test")
    public void ForLoopTest() {
        Block MethodBody = new Block(new ArrayList<IStatement>(
                Arrays.asList(new LocalVarDecl("c", BasicType.INT, new LocalOrFieldVar("a")),
                        new For(new Block(Arrays.asList(new LocalVarDecl("i", BasicType.INT, new IntExpr(0)))),
                                new Binary(Operator.LESS, new LocalOrFieldVar("i"), new LocalOrFieldVar("b")),
                                new Block(Arrays.asList(new Crement(BasicType.INT, new LocalOrFieldVar("i"), Operator.INCSUF))),
                                new Block(Arrays.asList(new Assign(new LocalOrFieldVar("c"), new Binary(Operator.PLUS, new LocalOrFieldVar("c"), new LocalOrFieldVar("a")))))))));
        ArrayList<Parameter> Parameters = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"), new Parameter(BasicType.INT, "b")));

        Method method = new Method(AccessModifier.PUBLIC, BasicType.VOID, "testFor", Parameters, MethodBody);


        ClassDecl classDecl = new ClassDecl("ClassFor", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT,
                "x", AccessModifier.PUBLIC, new IntExpr(10), false))), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        //Vergleich mit Parser muss hierhin

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ClassFor.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}
