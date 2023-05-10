package mmc.compiler;

import mmc.ast.main.Program;
import org.antlr.v4.runtime.CharStream;

public interface SyntaxTreeGenerator {

    Program generateSyntaxTree(CharStream inputstream);

}
