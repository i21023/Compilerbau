package mmc;

import mmc.compiler.Compiler;
import mmc.compiler.ICompiler;

import java.util.Scanner;


public class Main {
    //ToDo: .jar Ausführen testen
    public static void main(String[] args) {

        System.out.println("Willkommen beim Java-Compiler MachMalCompiler!");

        if (args.length == 0) {
            // Keine Argumente übergeben, Eingabeaufforderung für Dateinamen anzeigen
            System.out.println("Bitte geben Sie den Dateinamen ein:");
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();

            // Prüfen, ob ein benutzerdefiniertes Ausgabeverzeichnis angegeben werden soll
            System.out.println("Möchten Sie ein eigenes Ausgabeverzeichnis angeben? (ja/nein)");
            String useCustomOutDir = scanner.nextLine();
            String outDir = "";

            if (useCustomOutDir.equalsIgnoreCase("ja")) {
                // Benutzer möchte ein eigenes Ausgabeverzeichnis angeben
                System.out.println("Bitte geben Sie das Ausgabeverzeichnis ein:");
                outDir = scanner.nextLine();
            }

            // Prüfen, ob der Dateiname in Anführungszeichen steht und diese entfernen
            if (fileName.startsWith("\"") && fileName.endsWith("\"")) {
                fileName = fileName.substring(1, fileName.length() - 1);
            }

            if (fileName.endsWith(".java")) {
                // Kompilierung durchführen
                ICompiler compiler = new Compiler();
                compiler.compile(fileName, outDir);
                System.out.println("Kompilierung abgeschlossen.");
            } else {
                System.out.println("Ungültiger Dateiname. Bitte geben Sie eine Java-Datei ein.");
            }
        } else {
            System.out.println("Bitte kein Argument übergeben.");
        }

        System.out.println("Das Programm wird beendet.");
    }
}