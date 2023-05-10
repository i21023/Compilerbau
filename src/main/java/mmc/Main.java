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

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Program program = new Program(new ArrayList<ClassDecl>(Arrays.asList(new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(), new ArrayList<Constructor>(), AccessModifier.PUBLIC))));

        ProgramCodeGenerator programVisitor = new ProgramCodeGenerator();
        HashMap<String, byte[]> code = programVisitor.getBytecode(program);

        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/mmc/codegen/visitors/Test.class");
            fos.write(code.get("Test"));
            fos.close();
            System.out.println("Bytes written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}