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
        //Generate Program Bytecode
        classWriter.visit(Opcodes.V1_5, GeneratorHelpFunctions.getAccessModifier(classDecl.accessModifier, false),
                classDecl.name, null, "java/lang/Object", null);

        //Generate Field Bytecode
        classDecl.fields.forEach(field -> field.accept(this));

        //Generate Constructor Bytecode
        if(classDecl.constructors.isEmpty()){
            new Constructor().accept(new MethodCodeGenerator(classWriter));
        }
        else{
            classDecl.constructors.forEach(constructor -> constructor.accept(new MethodCodeGenerator(classWriter)));
        }

        //Generate Method ByteCode
        classDecl.methods.forEach(method -> method.accept(new MethodCodeGenerator(classWriter)));

    }

    @Override
    public void visit(Field fields) {

    }
}
