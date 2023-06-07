package mmc;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.ReferenceType;
import mmc.ast.expressions.*;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.Crement;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.*;
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
import java.util.List;

import static mmc.semantikcheck.SemanticCheck.generateTypedast;

public class ByteCodeTest {

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
                con);
        Program prog = new Program(Arrays.asList(classDecl));

        //(Block pStatement, List<Parameter> pParameters, AccessModifier pAccessModifier, Block pBlock)
        Program test = new Program(Arrays.asList(new ClassDecl("ContructorWithParam", new ArrayList<Field>(), new ArrayList<Method>(),
                new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(new ArrayList<IStatement>()),
                        new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "x"))),
                        AccessModifier.PUBLIC))))));
    }

    @Test
    @DisplayName("Constructor with Parameter")
    public void ContructorWithVarTest() {
        ArrayList<Constructor> con = new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(new ArrayList<IStatement>(Arrays.asList(
                new LocalVarDecl("x", BasicType.INT, new IntExpr(5))))),
                new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "x"))),
                AccessModifier.PUBLIC)));

        ClassDecl classDecl = new ClassDecl("ContructorWithParam", new ArrayList<Field>(), new ArrayList<Method>(),
                con);
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
                "x", AccessModifier.PUBLIC, new IntExpr(5), true))), new ArrayList<Method>(),
                new ArrayList<Constructor>());

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
                "x", AccessModifier.PUBLIC, new IntExpr(10), true))), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

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
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("LocalVarGet", "/Users/julian/IdeaProjects/Compilerbau/Compilerbau/src/test/java/mmc", code);
    }


    @Test
    @DisplayName("Class with FieldVars and Method")
    public void BinaryTest() {
        Method method = new Method(BasicType.INT, "add", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(
                        Arrays.asList(new LocalVarDecl("y",
                                        BasicType.INT, new Binary(Operator.PLUS, new IntExpr(1), new IntExpr(1))),
                                new If(new Block(new ArrayList<IStatement>(Arrays.asList(new Assign(new LocalOrFieldVar("y"), new IntExpr(10), null))) {
                                }), null, new Binary(Operator.GREATEREQUAL, new IntExpr(1), new LocalOrFieldVar("y"))),

                                new Return(BasicType.INT, new LocalOrFieldVar("y"))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("LocalVarGet", "C:/Users/Julian/Desktop/test", code);
    }


    @Test
    @DisplayName("Class with While Loop")
    public void WhileLoopTest() {
        Method method = new Method(BasicType.INT, "loop", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("x", BasicType.INT, new IntExpr(5)),
                        new While(new Binary(Operator.LESS, new LocalOrFieldVar("x"), new IntExpr(0)),
                                new Assign(new LocalOrFieldVar("x"), new Binary(Operator.MINUS, new LocalOrFieldVar("x"), new IntExpr(1)), null)
                        ), new Return(BasicType.INT, new LocalOrFieldVar("x"))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT,  "f", AccessModifier.PUBLIC, new IntExpr(0), false))), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("LocalVarGet", "C:/Users/Julian/Desktop/test", code);
    }

    @Test
    @DisplayName("Object initialisation")
    public void NewTest() {
        Method method = new Method(BasicType.VOID, "foo", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("stringvar", new ReferenceType("java/lang/String"), new New(new ArrayList<>(), new ReferenceType("java/lang/String"))),
                        new Return(BasicType.VOID, null)))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("LocalVarGet", "C:/Users/Julian/Desktop/test", code);
    }

    @Test
    @DisplayName("For Loop")
    public void ForLoopTest() {
        Method method = new Method(BasicType.INT, "foo", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("i", BasicType.INT, new IntExpr(0)),
                        new For(new LocalVarDecl("j", BasicType.INT, new IntExpr(0)), new Binary(Operator.LESS, new LocalOrFieldVar("j", BasicType.INT), new IntExpr(10)), new Assign(new LocalOrFieldVar("j", BasicType.INT), new Binary(Operator.PLUS, new LocalOrFieldVar("j", BasicType.INT), new IntExpr(1)), BasicType.INT),
                                new Block(new ArrayList<>(Arrays.asList(
                                        new Assign(new LocalOrFieldVar("i", BasicType.INT), new Binary(Operator.PLUS, new LocalOrFieldVar("i", BasicType.INT), new LocalOrFieldVar("j", BasicType.INT)), BasicType.INT)
                                ))), null),
                        new Return(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("LocalVarGet", "C:/Users/Julian/Desktop/test", code);
    }

    @Test
    @DisplayName("Initialize String")
    public void StringTest() {
        Method method = new Method(new ReferenceType("java/lang/String"), "foo", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("i", new ReferenceType("java/lang/String"), new New(new ArrayList<>(Arrays.asList(new StringExpr("Test"))), new ReferenceType("java/lang/String"))),
                        new Return(new ReferenceType("java/lang/String"), new LocalOrFieldVar("i", new ReferenceType("java/lang/String")))))), AccessModifier.PUBLIC, false);

        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("LocalVarGet", "C:/Users/Julian/Desktop/test", code);
    }

    @Test
    @DisplayName("More Complex Test with For Loop, static Field Var and StatementExpressions as Expressions")
    public void ComplexTest1(){

        Method method = new Method( BasicType.INT, "foo", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("i", BasicType.INT),
                        new LocalVarDecl("kwd", BasicType.INT, new IntExpr(500)),
                        new Assign(new LocalOrFieldVar("i", BasicType.INT), new IntExpr(0), BasicType.INT),
                        new For(new LocalVarDecl("j", BasicType.INT, new IntExpr(0)), new Binary(Operator.LESS, new LocalOrFieldVar("j", BasicType.INT), new IntExpr(10)), new Crement(BasicType.INT, new LocalOrFieldVar("j"), Operator.INCSUF),
                                new Block(new ArrayList<>(Arrays.asList(
                                        new Assign(new LocalOrFieldVar("i", BasicType.INT), new Binary(Operator.PLUS, new LocalOrFieldVar("i", BasicType.INT), new LocalOrFieldVar("j", BasicType.INT)), BasicType.INT)
                                ))), null),
                        new Return( BasicType.INT, new Assign(new LocalOrFieldVar("i", BasicType.INT), new LocalOrFieldVar("i", BasicType.INT), BasicType.INT))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(new ArrayList<>(Arrays.asList(
                new Field( BasicType.INT,"field", AccessModifier.PUBLIC, new IntExpr(100), true)))), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));
    }


    @Test
    @DisplayName("Assign in If Condition")
    public void ComplexTest2(){

        /*        public class Test{

            public int foo(){
                int i;
                i = 0;

                if(!false && (i = 10) == 10){
                    i++;
                }
                else {
                    i--;
                }

                return i;
            }

        }*/

    Method method = new Method( BasicType.INT, "foo", new ArrayList<Parameter>(),
            new Block(new ArrayList<IStatement>(Arrays.asList(
                    new LocalVarDecl("i", BasicType.INT),
                    new Assign(new LocalOrFieldVar("i", BasicType.INT), new IntExpr(0), BasicType.INT),
                    new If(new Crement( BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.INCSUF ), new Crement( BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.DECSUF ),
                            new Binary(Operator.AND,
                                    new Unary(Operator.NOT, new BoolExpr(false)),
                                    new Binary(Operator.EQUAL, new Assign(new LocalOrFieldVar("i"), new IntExpr(10), BasicType.INT) ,new IntExpr(10))
                            )),

                    new Return( BasicType.INT, new LocalOrFieldVar("i", BasicType.INT))))), AccessModifier.PUBLIC, false);


    ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
            new ArrayList<Constructor>());


    Program prog = new Program(Arrays.asList(classDecl));

    }

    //Call nonstatic String Method charAt
    Method method = new Method( BasicType.INT, "foo", new ArrayList<Parameter>(),
            new Block(new ArrayList<IStatement>(Arrays.asList(
                    new LocalVarDecl("i", BasicType.INT),
                    new Assign(new LocalOrFieldVar("i", BasicType.INT), new IntExpr(0), BasicType.INT),
                    new If(new Crement( BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.INCSUF ), new Crement( BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.DECSUF ),
                            new Binary(Operator.AND,
                                    new Unary(Operator.NOT, new BoolExpr(false)),
                                    new Binary(Operator.EQUAL, new Assign(new LocalOrFieldVar("i"), new IntExpr(10), BasicType.INT) ,new IntExpr(10))
                            )),

                    new Return( BasicType.INT, new LocalOrFieldVar("i", BasicType.INT))))), AccessModifier.PUBLIC, false);

    Method method2 = new Method( BasicType.CHAR, "bar", new ArrayList<Parameter>(),
            new Block(new ArrayList<IStatement>(Arrays.asList(
                    new LocalVarDecl("x", new ReferenceType("java/lang/String"), new StringExpr("Hallo")),
                    new Return( BasicType.CHAR, new MethodCall(new LocalOrFieldVar("x", new ReferenceType("java/lang/String")), "charAt", new ArrayList<>(Arrays.asList(new IntExpr(1))), BasicType.CHAR))))), AccessModifier.PUBLIC, false);

    ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method, method2)),
            new ArrayList<Constructor>());
}

