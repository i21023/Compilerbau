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
import mmc.ast.statements.*;
import mmc.codegen.ProgramCodeGenerator;
import mmc.compiler.ISyntaxTreeGenerator;
import mmc.compiler.SyntaxTreeGenerator;
import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ressources.helpers.Classwriter;
import ressources.helpers.ReflectionHelper;
import ressources.helpers.Resources;

import java.io.File;
import java.io.IOException;
import java.lang.Class;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import static mmc.semantikcheck.SemanticCheck.generateTypedast;
import static org.junit.jupiter.api.Assertions.*;

class ReflectionTest {

    @Test
    @DisplayName("Class with FieldVars and Method")
    public void fieldVarClassMutableTest() {

        Method method = new Method(BasicType.VOID, "changeX", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(
                        Arrays.asList(new Assign(new LocalOrFieldVar("x"),
                                new IntExpr(30), null)))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("FieldVarClassMutable", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT,
                "x", AccessModifier.PUBLIC, new IntExpr(10), false))), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>());

        Program prog = new Program(Arrays.asList(classDecl));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(prog);

        Classwriter.WriteClassFile("FieldVarClassMutable", "src/main/resources_tests/", code);

        System.out.println("Test-Reihenfolge");
        //Ab hier Testen durch laden des Kompilates
        // Pfad zu .class-Verzeichnis
        try {

            /*ressources.compiles.FieldVarClassMutable test = new ressources.compiles.FieldVarClassMutable();*/

            String resourcesPath = "src/main/resources_tests/";

            // Name der Klasse, die instanziiert werden soll
            String className = "FieldVarClassMutable";

            // URLClassLoader erstellen und das Verzeichnis zum Klassenpfad hinzufügen
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new File(resourcesPath).toURI().toURL()});

            // Klasse laden
            Class<?> loadedClass = classLoader.loadClass(className);
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();

            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            //Zugriff auf Variable mit inflection
            java.lang.reflect.Field pubVar = instance.getClass().getField("x");
            System.out.println("Wert von x: " + pubVar.get(instance));
            assertEquals(10, pubVar.get(instance));
            //Zugriff auf Methode per inflection
            java.lang.reflect.Method changeX = instance.getClass().getMethod("changeX");
            //methode aufrufen
            changeX.invoke(instance);

            System.out.println("Wert von x: " + pubVar.get(instance));
            assertEquals(30, pubVar.get(instance));


            // Beispielaufruf einer Methode der Klasse

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
    @DisplayName("Arithmetik Class Test via Reflection")
    public void ArithmetikTest() {
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

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        Classwriter.WriteClassFile("ArithmetikClass", "src/main/resources_tests/", code);

        try {


            /*ressources.compiles.FieldVarClassMutable test = new ressources.compiles.FieldVarClassMutable();*/

            String resourcesPath = "src/main/resources_tests/";

            // Name der Klasse, die instanziiert werden soll
            String className = "ArithmetikClass";

            // URLClassLoader erstellen und das Verzeichnis zum Klassenpfad hinzufügen
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new File(resourcesPath).toURI().toURL()});

            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.loadClass(className);
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();

            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            java.lang.reflect.Method add = instance.getClass().getMethod("add", int.class, int.class);

            int received = (int) add.invoke(instance, 3, 5);
            System.out.println("Ergebnis: " + received);
            assertEquals(8, received);

            java.lang.reflect.Method mult = instance.getClass().getMethod("mul", int.class, int.class);
            int result = (int) mult.invoke(instance, 3, 4);
            System.out.println("Ergebnis mul: " + result);
            assertEquals(12, result);


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
    @DisplayName("MethodCall")
    public void MethodCallTest() {
        Block Method1Body2 = new Block(Arrays.asList(new LocalVarDecl("a", BasicType.INT, new IntExpr(1)), new Return(BasicType.INT, new LocalOrFieldVar("a", BasicType.INT))), BasicType.INT);
        Block Method2Body2 = new Block(Arrays.asList(new Return(BasicType.INT, new Binary(Operator.PLUS, new LocalOrFieldVar("b", BasicType.INT), new MethodCall(new This(new ReferenceType("MethodCall")), "getA", new ArrayList<>(), BasicType.INT), BasicType.INT))), BasicType.INT);

        Method method12 = new Method(BasicType.INT, "getA", new ArrayList<Parameter>(), Method1Body2, AccessModifier.PRIVATE, false);
        Method method22 = new Method(BasicType.INT, "addConstant", new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "b"))), Method2Body2, AccessModifier.PUBLIC, false);
        ClassDecl classes2 = new ClassDecl("MethodCall", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method12, method22)), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        try {
//Mit Hilfe des ReflectionHelpers wird der ByteCode ohne vorheriges wegschreiben geladen In Zukunft nur noch über den ReflectionHelper
            String className = "MethodCall";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            java.lang.reflect.Method addConstant = instance.getClass().getMethod("addConstant", int.class);
            int result = (int) addConstant.invoke(instance, 3);
            System.out.println("Ergebnis addConstant: " + result);
            assertEquals(4, result);


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
    @DisplayName("Pretty Advanced Full Test")
    public void prettyAdvancedFullTest() {

        try {
            CharStream file = Resources.getFileInput("src/test/java/mmc/prettyadvancedfulltest.txt");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);
            Program genTast = generateTypedast(program);
            ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
            HashMap<String, byte[]> code = codeGen.getBytecode(genTast);

            try {


                // Name der Klasse, die instanziert werden soll
                String className = "MyClass";

                ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();

                // Klasse laden
                java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
                java.lang.Class<?> test = classLoader.defineClass("Test", code.get("Test"));

                java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();

                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();
                String[] args = {""};

                java.lang.reflect.Method main = instance.getClass().getMethod("main", String[].class);
                main.invoke(null, (Object) args);


            } catch (Exception e) {
                if (e instanceof InvocationTargetException) {
                    Throwable cause = ((InvocationTargetException) e).getTargetException();
                    cause.printStackTrace();
                } else {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Empty Class")
    public void EmptyClassTest() throws IOException {
        ClassDecl classDecl2 = new ClassDecl("EmptyClass", new ArrayList<Field>(),
                new ArrayList<Method>(), new ArrayList<Constructor>());
        ArrayList<ClassDecl> classDecls2 = new ArrayList<ClassDecl>();
        classDecls2.add(classDecl2);
        Program program = new Program(classDecls2);

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(program);

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
    @DisplayName("ClassWithMethodTest")
    public void ClassWithMethodTest() {

        ClassDecl classDecl2 = new ClassDecl("ClassMethod", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(
                new Method(BasicType.VOID, "testMethod", new ArrayList<Parameter>(), new Block(), AccessModifier.PUBLIC, false
                ))), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classDecl2));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        try {
            // Name der Klasse, die instanziert werden soll
            String className = "ClassMethod";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            java.lang.reflect.Method method = instance.getClass().getMethod("testMethod");
            method.invoke(instance);

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
    @DisplayName("ClassWithMethodParamTest")
    public void ClassWithMethodParamTest() {
        ArrayList<Parameter> MethodParam2 = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b")));
        ClassDecl classDecl2 = new ClassDecl("ClassMethodParam", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(
                new Method(BasicType.VOID, "paramMethod", MethodParam2, new Block(), AccessModifier.PUBLIC, false))), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classDecl2));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        try {
            // Name der Klasse, die instanziert werden soll
            String className = "ClassMethodParam";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            java.lang.reflect.Method method = instance.getClass().getMethod("paramMethod", int.class, int.class);
            method.invoke(instance, 0, 0);

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
    @DisplayName("Constructor")
    public void ClassConstructorTest() throws IOException {
        ArrayList<Constructor> con2 = new ArrayList<Constructor>(Arrays.asList(new Constructor(new Block(
                new ArrayList<IStatement>(Arrays.asList(new LocalVarDecl("a", BasicType.INT, new IntExpr(5))))),
                new ArrayList<Parameter>(),
                AccessModifier.PUBLIC)));

        ClassDecl classDecl2 = new ClassDecl("ClassContsructor", new ArrayList<Field>(), new ArrayList<Method>(),
                con2);
        Program tast = new Program(Arrays.asList(classDecl2));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        Classwriter.WriteClassFile("ClassContsructor", "src/main/resources_tests/", code);

        try {
            // Name der Klasse, die instanziert werden soll
            String className = "ClassContsructor";
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
    @DisplayName("ClassIF")
    public void ClassWithIfTest() {
        ArrayList<Parameter> MethodParam2 = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b")));
        Block MethodBody2 = new Block(Arrays.asList(new If(new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(true))), BasicType.BOOL)
                , new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(false))), BasicType.BOOL)
                , new Binary(Operator.EQUAL, new LocalOrFieldVar("a", BasicType.INT), new LocalOrFieldVar("b", BasicType.INT), BasicType.BOOL), BasicType.BOOL)), BasicType.BOOL);
        ArrayList<Method> methods2 = new ArrayList<Method>(Arrays.asList(new Method(BasicType.BOOL, "isEqual", MethodParam2, MethodBody2, AccessModifier.PUBLIC, false)));
        ClassDecl classes2 = new ClassDecl("ClassIf", new ArrayList<Field>(), new ArrayList<Method>(methods2), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        Classwriter.WriteClassFile("ClassIf", "src/main/resources_tests/", code);

        try {
            // Name der Klasse, die instanziert werden soll
            String className = "ClassIf";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            java.lang.reflect.Method addConstant = instance.getClass().getMethod("isEqual", int.class, int.class);
            boolean result = (boolean) addConstant.invoke(instance, 3, 3);
            System.out.println("Ergebnis: " + result);
            assertEquals(true, result);


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
    @DisplayName("ClassWithMultipleMethodsTest")
    public void ClassWithMultipleMethods() {
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

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        Classwriter.WriteClassFile("ClassWithMultipleMethods", "src/main/resources_tests/", code);

        try {
            // Name der Klasse, die instanziert werden soll
            String className = "ClassWithMultipleMethods";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            java.lang.reflect.Method method1 = instance.getClass().getMethod("method1");
            java.lang.reflect.Method method2 = instance.getClass().getMethod("method2");
            java.lang.reflect.Method method3 = instance.getClass().getMethod("method3");
            method1.invoke(instance);
            int result2 = (int) method2.invoke(instance);
            boolean result3 = (boolean) method3.invoke(instance);

            System.out.println("Ergebnis1: " + result2);
            System.out.println("Ergebnis2: " + result3);

            assertEquals(1, result2);
            assertEquals(true, result3);
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
    @DisplayName("For-Loop Test")
    public void ForLoopTest() {
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
        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        Classwriter.WriteClassFile("ClassFor", "src/main/resources_tests/", code);

        try {
            // Name der Klasse, die instanziert werden soll
            String className = "ClassFor";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            java.lang.reflect.Method method1 = instance.getClass().getMethod("testFor", int.class, int.class);

            int result = (int) method1.invoke(instance, 3, 4);

            System.out.println("Ergebnis: " + result);

            assertEquals(15, result);
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
    @DisplayName("ClassIFLocalVar")
    public void ClassWithIfLocalVarTest() {
        Block MethodBody2 = new Block(Arrays.asList(new LocalVarDecl("a", BasicType.INT, new IntExpr(3)),
                new LocalVarDecl("b", BasicType.INT, new IntExpr(3)),
                new If(new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(true))), BasicType.BOOL)
                        , new Block(Arrays.asList(new Return(BasicType.BOOL, new BoolExpr(false))), BasicType.BOOL)
                        , new Binary(Operator.EQUAL, new LocalOrFieldVar("a", BasicType.INT), new LocalOrFieldVar("b", BasicType.INT), BasicType.BOOL), BasicType.BOOL)), BasicType.BOOL);
        ArrayList<Method> methods2 = new ArrayList<Method>(Arrays.asList(new Method(BasicType.BOOL, "isEqual", new ArrayList<Parameter>(), MethodBody2, AccessModifier.PUBLIC, false)));
        ClassDecl classes2 = new ClassDecl("ClassIfLokalVar", new ArrayList<Field>(), new ArrayList<Method>(methods2), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        Classwriter.WriteClassFile("ClassIfLokalVar", "src/main/resources_tests/", code);

        try {
            // Name der Klasse, die instanziert werden soll
            String className = "ClassIfLokalVar";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            java.lang.reflect.Method method1 = instance.getClass().getMethod("isEqual");

            boolean result = (boolean) method1.invoke(instance);

            System.out.println("Ergebnis: " + result);

            assertEquals(true, result);
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
    @DisplayName("Rekursion")
    public void RekursionTest() {
        ArrayList<Parameter> params2 = new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"), new Parameter(BasicType.INT, "b")));
        Block Method1Body2 = new Block(Arrays.asList(
                new If(new Block(Arrays.asList(new Return(BasicType.INT, new LocalOrFieldVar("a", BasicType.INT))), BasicType.INT),
                        null,
                        new Binary(Operator.EQUAL, new LocalOrFieldVar("b", BasicType.INT), new IntExpr(0), BasicType.BOOL), BasicType.INT),
                new Return(BasicType.INT, new MethodCall(new This(new ReferenceType("Rekursion")), "addRek", new ArrayList<IExpression>(Arrays.asList(
                        new Crement(BasicType.INT, new LocalOrFieldVar("a", BasicType.INT), Operator.INCPRE),
                        new Crement(BasicType.INT, new LocalOrFieldVar("b", BasicType.INT), Operator.DECPRE))), BasicType.INT))), BasicType.INT);

        Method method12 = new Method(BasicType.INT, "addRek", params2, Method1Body2, AccessModifier.PUBLIC, false);
        ClassDecl classes2 = new ClassDecl("Rekursion", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method12)), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        Classwriter.WriteClassFile("Rekursion", "src/main/resources_tests/", code);

        try {
            // Name der Klasse, die instanziert werden soll
            String className = "Rekursion";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            java.lang.reflect.Method method1 = instance.getClass().getMethod("addRek", int.class, int.class);

            int result = (int) method1.invoke(instance, 4, 3);

            System.out.println("Ergebnis: " + result);

            assertEquals(7, result);
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
    @DisplayName("BooleanOperator")
    public void BooleanOperatorTest() {
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

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        Classwriter.WriteClassFile("BooleanOperator", "src/main/resources_tests/", code);

        try {
            // Name der Klasse, die instanziert werden soll
            String className = "BooleanOperator";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            java.lang.reflect.Method method1 = instance.getClass().getMethod("OpAnd");
            java.lang.reflect.Method method2 = instance.getClass().getMethod("OpOr");


            boolean result1 = (boolean) method1.invoke(instance);
            boolean result2 = (boolean) method2.invoke(instance);

            System.out.println("Ergebnis1: " + result1);
            System.out.println("Ergebnis2: " + result2);

            assertEquals(false, result1);
            assertEquals(true, result2);
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
    @DisplayName("ReturnMethodTest")
    public void ReturnMethodTest() {
        Block MethodBody2 = new Block(Arrays.asList(new Return(BasicType.INT, new Binary(Operator.PLUS, new LocalOrFieldVar("a", BasicType.INT), new LocalOrFieldVar("b", BasicType.INT), BasicType.INT))), BasicType.INT);

        Method method2 = new Method(BasicType.INT, "add", new ArrayList<Parameter>(Arrays.asList(new Parameter(BasicType.INT, "a"),
                new Parameter(BasicType.INT, "b"))), MethodBody2, AccessModifier.PUBLIC, false);
        ClassDecl classes2 = new ClassDecl("ReturnMethod", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method2)), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        Classwriter.WriteClassFile("ReturnMethod", "src/main/resources_tests/", code);

        try {
            // Name der Klasse, die instanziert werden soll
            String className = "ReturnMethod";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            java.lang.reflect.Method method1 = instance.getClass().getMethod("add", int.class, int.class);

            int result1 = (int) method1.invoke(instance, 3, 4);

            System.out.println("Ergebnis1: " + result1);

            assertEquals(7, result1);
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
    @DisplayName("LocalVarGetTest")
    public void LocalVarGetTest() {
        Block MethodBody2 = new Block(Arrays.asList(new LocalVarDecl("y", BasicType.INT, new IntExpr(30)), new Return(BasicType.INT, new LocalOrFieldVar("y", BasicType.INT))), BasicType.INT);
        Method method2 = new Method(BasicType.INT, "getY", new ArrayList<Parameter>(), MethodBody2, AccessModifier.PUBLIC, false);
        ClassDecl classes2 = new ClassDecl("LocalVarGet", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method2)), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        Classwriter.WriteClassFile("LocalVarGet", "src/main/resources_tests/", code);

        try {
            // Name der Klasse, die instanziert werden soll
            String className = "LocalVarGet";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();

            java.lang.reflect.Method method1 = instance.getClass().getMethod("getY");

            int result1 = (int) method1.invoke(instance);

            System.out.println("Ergebnis1: " + result1);

            assertEquals(30, result1);
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
    @DisplayName("FieldVarClassTest")
    public void FieldVarClassTest() {
        ClassDecl classes2 = new ClassDecl("FieldVarClass", new ArrayList<Field>(Arrays.asList(
                new Field(BasicType.INT, "x", AccessModifier.PUBLIC, new IntExpr(5), false))),
                new ArrayList<Method>(), new ArrayList<Constructor>());
        Program tast = new Program(Arrays.asList(classes2));

        ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = codeGen.getBytecode(tast);

        Classwriter.WriteClassFile("FieldVarClass", "src/main/resources_tests/", code);

        try {
            // Name der Klasse, die instanziert werden soll
            String className = "FieldVarClass";
            ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
            // Klasse laden
            java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
            java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
            // Instanz der Klasse erstellen
            Object instance = constructor.newInstance();
            java.lang.reflect.Field result = instance.getClass().getField("x");

            System.out.println("Ergebnis1: " + result.get(instance));

            assertEquals(5, result.get(instance));
        } catch (Exception e) {
            if (e instanceof InvocationTargetException) {
                Throwable cause = ((InvocationTargetException) e).getTargetException();
                cause.printStackTrace();
            } else {
                e.printStackTrace();
            }
        }
    }
}