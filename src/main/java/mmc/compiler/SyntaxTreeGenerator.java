package mmc.compiler;

import mmc.ast.main.Program;
import mmc.parser.CustomErrorListener;
import mmc.parser.antlr.MiniJavaLexer;
import mmc.parser.antlr.MiniJavaParser;
import mmc.parser.adapter.main.ProgramAdapter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class SyntaxTreeGenerator implements ISyntaxTreeGenerator {
    @Override
    public Program generateSyntaxTree(CharStream inputstream) {

        CustomErrorListener errorListener = new CustomErrorListener();

        //Call the generated Components from the antlr file (lexer->tokens->parser)
        MiniJavaLexer lexer = new MiniJavaLexer(inputstream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        MiniJavaParser parser = new MiniJavaParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        return new ProgramAdapter().adapt(parser.program());
    }
}
