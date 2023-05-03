package mmc.ast.main;

import mmc.Visitable;
import mmc.codegen.visitors.IProgramCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;
import org.objectweb.asm.ClassWriter;

import java.beans.Visibility;
import java.util.List;

public class Program implements Visitable {
    public List<ClassDecl> classes;

    public Program(List<ClassDecl> pClasses){
        classes = pClasses;
    }


    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public void accept (IProgramCodeVisitor visitor){
        visitor.visit(this);
    }
}
