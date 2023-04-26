package mmc.ast.main;

import org.objectweb.asm.ClassWriter;

import java.util.List;

public class Program {
    List<ClassDecl> classes;

    public void codeGen(){
        classes.stream().forEach(ClassDecl::codeGen);
    }
}
