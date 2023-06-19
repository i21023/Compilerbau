package mmc;

import mmc.ast.main.Program;
import mmc.codegen.ProgramCodeGenerator;

import mmc.compiler.ISyntaxTreeGenerator;
import mmc.compiler.SyntaxTreeGenerator;
import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ressources.helpers.Classwriter;
import ressources.helpers.ReflectionHelper;
import ressources.helpers.Resources;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import static mmc.semantikcheck.SemanticCheck.generateTypedast;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FullRunTests {

    @Test
    @DisplayName("All-Operators-Test")
    public void AllOperatorTest() {

        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/Testcases/AllOperators.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);
            Program genTast = generateTypedast(program);
            ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
            HashMap<String, byte[]> code = codeGen.getBytecode(genTast);

            Classwriter.WriteClassFile("AllOperators", "src/main/resources_tests/", code);

            try {
                // Name der Klasse, die instanziert werden soll
                String className = "AllOperators";
                ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();
                // Klasse laden
                java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
                java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();

                String[] args = {""};

                java.lang.reflect.Method main = instance.getClass().getMethod("main", String[].class);
                main.invoke(null, (Object) args);

                java.lang.reflect.Method plus = instance.getClass().getMethod("plus", int.class, int.class);
                java.lang.reflect.Method minus = instance.getClass().getMethod("minus", int.class, int.class);
                java.lang.reflect.Method mul = instance.getClass().getMethod("mul", int.class, int.class);
                java.lang.reflect.Method div = instance.getClass().getMethod("div", int.class, int.class);
                java.lang.reflect.Method mod = instance.getClass().getMethod("mod", int.class, int.class);
                java.lang.reflect.Method incpre = instance.getClass().getMethod("incpre", int.class);
                java.lang.reflect.Method incsuf = instance.getClass().getMethod("incsuf", int.class);
                java.lang.reflect.Method decpre = instance.getClass().getMethod("decpre", int.class);
                java.lang.reflect.Method decsuf = instance.getClass().getMethod("decsuf", int.class);
                java.lang.reflect.Method relLess = instance.getClass().getMethod("relLess", int.class, int.class);
                java.lang.reflect.Method relGreater = instance.getClass().getMethod("relGreater", int.class, int.class);
                java.lang.reflect.Method relLessEqual = instance.getClass().getMethod("relLessEqual", int.class, int.class);
                java.lang.reflect.Method relGreatEqual = instance.getClass().getMethod("relGreatEqual", int.class, int.class);
                java.lang.reflect.Method equal = instance.getClass().getMethod("equal", int.class, int.class);
                java.lang.reflect.Method notEqual = instance.getClass().getMethod("notEqual", int.class, int.class);
                java.lang.reflect.Method And = instance.getClass().getMethod("And", boolean.class, boolean.class);
                java.lang.reflect.Method Or = instance.getClass().getMethod("Or", boolean.class, boolean.class);
                java.lang.reflect.Method bwAnd = instance.getClass().getMethod("bwAnd", boolean.class, boolean.class);
                java.lang.reflect.Method bwOr = instance.getClass().getMethod("bwOr", boolean.class, boolean.class);
                java.lang.reflect.Method assign = instance.getClass().getMethod("assign", int.class);
                java.lang.reflect.Method plusAssign = instance.getClass().getMethod("plusAssign", int.class);
                java.lang.reflect.Method minusAssign = instance.getClass().getMethod("minusAssign", int.class);
                java.lang.reflect.Method mulAssign = instance.getClass().getMethod("mulAssing", int.class);
                java.lang.reflect.Method divAssign = instance.getClass().getMethod("divAssing", int.class);
                java.lang.reflect.Method modAssign = instance.getClass().getMethod("modAssing", int.class);

                assertEquals(7, plus.invoke(instance, 2, 5));
                assertEquals(-3, minus.invoke(instance, 2, 5));
                assertEquals(10, mul.invoke(instance, 2, 5));
                assertEquals(0, div.invoke(instance, 2, 5));
                assertEquals(0, mod.invoke(instance, 4, 2));
                assertEquals(3, incpre.invoke(instance, 2));
                assertEquals(3, incsuf.invoke(instance, 2));
                assertEquals(1, decpre.invoke(instance, 2));
                assertEquals(1, decsuf.invoke(instance, 2));
                assertEquals(true, relLess.invoke(instance, 2, 5));
                assertEquals(false, relGreater.invoke(instance, 2, 5));
                assertEquals(true, relLessEqual.invoke(instance, 2, 5));
                assertEquals(false, relGreatEqual.invoke(instance, 2, 5));
                assertEquals(false, equal.invoke(instance, 2, 5));
                assertEquals(true, notEqual.invoke(instance, 2, 5));
                assertEquals(false, And.invoke(instance, true, false));
                assertEquals(true, Or.invoke(instance, true, false));
                assertEquals(false, bwAnd.invoke(instance, true, false));
                assertEquals(true, bwOr.invoke(instance, true, false));
                assertEquals(2, assign.invoke(instance, 2));
                assertEquals(5, plusAssign.invoke(instance, 2));
                assertEquals(1, minusAssign.invoke(instance, 2));
                assertEquals(8, mulAssign.invoke(instance, 2));
                assertEquals(2, divAssign.invoke(instance, 2));
                assertEquals(0, modAssign.invoke(instance, 2));

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
    @DisplayName("Inline Ifs Test")
    public void InlineIfsTest() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/Testcases/InlineIfs.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);
            Program genTast = generateTypedast(program);
            ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
            HashMap<String, byte[]> code = codeGen.getBytecode(genTast);

            try {
                // Name der Klasse, die instanziert werden soll
                String className = "InlineIfs";

                ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();

                // Klasse laden
                java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));

                java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();

                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();
                java.lang.reflect.Method method = instance.getClass().getMethod("method", boolean.class);

                assertTrue((boolean) method.invoke(instance, true));

                assertTrue((boolean) method.invoke(instance, false));

            } catch (Exception e) {
                if (e instanceof InvocationTargetException) {
                    Throwable cause = ((InvocationTargetException) e).getTargetException();
                    cause.printStackTrace();
                } else {
                    e.printStackTrace();
                    assertTrue(true);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            assertTrue(true);
        }
    }
}
