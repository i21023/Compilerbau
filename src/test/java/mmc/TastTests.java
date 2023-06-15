package mmc;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.Type;
import mmc.ast.expressions.*;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.Crement;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statements.*;
import mmc.codegen.visitors.ProgramCodeGenerator;
import mmc.compiler.ISyntaxTreeGenerator;
import mmc.compiler.SyntaxTreeGenerator;
import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ressources.helpers.Classwriter;
import ressources.helpers.Resources;

import java.beans.Statement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static mmc.semantikcheck.SemanticCheck.generateTypedast;

import static org.junit.jupiter.api.Assertions.assertEquals;

//hallo
public class TastTests {

    @Test
    @DisplayName("Empty Class")
    public void EmptyClassTest() throws IOException {
        CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/EmptyClass.java");

        //Program tast = Compiler.getAst(file);
        //List<Constructor> constructors = new List<Constructor>(1);
        ClassDecl classDecl = new ClassDecl("EmptyClass", new ArrayList<Field>(),
                new ArrayList<Method>(), new ArrayList<Constructor>());
        ArrayList<ClassDecl> classDecls = new ArrayList<ClassDecl>();
        classDecls.add(classDecl);
        Program testTast = new Program(classDecls);
        Program testTast2 = new Program(classDecls);
        Program tast = generateTypedast(testTast);
        assertEquals(testTast2, tast);

    }

    @Test
    @DisplayName("ClassIfLokalVar")
    public void ClassIfLokalVarTest() {
        Block ElseBlock = new Block(new ArrayList<IStatement>(Arrays.asList(new Return(new BoolExpr(false)))));
        Block IfBlock = new Block(new ArrayList<IStatement>(Arrays.asList(new Return(new BoolExpr(true)))));
        Binary IfExpression = new Binary(Operator.EQUAL, new LocalOrFieldVar("a"), new LocalOrFieldVar("b"));
        Block Rumpf = new Block(new ArrayList<IStatement>(Arrays.asList(new LocalVarDecl("a", BasicType.INT), new Assign(new LocalOrFieldVar("a"), new IntExpr(3), null), new LocalVarDecl("b", BasicType.INT), new Assign(new LocalOrFieldVar("b"), new IntExpr(3), null), new If(IfBlock, ElseBlock, IfExpression))));
        ArrayList<Method> method = new ArrayList<Method>(Arrays.asList(new Method(BasicType.BOOL, "isEqual", new ArrayList<Parameter>(), Rumpf, AccessModifier.PUBLIC, false)));
        ArrayList<ClassDecl> Testclass = new ArrayList<ClassDecl>(Arrays.asList(new ClassDecl("ClassIfLokalVar", new ArrayList<Field>(), method, new ArrayList<Constructor>())));
        Program prog = new Program(Testclass);

        Program tast = generateTypedast(prog);

        assertEquals(prog, tast);
    }

    @Test
    @DisplayName("Class with FieldVars and Method")
    public void FieldVarClassMutableTest() {

        Method method = new Method(BasicType.INT, "getY", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(
                        Arrays.asList(new LocalVarDecl("y",
                                BasicType.INT, new IntExpr(30)), new Return(null, new LocalOrFieldVar("y"))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("FieldVarClassMutable", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        Method method2 = new Method(BasicType.INT, "getY", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(
                        Arrays.asList(new LocalVarDecl("y",
                                BasicType.INT, new IntExpr(30)), new Return(BasicType.INT, new LocalOrFieldVar("y", BasicType.INT)))), BasicType.INT), AccessModifier.PUBLIC, false);


        ClassDecl classDecl2 = new ClassDecl("FieldVarClassMutable", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method2)),
                new ArrayList<Constructor>());

        Program tast = generateTypedast(prog);
        Program testTast = new Program(Arrays.asList(classDecl2));
        assertEquals(testTast, tast);

    }

    @Test
    @DisplayName("Class with FieldVars")
    public void FieldVarClassTest() {
        ClassDecl classDecl = new ClassDecl("FieldVarClass", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT,
                "x", AccessModifier.PUBLIC, new IntExpr(5), true))), new ArrayList<Method>(),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        Program tast = generateTypedast(prog);

