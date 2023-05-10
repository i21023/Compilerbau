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

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MethodCodeGenerator implements IMethodCodeVisitor{

    private final ClassWriter classWriter;
    private MethodVisitor methodVisitor;

    int stacksize;

    public MethodCodeGenerator(ClassWriter cw){
        this.classWriter = cw;
        stacksize = 0;
    }

    @Override
    public void visit(Method method) {

        List<Type> parameterTypes = method.parameters.stream().map(parameter -> parameter.type).collect(Collectors.toList());

        methodVisitor = classWriter.visitMethod(GeneratorHelpFunctions.getAccessModifier(method.accessModifier, false),
                method.name, GeneratorHelpFunctions.getDescriptor(parameterTypes, method.type), null, null);

        stacksize++;
        stacksize += method.parameters.size();

        methodVisitor.visitCode();
        method.statement.accept(this);
        //TODO: Check ob void zurückkommt
        methodVisitor.visitMaxs(0,0);
        methodVisitor.visitEnd();
    }

    @Override
    public void visit(Constructor constructor) {
        List<Type> parameterTypes = constructor.parameters.stream().map(parameter -> parameter.type).collect(Collectors.toList());

        methodVisitor = classWriter.visitMethod(GeneratorHelpFunctions.getAccessModifier(constructor.accessModifier, false),
                "<init>", GeneratorHelpFunctions.getDescriptor(parameterTypes, constructor.type), null, null);

        stacksize++;
        stacksize += constructor.parameters.size();

        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "V()", false);

        //Generate Code of Constructor Block
        constructor.statement.accept(this);

        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(0,0);
        methodVisitor.visitEnd();

        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
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
            return;
        }
        localVarDecl.expression.accept(this);
        if(localVarDecl.type instanceof BasicType){
            methodVisitor.visitVarInsn(Opcodes.ISTORE, ++stacksize);
        }
        else{
            methodVisitor.visitVarInsn(Opcodes.ASTORE, ++stacksize);
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

    }

    @Override
    public void visit(This thisExpr) {

    }

    @Override
    public void visit(Assign assign) {

    }

    @Override
    public void visit(MethodCall methodCall) {

    }

    @Override
    public void visit(New newCall) {

    }
}
