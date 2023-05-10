package mmc;

import mmc.compiler.Compiler;
import mmc.compiler.CompilerImpl;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Bitte Datei eingeben.");
            return;
        }
        if (args.length == 1 && args[0].endsWith(".java")) {
            Compiler compiler = new CompilerImpl();
            compiler.compile(args[0], "");
        }
        else {
            System.out.println("Bitte nur eine Java-Datei eingeben.");
        }


    }
}