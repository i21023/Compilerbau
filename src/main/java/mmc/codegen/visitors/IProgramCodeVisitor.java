package mmc.codegen.visitors;

import mmc.ast.main.Program;

public interface IProgramCodeVisitor {
    void visit(Program program);
}
