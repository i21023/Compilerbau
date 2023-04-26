package mmc.ast.main;

import mmc.ast.statements.Statement;
import org.objectweb.asm.ClassWriter;

import java.util.List;

public class Constructor {
    public List<Parameter> parameters;
    public Statement statement;

    public void codeGen(ClassWriter cw){

    }
}
