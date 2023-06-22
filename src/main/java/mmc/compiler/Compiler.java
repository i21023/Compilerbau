package mmc.compiler;

import mmc.ast.AccessModifier;
import mmc.ast.main.ClassDecl;
import mmc.ast.main.Program;
import mmc.codegen.ProgramCodeGenerator;
import mmc.codegen.visitors.IProgramCodeVisitor;
import mmc.semantikcheck.Exception;
import mmc.semantikcheck.SemanticCheck;
import org.antlr.v4.runtime.CharStreams;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

;

public class Compiler implements ICompiler {


    @Override
    public void compile(String fileName, String outDir) {

        File file = new File(fileName);

        // Bestimme den Pfad des JAR-Dateis
        String jarPath = Compiler.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String decodedPath;
        try {
            decodedPath = URLDecoder.decode(jarPath, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Fehler beim Decodieren des Dateipfads", e);
        }

        // Bestimme den Pfad des Ordners, in dem sich das JAR-File befindet
        String jarDir = new File(decodedPath).getParent();

        // Erzeuge den Ausgabeordnerpfad relativ zum JAR-Ordner
        String outDirPath = jarDir + File.separator + "gen";

        // Überprüfe, ob der Ausgabeordnerpfad angegeben wurde, sonst verwende den Standardpfad
        if (outDir == null || outDir.isEmpty()) {
            outDir = outDirPath;
        } else {
            outDir = new File(outDir).getAbsolutePath() + File.separator + "gen";
        }

        // Erzeuge den Ausgabeordner, falls er nicht existiert
        File outDirectory = new File(outDir);
        if (!outDirectory.exists()) {
            outDirectory.mkdir();
        } else {
            // Lösche die vorhandenen Dateien im Ausgabeordner
            File[] files = outDirectory.listFiles();
            if (files != null) {
                for (File f : files) {
                    try {
                        moveToTrash(f);
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Fehler beim Löschen der alten Dateien.");
                    }
                }
            }
        }

        if (file.exists()) {
            try {
                // Lese die Datei ein und generiere den Syntaxbaum
                InputStream inputStream = new FileInputStream(file);
                ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

                Program program = astGenerator.generateSyntaxTree(CharStreams.fromStream(inputStream));

                System.out.println("Syntaxbaum wurde generiert.");

                if (hasPublicClassWithNotMatchingName(program, file)) {
                    throw new Exception("The file contains a public class that does not match the file name.");
                }

                // Führe die semantische Überprüfung durch und generiere den typisierten AST
                SemanticCheck tAst = new SemanticCheck();
                Program tAstProgram = tAst.generateTypedast(program);

                System.out.println("Typisierter AST wurde generiert.");

                // Generiere den Bytecode und schreibe die Klassen in die Ausgabedateien
                IProgramCodeVisitor programVisitor = new ProgramCodeGenerator();
                HashMap<String, byte[]> code = programVisitor.getBytecode(tAstProgram);

                String finalOutDir1 = outDir;
                code.forEach((x, y) -> {
                    try {
                        FileOutputStream fos = new FileOutputStream(finalOutDir1 + File.separator + x + ".class");
                        fos.write(y);
                        fos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                System.out.println("Bytes wurden erfolgreich in Dateien geschrieben:");
                System.out.println(outDir);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean hasPublicClassWithNotMatchingName(Program program, File file) {
        String fileNameWithoutExtension = file.getName().replaceFirst("[.][^.]+$", "");
        for (ClassDecl classDeclaration : program.classes) {
            if (!classDeclaration.name.equals(fileNameWithoutExtension) && classDeclaration.accessModifier == AccessModifier.PUBLIC) {
                return true;
            }
        }
        return false;
    }

    public static void moveToTrash(File file) throws IOException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.MOVE_TO_TRASH)) {
            // Plattformspezifische Implementierung, wenn moveToTrash unterstützt wird
            Desktop.getDesktop().moveToTrash(file);
        } else {
            System.out.println("Verschieben alter Dateien des gen-Ordners durch System nicht unterstützt.");
        }
    }
}

