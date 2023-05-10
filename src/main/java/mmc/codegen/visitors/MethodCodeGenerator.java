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
import java.util.stream.Collectors;

public class MethodCodeGenerator implements IMethodCodeVisitor{

    private final ClassWriter classWriter;
    private MethodVisitor methodVisitor;

    public MethodCodeGenerator(ClassWriter cw){
        this.classWriter = cw;
    }

    @Override
    public void visit(Method method) {

    }

    @Override
    public void visit(Constructor constructor) {
        List<Type> parameterTypes = constructor.parameters.stream().map(parameter -> parameter.type).collect(Collectors.toList());

        methodVisitor = classWriter.visitMethod(GeneratorHelpFunctions.getAccessModifier(constructor.accessModifier, false),
                "<init>", GeneratorHelpFunctions.getDescriptor(parameterTypes, constructor.type), null, null);

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

    }

    @Override
    public void visit(CharExpr charExpr) {

    }

    @Override
    public void visit(InstVar instVar) {

    }

    @Override
    public void visit(IntExpr intExpr) {

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
