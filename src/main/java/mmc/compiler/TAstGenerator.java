package mmc.compiler;

import mmc.ast.main.Program;

public class TAstGenerator implements ITAstGenerator{
    @Override
    public Program getTast(Program ast) {
        return ast;
    }
}
