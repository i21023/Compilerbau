package mmc;

import mmc.ast.*;
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


        ClassDecl classDecl = new ClassDecl("EmptyClass", new ArrayList<Field>(),
                new ArrayList<Method>(), new ArrayList<Constructor>());
        ArrayList<ClassDecl> classDecls = new ArrayList<ClassDecl>();
        classDecls.add(classDecl);
        Program prog = new Program(classDecls);
        //generate Tast
        Program genTast = generateTypedast(prog);

        //selfmade Tast
        ClassDecl classDecl2 = new ClassDecl("EmptyClass", new ArrayList<Field>(),
                new ArrayList<Method>(), new ArrayList<Constructor>());
        ArrayList<ClassDecl> classDecls2 = new ArrayList<ClassDecl>();
        classDecls2.add(classDecl2);
        Program program = new Program(classDecls2);


        assertEquals(program, genTast);
    }

    @Test
    @DisplayName("ClassWithMethodTest")
    public void ClassWithMethodTest() {
        ClassDecl classDecl = new ClassDecl("ClassMethod", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(
                new Method(BasicType.VOID, "testMethod", new ArrayList<Parameter>(), new Block(), AccessModifier.PUBLIC, false
                ))), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classDecl));

        Program genTast = generateTypedast(prog);

        ClassDecl classDecl2 = new ClassDecl("ClassMethod", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(
                new Method(BasicType.VOID, "testMethod", new ArrayList<Parameter>(), new Block(), AccessModifier.PUBLIC, false
                ))), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classDecl2));

        assertEquals(tast, genTast);


    }

    @Test
    @DisplayName("ClassWithMethodParamTest")
    public void ClassWithMethodParamTest() {
        ArrayList<Parameter> MethodParam = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b")));
        ClassDecl classDecl = new ClassDecl("ClassMethodParam", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(
                new Method(BasicType.VOID, "paramMethod", MethodParam, new Block(), AccessModifier.PUBLIC, false))), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classDecl));

        Program genTast = generateTypedast(prog);

        ArrayList<Parameter> MethodParam2 = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b")));
        ClassDecl classDecl2 = new ClassDecl("ClassMethodParam", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(
                new Method(BasicType.VOID, "paramMethod", MethodParam2, new Block(), AccessModifier.PUBLIC, false))), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classDecl2));

        assertEquals(tast, genTast);


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

        Program genTast = generateTypedast(prog);

        ArrayList<Constructor> con2 = new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(
                new ArrayList<IStatement>(Arrays.asList(new LocalVarDecl("a", BasicType.INT, new IntExpr(5))))),
                new ArrayList<Parameter>(),
                AccessModifier.PUBLIC)));

        ClassDecl classDecl2 = new ClassDecl("ClassContsructor", new ArrayList<Field>(), new ArrayList<Method>(),
                con2);
        Program tast = new Program(Arrays.asList(classDecl2));

        assertEquals(tast, genTast);
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

        Program genTast = generateTypedast(prog);

        ArrayList<Parameter> MethodParam2 = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b")));
        Block MethodBody2 = new Block(Arrays.asList(new If(new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(true))), BasicType.BOOL)
                , new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(false))), BasicType.BOOL)
                , new Binary(Operator.EQUAL, new LocalOrFieldVar("a", BasicType.INT), new LocalOrFieldVar("b", BasicType.INT), BasicType.BOOL), BasicType.BOOL)), BasicType.BOOL);
        ArrayList<Method> methods2 = new ArrayList<Method>(Arrays.asList(new Method(BasicType.BOOL, "isEqual", MethodParam2, MethodBody2, AccessModifier.PUBLIC, false)));
        ClassDecl classes2 = new ClassDecl("ClassIf", new ArrayList<Field>(), new ArrayList<Method>(methods2), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        assertEquals(tast, genTast);

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
        ArrayList<Method> methods = new ArrayList<Method>(Arrays.asList(new Method(BasicType.INT, "mult", MethodParam, MethodBody, AccessModifier.PUBLIC, false)));
        ClassDecl classes = new ClassDecl("ClassWhile", new ArrayList<Field>(), new ArrayList<Method>(methods), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        Program genTast = generateTypedast(prog);

        ArrayList<Parameter> MethodParam2 = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b")));
        Block MethodBody2 = new Block(Arrays.asList(new LocalVarDecl("c", BasicType.INT, new IntExpr(0)),
                new If(new Block(Arrays.asList(new Return(BasicType.INT, new IntExpr(0))), BasicType.INT)
                        , null
                        , new Binary(Operator.OR,
                        new Binary(Operator.EQUAL, new LocalOrFieldVar("a", BasicType.INT), new IntExpr(0), BasicType.BOOL),
                        new Binary(Operator.EQUAL, new LocalOrFieldVar("b", BasicType.INT), new IntExpr(0), BasicType.BOOL), BasicType.BOOL), BasicType.INT),
                new While(new Binary(Operator.NOTEQUAL, new LocalOrFieldVar("b", BasicType.INT), new IntExpr(1), BasicType.INT),
                        new Block(Arrays.asList(new Assign(new LocalOrFieldVar("c", BasicType.INT), new Binary(Operator.PLUS, new LocalOrFieldVar("c", BasicType.INT), new LocalOrFieldVar("a", BasicType.INT), BasicType.INT), BasicType.INT),
                                new Crement(BasicType.INT, new LocalOrFieldVar("b", BasicType.INT), Operator.DECSUF)), BasicType.INT), BasicType.INT),
                new Return(BasicType.INT, new LocalOrFieldVar("c", BasicType.INT))), BasicType.INT);
        ArrayList<Method> methods2 = new ArrayList<Method>(Arrays.asList(new Method(BasicType.INT, "mult", MethodParam2, MethodBody2, AccessModifier.PUBLIC, false)));
        ClassDecl classes2 = new ClassDecl("ClassWhile", new ArrayList<Field>(), new ArrayList<Method>(methods2), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));


        assertEquals(tast, genTast); //While funktioniert noch nicht richtig. Type wird nicht gesetzt
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

        Program genTast = generateTypedast(prog);

        Method method2 = new Method(BasicType.VOID, "changeX", new ArrayList<Parameter>(), new Block(new ArrayList<IStatement>(
                Arrays.asList(new Assign(new LocalOrFieldVar("x", BasicType.INT),
                        new IntExpr(30), BasicType.INT)))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl2 = new ClassDecl("FieldVarClassMutable", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT,
                "x", AccessModifier.PUBLIC, new IntExpr(10), false))), new ArrayList<Method>(Arrays.asList(method2)),
                new ArrayList<Constructor>());

        Program tast = new Program(Arrays.asList(classDecl2));

        assertEquals(tast, genTast);

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

        Program genTast = generateTypedast(prog);

        ArrayList<Method> methods2 = new ArrayList<Method>();
        Method method1_2 = new Method(BasicType.VOID, "method1", new ArrayList<Parameter>(), new Block(), AccessModifier.PUBLIC, false);
        Method method2_2 = new Method(BasicType.INT, "method2", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(BasicType.INT, new IntExpr(1))), BasicType.INT), AccessModifier.PUBLIC, false);
        Method method3_2 = new Method(BasicType.BOOL, "method3", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(true))), BasicType.BOOL), AccessModifier.PUBLIC, false);
        Method method4_2 = new Method(BasicType.CHAR, "method4", new ArrayList<Parameter>(), new Block(Arrays.asList(new Return(BasicType.CHAR, new CharExpr('c'))), BasicType.CHAR), AccessModifier.PRIVATE, false);
        methods2.add(method1_2);
        methods2.add(method2_2);
        methods2.add(method3_2);
        methods2.add(method4_2);

        ClassDecl classDecl2 = new ClassDecl("ClassWithMultipleMethods", new ArrayList<Field>(),
                methods2, new ArrayList<Constructor>());
        ArrayList<ClassDecl> classDecls2 = new ArrayList<ClassDecl>();
        classDecls2.add(classDecl2);
        Program tast = new Program(classDecls2);

        assertEquals(tast, genTast);
    }

    @Test
    @DisplayName("For-Loop Test")
    public void ForLoopTest() {
        ArrayList<Parameter> params = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"), new Parameter(BasicType.INT, "b")));
        Method method = new Method(BasicType.INT, "testFor", params, new Block(Arrays.asList(
                new LocalVarDecl("c", BasicType.INT, new LocalOrFieldVar("a")),
                new For(Arrays.asList(new LocalVarDecl("i", BasicType.INT, new IntExpr(0))),
                        new Binary(Operator.LESS, new LocalOrFieldVar("i"), new LocalOrFieldVar("b")),
                        Arrays.asList(new Crement(BasicType.INT, new LocalOrFieldVar("i"), Operator.INCSUF)),
                        new Block(Arrays.asList(new Assign(new LocalOrFieldVar("c"), new Binary(Operator.PLUS, new LocalOrFieldVar("c"), new LocalOrFieldVar("a")))))),
                new Return(new LocalOrFieldVar("c"))
        )), AccessModifier.PUBLIC, false);

        ArrayList<ClassDecl> classes = new ArrayList<ClassDecl>(Arrays.asList(
                new ClassDecl("ClassFor", new ArrayList<>(), Arrays.asList(method), new ArrayList<>(), AccessModifier.PUBLIC)
        ));

        Program prog = new Program(classes);

        Program genTast = generateTypedast(prog);

        ArrayList<Parameter> params2 = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"), new Parameter(BasicType.INT, "b")));
        Method method2 = new Method(BasicType.INT, "testFor", params2, new Block(Arrays.asList(
                new LocalVarDecl("c", BasicType.INT, new LocalOrFieldVar("a", BasicType.INT)),
                new For(Arrays.asList(new LocalVarDecl("i", BasicType.INT, new IntExpr(0))),
                        new Binary(Operator.LESS, new LocalOrFieldVar("i", BasicType.INT), new LocalOrFieldVar("b", BasicType.INT), BasicType.BOOL),
                        Arrays.asList(new Crement(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.INCSUF)),
                        new Block(Arrays.asList(new Assign(new LocalOrFieldVar("c", BasicType.INT), new Binary(Operator.PLUS, new LocalOrFieldVar("c", BasicType.INT), new LocalOrFieldVar("a", BasicType.INT), BasicType.INT), BasicType.INT)))),
                new Return(BasicType.INT, new LocalOrFieldVar("c", BasicType.INT))
        ), BasicType.INT), AccessModifier.PUBLIC, false);

        ArrayList<ClassDecl> classes2 = new ArrayList<ClassDecl>(Arrays.asList(
                new ClassDecl("ClassFor", new ArrayList<>(), Arrays.asList(method2), new ArrayList<>(), AccessModifier.PUBLIC)
        ));

        Program tast = new Program(classes2);

        assertEquals(tast, genTast);

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

        Program genTast = generateTypedast(prog);

        Block MethodBody2 = new Block(Arrays.asList(new LocalVarDecl("a", BasicType.INT, new IntExpr(3)),
                new LocalVarDecl("b", BasicType.INT, new IntExpr(3)),
                new If(new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(true))), BasicType.BOOL)
                        , new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(false))), BasicType.BOOL)
                        , new Binary(Operator.EQUAL, new LocalOrFieldVar("a", BasicType.INT), new LocalOrFieldVar("b", BasicType.INT), BasicType.BOOL), BasicType.BOOL)), BasicType.BOOL);
        ArrayList<Method> methods2 = new ArrayList<Method>(Arrays.asList(new Method(BasicType.BOOL, "isEqual", new ArrayList<Parameter>(), MethodBody2, AccessModifier.PUBLIC, false)));
        ClassDecl classes2 = new ClassDecl("ClassIfLokalVar", new ArrayList<Field>(), new ArrayList<Method>(methods2), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        assertEquals(tast, genTast);

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

        Program genTast = generateTypedast(prog);

        Block Method1Body2 = new Block(Arrays.asList(new LocalVarDecl("a", BasicType.INT, new IntExpr(1)), new Return(BasicType.INT, new LocalOrFieldVar("a", BasicType.INT))), BasicType.INT);
        Block Method2Body2 = new Block(Arrays.asList(new Return(BasicType.INT, new Binary(Operator.PLUS, new LocalOrFieldVar("b", BasicType.INT), new MethodCall(new This(new ReferenceType("MethodCall")), "getA", new ArrayList<>(), BasicType.INT), BasicType.INT))), BasicType.INT);

        Method method12 = new Method(BasicType.INT, "getA", new ArrayList<Parameter>(), Method1Body2, AccessModifier.PRIVATE, false);
        Method method22 = new Method(BasicType.INT, "addConstant", new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "b"))), Method2Body2, AccessModifier.PUBLIC, false);
        ClassDecl classes2 = new ClassDecl("MethodCall", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method12, method22)), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        assertEquals(tast, genTast);

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

        Program genTast = generateTypedast(prog);

        ArrayList<Parameter> params2 = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"), new Parameter(BasicType.INT, "b")));
        Block Method1Body2 = new Block(Arrays.asList(
                new If(new Block(Arrays.asList(new Return(BasicType.INT, new LocalOrFieldVar("a", BasicType.INT))), BasicType.INT),
                        null,
                        new Binary(Operator.EQUAL, new LocalOrFieldVar("b", BasicType.INT), new IntExpr(0), BasicType.BOOL), BasicType.INT),
                new Return(BasicType.INT, new MethodCall(new This(new ReferenceType("Rekursion")), "addRek", new ArrayList<IExpression>(Arrays.asList(
                        new Crement(BasicType.INT, new LocalOrFieldVar("a", BasicType.INT), Operator.INCSUF),
                        new Crement(BasicType.INT, new LocalOrFieldVar("b", BasicType.INT), Operator.DECSUF))), BasicType.INT))), BasicType.INT);

        Method method12 = new Method(BasicType.INT, "addRek", params2, Method1Body2, AccessModifier.PUBLIC, false);
        ClassDecl classes2 = new ClassDecl("Rekursion", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method12)), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        assertEquals(tast, genTast);
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

        Program genTast = generateTypedast(prog);

        ArrayList<Field> Fields2 = new ArrayList<Field>(Arrays.asList(
                new Field(BasicType.BOOL, "bool1", AccessModifier.DEFAULT, new BoolExpr(true), false),
                new Field(BasicType.BOOL, "bool2", AccessModifier.DEFAULT, new BoolExpr(false), false)));
        Block Method1Body2 = new Block(Arrays.asList(
                new If(
                        new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(true))), BasicType.BOOL), new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(false))), BasicType.BOOL),
                        new Binary(Operator.SINGLEAND, new LocalOrFieldVar("bool1", BasicType.BOOL), new LocalOrFieldVar("bool2", BasicType.BOOL), BasicType.BOOL), BasicType.BOOL)), BasicType.BOOL);

        Block Method2Body2 = new Block(Arrays.asList(
                new If(
                        new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(true))), BasicType.BOOL), new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(false))), BasicType.BOOL),
                        new Binary(Operator.SINGLEOR, new LocalOrFieldVar("bool1", BasicType.BOOL), new LocalOrFieldVar("bool2", BasicType.BOOL), BasicType.BOOL), BasicType.BOOL)), BasicType.BOOL);


        Method method12 = new Method(BasicType.BOOL, "OpAnd", new ArrayList<Parameter>(), Method1Body2, AccessModifier.PUBLIC, false);
        Method method22 = new Method(BasicType.BOOL, "OpOr", new ArrayList<Parameter>(), Method2Body2, AccessModifier.PUBLIC, false);
        ClassDecl classes2 = new ClassDecl("BooleanOperator", Fields2, new ArrayList<Method>(Arrays.asList(method12, method22)), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        assertEquals(tast, genTast);
    }

    @Test
    @DisplayName("ReturnMethodTest")
    public void ReturnMethodTest() {
        Block MethodBody = new Block(Arrays.asList(new Return(new Binary(Operator.PLUS, new LocalOrFieldVar("a"), new LocalOrFieldVar("b")))));

        Method method = new Method(BasicType.INT, "add", new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b"))), MethodBody, AccessModifier.PUBLIC, false);
        ClassDecl classes = new ClassDecl("ReturnMethod", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        Program genTast = generateTypedast(prog);

        Block MethodBody2 = new Block(Arrays.asList(new Return(BasicType.INT, new Binary(Operator.PLUS, new LocalOrFieldVar("a", BasicType.INT), new LocalOrFieldVar("b", BasicType.INT), BasicType.INT))), BasicType.INT);

        Method method2 = new Method(BasicType.INT, "add", new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b"))), MethodBody2, AccessModifier.PUBLIC, false);
        ClassDecl classes2 = new ClassDecl("ReturnMethod", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method2)), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        assertEquals(tast, genTast);
    }

    @Test
    @DisplayName("LocalVarGetTest")
    public void LocalVarGetTest() {
        Block MethodBody = new Block(Arrays.asList(new LocalVarDecl("y", BasicType.INT, new IntExpr(30)), new Return(new LocalOrFieldVar("y"))));
        Method method = new Method(BasicType.INT, "getY", new ArrayList<Parameter>(), MethodBody, AccessModifier.PUBLIC, false);
        ClassDecl classes = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        Program genTast = generateTypedast(prog);

        Block MethodBody2 = new Block(Arrays.asList(new LocalVarDecl("y", BasicType.INT, new IntExpr(30)), new Return(BasicType.INT, new LocalOrFieldVar("y", BasicType.INT))), BasicType.INT);
        Method method2 = new Method(BasicType.INT, "getY", new ArrayList<Parameter>(), MethodBody2, AccessModifier.PUBLIC, false);
        ClassDecl classes2 = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method2)), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        assertEquals(tast, genTast);
    }

    @Test
    @DisplayName("FieldVarClassTest")
    public void FieldVarClassTest() {
        ClassDecl classes = new ClassDecl("FieldVarClass", new ArrayList<Field>(Arrays.asList(
                new Field(BasicType.INT, "x", AccessModifier.DEFAULT, new IntExpr(5), false))),
                new ArrayList<Method>(), new ArrayList<Constructor>());
        Program prog = new Program(Arrays.asList(classes));

        Program genTast = generateTypedast(prog);

        ClassDecl classes2 = new ClassDecl("FieldVarClass", new ArrayList<Field>(Arrays.asList(
                new Field(BasicType.INT, "x", AccessModifier.DEFAULT, new IntExpr(5), false))),
                new ArrayList<Method>(), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        assertEquals(tast, genTast);
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

        Program genTast = generateTypedast(prog);

        ArrayList<Parameter> params2 = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"), new Parameter(BasicType.INT, "b")));
        Method method12 = new Method(BasicType.INT, "add", params2, new Block(Arrays.asList(
                new If(new Block(Arrays.asList(new Return(BasicType.INT, new LocalOrFieldVar("a", BasicType.INT))), BasicType.INT), null, new Binary(Operator.EQUAL, new LocalOrFieldVar("b", BasicType.INT), new IntExpr(0), BasicType.BOOL), BasicType.INT),
                new Return(BasicType.INT, new MethodCall(new This(new ReferenceType("ArithmetikClass")), "add", new ArrayList<IExpression>(Arrays.asList(
                        new Binary(Operator.PLUS, new LocalOrFieldVar("a", BasicType.INT), new IntExpr(1), BasicType.INT), new Binary(Operator.MINUS, new LocalOrFieldVar("b", BasicType.INT), new IntExpr(1), BasicType.INT))), BasicType.INT))), BasicType.INT), AccessModifier.PUBLIC, false);
        Method method22 = new Method(BasicType.INT, "mul", params2, new Block(Arrays.asList(
                new If(new Block(Arrays.asList(new Return(BasicType.INT, new IntExpr(0))), BasicType.INT), null, new Binary(Operator.EQUAL, new LocalOrFieldVar("b", BasicType.INT), new IntExpr(0), BasicType.BOOL), BasicType.INT),
                new If(new Block(Arrays.asList(new Return(BasicType.INT, new LocalOrFieldVar("a", BasicType.INT))), BasicType.INT), null, new Binary(Operator.EQUAL, new LocalOrFieldVar("b", BasicType.INT), new IntExpr(1), BasicType.BOOL), BasicType.INT),
                new Return(BasicType.INT, new MethodCall(new This(new ReferenceType("ArithmetikClass")), "add", new ArrayList<IExpression>(Arrays.asList(
                        new LocalOrFieldVar("a", BasicType.INT), new MethodCall(new This(new ReferenceType("ArithmetikClass")), "mul", new ArrayList<IExpression>(Arrays.asList(
                                new LocalOrFieldVar("a", BasicType.INT), new Binary(Operator.MINUS, new LocalOrFieldVar("b", BasicType.INT), new IntExpr(1), BasicType.INT)
                        )), BasicType.INT))), BasicType.INT))), BasicType.INT), AccessModifier.PUBLIC, false);

        ClassDecl classes2 = new ClassDecl("ArithmetikClass", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method12, method22)), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        assertEquals(tast, genTast);
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

    //FailTests
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

}
