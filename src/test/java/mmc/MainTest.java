package mmc;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;

import mmc.ast.Operator;
import mmc.ast.ReferenceType;
import mmc.ast.expressions.*;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statements.*;
import mmc.codegen.visitors.ProgramCodeGenerator;
import mmc.compiler.ISyntaxTreeGenerator;
import mmc.compiler.SyntaxTreeGenerator;
import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ressources.Testcases.FieldVarClassMutable;
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

class MainTest {

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
}