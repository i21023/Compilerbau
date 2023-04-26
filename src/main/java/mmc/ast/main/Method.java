package mmc.ast.main;

import mmc.ast.statements.Statement;
import mmc.ast.Type;
import org.objectweb.asm.ClassWriter;

import java.util.List;

public class Method {
    Type type;
    String name;
    List<Parameter> parameters;
    Statement statement;

    public void codeGen(ClassWriter cw) {

    }
}
