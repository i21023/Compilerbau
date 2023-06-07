package mmc.codegen.visitors;

import mmc.ast.*;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.main.ClassDecl;
import mmc.ast.main.Constructor;
import mmc.ast.main.Field;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statements.Block;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

import java.util.*;
import java.util.stream.Collectors;

public class ClassCodeGenerator implements IClassCodeVisitor{
    private final ClassWriter classWriter;

    private Map<String, Type> fieldVars;
    private List<String> classNames;

    public ClassCodeGenerator(List<String> classes){
        classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

        fieldVars = new HashMap<String, Type>();
        classNames = classes;
    }

    public byte[] getBytecode(){
        return classWriter.toByteArray();
    }

    @Override
    public void visit(ClassDecl classDecl) {
        //Generate Program Bytecode
        classWriter.visit(Opcodes.V1_5, GeneratorHelpFunctions.getAccessModifier(/*classDecl.accessModifier*/AccessModifier.PUBLIC, false),
                classDecl.name, null, "java/lang/Object", null);

        //Generate Field Bytecode
        classDecl.fields.forEach(field -> field.accept(this));

        //Generate Constructor Bytecode
        if(classDecl.constructors.isEmpty()){
            //generate default Constructor
            classDecl.constructors.add(new Constructor());
        }

        Map<Boolean, List<Field>> partitionedFieldList = classDecl.fields.stream().filter(field -> field.expression != null).collect(Collectors.partitioningBy(field -> field.isStatic));

        //add all nonstatic fieldVar initializations to each constructor
        classDecl.constructors.forEach(constructor -> {
            partitionedFieldList.get(false).forEach(field -> {
                constructor.statement.statements.add(0, new Assign(new LocalOrFieldVar(field.name),
                        field.expression, null));
            });
            constructor.accept(new MethodCodeGenerator(classWriter, fieldVars, classDecl.name, classNames));
        });

        //add static fieldVar initializations in class initialization method
        if(partitionedFieldList.get(true).size() > 0){
            new MethodCodeGenerator(classWriter, fieldVars, classDecl.name, classNames).classConstructor(partitionedFieldList.get(true));
        }

        //Generate Method ByteCode
        classDecl.methods.forEach(method -> method.accept(new MethodCodeGenerator(classWriter, fieldVars, classDecl.name, classNames)));

    }

    @Override
    public void visit(Field field) {

        fieldVars.put(field.name, field.type);
        FieldVisitor fieldVisitor = classWriter.visitField(GeneratorHelpFunctions.getAccessModifier(field.accessModifier, field.isStatic), field.name,
                GeneratorHelpFunctions.getDescriptor(null, field.getType()), null, null);

        fieldVisitor.visitEnd();
    }
}
