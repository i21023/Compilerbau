package mmc.codegen;

import mmc.ast.main.ClassDecl;
import mmc.ast.main.Field;

public interface ClassCodeVisitor {
    void visit(ClassDecl classDecl);
    void visit(Field fields);
}
