package mmc.codegen.visitors;

import mmc.ast.BasicType;
import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.ast.main.ClassDecl;
import mmc.ast.main.Constructor;
import mmc.ast.main.Field;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

import java.util.*;

public class ClassCodeGenerator implements IClassCodeVisitor{
    private final ClassWriter classWriter;

    private Map<String, Type> fieldVars;

    public ClassCodeGenerator(){
        classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

        fieldVars = new HashMap<String, Type>();
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
            new Constructor().accept(new MethodCodeGenerator(classWriter, fieldVars, classDecl.name));
        }
        else{
            classDecl.constructors.forEach(constructor -> constructor.accept(new MethodCodeGenerator(classWriter, fieldVars, classDecl.name)));
        }

        //Generate Method ByteCode
        classDecl.methods.forEach(method -> method.accept(new MethodCodeGenerator(classWriter, fieldVars, classDecl.name)));

    }

    @Override
    public void visit(Field field) {
        fieldVars.put(field.name, field.type);
        FieldVisitor fieldVisitor = classWriter.visitField(GeneratorHelpFunctions.getAccessModifier(field.accessModifier, field.isStatic), field.name,
                GeneratorHelpFunctions.getDescriptor(null, field.getType()), null, null);

        fieldVisitor.visitEnd();
    }
}
