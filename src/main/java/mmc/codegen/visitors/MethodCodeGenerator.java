package mmc.codegen.visitors;

import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.ast.expressions.*;
import mmc.ast.expressions.Class;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.Crement;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.*;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class MethodCodeGenerator implements IMethodCodeVisitor {

    private final ClassWriter classWriter;
    private MethodVisitor methodVisitor;
    private String currentClassName;
    private String lastCalledClassName;

    private Map<String, Type> fieldVars;
    private Stack<String> localVars;
    private boolean isStaticMethod;

    private boolean pushOnStack = false;


    public MethodCodeGenerator(ClassWriter cw, Map<String, Type> fieldVars, String currentClassName) {
        this.classWriter = cw;
        this.fieldVars = fieldVars;
        this.currentClassName = currentClassName;
        localVars = new Stack<>();
    }

    @Override
    public void visit(Method method) {

        isStaticMethod = method.isStatic;

        if (!method.isStatic) {
            localVars.push("this");
        }

        List<Type> parameterTypes = method.parameters.stream().map(parameter -> parameter.type).collect(Collectors.toList());

        methodVisitor = classWriter.visitMethod(GeneratorHelpFunctions.getAccessModifier(method.accessModifier, method.isStatic),
                method.name, GeneratorHelpFunctions.getDescriptor(parameterTypes, method.type), null, null);

        //Add parameters to localVars
        method.parameters.forEach(parameter -> localVars.add(parameter.name));

        methodVisitor.visitCode();
        method.block.accept(this);

        if (!(method.block.statements.get(method.block.statements.size() - 1) instanceof Return)) {
            new Return(BasicType.VOID, null).accept(this);
        }

        methodVisitor.visitMaxs(0, 0);
        methodVisitor.visitEnd();

    }

    @Override
    public void visit(MainMethod mainMethod) {
        methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        methodVisitor.visitCode();
        mainMethod.block.accept(this);

        if (!(mainMethod.block.statements.get(mainMethod.block.statements.size() - 1) instanceof Return)) {
            new Return(BasicType.VOID, null).accept(this);
        }
        methodVisitor.visitMaxs(0, 0);
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
        methodVisitor.visitMaxs(0, 0);
        methodVisitor.visitEnd();

    }

    public void classConstructor(List<Field> fields) {
        methodVisitor = classWriter.visitMethod(Opcodes.ACC_STATIC, "<clinit>", "()V", null, null);
        methodVisitor.visitCode();

        fields.forEach(field -> {
            new Assign(new LocalOrFieldVar(field.name, field.type, field.isStatic), field.expression, field.type).accept(this);
        });

        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(0, 0);
        methodVisitor.visitEnd();
    }

    @Override
    public void visit(Block block) {
        int stackSizeBefore = localVars.size();
        block.statements.forEach(statement -> statement.accept(this));

        int stackSizeAfter = localVars.size();
        //remove all localVars from Stack that have been initialized in the Block
        for (int i = stackSizeBefore; i < stackSizeAfter; i++) {
            localVars.pop();
        }
    }

    @Override
    public void visit(If ifStmt) {
        Label notEQ = new Label();
        Label end = new Label();

        pushOnStack = true;
        ifStmt.expression.accept(this);
        pushOnStack = false;
        methodVisitor.visitInsn(Opcodes.ICONST_1);

        if (ifStmt.blockElse == null) {
            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, notEQ);

            ifStmt.blockIf.accept(this);

            methodVisitor.visitLabel(notEQ);
        } else {
            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, notEQ);

            //If Block
            ifStmt.blockIf.accept(this);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, end);

            //Else Block
            methodVisitor.visitLabel(notEQ);
            ifStmt.blockElse.accept(this);

            methodVisitor.visitLabel(end);

        }

    }

    @Override
    public void visit(LocalVarDecl localVarDecl) {

        if (localVarDecl.expression == null) {
            localVars.push(localVarDecl.name);
            return;
        }
        pushOnStack = true;
        localVarDecl.expression.accept(this);
        pushOnStack = false;
        if (localVarDecl.type instanceof BasicType) {
            methodVisitor.visitVarInsn(Opcodes.ISTORE, localVars.size());
        } else {
            methodVisitor.visitVarInsn(Opcodes.ASTORE, localVars.size());
        }
        localVars.push(localVarDecl.name);
    }

    @Override
    public void visit(Return returnStmt) {

        if (returnStmt.expression != null) {
            pushOnStack = true;
            returnStmt.expression.accept(this);
            pushOnStack = false;
        }
        if (returnStmt.type instanceof BasicType) {
            switch ((BasicType) returnStmt.type) {
                case VOID -> methodVisitor.visitInsn(Opcodes.RETURN);
                case INT, BOOL, CHAR -> methodVisitor.visitInsn(Opcodes.IRETURN);
            }
        } else if (returnStmt.type instanceof ReferenceType) {
            methodVisitor.visitInsn(Opcodes.ARETURN);
        }
    }

    @Override
    public void visit(While whileStmt) {
        Label startLoop = new Label();
        Label endLoop = new Label();

        methodVisitor.visitLabel(startLoop);

        pushOnStack = true;
        whileStmt.expression.accept(this);
        pushOnStack = false;

        methodVisitor.visitJumpInsn(Opcodes.IFEQ, endLoop);

        whileStmt.statement.accept(this);

        methodVisitor.visitJumpInsn(Opcodes.GOTO, startLoop);

        methodVisitor.visitLabel(endLoop);

    }

    @Override
    public void visit(For forStmt) {
        int stackSizeBefore = localVars.size();

        Label start = new Label();
        Label end = new Label();

        //init statement
        //don't call block or else the declared variables will not be available in for body
        forStmt.initStatements.forEach(statement -> statement.accept(this));

        methodVisitor.visitLabel(start);

        //condition
        if (forStmt.condition != null) {
            pushOnStack = true;
            forStmt.condition.accept(this);
            pushOnStack = false;
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, end); //if condition evaluates to false
        }

        forStmt.statementBlock.accept(this);

        forStmt.updateStatements.forEach(statement -> statement.accept(this));

        methodVisitor.visitJumpInsn(Opcodes.GOTO, start);

        methodVisitor.visitLabel(end);


        int stackSizeAfter = localVars.size();
        //remove all localVars from Stack that have been initialized in the Block
        for (int i = stackSizeBefore; i < stackSizeAfter; i++) {
            localVars.pop();
        }
    }

    @Override
    public void visit(Unary unary) {
        switch (unary.operator) {
            case NOT -> {
                Label evaluateTrue = new Label();
                Label end = new Label();

                unary.expression.accept(this);
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, evaluateTrue);

                methodVisitor.visitInsn(Opcodes.ICONST_0);
                methodVisitor.visitJumpInsn(Opcodes.GOTO, end);

                methodVisitor.visitLabel(evaluateTrue);
                methodVisitor.visitInsn(Opcodes.ICONST_1);

                methodVisitor.visitLabel(end);
            }
        }
    }

    @Override
    public void visit(Binary binary) {
        if (binary.operator != Operator.AND && binary.operator != Operator.OR) {
            binary.expression1.accept(this);
            binary.expression2.accept(this);

            switch (binary.operator) {
                case PLUS -> {
                    methodVisitor.visitInsn(Opcodes.IADD);
                }
                case MINUS -> {
                    methodVisitor.visitInsn(Opcodes.ISUB);
                }
                case MULT -> {
                    methodVisitor.visitInsn(Opcodes.IMUL);
                }
                case DIV -> {
                    methodVisitor.visitInsn(Opcodes.IDIV);
                }
                case MOD -> {
                    methodVisitor.visitInsn(Opcodes.IREM);
                }
                case SINGLEAND -> {
                    methodVisitor.visitInsn(Opcodes.IAND);
                }
                case SINGLEOR -> {
                    methodVisitor.visitInsn(Opcodes.IOR);
                }

                case EQUAL -> {
                    Label notEQ = new Label();
                    Label end = new Label();
                    //compare values on the Stack
                    methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, notEQ);

                    //if equal evaluates true
                    methodVisitor.visitInsn(Opcodes.ICONST_1);
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, end);

                    //if equal evaluates false
                    methodVisitor.visitLabel(notEQ);
                    methodVisitor.visitInsn(Opcodes.ICONST_0);

                    methodVisitor.visitLabel(end);
                }
                case NOTEQUAL -> {
                    Label notEQ = new Label();
                    Label end = new Label();
                    //compare values on the Stack
                    methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, notEQ);

                    //if equal evaluates true
                    methodVisitor.visitInsn(Opcodes.ICONST_0);
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, end);

                    //if equal evaluates false
                    methodVisitor.visitLabel(notEQ);
                    methodVisitor.visitInsn(Opcodes.ICONST_1);

                    methodVisitor.visitLabel(end);
                }

                case LESS -> {
                    Label less = new Label();
                    Label end = new Label();
                    //compare values on the Stack
                    methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLT, less);

                    //if LESSTHAN evaluates false
                    methodVisitor.visitInsn(Opcodes.ICONST_0);
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, end);

                    //if LESSTHAN evaluates true
                    methodVisitor.visitLabel(less);
                    methodVisitor.visitInsn(Opcodes.ICONST_1);

                    methodVisitor.visitLabel(end);
                }

                case GREATER -> {
                    Label greater = new Label();
                    Label end = new Label();
                    //compare values on the Stack
                    methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGT, greater);

                    //if GREATERTHAN evaluates false
                    methodVisitor.visitInsn(Opcodes.ICONST_0);
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, end);

                    //if GREATERTHAN evaluates true
                    methodVisitor.visitLabel(greater);
                    methodVisitor.visitInsn(Opcodes.ICONST_1);

                    methodVisitor.visitLabel(end);
                }

                case LESSEQUAL -> {
                    Label lesseq = new Label();
                    Label end = new Label();
                    //compare values on the Stack
                    methodVisitor.visitJumpInsn(Opcodes.IF_ICMPLE, lesseq);

                    //if LESSTHAN evaluates false
                    methodVisitor.visitInsn(Opcodes.ICONST_0);
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, end);

                    //if LESSTHAN evaluates true
                    methodVisitor.visitLabel(lesseq);
                    methodVisitor.visitInsn(Opcodes.ICONST_1);

                    methodVisitor.visitLabel(end);
                }

                case GREATEREQUAL -> {
                    Label greatereq = new Label();
                    Label end = new Label();
                    //compare values on the Stack
                    methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, greatereq);

                    //if GREATERTHAN evaluates false
                    methodVisitor.visitInsn(Opcodes.ICONST_0);
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, end);

                    //if GREATERTHAN evaluates true
                    methodVisitor.visitLabel(greatereq);
                    methodVisitor.visitInsn(Opcodes.ICONST_1);

                    methodVisitor.visitLabel(end);
                }

            }

        } else {
            switch (binary.operator) {

                case AND -> {

                    Label andFalse = new Label();
                    Label end = new Label();

                    binary.expression1.accept(this);
                    methodVisitor.visitJumpInsn(Opcodes.IFEQ, andFalse);

                    binary.expression2.accept(this);
                    methodVisitor.visitJumpInsn(Opcodes.IFEQ, andFalse);
                    methodVisitor.visitInsn(Opcodes.ICONST_1);
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, end);

                    methodVisitor.visitLabel(andFalse);
                    methodVisitor.visitInsn(Opcodes.ICONST_0);

                    methodVisitor.visitLabel(end);

                }

                case OR -> {
                    Label orTrue = new Label();
                    Label end = new Label();

                    binary.expression1.accept(this);
                    methodVisitor.visitJumpInsn(Opcodes.IFNE, orTrue);

                    binary.expression2.accept(this);
                    methodVisitor.visitJumpInsn(Opcodes.IFNE, orTrue);
                    methodVisitor.visitInsn(Opcodes.ICONST_0);
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, end);

                    methodVisitor.visitLabel(orTrue);
                    methodVisitor.visitInsn(Opcodes.ICONST_1);

                    methodVisitor.visitLabel(end);
                }

            }
        }

    }

    @Override
    public void visit(BoolExpr boolExpr) {
        if (boolExpr.value) {
            methodVisitor.visitInsn(Opcodes.ICONST_1);
        } else {
            methodVisitor.visitInsn(Opcodes.ICONST_0);
        }
    }

    @Override
    public void visit(CharExpr charExpr) {
        if (charExpr.value <= 127) {
            methodVisitor.visitVarInsn(Opcodes.BIPUSH, charExpr.value);
        } else if (charExpr.value <= 32767) {
            methodVisitor.visitVarInsn(Opcodes.SIPUSH, charExpr.value);
        } else {
            methodVisitor.visitLdcInsn(charExpr.value);
        }
    }

    @Override
    public void visit(InstVar instVar) {
        instVar.expression.accept(this);
        lastCalledClassName = ((ReferenceType) instVar.expression.getType()).type;

        if (!instVar.isStatic) {
            methodVisitor.visitFieldInsn(Opcodes.GETFIELD, lastCalledClassName, instVar.name,
                    GeneratorHelpFunctions.getDescriptor(null, instVar.type));
        } else {
            methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, lastCalledClassName, instVar.name,
                    GeneratorHelpFunctions.getDescriptor(null, instVar.type));
        }
    }

    @Override
    public void visit(IntExpr intExpr) {
        if (intExpr.value >= -1 && intExpr.value <= 5) {
            switch (intExpr.value) {
                case -1 -> methodVisitor.visitInsn(Opcodes.ICONST_M1);
                case 0 -> methodVisitor.visitInsn(Opcodes.ICONST_0);
                case 1 -> methodVisitor.visitInsn(Opcodes.ICONST_1);
                case 2 -> methodVisitor.visitInsn(Opcodes.ICONST_2);
                case 3 -> methodVisitor.visitInsn(Opcodes.ICONST_3);
                case 4 -> methodVisitor.visitInsn(Opcodes.ICONST_4);
                case 5 -> methodVisitor.visitInsn(Opcodes.ICONST_5);
            }
        } else if (intExpr.value >= -128 && intExpr.value <= 127) {
            methodVisitor.visitIntInsn(Opcodes.BIPUSH, intExpr.value);
        } else if (intExpr.value >= -32768 && intExpr.value <= 32767) {
            methodVisitor.visitIntInsn(Opcodes.SIPUSH, intExpr.value);
        } else {
            methodVisitor.visitLdcInsn(Integer.valueOf(intExpr.value));
        }
    }

    @Override
    public void visit(StringExpr stringExpr) {
        methodVisitor.visitLdcInsn(stringExpr.value);
    }

    @Override
    public void visit(JNull jNull) {
        methodVisitor.visitInsn(Opcodes.ACONST_NULL);
    }

    @Override
    public void visit(LocalOrFieldVar localOrFieldVar) {
        if (localVars.contains(localOrFieldVar.name)) {
            if (localOrFieldVar.type instanceof BasicType)
                methodVisitor.visitVarInsn(Opcodes.ILOAD, localVars.indexOf(localOrFieldVar.name));
            else
                methodVisitor.visitVarInsn(Opcodes.ALOAD, localVars.indexOf(localOrFieldVar.name));
        } else if (fieldVars.containsKey(localOrFieldVar.name)) {

            if (!localOrFieldVar.isStatic) {
                methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
                methodVisitor.visitFieldInsn(Opcodes.GETFIELD, currentClassName, localOrFieldVar.name,
                        GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(localOrFieldVar.name)));
            } else {
                methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, currentClassName, localOrFieldVar.name,
                        GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(localOrFieldVar.name)));

            }

        }
    }

    @Override
    public void visit(This thisExpr) {
        lastCalledClassName = currentClassName;
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
    }

    @Override
    public void visit(Assign assign) {

        boolean pushOnStackState = pushOnStack;

        switch (assign.operator) {
            case ASSIGN -> {
                if (assign.leftExpr instanceof LocalOrFieldVar leftExpr) {
                    if (localVars.contains(leftExpr.name)) {
                        assign.rightExpr.accept(this);

                        if (pushOnStack) { //when used as expression
                            methodVisitor.visitInsn(Opcodes.DUP);
                        }

                        if (assign.getType() instanceof BasicType)
                            methodVisitor.visitVarInsn(Opcodes.ISTORE, localVars.indexOf(leftExpr.name));
                        else
                            methodVisitor.visitVarInsn(Opcodes.ASTORE, localVars.indexOf(leftExpr.name));
                    } else if (fieldVars.containsKey(leftExpr.name)) {
                        if (!leftExpr.isStatic) {
                            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);

                            pushOnStack = true;
                            assign.rightExpr.accept(this);
                            pushOnStack = pushOnStackState;

                            if (pushOnStack) { //if used as expression
                                methodVisitor.visitInsn(Opcodes.DUP_X1);
                            }

                            methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, currentClassName, leftExpr.name,
                                    GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(leftExpr.name)));
                        } else {
                            assign.rightExpr.accept(this);

                            if (pushOnStack) {
                                methodVisitor.visitInsn(Opcodes.DUP);
                            }

                            methodVisitor.visitFieldInsn(Opcodes.PUTSTATIC, currentClassName, leftExpr.name,
                                    GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(leftExpr.name)));
                        }

                    }
                } else {

                    InstVar leftExpr = (InstVar) assign.leftExpr;

                    ReferenceType owner = (ReferenceType) leftExpr.expression.getType();

                    if (!leftExpr.isStatic) {
                        leftExpr.expression.accept(this);

                        pushOnStack = true;
                        assign.rightExpr.accept(this);
                        pushOnStack = pushOnStackState;

                        if (pushOnStack) { //if used as expression
                            methodVisitor.visitInsn(Opcodes.DUP_X1);
                        }

                        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, owner.type, leftExpr.name,
                                GeneratorHelpFunctions.getDescriptor(null, leftExpr.type));

                    } else {
                        assign.rightExpr.accept(this);

                        if (pushOnStack) {
                            methodVisitor.visitInsn(Opcodes.DUP);
                        }

                        methodVisitor.visitFieldInsn(Opcodes.PUTSTATIC, owner.type, leftExpr.name,
                                GeneratorHelpFunctions.getDescriptor(null, leftExpr.type));
                    }

                }
                //TODO: Instvar
            }

            case PLUSASSIGN -> {
                new Assign(assign.leftExpr, new Binary(Operator.PLUS, assign.leftExpr, assign.rightExpr), assign.type).accept(this);
            }

            case MINUSASSIGN -> {
                new Assign(assign.leftExpr, new Binary(Operator.MINUS, assign.leftExpr, assign.rightExpr), assign.type).accept(this);
            }

            case MULTASSIGN -> {
                new Assign(assign.leftExpr, new Binary(Operator.MULT, assign.leftExpr, assign.rightExpr), assign.type).accept(this);
            }

            case DIVASSIGN -> {
                new Assign(assign.leftExpr, new Binary(Operator.DIV, assign.leftExpr, assign.rightExpr), assign.type).accept(this);
            }

            case MODASSIGN -> {
                new Assign(assign.leftExpr, new Binary(Operator.MOD, assign.leftExpr, assign.rightExpr), assign.type).accept(this);
            }

            default -> {
                throw new IllegalArgumentException("Unexpected Operator: " + assign.operator);
            }
        }

    }


    @Override
    public void visit(MethodCall methodCall) {

        boolean pushOnStackState = pushOnStack;

        pushOnStack = true;
        methodCall.methodOwnerPrefix.accept(this);
        methodCall.arguments.forEach(argument -> argument.accept(this));
        pushOnStack = pushOnStackState;

        String type = methodCall.methodOwnerPrefix.getType() instanceof ReferenceType ref ? ref.type : null;

        if (type == null)
            throw new IllegalArgumentException("Unexpected: " + methodCall.methodOwnerPrefix.getType());

        if (methodCall.isStatic) {
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, type, methodCall.name, GeneratorHelpFunctions.getDescriptor(methodCall.arguments.stream().map(IExpression::getType).collect(Collectors.toList()), methodCall.type), false);
        } else {
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, type, methodCall.name, GeneratorHelpFunctions.getDescriptor(methodCall.arguments.stream().map(IExpression::getType).collect(Collectors.toList()), methodCall.type), false);
        }
        if (!pushOnStack && methodCall.type != BasicType.VOID) {
            methodVisitor.visitInsn(Opcodes.POP);
        }
    }

    @Override
    public void visit(New newCall) {

        boolean pushOnStackState = pushOnStack;

        if (!(newCall.type instanceof ReferenceType)) {
            throw new IllegalArgumentException("Cannot call new on a primitive datatype");
        }

        String type = ((ReferenceType) newCall.type).type;
        methodVisitor.visitTypeInsn(Opcodes.NEW, type);

        if (pushOnStack) { //Don't put reference on stack when called as statement
            methodVisitor.visitInsn(Opcodes.DUP);
        }

        pushOnStack = true;
        newCall.arguments.forEach(argument -> argument.accept(this));
        pushOnStack = pushOnStackState;

        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, type, "<init>", GeneratorHelpFunctions.getDescriptor(newCall.arguments.stream().map(IExpression::getType).collect(Collectors.toList()), BasicType.VOID), false);
    }

    @Override
    public void visit(Crement crement) {

        int vartype = 0; // localvar

        if (crement.expression instanceof LocalOrFieldVar l) {
            if (!localVars.contains(l.name)) {
                vartype = 1; //fieldvar
            }
        }
        else {
            vartype = 2; //instvar
        }

            switch (crement.operator) {

                case INCPRE -> {
                    switch(vartype){
                        case 0 -> crementLocalVar(crement, true, true);
                        case 1 -> crementFieldVar(crement, true, true);
                        case 2 -> crementInstVar(crement, true, true);
                    }
                }
                case INCSUF -> {
                    switch(vartype){
                        case 0 -> crementLocalVar(crement, true, false);
                        case 1 -> crementFieldVar(crement, true, false);
                        case 2 -> crementInstVar(crement, true, false);
                    }
                }
                case DECPRE -> {
                    switch(vartype){
                        case 0 -> crementLocalVar(crement, false, true);
                        case 1 -> crementFieldVar(crement, false, true);
                        case 2 -> crementInstVar(crement, false, true);
                    }
                }
                case DECSUF -> {
                    switch(vartype){
                        case 0 -> crementLocalVar(crement, false, false);
                        case 1 -> crementFieldVar(crement, false, false);
                        case 2 -> crementInstVar(crement, false, false);
                    }
                }
                default -> throw new IllegalArgumentException("Crement Expression cannot have Operator: " + crement.operator);
            }
        }

    public void crementLocalVar(Crement crement, boolean amount, boolean pre){

        String name = ((LocalOrFieldVar) crement.expression).name;

        if(!pre && pushOnStack){
            crement.expression.accept(this);
        }

        if(amount)
            methodVisitor.visitIincInsn(localVars.indexOf(name), 1);
        else
            methodVisitor.visitIincInsn(localVars.indexOf(name), -1);

        if(pre && pushOnStack){
            crement.expression.accept(this);
        }

    }

    public void crementFieldVar(Crement crement, boolean amount, boolean pre) {

        String name = ((LocalOrFieldVar) crement.expression).name;

        if (!((LocalOrFieldVar) crement.expression).isStatic) {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitInsn(Opcodes.DUP);
            methodVisitor.visitFieldInsn(Opcodes.GETFIELD, currentClassName, name,
                    GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(name)));

            if (!pre && pushOnStack) {
                methodVisitor.visitInsn(Opcodes.DUP_X1);
            }

            if (amount) {
                methodVisitor.visitInsn(Opcodes.ICONST_1);
            } else {
                methodVisitor.visitInsn(Opcodes.ICONST_M1);
            }
            methodVisitor.visitInsn(Opcodes.IADD);

            if (pre && pushOnStack) {
                methodVisitor.visitInsn(Opcodes.DUP_X1);
            }

            methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, currentClassName, name,
                    GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(name)));
        } else {
            //methodVisitor.visitInsn(Opcodes.DUP);
            methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, currentClassName, name,
                    GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(name)));

            if (!pre && pushOnStack) {
                methodVisitor.visitInsn(Opcodes.DUP);
            }

            if (amount) {
                methodVisitor.visitInsn(Opcodes.ICONST_1);
            } else {
                methodVisitor.visitInsn(Opcodes.ICONST_M1);
            }
            methodVisitor.visitInsn(Opcodes.IADD);

            if (pre && pushOnStack) {
                methodVisitor.visitInsn(Opcodes.DUP);
            }

            methodVisitor.visitFieldInsn(Opcodes.PUTSTATIC, currentClassName, name,
                    GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(name)));
        }
    }

    public void crementInstVar(Crement crement, boolean amount, boolean pre) {

        InstVar instVar = (InstVar) crement.expression;

        ReferenceType owner = (ReferenceType) instVar.expression.getType();

        if (((InstVar) crement.expression).isStatic) {
            methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, owner.type, instVar.name, GeneratorHelpFunctions.getDescriptor(null, instVar.type));

            if (!pre && pushOnStack) {
                methodVisitor.visitInsn(Opcodes.DUP);
            }

            if (amount) {
                methodVisitor.visitInsn(Opcodes.ICONST_1);
            } else {
                methodVisitor.visitInsn(Opcodes.ICONST_M1);
            }
            methodVisitor.visitInsn(Opcodes.IADD);

            if (pre && pushOnStack) {
                methodVisitor.visitInsn(Opcodes.DUP);
            }

            methodVisitor.visitFieldInsn(Opcodes.PUTSTATIC, owner.type, instVar.name, GeneratorHelpFunctions.getDescriptor(null, instVar.type));

        } else {

            ((InstVar) crement.expression).expression.accept(this);
            methodVisitor.visitInsn(Opcodes.DUP);

            methodVisitor.visitFieldInsn(Opcodes.GETFIELD, owner.type, instVar.name,
                    GeneratorHelpFunctions.getDescriptor(null, instVar.type));

            if (!pre && pushOnStack) {
                methodVisitor.visitInsn(Opcodes.DUP_X1);
            }

            if (amount) {
                methodVisitor.visitInsn(Opcodes.ICONST_1);
            } else {
                methodVisitor.visitInsn(Opcodes.ICONST_M1);
            }
            methodVisitor.visitInsn(Opcodes.IADD);

            if (pre && pushOnStack) {
                methodVisitor.visitInsn(Opcodes.DUP_X1);
            }

            methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, owner.type, instVar.name,
                    GeneratorHelpFunctions.getDescriptor(null, instVar.type));
        }

    }

    @Override
    public void visit(Class classz) {
        // do nothing
    }

}
