package mmc.compiler;

import mmc.ast.main.Program;

import java.io.InputStream;

public interface ITAst {
    Program getTast(Program ast);
}