        assertEquals(prog, tast);
    }

    @Test
    @DisplayName("Class with FieldVars and Method")
    public void LocalVarGetTest() {
        Method method = new Method(BasicType.INT, "getY", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(
                        Arrays.asList(new LocalVarDecl("y",
                                BasicType.INT, new IntExpr(30)), new Return(null, new LocalOrFieldVar("y"))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        Program tast = generateTypedast(prog);

        assertEquals(prog, tast);
    }

    @Test
    @DisplayName("Rekursion-Test")
    public void RekursionTest() {
        If Ifstm = new If(new Block(new ArrayList<IStatement>(Arrays.asList(new Return(null, new LocalOrFieldVar("a"))))),
                null, new Binary(Operator.EQUAL, new LocalOrFieldVar("b"), new IntExpr(0)));
        Method method = new Method(BasicType.INT, "addRek", new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"), new Parameter(BasicType.INT, "b"))),
                new Block(new ArrayList<IStatement>(
                        Arrays.asList(Ifstm, new Return(null, new MethodCall(new This(), "addRek",
                                new ArrayList<IExpression>(Arrays.asList(new Unary(Operator.INCSUF, new LocalOrFieldVar("a")),
                                        new Unary(Operator.DECSUF, new LocalOrFieldVar("b")))), null))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("Rekursion", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        Program tast = generateTypedast(prog);

        assertEquals(prog, tast);
    }

    @Test
    @DisplayName("While-Test")
    public void WhileTest() {
        Block WhileBlock = new Block(Arrays.asList(new LocalVarDecl("x", BasicType.INT)));
        While WhileStmt = new While(new BoolExpr(true), WhileBlock);
        Method method = new Method(BasicType.VOID, "While", new ArrayList<Parameter>(), new Block(new ArrayList<>(Arrays.asList(WhileStmt))), AccessModifier.PUBLIC, false);
        ClassDecl classDecl = new ClassDecl("WhileTest", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)), new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        Program tast = generateTypedast(prog);
        assertEquals(prog, tast);

    }

    @Test
    @DisplayName("For-Test")
    public void ForTest() {
        Block ForBlock = new Block(Arrays.asList(new LocalVarDecl("x", BasicType.INT)));
        For ForStmt = new For(new ArrayList<>(Arrays.asList(new LocalVarDecl("i", BasicType.INT, new IntExpr(0)))),
                new Binary(Operator.LESSEQUAL, new LocalOrFieldVar("i"), new IntExpr(10)),
                new ArrayList<>(Arrays.asList(new Crement(null, new LocalOrFieldVar("i"), Operator.INCSUF))), ForBlock);
        Method method = new Method(BasicType.VOID, "While", new ArrayList<Parameter>(), new Block(new ArrayList<>(Arrays.asList(ForStmt))), AccessModifier.PUBLIC, false);
        ClassDecl classDecl = new ClassDecl("WhileTest", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)), new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        Program tast = generateTypedast(prog);
        assertEquals(prog, tast);


    }

    @Test
    @DisplayName("If-Fail-Test")
    public void IfFailTest() {
        boolean HasFailed = false;

        Block IfBlock = new Block(Arrays.asList(new Return(new BoolExpr(true))));
        If Ifstm = new If(IfBlock, new Block(), new Binary(Operator.EQUAL, new IntExpr(3), new StringExpr("Hallo")));
        Method method = new Method(BasicType.BOOL, "Fails", new ArrayList<Parameter>(), new Block(new ArrayList<>(Arrays.asList(Ifstm))), AccessModifier.PUBLIC, false);
        ClassDecl classDecl = new ClassDecl("FailTestIf", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)), new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        try {
            Program tast = generateTypedast(prog);
        } catch (Exception e) {
            HasFailed = true;
        }
        assertEquals(true, HasFailed);

    }

    @Test
    @DisplayName("While-Fail-Test")
    public void WhileFailTest() {
        boolean HasFailed = false;
        Block WhileBlock = new Block(Arrays.asList(new LocalVarDecl("x", BasicType.INT)));
        While WhileStmt = new While(new Binary(Operator.EQUAL, new IntExpr(5), new BoolExpr(false)), WhileBlock);
        Method method = new Method(BasicType.VOID, "While", new ArrayList<Parameter>(), new Block(new ArrayList<>(Arrays.asList(WhileStmt))), AccessModifier.PUBLIC, false);
        ClassDecl classDecl = new ClassDecl("WhileTest", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)), new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        try {
            Program tast = generateTypedast(prog);
            assertEquals(prog, tast);
        } catch (Exception e) {
            HasFailed = true;
        }
        assertEquals(true, HasFailed);

    }

    @Test
    @DisplayName("ClassWithMultipleMethods")
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

            Program program = generateTypedast(prog);

            ArrayList<Method> methodsTast = new ArrayList<Method>();
            Method method1Tast = new Method(BasicType.VOID, "method1", new ArrayList<Parameter>(), new Block(), AccessModifier.PUBLIC, false);
            Method method2Tast = new Method(BasicType.INT, "method2", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(BasicType.INT, new IntExpr(1))), BasicType.INT), AccessModifier.PUBLIC, false);
            Method method3Tast = new Method(BasicType.BOOL, "method3", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(true))), BasicType.BOOL), AccessModifier.PUBLIC, false);
            Method method4Tast = new Method(BasicType.CHAR, "method4", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(BasicType.CHAR, new CharExpr('c'))), BasicType.CHAR), AccessModifier.PRIVATE, false);
            methodsTast.add(method1Tast);
            methodsTast.add(method2Tast);
            methodsTast.add(method3Tast);
            methodsTast.add(method4Tast);

            ClassDecl classDeclTast = new ClassDecl("ClassWithMultipleMethods", new ArrayList<Field>(),
                    methodsTast, new ArrayList<Constructor>());
            ArrayList<ClassDecl> classDeclsTast = new ArrayList<ClassDecl>();
            classDeclsTast.add(classDeclTast);
            Program testTast = new Program(classDeclsTast);


            assertEquals(testTast, program);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    //Tests mit Parser
    @Test
    @DisplayName("ParserWithMultipleMethods")
    public void ParserWithMultipleMethods() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/ClassWithMultipleMethods.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);

            Program prog = generateTypedast(program);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @Test
    @DisplayName("ParserWithMultipleMethods")
    public void ParserFieldVars() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/FieldVarClassMutable.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);

            Program prog = generateTypedast(program);


            assertEquals(prog, program);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }


}
