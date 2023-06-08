package mmc.compiler;

import mmc.ast.main.Program;
import mmc.parser.antlr.MiniJavaLexer;
import mmc.parser.antlr.MiniJavaParser;
import mmc.parser.adapter.main.ProgramAdapter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class SyntaxTreeGeneratorImpl implements SyntaxTreeGenerator {
    @Override
    public Program generateSyntaxTree(CharStream inputstream) {

        //Call the generated Components from the antlr file (lexer->tokens->parser)
        MiniJavaLexer lexer = new MiniJavaLexer(inputstream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);

        return new ProgramAdapter().adapt(parser.program());
    }
}
