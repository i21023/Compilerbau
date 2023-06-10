package mmc.parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class CustomErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        // Fehlerbehandlung für Syntaxfehler
        throw new ParseCancellationException("Syntaxfehler in Zeile " + line + ":" + charPositionInLine + " - " + msg);
    }

//    @Override
//    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
//        Token startToken = recognizer.getInputStream().get(startIndex);
//        Token stopToken = recognizer.getInputStream().get(stopIndex);
//        int startLine = startToken.getLine();
//        int startCharPositionInLine = startToken.getCharPositionInLine();
//        int stopLine = stopToken.getLine();
//        int stopCharPositionInLine = stopToken.getCharPositionInLine() + stopToken.getText().length();
//
//        // Fehlerbehandlung für Mehrdeutigkeiten
//        System.err.println("Mehrdeutigkeit erkannt von Zeile " + startLine + ", Zeichen " + startCharPositionInLine +
//                " bis Zeile " + stopLine + ", Zeichen " + stopCharPositionInLine);
//    }
//
//    @Override
//    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
//        Token startToken = recognizer.getInputStream().get(startIndex);
//        Token stopToken = recognizer.getInputStream().get(stopIndex);
//        int startLine = startToken.getLine();
//        int startCharPositionInLine = startToken.getCharPositionInLine();
//        int stopLine = stopToken.getLine();
//        int stopCharPositionInLine = stopToken.getCharPositionInLine() + stopToken.getText().length();
//
//        // Fehlerbehandlung für vollständigen Kontext
//        System.err.println("Vollständiger Kontext erkannt von Zeile " + startLine + ", Zeichen " + startCharPositionInLine +
//                " bis Zeile " + stopLine + ", Zeichen " + stopCharPositionInLine);
//    }
//
//    @Override
//    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
//        // Fehlerbehandlung für Kontextsensitivität
//        TokenStream tokens = recognizer.getInputStream();
//        int startLine = tokens.get(startIndex).getLine();
//        int startCharPositionInLine = tokens.get(startIndex).getCharPositionInLine();
//        int stopLine = tokens.get(stopIndex).getLine();
//        int stopCharPositionInLine = tokens.get(stopIndex).getCharPositionInLine();
//
//        System.err.println("Kontextsensitivität erkannt von Zeile " + startLine + ", Zeichen " + startCharPositionInLine + " bis Zeile " + stopLine + ", Zeichen " + stopCharPositionInLine);
//    }
}