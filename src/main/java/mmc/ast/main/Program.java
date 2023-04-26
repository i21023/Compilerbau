package mmc.ast.main;

import org.objectweb.asm.ClassWriter;

import java.util.List;

public class Program {
    public List<ClassDecl> classes;

    public void codeGen(){
        classes.stream().forEach(ClassDecl::codeGen);
    }
}
