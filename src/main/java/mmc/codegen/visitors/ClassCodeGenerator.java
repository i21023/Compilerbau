package mmc.codegen.visitors;

import mmc.ast.main.ClassDecl;
import mmc.ast.main.Constructor;
import mmc.ast.main.Field;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;

public class ClassCodeGenerator implements IClassCodeVisitor{
    private final ClassWriter classWriter;

    public ClassCodeGenerator(){
        classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
    }

    public byte[] getBytecode(){
        return classWriter.toByteArray();
    }

    @Override
    public void visit(ClassDecl classDecl) {
        classWriter.visit(Opcodes.V1_5, GeneratorHelpFunctions.getAccessModifier(classDecl.accessModifier, false),
                classDecl.name, null, "java/lang/Object", null);

        classDecl.fields.forEach(field -> field.accept(this));

        if(classDecl.constructors.isEmpty()){
            new Constructor().accept(new MethodCodeGenerator(classWriter));
        }
    }

    @Override
    public void visit(Field fields) {

    }
}
