package mmc.ast.main;

import mmc.ast.Type;
import org.objectweb.asm.ClassWriter;

public class Field  {
    public Type type;
    public String name;

    public Field(Type pType, String pName)
    {
        type=pType;
        name=pName;
    }

    public void codeGen(ClassWriter cw) {

    }
}
