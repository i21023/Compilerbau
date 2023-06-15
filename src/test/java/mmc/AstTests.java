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
import mmc.ast.statementexpression.MethodCall;
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
                new Method(BasicType.VOID, "testMethod", new ArrayList<Parameter>(), new Block(), AccessModifier.PUBLIC, false
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
                new Method(BasicType.VOID, "paramMethod", MethodParam, new Block(), AccessModifier.PUBLIC, false))), new ArrayList<Constructor>());
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
        ArrayList<Method> methods = new ArrayList<Method>(Arrays.asList(new Method(BasicType.BOOL, "isEqual", MethodParam, MethodBody, AccessModifier.PUBLIC, false)));
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
        ArrayList<Method> methods = new ArrayList<Method>(Arrays.asList(new Method(BasicType.BOOL, "mult", MethodParam, MethodBody, AccessModifier.PUBLIC, false)));
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

        Method method = new Method(BasicType.VOID, "changeX", new ArrayList<Parameter>(), new Block(new ArrayList<IStatement>(
                Arrays.asList(new Assign(new LocalOrFieldVar("x"),
                        new IntExpr(30))))), AccessModifier.PUBLIC, false);


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
    @DisplayName("ClassWithMultipleMethodsTest")
    public void ClassWithMultipleMethods() {
        ArrayList<Method> methods = new ArrayList<Method>();
        Method method1 = new Method(BasicType.VOID, "method1", new ArrayList<Parameter>(), new Block(), AccessModifier.PUBLIC, false);
        Method method2 = new Method(BasicType.INT, "method2", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(new IntExpr(1)))), AccessModifier.PUBLIC, false);
        Method method3 = new Method(BasicType.BOOL, "method3", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(new BoolExpr(true)))), AccessModifier.PUBLIC, false);
        Method method4 = new Method(BasicType.CHAR, "method4", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(new CharExpr('c')))), AccessModifier.PRIVATE, false);
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
                        new For(new ArrayList<>(Arrays.asList(new Block(Arrays.asList(new LocalVarDecl("i", BasicType.INT, new IntExpr(0)))))),
                                new Binary(Operator.LESS, new LocalOrFieldVar("i"), new LocalOrFieldVar("b")),
                                new ArrayList(Arrays.asList(new Crement(BasicType.INT, new LocalOrFieldVar("i"), Operator.INCSUF))),
                                new Block(Arrays.asList(new Assign(new LocalOrFieldVar("c"), new Binary(Operator.PLUS, new LocalOrFieldVar("c"), new LocalOrFieldVar("a")))))))));
        ArrayList<Parameter> Parameters = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"), new Parameter(BasicType.INT, "b")));

        Method method = new Method(BasicType.VOID, "testFor", Parameters, MethodBody, AccessModifier.PUBLIC, false);


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

    @Test
    @DisplayName("ClassIFLocalVar")
    public void ClassWithIfLocalVarTest() {

        Block MethodBody = new Block(Arrays.asList(new LocalVarDecl("a", BasicType.INT, new IntExpr(3)),
                new LocalVarDecl("b", BasicType.INT, new IntExpr(3)),
                new If(new Block(Arrays.asList(new Return(new BoolExpr(true))))
                        , new Block(Arrays.asList(new Return(new BoolExpr(false))))
                        , new Binary(Operator.EQUAL, new LocalOrFieldVar("a"), new LocalOrFieldVar("b")))));
        ArrayList<Method> methods = new ArrayList<Method>(Arrays.asList(new Method(BasicType.BOOL, "isEqual", new ArrayList<Parameter>(), MethodBody, AccessModifier.PUBLIC, false)));
        ClassDecl classes = new ClassDecl("ClassIfLokalVar", new ArrayList<Field>(), new ArrayList<Method>(methods), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ClassIfLokalVar.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    @DisplayName("MethodCallTest")
    public void MethodCallTest() {

        Block Method1Body = new Block(Arrays.asList(new LocalVarDecl("a", BasicType.INT, new IntExpr(1)), new Return(new LocalOrFieldVar("a"))));
        Block Method2Body = new Block(Arrays.asList(new Return(new Binary(Operator.PLUS, new LocalOrFieldVar("b"), new MethodCall(null, "getA", new ArrayList<>())))));

        Method method1 = new Method(BasicType.INT, "getA", new ArrayList<Parameter>(), Method1Body, AccessModifier.PRIVATE, false);
        Method method2 = new Method(BasicType.INT, "addConstant", new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "b"))), Method2Body, AccessModifier.PUBLIC, false);
        ClassDecl classes = new ClassDecl("MethodCall", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method1, method2)), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/MethodCall.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    @DisplayName("Rekursion")
    public void RekursionTest() {
        ArrayList<Parameter> params = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"), new Parameter(BasicType.INT, "b")));
        Block Method1Body = new Block(Arrays.asList(
                new If(new Block(Arrays.asList(new Return(new LocalOrFieldVar("a")))),
                        null,
                        new Binary(Operator.EQUAL, new LocalOrFieldVar("b"), new IntExpr(0))),
                new Return(new MethodCall(null, "addRek", new ArrayList<IExpression>(Arrays.asList(
                        new Crement(BasicType.INT, new LocalOrFieldVar("a"), Operator.INCSUF),
                        new Crement(BasicType.INT, new LocalOrFieldVar("b"), Operator.DECSUF)))))));

        Method method1 = new Method(BasicType.INT, "addRek", params, Method1Body, AccessModifier.PUBLIC, false);
        ClassDecl classes = new ClassDecl("Rekursion", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method1)), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/Rekursion.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    @DisplayName("BooleanOperator")
    public void BooleanOperatorTest() {
        ArrayList<Field> Fields = new ArrayList<Field>(Arrays.asList(
                new Field(BasicType.BOOL, "bool1", AccessModifier.DEFAULT, new BoolExpr(true), false),
                new Field(BasicType.BOOL, "bool2", AccessModifier.DEFAULT, new BoolExpr(false), false)));
        Block Method1Body = new Block(Arrays.asList(
                new If(
                        new Block(Arrays.asList(new Return(new BoolExpr(true)))), new Block(Arrays.asList(new Return(new BoolExpr(false)))),
                        new Binary(Operator.SINGLEAND, new LocalOrFieldVar("bool1"), new LocalOrFieldVar("bool2")))));

        Block Method2Body = new Block(Arrays.asList(
                new If(
                        new Block(Arrays.asList(new Return(new BoolExpr(true)))), new Block(Arrays.asList(new Return(new BoolExpr(false)))),
                        new Binary(Operator.SINGLEOR, new LocalOrFieldVar("bool1"), new LocalOrFieldVar("bool2")))));


        Method method1 = new Method(BasicType.BOOL, "OpAnd", new ArrayList<Parameter>(), Method1Body, AccessModifier.PUBLIC, false);
        Method method2 = new Method(BasicType.BOOL, "OpOr", new ArrayList<Parameter>(), Method2Body, AccessModifier.PUBLIC, false);
        ClassDecl classes = new ClassDecl("BooleanOperator", Fields, new ArrayList<Method>(Arrays.asList(method1, method2)), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/BooleanOperator.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    @DisplayName("ReturnMethodTest")
    public void ReturnMethodTest() {


        Block MethodBody = new Block(Arrays.asList(new Return(new Binary(Operator.PLUS, new LocalOrFieldVar("a"), new LocalOrFieldVar("b")))));


        Method method = new Method(BasicType.INT, "add", new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b"))), MethodBody, AccessModifier.PUBLIC, false);
        ClassDecl classes = new ClassDecl("ReturnMethod", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ReturnMethod.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    @DisplayName("LocalVarGetTest")
    public void LocalVarGetTest() {


        Block MethodBody = new Block(Arrays.asList(new LocalVarDecl("y", BasicType.INT, new IntExpr(30)), new Return(new LocalOrFieldVar("y"))));


        Method method = new Method(BasicType.INT, "getY", new ArrayList<Parameter>(), MethodBody, AccessModifier.PUBLIC, false);
        ClassDecl classes = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/LocalVarGet.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    @DisplayName("FieldVarClassTest")
    public void FieldVarClassTest() {

        ClassDecl classes = new ClassDecl("FieldVarClass", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT, "x", AccessModifier.DEFAULT, new IntExpr(5), false))), new ArrayList<Method>(), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/FieldVarClass.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Test
    @DisplayName("ArithmetikClassTest")
    public void ArithmetikClassTest() {
        ArrayList<Parameter> params = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"), new Parameter(BasicType.INT, "b")));
        Method method1 = new Method(BasicType.INT, "add", params, new Block(Arrays.asList(
                new If(new Block(Arrays.asList(new Return(new LocalOrFieldVar("a")))), null, new Binary(Operator.EQUAL, new LocalOrFieldVar("b"), new IntExpr(0))),
                new Return(new MethodCall(null, "add", new ArrayList<IExpression>(Arrays.asList(
                        new Binary(Operator.PLUS, new LocalOrFieldVar("a"), new IntExpr(1)), new Binary(Operator.MINUS, new LocalOrFieldVar("b"), new IntExpr(1)))))))), AccessModifier.PUBLIC, false);
        Method method2 = new Method(BasicType.INT, "mul", params, new Block(Arrays.asList(
                new If(new Block(Arrays.asList(new Return(new IntExpr(0)))), null, new Binary(Operator.EQUAL, new LocalOrFieldVar("b"), new IntExpr(0))),
                new If(new Block(Arrays.asList(new Return(new LocalOrFieldVar("a")))), null, new Binary(Operator.EQUAL, new LocalOrFieldVar("b"), new IntExpr(1))),
                new Return(new MethodCall(null, "add", new ArrayList<IExpression>(Arrays.asList(
                        new LocalOrFieldVar("a"), new MethodCall(null, "mul", new ArrayList<IExpression>(Arrays.asList(
                                new LocalOrFieldVar("a"), new Binary(Operator.MINUS, new LocalOrFieldVar("b"), new IntExpr(1))
                        ))))))))), AccessModifier.PUBLIC, false);

        ClassDecl classes = new ClassDecl("ArithmetikClass", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method1, method2)), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ArithmetikClass.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
