package mmc;

import mmc.compiler.ICompiler;
import mmc.compiler.Compiler;

//ToDo: Uml aktualisieren? AST und TAST trennen?
//ToDo: Readme schreiben
//ToDo: Wollen wir Javadoc machen? (Keinen Bock eigentlich)
//ToDo: @Emma (alle): wie prüfen wir bei Methodenaufrufen und Feldaufrufen, ob sie static sind?

public class Main {
    public static void main(String[] args) {

        //ToDo: Dialog für Ausführung einfügen
        if (args.length == 0) {
            System.out.println("Bitte Datei eingeben.");
            return;
        }
        if (args.length == 1 && args[0].endsWith(".java")) {
            ICompiler compiler = new Compiler();
            compiler.compile(args[0], "");
        }
        else {
            System.out.println("Bitte nur eine Java-Datei eingeben.");
        }
    }
}