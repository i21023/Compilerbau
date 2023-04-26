package mmc.ast.main;

import java.util.List;

import mmc.ast.Type;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class ClassDecl{
    public String name;
    public Type type;
    public List<Field> fields;
    public List<Method> methods;
    public List<Constructor> constructors;

    //SemantikCheck

    public void codeGen(){
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, name, null,
                "java/lang/Object", null);

        fields.forEach(f -> f.codeGen(cw));
        constructors.forEach(c -> c.codeGen(cw));
        methods.forEach(m -> m.codeGen(cw));
    }
}
