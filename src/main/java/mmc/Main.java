package mmc;

import mmc.ast.AccessModifier;
import mmc.ast.main.*;
import mmc.codegen.visitors.ProgramCodeGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import mmc.compiler.Compiler;
import mmc.compiler.CompilerImpl;

public class Main {
    public static void main(String[] args) {
        Program program = new Program(new ArrayList<ClassDecl>(Arrays.asList(new ClassDecl("Test", new ArrayList<Field>(){}, new ArrayList<Method>(){}, new ArrayList<Constructor>(){}, AccessModifier.PUBLIC))));

        if (args.length == 0) {
            System.out.println("Bitte Datei eingeben.");
            return;
        }
        if (args.length == 1 && args[0].endsWith(".java")) {
            Compiler compiler = new CompilerImpl();
            compiler.compile(args[0], ".");
        }
        else {
            System.out.println("Bitte nur eine Java-Datei eingeben.");
        }


    }
}