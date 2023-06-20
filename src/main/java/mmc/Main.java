package mmc;

import mmc.compiler.Compiler;
import mmc.compiler.ICompiler;

import java.io.File;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        System.out.println("Willkommen beim Java-Compiler MachMalCompiler!");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Bitte wählen Sie eine Option:");
            System.out.println("1. Dateiname eingeben");
            System.out.println("2. Programm beenden");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    compileJavaFile(scanner);
                    break;
                case "2":
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte wählen Sie erneut.");
                    break;
            }
        }

        System.out.println("Das Programm wird beendet.");
    }

    private static void compileJavaFile(Scanner scanner) {
        System.out.println("Bitte geben Sie den Dateinamen ein:");
        String fileName = scanner.nextLine();

        System.out.println("Möchten Sie ein eigenes Ausgabeverzeichnis angeben? (ja/nein)");
        String useCustomOutDir = scanner.nextLine();
        String outDir = "";

        if (useCustomOutDir.equalsIgnoreCase("ja")) {
            System.out.println("Bitte geben Sie das Ausgabeverzeichnis ein:");
            outDir = scanner.nextLine();

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
    }
}