package mmc;

import mmc.compiler.Compiler;
import mmc.compiler.ICompiler;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Willkommen beim Java-Compiler MachMalCompiler!");

        if (args.length < 1) {
            System.out.println("Bitte geben Sie den Dateinamen als Argument ein.");
            return;
        }

        String fileName = args[0];
        String outDir = "";

        if (args.length == 2) {
            outDir = args[1];
            File directory = new File(outDir);
            if (!directory.exists() || !directory.isDirectory()) {
                System.out.println("Das angegebene Ausgabeverzeichnis existiert nicht.");
                return;
            }
        }

        if (fileName.startsWith("\"") && fileName.endsWith("\"")) {
            fileName = fileName.substring(1, fileName.length() - 1);
        }

        if (fileName.endsWith(".java")) {
            ICompiler compiler = new Compiler();
            compiler.compile(fileName, outDir);
            System.out.println("Kompilierung abgeschlossen.");
        } else {
            System.out.println("Ungültiger Dateiname. Bitte geben Sie eine Java-Datei ein.");
        }

        System.out.println("Das Programm wird beendet.");
    }
}