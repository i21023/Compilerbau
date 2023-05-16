package mmc.codegen.visitors;

import mmc.ast.BasicType;
import mmc.ast.Type;
import mmc.ast.expressions.*;
import mmc.ast.main.Constructor;
import mmc.ast.main.Method;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.*;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class MethodCodeGenerator implements IMethodCodeVisitor{

    private final ClassWriter classWriter;
    private MethodVisitor methodVisitor;
    String className;

    private Map<String, Type> fieldVars;
    private Stack<String> localVars;

    public MethodCodeGenerator(ClassWriter cw, Map<String, Type> fieldVars, String className){
        this.classWriter = cw;
        this.fieldVars = fieldVars;
        this.className = className;
        localVars = new Stack<>();
        localVars.push("this");

    }

    @Override
    public void visit(Method method) {

        List<Type> parameterTypes = method.parameters.stream().map(parameter -> parameter.type).collect(Collectors.toList());

        methodVisitor = classWriter.visitMethod(GeneratorHelpFunctions.getAccessModifier(method.accessModifier, false),
                method.name, GeneratorHelpFunctions.getDescriptor(parameterTypes, method.type), null, null);

        //Add parameters to localVars
        method.parameters.forEach(parameter -> localVars.add(parameter.name));

        methodVisitor.visitCode();
        method.statement.accept(this);
        //TODO: Check if void comes back
        methodVisitor.visitMaxs(0,0);
        methodVisitor.visitEnd();

    }

    @Override
    public void visit(Constructor constructor) {
        List<Type> parameterTypes = constructor.parameters.stream().map(parameter -> parameter.type).collect(Collectors.toList());

        methodVisitor = classWriter.visitMethod(GeneratorHelpFunctions.getAccessModifier(constructor.accessModifier, false),
                "<init>", GeneratorHelpFunctions.getDescriptor(parameterTypes, constructor.type), null, null);

        //Add parameters to localVars
        constructor.parameters.forEach(parameter -> localVars.add(parameter.name));

        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);

        //Generate Code of Constructor Block
        constructor.statement.accept(this);

        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(0,0);
        methodVisitor.visitEnd();


    }

    @Override
    public void visit(Block block) {
        block.statements.forEach(statement -> statement.accept(this));
    }

    @Override
    public void visit(If ifStmt) {
    }

    @Override
    public void visit(LocalVarDecl localVarDecl) {
        if(localVarDecl.expression == null){
            localVars.push(localVarDecl.name);
        }
        localVarDecl.expression.accept(this);
        if(localVarDecl.type instanceof BasicType){
            methodVisitor.visitVarInsn(Opcodes.ISTORE, localVars.size());
            localVars.push(localVarDecl.name);
        }
        else{
            methodVisitor.visitVarInsn(Opcodes.ASTORE, localVars.size());
            localVars.push(localVarDecl.name);
        }
    }

    @Override
    public void visit(Return returnStmt) {

    }

    @Override
    public void visit(While whileStmt) {

    }

    @Override
    public void visit(Unary unary) {

    }

    @Override
    public void visit(Binary binary) {

    }

    @Override
    public void visit(BoolExpr boolExpr) {
        if(boolExpr.value){
            methodVisitor.visitInsn(Opcodes.ICONST_1);
        }
        else{
            methodVisitor.visitInsn(Opcodes.ICONST_0);
        }
    }

    @Override
    public void visit(CharExpr charExpr) {
        if(charExpr.value <= 127){
            methodVisitor.visitVarInsn(Opcodes.BIPUSH, charExpr.value);
        }
        else if(charExpr.value <= 32767) {
            methodVisitor.visitVarInsn(Opcodes.SIPUSH, charExpr.value);
        }
        else{
            methodVisitor.visitLdcInsn(charExpr.value);
        }
    }

    @Override
    public void visit(InstVar instVar) {

    }

    @Override
    public void visit(IntExpr intExpr) {
        if(intExpr.value >= -1 && intExpr.value <= 5){
            switch (intExpr.value){
                case -1 -> methodVisitor.visitInsn(Opcodes.ICONST_M1);
                case 0 -> methodVisitor.visitInsn(Opcodes.ICONST_0);
                case 1 -> methodVisitor.visitInsn(Opcodes.ICONST_1);
                case 2 -> methodVisitor.visitInsn(Opcodes.ICONST_2);
                case 3 -> methodVisitor.visitInsn(Opcodes.ICONST_3);
                case 4 -> methodVisitor.visitInsn(Opcodes.ICONST_4);
                case 5 -> methodVisitor.visitInsn(Opcodes.ICONST_5);
            }
        }
        else if(intExpr.value >= -128 && intExpr.value <= 127){
            methodVisitor.visitIntInsn(Opcodes.BIPUSH, intExpr.value);
        } else if (intExpr.value >= -32768 && intExpr.value <= 32767) {
            methodVisitor.visitIntInsn(Opcodes.SIPUSH, intExpr.value);
        }
        else {
            methodVisitor.visitLdcInsn(Integer.valueOf(intExpr.value));
        }
    }

    @Override
    public void visit(JNull jNull) {

    }

    @Override
    public void visit(LocalOrFieldVar localOrFieldVar) {
        if(localVars.contains(localOrFieldVar.name)){
            methodVisitor.visitVarInsn(Opcodes.ISTORE, localVars.indexOf(localOrFieldVar));
        }
        else if(fieldVars.containsKey(localOrFieldVar.name)){
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, className, localOrFieldVar.name,
                    GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(localOrFieldVar.name)));
        }
    }

    @Override
    public void visit(This thisExpr) {

    }

    @Override
    public void visit(Assign assign) {

        if(assign.leftExpr instanceof LocalOrFieldVar){
            LocalOrFieldVar leftExpr = (LocalOrFieldVar) assign.leftExpr;
            if(localVars.contains(leftExpr.name)){
                assign.rightExpr.accept(this);
                methodVisitor.visitVarInsn(Opcodes.ISTORE, localVars.indexOf(leftExpr.name));
            }
            else if(fieldVars.containsKey(leftExpr.name)){
                methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
                assign.rightExpr.accept(this);
                methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, className, leftExpr.name,
                        GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(leftExpr.name)));
            }

        }

    }

    @Override
    public void visit(MethodCall methodCall) {

    }

    @Override
    public void visit(New newCall) {

    }
}
