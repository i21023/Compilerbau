package mmc.codegen.visitors;

import mmc.ast.main.ClassDecl;
import mmc.ast.main.Field;

public interface IClassCodeVisitor {
    void visit(ClassDecl classDecl);
    void visit(Field fields);
}
