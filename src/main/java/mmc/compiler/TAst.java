package mmc.compiler;

import mmc.ast.main.Program;
import mmc.semantikcheck.SemanticCheck;

import java.io.InputStream;

public class TAst implements ITAst {

    @Override
    public Program getTast(Program ast) {
        return SemanticCheck.generateTypedast(ast);
    }
}
