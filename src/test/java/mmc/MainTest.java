package mmc;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;

import mmc.ast.expressions.IntExpr;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statements.Block;
import mmc.ast.statements.IStatement;
import mmc.codegen.visitors.ProgramCodeGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ressources.Testcases.FieldVarClassMutable;
import ressources.helpers.Classwriter;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


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
            //Zugriff auf Methode per inflection
            java.lang.reflect.Method changeX = instance.getClass().getMethod("changeX");
            //methode aufrufen
            changeX.invoke(instance);

            System.out.println("Wert von x: " + pubVar.get(instance));


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


}