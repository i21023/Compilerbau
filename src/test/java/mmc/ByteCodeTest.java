package mmc;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.ReferenceType;
import mmc.ast.expressions.*;
import mmc.ast.expressions.Class;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.Crement;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.*;
import mmc.codegen.ProgramCodeGenerator;

import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ressources.helpers.Classwriter;
import ressources.helpers.ReflectionHelper;
import ressources.helpers.Resources;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class ByteCodeTest {

    @Test
    @DisplayName("Empty Class")
    public void emptyClassTest() throws IOException {
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

        Classwriter.WriteClassFile("EmptyClass", "src/main/ressources_tests", code);
        try {
            // Name der Klasse, die instanziert werden soll
            String className = "EmptyClass";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();
        } catch (Exception e) {
            if (e instanceof InvocationTargetException) {
                Throwable cause = ((InvocationTargetException) e).getTargetException();
                cause.printStackTrace();
            } else {
                e.printStackTrace();
            }
        }

    }

    @Test
    @DisplayName("Constructor with Parameter")
    public void contructorWithParamTest() {
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
    public void contructorWithVarTest() {
        ArrayList<Constructor> con = new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(new ArrayList<IStatement>(Arrays.asList(
                new LocalVarDecl("x", BasicType.INT, new IntExpr(5))))),
                new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "x"))),
                AccessModifier.PUBLIC)));

        ClassDecl classDecl = new ClassDecl("ContructorWithParam", new ArrayList<Field>(), new ArrayList<Method>(),
                con);
        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("ContructorWithParam", "src/main/ressources_tests", code);


        //(Block pStatement, List<Parameter> pParameters, AccessModifier pAccessModifier, Block pBlock)
        /*Program test = new Program(Arrays.asList(new ClassDecl("ContructorWithParam", new ArrayList<Field>(), new ArrayList<Method>(),
                new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(new ArrayList<IStatement>()),
                        new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT,"x"))),
                        AccessModifier.PUBLIC))), AccessModifier.PUBLIC)));*/
    }

    @Test
    @DisplayName("Class with FieldVars")
    public void fieldVarClassTest() {
        ClassDecl classDecl = new ClassDecl("FieldVarClass", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT,
                "x", AccessModifier.PUBLIC, new IntExpr(5), true))), new ArrayList<Method>(),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("FieldVarClass", "src/main/ressources_tests", code);

    }

    @Test
    @DisplayName("Class with FieldVars and Method")
    public void fieldVarClassMutableTest() {

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

        Classwriter.WriteClassFile("FieldVarClassMutable", "src/main/ressources_tests", code);

        System.out.println("Test-Reihenfolge");
        //Ab hier Testen durch laden des Kompilates
        // Pfad zu .class-Verzeichnis

    }


    @Test
    @DisplayName("Class with FieldVars and Method")
    public void localVarGetTest() {
        Method method = new Method(BasicType.INT, "getY", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(
                        Arrays.asList(new LocalVarDecl("y",
                                BasicType.INT, new IntExpr(30)), new Return(BasicType.INT, new LocalOrFieldVar("y"))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("LocalVarGet", "src/main/ressources_tests", code);
    }


    @Test
    @DisplayName("Class with FieldVars and Method")
    public void binaryTest() {
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

        Classwriter.WriteClassFile("LocalVarGet", "src/main/ressources_tests", code);
    }


    @Test
    @DisplayName("Class with While Loop")
    public void whileLoopTest() {
        Method method = new Method(BasicType.INT, "loop", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("x", BasicType.INT, new IntExpr(5)),
                        new While(new Binary(Operator.LESS, new LocalOrFieldVar("x"), new IntExpr(0)),
                                new Assign(new LocalOrFieldVar("x"), new Binary(Operator.MINUS, new LocalOrFieldVar("x"), new IntExpr(1)), null)
                        ), new Return(BasicType.INT, new LocalOrFieldVar("x"))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT, "f", AccessModifier.PUBLIC, new IntExpr(0), false))), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("LocalVarGet", "src/main/ressources_tests", code);
    }

    @Test
    @DisplayName("Object initialisation")
    public void newTest() {
        Method method = new Method(BasicType.VOID, "foo", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("stringvar", new ReferenceType("java/lang/String"), new New("java/lang/String", new ArrayList<>())),
                        new Return(BasicType.VOID, null)))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("LocalVarGet", "src/main/ressources_tests", code);
    }

    @Test
    @DisplayName("For Loop")
    public void forLoopTest() {
        Method method = new Method(BasicType.INT, "foo", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("i", BasicType.INT, new IntExpr(0)),
                        new For(new ArrayList<>(Arrays.asList(new LocalVarDecl("j", BasicType.INT, new IntExpr(0)))), new Binary(Operator.LESS, new LocalOrFieldVar("j", BasicType.INT), new IntExpr(10)),
                                new ArrayList<>(Arrays.asList(new Assign(new LocalOrFieldVar("j", BasicType.INT), new Binary(Operator.PLUS, new LocalOrFieldVar("j", BasicType.INT), new IntExpr(1)), BasicType.INT))),
                                new Block(new ArrayList<>(Arrays.asList(
                                        new Assign(new LocalOrFieldVar("i", BasicType.INT), new Binary(Operator.PLUS, new LocalOrFieldVar("i", BasicType.INT), new LocalOrFieldVar("j", BasicType.INT)), BasicType.INT)
                                ))), null),
                        new Return(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("LocalVarGet", "src/main/ressources_tests", code);
    }

    @Test
    @DisplayName("Initialize String")
    public void stringTest() {
        Method method = new Method(new ReferenceType("java/lang/String"), "foo", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("i", new ReferenceType("java/lang/String"), new New("java/lang/String", new ArrayList<>(Arrays.asList(new StringExpr("Test"))))),
                        new Return(new ReferenceType("java/lang/String"), new LocalOrFieldVar("i", new ReferenceType("java/lang/String")))))), AccessModifier.PUBLIC, false);

        ClassDecl classDecl = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("LocalVarGet", "src/main/ressources_tests", code);
    }

    @Test
    @DisplayName("More Complex Test with For Loop, static Field Var and StatementExpressions as Expressions")
    public void complexTest1() {

        Method method = new Method(BasicType.INT, "foo", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("i", BasicType.INT),
                        new LocalVarDecl("kwd", BasicType.INT, new IntExpr(500)),
                        new Assign(new LocalOrFieldVar("i", BasicType.INT), new IntExpr(0), BasicType.INT),
                        new For(new ArrayList<>(Arrays.asList(new LocalVarDecl("j", BasicType.INT, new IntExpr(0)))), new Binary(Operator.LESS, new LocalOrFieldVar("j", BasicType.INT), new IntExpr(10)), new ArrayList<>(Arrays.asList(new Crement(BasicType.INT, new LocalOrFieldVar("j"), Operator.INCSUF))),
                                new Block(new ArrayList<>(Arrays.asList(
                                        new Assign(new LocalOrFieldVar("i", BasicType.INT), new Binary(Operator.PLUS, new LocalOrFieldVar("i", BasicType.INT), new LocalOrFieldVar("j", BasicType.INT)), BasicType.INT)
                                ))), null),
                        new Return(BasicType.INT, new Assign(new LocalOrFieldVar("i", BasicType.INT), new LocalOrFieldVar("i", BasicType.INT), BasicType.INT))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(new ArrayList<>(Arrays.asList(
                new Field(BasicType.INT, "field", AccessModifier.PUBLIC, new IntExpr(100), true)))), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));
    }


    @Test
    @DisplayName("Assign in If Condition")
    public void complexTest2() {

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

        Method method = new Method(BasicType.INT, "foo", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("i", BasicType.INT),
                        new Assign(new LocalOrFieldVar("i", BasicType.INT), new IntExpr(0), BasicType.INT),
                        new If(new Crement(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.INCSUF), new Crement(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.DECSUF),
                                new Binary(Operator.AND,
                                        new Unary(Operator.NOT, new BoolExpr(false)),
                                        new Binary(Operator.EQUAL, new Assign(new LocalOrFieldVar("i"), new IntExpr(10), BasicType.INT), new IntExpr(10))
                                )),

                        new Return(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());


        Program prog = new Program(Arrays.asList(classDecl));

    }

    @Test
    public void stringFunctionTest() {
        //Call nonstatic String Method charAt
        Method method = new Method(BasicType.INT, "foo", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("i", BasicType.INT),
                        new Assign(new LocalOrFieldVar("i", BasicType.INT), new IntExpr(0), BasicType.INT),
                        new If(new Crement(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.INCSUF), new Crement(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.DECSUF),
                                new Binary(Operator.AND,
                                        new Unary(Operator.NOT, new BoolExpr(false)),
                                        new Binary(Operator.EQUAL, new Assign(new LocalOrFieldVar("i"), new IntExpr(10), BasicType.INT), new IntExpr(10))
                                )),

                        new Return(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT))))), AccessModifier.PUBLIC, false);

        Method method2 = new Method(BasicType.CHAR, "bar", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("x", new ReferenceType("java/lang/String"), new StringExpr("Hallo")),
                        new Return(BasicType.CHAR, new MethodCall(new LocalOrFieldVar("x", new ReferenceType("java/lang/String")), "charAt", new ArrayList<>(Arrays.asList(new IntExpr(1))), BasicType.CHAR))))), AccessModifier.PUBLIC, false);

        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method, method2)),
                new ArrayList<Constructor>());
    }

    @Test
    public void binaryAndTest() {
        //Single And
    /*
    public class Test{

        public int foo(){
            int i;
            i = 0;

            if(!true & (i = 10) == 10){
                i++;
            }
            else{
                i--;
            }
            return i;
        }
    } */
        Method method = new Method(BasicType.INT, "foo", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new LocalVarDecl("i", BasicType.INT),
                        new Assign(new LocalOrFieldVar("i", BasicType.INT), new IntExpr(0), BasicType.INT),
                        new If(new Crement(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.INCSUF), new Crement(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.DECSUF),
                                new Binary(Operator.SINGLEAND,
                                        new Unary(Operator.NOT, new BoolExpr(true)),
                                        new Binary(Operator.EQUAL, new Assign(new LocalOrFieldVar("i"), new IntExpr(10), BasicType.INT), new IntExpr(9))
                                )),

                        new Return(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT))))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());


        Program prog = new Program(Arrays.asList(classDecl));
    }

    @Test
    public void printlnTest() {
        Method method = new Method(BasicType.VOID, "foo", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new MethodCall(
                                new InstVar("out",
                                        new Class("java/lang/System",
                                                new ReferenceType("java/lang/System")),
                                        new ReferenceType("java/io/PrintStream"), true), "println",
                                new ArrayList<>(Arrays.asList(
                                        new StringExpr("Hallo1234"))), BasicType.VOID)
                ))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());


        Program prog = new Program(Arrays.asList(classDecl));
    }

    @Test
    public void initStaticReferenceFieldVar() {

        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(
                Arrays.asList(new Field(new ReferenceType("java/lang/String"), "a", AccessModifier.PUBLIC, new StringExpr("Test"), false))
        ), new ArrayList<Method>(),
                new ArrayList<Constructor>());

        Program program = new Program(Arrays.asList(classDecl));
    }

    @Test
    public void fibonacciTest() {
        /*public class Test{

            public int fib(int n){
                if(n == 0 || n == 1)
                    return n;
                else
                    return fib(n-1) + fib(n-2);
            }
        }*/

        Method method = new Method(BasicType.INT, "fib", new ArrayList<Parameter>(Arrays.asList(
                new Parameter(BasicType.INT, "n")
        )),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new If(new Return(BasicType.INT, new LocalOrFieldVar("n", BasicType.INT, false)),
                                new Return(BasicType.INT, new Binary(Operator.PLUS,
                                        new MethodCall(new This(new ReferenceType("Test")), "fib", new ArrayList<>(Arrays.asList(
                                                new Binary(Operator.MINUS, new LocalOrFieldVar("n", BasicType.INT, false), new IntExpr(1), BasicType.INT))), BasicType.INT),
                                        new MethodCall(new This(new ReferenceType("Test")), "fib", new ArrayList<>(Arrays.asList(
                                                new Binary(Operator.MINUS, new LocalOrFieldVar("n", BasicType.INT, false), new IntExpr(2), BasicType.INT))), BasicType.INT))),
                                new Binary(Operator.OR,
                                        new Binary(Operator.EQUAL, new LocalOrFieldVar("n", BasicType.INT, false), new IntExpr(0)),
                                        new Binary(Operator.EQUAL, new LocalOrFieldVar("n", BasicType.INT, false), new IntExpr(1))
                                )),

                        new Return(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT))))), AccessModifier.PUBLIC, false);

        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program program = new Program(new ArrayList<>(Arrays.asList(classDecl)));

    }

    @Test
    public void fibWithMainFunc() {
        /*public class Test{

            public int fib(int n){
                if(n == 0 || n == 1)
                    return n;
                else
                    return fib(n-1) + fib(n-2);
            }

            public static void main(String[]args){
                Test test = new Test();
                System.out.println(test.fib(30));
            }
        }*/

        Method method = new Method(BasicType.INT, "fib", new ArrayList<Parameter>(Arrays.asList(
                new Parameter(BasicType.INT, "n")
        )),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new If(new Return(BasicType.INT, new LocalOrFieldVar("n", BasicType.INT, false)),
                                new Return(BasicType.INT, new Binary(Operator.PLUS,
                                        new MethodCall(new This(new ReferenceType("Test")), "fib", new ArrayList<>(Arrays.asList(
                                                new Binary(Operator.MINUS, new LocalOrFieldVar("n", BasicType.INT, false), new IntExpr(1), BasicType.INT))), BasicType.INT),
                                        new MethodCall(new This(new ReferenceType("Test")), "fib", new ArrayList<>(Arrays.asList(
                                                new Binary(Operator.MINUS, new LocalOrFieldVar("n", BasicType.INT, false), new IntExpr(2), BasicType.INT))), BasicType.INT))),
                                new Binary(Operator.OR,
                                        new Binary(Operator.EQUAL, new LocalOrFieldVar("n", BasicType.INT, false), new IntExpr(0)),
                                        new Binary(Operator.EQUAL, new LocalOrFieldVar("n", BasicType.INT, false), new IntExpr(1))
                                )),
                        new Return(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT))))), AccessModifier.PUBLIC, false);

        Method method1 = new MainMethod(new Block(new ArrayList<>(Arrays.asList(
                new LocalVarDecl("test", new ReferenceType("Test"), new New("Test", new ArrayList<>())),
                new MethodCall(
                        new InstVar("out",
                                new Class("java/lang/System",
                                        new ReferenceType("java/lang/System")),
                                new ReferenceType("java/io/PrintStream"), true), "println",
                        new ArrayList<>(Arrays.asList(
                                new MethodCall(new LocalOrFieldVar("test", new ReferenceType("Test"), false), "fib", new ArrayList<>(Arrays.asList(new IntExpr(30))), BasicType.INT))), BasicType.VOID)
        ))));

        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method, method1)),
                new ArrayList<Constructor>());

        Program program = new Program(new ArrayList<>(Arrays.asList(classDecl)));
    }


    public void incrementInstVar() {

        //Class Bar needs to be in the same folder
        /*class Bar{
            public static int i = 0;
            public int j = 1;
        }*/

        Method method = new MainMethod(new Block(new ArrayList<>(Arrays.asList(
                new LocalVarDecl("p", new ReferenceType("Bar"), new New("Bar", new ArrayList<>())),
                new LocalVarDecl("a", BasicType.INT, new Crement(BasicType.INT, new InstVar("j", new LocalOrFieldVar("p", new ReferenceType("Bar"), false), BasicType.INT, false), Operator.INCPRE)),
                new MethodCall(
                        new InstVar("out",
                                new Class("java/lang/System",
                                        new ReferenceType("java/lang/System")),
                                new ReferenceType("java/io/PrintStream"), true), "println",
                        new ArrayList<>(Arrays.asList(
                                new LocalOrFieldVar("a", BasicType.INT, false))), BasicType.VOID)
        ))));


        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program program = new Program(new ArrayList<>(Arrays.asList(classDecl)));
    }

    public void assignStaticInstVar() {

        //Class Bar needs to be in the same folder
        /*
        class Bar{
            public static int i = 0;
            public int j = 1;

            public void foo(){
            System.out.println(i);
            }
        }
        */

        Method method = new MainMethod(new Block(new ArrayList<>(Arrays.asList(
                new LocalVarDecl("p", new ReferenceType("Bar"), new New("Bar", new ArrayList<>())),
                new Assign(new InstVar("i", new Class("Bar", new ReferenceType("Bar")), BasicType.INT, true), new IntExpr(10), BasicType.INT),
                new MethodCall(
                        new InstVar("out",
                                new Class("java/lang/System",
                                        new ReferenceType("java/lang/System")),
                                new ReferenceType("java/io/PrintStream"), true), "println",
                        new ArrayList<>(Arrays.asList(
                                new InstVar("i", new Class("Bar", new ReferenceType("Bar")), BasicType.INT, true))
                        ), BasicType.VOID),
                new MethodCall(new LocalOrFieldVar("p", new ReferenceType("Bar"), false), "foo", new ArrayList<>(), BasicType.VOID)
        ))));

        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program program = new Program(new ArrayList<>(Arrays.asList(classDecl)));
    }

    public void inlineNewInstVarWithCrement() {

/*        class Test{

            public static void main(String[] args){
                int p = ++new Bar().i;
                ++p;
                System.out.println(p);
            }

        }

        class Bar{
            public static int i = 0;
        }*/

        Method method = new MainMethod(new Block(new ArrayList<>(Arrays.asList(
                new LocalVarDecl("p", BasicType.INT, new Crement(BasicType.INT, new InstVar("i", new New("Bar", new ArrayList<>()), BasicType.INT, false), Operator.INCPRE)),
                new Crement(BasicType.INT, new LocalOrFieldVar("p", BasicType.INT, false), Operator.DECPRE),
                new MethodCall(
                        new InstVar("out",
                                new Class("java/lang/System",
                                        new ReferenceType("java/lang/System")),
                                new ReferenceType("java/io/PrintStream"), true), "println",
                        new ArrayList<>(Arrays.asList(
                                new LocalOrFieldVar("p", BasicType.INT, false))
                        ), BasicType.VOID))

        )));

        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program program = new Program(new ArrayList<>(Arrays.asList(classDecl)));
    }


    public void staticFib() {

        /*public class Test{

            public static int fib(int n){
                if(n == 0 || n == 1)
                    return n;
                else
                    return fib(n-1) + fib(n-2);
            }

            public static void main(String[]args){
                System.out.println(fib(30));
            }
        }*/

        Method method = new Method(BasicType.INT, "fib", new ArrayList<Parameter>(Arrays.asList(
                new Parameter(BasicType.INT, "n")
        )),
                new Block(new ArrayList<IStatement>(Arrays.asList(
                        new If(new Return(BasicType.INT, new LocalOrFieldVar("n", BasicType.INT, false)),
                                new Return(BasicType.INT, new Binary(Operator.PLUS,
                                        new MethodCall(new This(new ReferenceType("Test")), "fib", new ArrayList<>(Arrays.asList(
                                                new Binary(Operator.MINUS, new LocalOrFieldVar("n", BasicType.INT, false), new IntExpr(1), BasicType.INT))), BasicType.INT, true),
                                        new MethodCall(new This(new ReferenceType("Test")), "fib", new ArrayList<>(Arrays.asList(
                                                new Binary(Operator.MINUS, new LocalOrFieldVar("n", BasicType.INT, false), new IntExpr(2), BasicType.INT))), BasicType.INT, true))),
                                new Binary(Operator.OR,
                                        new Binary(Operator.EQUAL, new LocalOrFieldVar("n", BasicType.INT, false), new IntExpr(0)),
                                        new Binary(Operator.EQUAL, new LocalOrFieldVar("n", BasicType.INT, false), new IntExpr(1))
                                )),
                        new Return(BasicType.INT, new LocalOrFieldVar("i", BasicType.INT))))), AccessModifier.PUBLIC, true);

        Method method1 = new MainMethod(new Block(new ArrayList<>(Arrays.asList(
                new MethodCall(
                        new InstVar("out",
                                new Class("java/lang/System",
                                        new ReferenceType("java/lang/System")),
                                new ReferenceType("java/io/PrintStream"), true), "println",
                        new ArrayList<>(Arrays.asList(
                                new MethodCall(new This(new ReferenceType("Test")), "fib", new ArrayList<>(Arrays.asList(new IntExpr(30))), BasicType.INT, true))), BasicType.VOID)
        ))));

        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method, method1)),
                new ArrayList<Constructor>());

        Program program = new Program(new ArrayList<>(Arrays.asList(classDecl)));
    }

    public void callStaticMethodFromOtherClass() {
        //Klasse Bar gegeben:
        /* class Bar{

            public static int foo(int n){
                return n;
            }

        }*/

        /* class Test{

            public static void main(String[] args){
                System.out.println(Bar.foo(30));
            }

        }*/

        Method method1 = new MainMethod(new Block(new ArrayList<>(Arrays.asList(
                new MethodCall(
                        new InstVar("out",
                                new Class("java/lang/System",
                                        new ReferenceType("java/lang/System")),
                                new ReferenceType("java/io/PrintStream"), true), "println",
                        new ArrayList<>(Arrays.asList(
                                new MethodCall(new LocalOrFieldVar("Bar", new ReferenceType("Bar")), "foo", new ArrayList<>(Arrays.asList(new IntExpr(30))), BasicType.INT, true))), BasicType.VOID)
        ))));

        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method1)),
                new ArrayList<Constructor>());

        Program program = new Program(new ArrayList<>(Arrays.asList(classDecl)));
    }

    @Test
    public void stringConcat() {

        Method method1 = new MainMethod(new Block(new ArrayList<>(Arrays.asList(

                new LocalVarDecl("i", new ReferenceType("java/lang/String"), new MethodCall(new StringExpr("Hallo"), "concat", new ArrayList<>(Arrays.asList(new StringExpr("Hallo"))), new ReferenceType("java/lang/String"))),
                new MethodCall(
                        new InstVar("out",
                                new Class("java/lang/System",
                                        new ReferenceType("java/lang/System")),
                                new ReferenceType("java/io/PrintStream"), true), "println",
                        new ArrayList<>(Arrays.asList(
                                new LocalOrFieldVar("i", new ReferenceType("java/lang/String"), false))), BasicType.VOID, false)
        ))));

        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method1)),
                new ArrayList<Constructor>());

        Program program = new Program(new ArrayList<>(Arrays.asList(classDecl)));
    }

    public void stringEqual() {
        Method method1 = new MainMethod(new Block(new ArrayList<>(Arrays.asList(

                new LocalVarDecl("i", BasicType.BOOL, new Binary(Operator.EQUAL, new New("java/lang/String", new ArrayList<>(Arrays.asList(new StringExpr("Hallo")))), new StringExpr("Hallo"), BasicType.BOOL)),
                new MethodCall(
                        new InstVar("out",
                                new Class("java/lang/System",
                                        new ReferenceType("java/lang/System")),
                                new ReferenceType("java/io/PrintStream"), true), "println",
                        new ArrayList<>(Arrays.asList(
                                new LocalOrFieldVar("i", BasicType.BOOL, false))), BasicType.VOID, false)
        ))));

        ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method1)),
                new ArrayList<Constructor>());

        Program program = new Program(new ArrayList<>(Arrays.asList(classDecl)));

    }

    public void staticInstVarCallOnReference() {
        Method MainMethod = new MainMethod(new Block(new ArrayList<>(Arrays.asList(new MethodCall(new Class("Main", new ReferenceType("Main")), "foo", new ArrayList<>(), BasicType.VOID, true)))));

        Method foo = new Method(BasicType.VOID, "foo", new ArrayList<>(), new Block(new ArrayList<>(Arrays.asList(
                new MethodCall(
                        new InstVar("out",
                                new Class("java/lang/System",
                                        new ReferenceType("java/lang/System")),
                                new ReferenceType("java/io/PrintStream"), true), "println",
                        new ArrayList<>(Arrays.asList(
                                new MethodCall(new InstVar("a",
                                        new MethodCall(new Class("Test", new ReferenceType("Test")), "getInstance", new ArrayList<>(), new ReferenceType("Test"), true), new ReferenceType("java/lang/String"), true)
                                        , "charAt", new ArrayList<>(List.of(new IntExpr(0))), BasicType.CHAR, false)
                        )), BasicType.VOID, false)))), AccessModifier.PUBLIC, true);

        ClassDecl main = new ClassDecl("Main", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(foo, MainMethod)),
                new ArrayList<Constructor>());

        Method getInstance = new Method(new ReferenceType("Test"), "getInstance", new ArrayList<>(), new Block(new ArrayList<>(Arrays.asList(
                new Return(new ReferenceType("Test"), new New("Test", new ArrayList<>())
                )))), AccessModifier.DEFAULT, true);

        ClassDecl test = new ClassDecl("Test", new ArrayList<Field>(
                Arrays.asList(new Field(new ReferenceType("java/lang/String"), "a", AccessModifier.DEFAULT, new StringExpr("MMC"), true))
        ), new ArrayList<Method>(Arrays.asList(getInstance)),
                new ArrayList<Constructor>());

        Program program = new Program(new ArrayList<>(Arrays.asList(main, test)));
    }

    public void staticMethodCallOnReference() {
        Method MainMethod = new MainMethod(new Block(new ArrayList<>(Arrays.asList(new MethodCall(new Class("Main", new ReferenceType("Main")), "foo", new ArrayList<>(), BasicType.VOID, true)))));

        Method foo = new Method(BasicType.VOID, "foo", new ArrayList<>(), new Block(new ArrayList<>(Arrays.asList(
                new MethodCall(
                        new InstVar("out",
                                new Class("java/lang/System",
                                        new ReferenceType("java/lang/System")),
                                new ReferenceType("java/io/PrintStream"), true), "println",
                        new ArrayList<>(Arrays.asList(
                                new MethodCall(
                                        new MethodCall(new Class("Test", new ReferenceType("Test")), "getInstance", new ArrayList<>(), new ReferenceType("Test"), true), "test", new ArrayList<>(), BasicType.INT, true)
                        )), BasicType.VOID, false)))), AccessModifier.PUBLIC, true);

        ClassDecl main = new ClassDecl("Main", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(foo, MainMethod)),
                new ArrayList<Constructor>());

        Method getInstance = new Method(new ReferenceType("Test"), "getInstance", new ArrayList<>(), new Block(new ArrayList<>(Arrays.asList(
                new Return(new ReferenceType("Test"), new New("Test", new ArrayList<>())
                )))), AccessModifier.DEFAULT, true);

        Method testmethod = new Method(BasicType.INT, "test", new ArrayList<>(), new Block(new ArrayList<>(Arrays.asList(
                new Return(BasicType.INT, new InstVar("b", new Class("Test", new ReferenceType("Test")), BasicType.INT, true))
        ))), AccessModifier.DEFAULT, true);

        ClassDecl test = new ClassDecl("Test", new ArrayList<Field>(
                Arrays.asList(new Field(BasicType.INT, "b", AccessModifier.DEFAULT, null, true))
        ), new ArrayList<Method>(Arrays.asList(getInstance, testmethod)),
                new ArrayList<Constructor>());

        Program program = new Program(new ArrayList<>(Arrays.asList(main, test)));
    }
}

