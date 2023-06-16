package mmc.ast.main;

import mmc.Visitable;
import mmc.codegen.visitors.IProgramCodeVisitor;
import mmc.semantikcheck.Environment.ProgramEnvironment;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;
import org.objectweb.asm.ClassWriter;

import java.beans.Visibility;
import java.util.ArrayList;
import java.util.List;

public class Program implements Visitable {
    public List<ClassDecl> classes;
    public ProgramEnvironment programEnvironment;
    public int startLine; public int stopLine;

    public Program(List<ClassDecl> pClasses) {
        classes = pClasses;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o==null||getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return classes.equals(program.classes);
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public void accept(IProgramCodeVisitor visitor) {
        visitor.visit(this);
    }
}
