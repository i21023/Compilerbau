package mmc.codegen.visitors;

import mmc.ast.main.Program;

import java.util.HashMap;

public interface IProgramCodeVisitor {
    void visit(Program program);

    HashMap<String, byte[]> getBytecode (Program program);
}
