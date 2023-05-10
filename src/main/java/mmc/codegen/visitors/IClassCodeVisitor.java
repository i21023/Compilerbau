package mmc.codegen.visitors;

import mmc.ast.main.ClassDecl;
import mmc.ast.main.Field;

public interface IClassCodeVisitor {

    public void visit(ClassDecl classDecl);
    public void visit(Field fields);
}
