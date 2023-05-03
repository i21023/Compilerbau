package mmc.codegen.visitors;

import mmc.ast.main.ClassDecl;
import mmc.ast.main.Field;

import java.util.HashMap;

public class ClassCodeGenerator implements IClassCodeVisitor{


    public byte[] getBytecode(){
        //TODO: implement
        return null;
    }

    @Override
    public void visit(ClassDecl classDecl) {
    }

    @Override
    public void visit(Field fields) {

    }
}
