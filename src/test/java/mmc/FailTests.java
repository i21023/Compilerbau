package mmc;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.BoolExpr;
import mmc.ast.expressions.IntExpr;
import mmc.ast.expressions.StringExpr;
import mmc.ast.main.*;
import mmc.ast.statements.*;
import mmc.codegen.ProgramCodeGenerator;
import mmc.compiler.ISyntaxTreeGenerator;
import mmc.compiler.SyntaxTreeGenerator;
import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.Assertions;
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

import static mmc.semantikcheck.SemanticCheck.generateTypedast;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FailTests {

    //All those Tests schould fail
    @Test
    @DisplayName("Assign Fail")
    public void AssignFailTest() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/Testcases/failTest/AssignFail.txt");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);
            Program genTast = generateTypedast(program);
            ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
            HashMap<String, byte[]> code = codeGen.getBytecode(genTast);

            try {
                // Name der Klasse, die instanziert werden soll
                String className = "AssignFail";

                ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();

                // Klasse laden
                java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
                java.lang.Class<?> test = classLoader.defineClass(className, code.get(className));

                java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();

                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();
                String[] args = {""};

                java.lang.reflect.Method main = instance.getClass().getMethod("foo");
                main.invoke(instance);

                System.out.println("Failure, it compiled.");
                assertTrue(false);
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

    @Test
    @DisplayName("Math Fail")
    public void MathFailTest() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/Testcases/failTest/MathFail.java");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);
            Program genTast = generateTypedast(program);
            ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
            HashMap<String, byte[]> code = codeGen.getBytecode(genTast);

            try {
                // Name der Klasse, die instanziert werden soll
                String className = "MathFail";

                ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();

                // Klasse laden
                java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
                java.lang.Class<?> test = classLoader.defineClass(className, code.get(className));

                java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();

                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();
                String[] args = {""};

                java.lang.reflect.Method main = instance.getClass().getMethod("div");
                main.invoke(instance);

                System.out.println("Failure, it compiled.");
                assertTrue(false);
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

    @Test
    @DisplayName("Private Call Fail")
    public void PrivateCallTest() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/Testcases/failTest/PrivateCall.txt");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);
            Program genTast = generateTypedast(program);
            ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
            HashMap<String, byte[]> code = codeGen.getBytecode(genTast);

            try {
                // Name der Klasse, die instanziert werden soll
                String className = "PrivateCall";

                ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();

                // Klasse laden
                java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
                className = "Caller";

                java.lang.Class<?> test = classLoader.defineClass(className, code.get(className));

                java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();
                java.lang.reflect.Constructor<?> testcon = test.getConstructor();

                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();
                Object testInstance = testcon.newInstance();
                String[] args = {""};

                java.lang.reflect.Method main = testInstance.getClass().getMethod("getX");
                main.invoke(instance);

                System.out.println("Failure, it compiled.");
                assertTrue(false);
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

    @Test
    @DisplayName("Same Class Identifier Fail")
    public void SameClassIdentifierTest() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/Testcases/failTest/SameClassIdentifier.txt");
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
                java.lang.Class<?> test = classLoader.defineClass(className, code.get(className));

                java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();

                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();
                System.out.println("Failure, it compiled.");
                assertTrue(false);
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

    @Test
    @DisplayName("Same Method Identifier Fail")
    public void SameMethodIdentifierTest() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/Testcases/failTest/SameMethodIdentifier.txt");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);
            Program genTast = generateTypedast(program);
            ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
            HashMap<String, byte[]> code = codeGen.getBytecode(genTast);

            try {
                // Name der Klasse, die instanziert werden soll
                String className = "SameMethodIdentifier";

                ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();

                // Klasse laden
                java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));

                java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();

                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();
                System.out.println("Failure, it compiled.");
                assertTrue(false);
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

    @Test
    @DisplayName("Same Variable Identifier Fail")
    public void SameVariableIdentifierTest() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/Testcases/failTest/SameVarID.txt");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);
            Program genTast = generateTypedast(program);
            ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
            HashMap<String, byte[]> code = codeGen.getBytecode(genTast);

            try {
                // Name der Klasse, die instanziert werden soll
                String className = "SameVarID";

                ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();

                // Klasse laden
                java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));

                java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();

                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();
                System.out.println("Failure, it compiled.");
                assertTrue(false);
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

    @Test
    @DisplayName("Static Call Fail")
    public void StaticCallTest() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/Testcases/failTest/StaticCall.txt");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);
            Program genTast = generateTypedast(program);
            ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
            HashMap<String, byte[]> code = codeGen.getBytecode(genTast);

            try {
                // Name der Klasse, die instanziert werden soll
                String className = "StaticCall";

                ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();

                // Klasse laden
                java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));
                java.lang.Class<?> test = classLoader.defineClass("test", code.get("test"));

                java.lang.reflect.Constructor<?> constructor = test.getConstructor();

                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();
                java.lang.reflect.Method getX = instance.getClass().getMethod("getX");
                getX.invoke(instance);
                //System.out.println("Failure, it compiled.");
                assertTrue(true);
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

    @Test
    @DisplayName("Wrong If Types Fail")
    public void WrongIfTypesTest() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/Testcases/failTest/WrongIfTypes.txt");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);
            Program genTast = generateTypedast(program);
            ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
            HashMap<String, byte[]> code = codeGen.getBytecode(genTast);

            try {
                // Name der Klasse, die instanziert werden soll
                String className = "WrongIfTypes";

                ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();

                // Klasse laden
                java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));

                java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();

                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();
                java.lang.reflect.Method equal1 = instance.getClass().getMethod("equal", int.class, char.class);
                java.lang.reflect.Method equal2 = instance.getClass().getMethod("equal", String.class, boolean.class);
                equal1.invoke(instance, 2, 'a');
                equal2.invoke(instance, "Hi", true);
                System.out.println("Failure, it compiled.");
                assertTrue(false);
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

    @Test
    @DisplayName("Wrong Return Types Fail")
    public void WrongReturnTypesTest() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/Testcases/failTest/WrongReturnType.txt");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);
            Program genTast = generateTypedast(program);
            ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
            HashMap<String, byte[]> code = codeGen.getBytecode(genTast);

            try {
                // Name der Klasse, die instanziert werden soll
                String className = "WrongReturnTypes";

                ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();

                // Klasse laden
                java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));

                java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();

                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();
                java.lang.reflect.Method equal1 = instance.getClass().getMethod("foo", int.class);

                equal1.invoke(instance, 2);

                System.out.println("Failure, it compiled.");
                assertTrue(false);
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

    @Test
    @DisplayName("Wrong While Types Fail")
    public void WrongWhileTypeTest() {
        try {
            CharStream file = Resources.getFileInput("src/test/java/ressources/Testcases/failTest/WrongWhileType.txt");
            ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

            Program program = astGenerator.generateSyntaxTree(file);
            Program genTast = generateTypedast(program);
            ProgramCodeGenerator codeGen = new ProgramCodeGenerator();
            HashMap<String, byte[]> code = codeGen.getBytecode(genTast);

            try {
                // Name der Klasse, die instanziert werden soll
                String className = "WrongWhileTypes";

                ReflectionHelper.ByteArrayClassLoader classLoader = new ReflectionHelper.ByteArrayClassLoader();

                // Klasse laden
                java.lang.Class<?> loadedClass = classLoader.defineClass(className, code.get(className));

                java.lang.reflect.Constructor<?> constructor = loadedClass.getConstructor();

                // Instanz der Klasse erstellen
                Object instance = constructor.newInstance();
                java.lang.reflect.Method equal1 = instance.getClass().getMethod("method", char.class);

                equal1.invoke(instance, 'a');

                System.out.println("Failure, it compiled.");
                assertTrue(false);
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
            e.printStackTrace();
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
            e.printStackTrace();
            HasFailed = true;
        }
        assertEquals(true, HasFailed);

    }
}
