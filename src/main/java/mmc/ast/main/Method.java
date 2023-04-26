package mmc.ast.main;

import mmc.ast.statements.Statement;
import mmc.ast.Type;
import org.objectweb.asm.ClassWriter;

import java.util.List;

public class Method {
    public Type type;
    public String name;
    public List<Parameter> parameters;
    public Statement statement;

    public void codeGen(ClassWriter cw) {

    }
}
