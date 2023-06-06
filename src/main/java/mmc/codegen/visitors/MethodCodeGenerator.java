package mmc.codegen.visitors;

import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.ast.expressions.*;
import mmc.ast.main.Constructor;
import mmc.ast.main.Field;
import mmc.ast.main.Method;
import mmc.ast.main.Parameter;
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
    private List<String> classNames;

    private Map<String, Type> fieldVars;
    private Stack<String> localVars;
    private boolean isStaticMethod;

    private boolean pushCrementOnStack = false;


    public MethodCodeGenerator(ClassWriter cw, Map<String, Type> fieldVars, String currentClassName, List<String> classNames) {
        this.classWriter = cw;
        this.fieldVars = fieldVars;
        this.currentClassName = currentClassName;
        this.classNames = classNames;
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
        method.statement.accept(this);

        if (method.statement instanceof Block block) {
            if (!(block.statements.get(block.statements.size() - 1) instanceof Return)) {
                new Return(BasicType.VOID, null).accept(this);
            }
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
            new Assign(new LocalOrFieldVar(field.name, field.type, field.isStatic), field.expression, null).accept(this);
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

        ifStmt.expression.accept(this);
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
        localVarDecl.expression.accept(this);
        if (localVarDecl.type instanceof BasicType) {
            methodVisitor.visitVarInsn(Opcodes.ISTORE, localVars.size());
        } else {
            methodVisitor.visitVarInsn(Opcodes.ASTORE, localVars.size());
        }
        localVars.push(localVarDecl.name);
    }

    @Override
    public void visit(Return returnStmt) {

        if (returnStmt.expression != null)
            pushCrementOnStack = true;
        returnStmt.expression.accept(this);
        pushCrementOnStack = false;

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
        whileStmt.expression.accept(this);
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
        if (forStmt.initStatement instanceof Block block) {
            block.statements.forEach(statement -> statement.accept(this));
        }
        forStmt.initStatement.accept(this);

        methodVisitor.visitLabel(start);

        //condition
        forStmt.condition.accept(this);

        methodVisitor.visitJumpInsn(Opcodes.IFEQ, end); //if condition evaluates to false

        forStmt.statementBlock.accept(this);

        if (forStmt.updateStatement instanceof Block block) {
            block.statements.forEach(statement -> statement.accept(this));
        }
        forStmt.updateStatement.accept(this);

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
                methodVisitor.visitJumpInsn(Opcodes.IFNE, evaluateTrue);

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
                    methodVisitor.visitJumpInsn(Opcodes.IFNE, andFalse);

                    binary.expression2.accept(this);
                    methodVisitor.visitJumpInsn(Opcodes.IFNE, andFalse);
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
                    methodVisitor.visitJumpInsn(Opcodes.IFEQ, orTrue);

                    binary.expression2.accept(this);
                    methodVisitor.visitJumpInsn(Opcodes.IFEQ, orTrue);
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

    }

    @Override
    public void visit(Assign assign) {

        switch (assign.operator) {
            case ASSIGN -> {
                pushCrementOnStack = true;
                if (assign.leftExpr instanceof LocalOrFieldVar) {
                    LocalOrFieldVar leftExpr = (LocalOrFieldVar) assign.leftExpr;
                    if (localVars.contains(leftExpr.name)) {
                        assign.rightExpr.accept(this);
                        if (assign.getType() instanceof BasicType)
                            methodVisitor.visitVarInsn(Opcodes.ISTORE, localVars.indexOf(leftExpr.name));
                        else
                            methodVisitor.visitVarInsn(Opcodes.ASTORE, localVars.indexOf(leftExpr.name));
                    } else if (fieldVars.containsKey(leftExpr.name)) {
                        if (!leftExpr.isStatic) {
                            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
                            assign.rightExpr.accept(this);
                            methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, currentClassName, leftExpr.name,
                                    GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(leftExpr.name)));
                        } else {
                            assign.rightExpr.accept(this);
                            methodVisitor.visitFieldInsn(Opcodes.PUTSTATIC, currentClassName, leftExpr.name,
                                    GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(leftExpr.name)));
                        }

                    }
                }
                //TODO: Instvar
                pushCrementOnStack = false;
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

    }

    @Override
    public void visit(New newCall) {
        if (!(newCall.type instanceof ReferenceType)) {
            throw new IllegalArgumentException("Cannot Call new on a Primitive Datatype");
        }

        String type = ((ReferenceType) newCall.type).type;
        methodVisitor.visitTypeInsn(Opcodes.NEW, type);
        methodVisitor.visitInsn(Opcodes.DUP);
        //TODO: POP Reference if it is not assigned
        newCall.arguments.forEach(argument -> argument.accept(this));
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, type, "<init>", GeneratorHelpFunctions.getDescriptor(newCall.arguments.stream().map(IExpression::getType).collect(Collectors.toList()), BasicType.VOID), false);
    }

    @Override
    public void visit(Crement crement) {

        switch (crement.operator) {

            case INCPRE -> {
                doCrement(crement, 1);
                if (pushCrementOnStack) {
                    crement.expression.accept(this);
                }

            }
            case INCSUF -> {
                if (pushCrementOnStack) {
                    crement.expression.accept(this);
                }
                doCrement(crement, 1);
            }
            case DECPRE -> {
                doCrement(crement, -1);
                if (pushCrementOnStack) {
                    crement.expression.accept(this);
                }
            }
            case DECSUF -> {
                if (pushCrementOnStack) {
                    crement.expression.accept(this);
                }
                doCrement(crement, -1);
            }
            default -> {
                throw new IllegalArgumentException("Crement Expression cannot have Operator: " + crement.operator);
            }
        }
        pushCrementOnStack = false;
    }

    public void doCrement(Crement crement, int amount) {
        if (crement.expression instanceof LocalOrFieldVar) {
            String name = ((LocalOrFieldVar) crement.expression).name;

            if (localVars.contains(name)) { //LocalVar
                methodVisitor.visitIincInsn(localVars.indexOf(name), amount);
            } else { //FieldVar
                if (!((LocalOrFieldVar) crement.expression).isStatic) {
                    methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
                    methodVisitor.visitInsn(Opcodes.DUP);
                    methodVisitor.visitFieldInsn(Opcodes.GETFIELD, currentClassName, name,
                            GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(name)));
                    if (amount == 1) {
                        methodVisitor.visitInsn(Opcodes.ICONST_1);
                    } else {
                        methodVisitor.visitInsn(Opcodes.ICONST_M1);
                    }
                    methodVisitor.visitInsn(Opcodes.IADD);
                    methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, currentClassName, name,
                            GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(name)));
                } else {
                    //methodVisitor.visitInsn(Opcodes.DUP);
                    methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, currentClassName, name,
                            GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(name)));
                    if (amount == 1) {
                        methodVisitor.visitInsn(Opcodes.ICONST_1);
                    } else {
                        methodVisitor.visitInsn(Opcodes.ICONST_M1);
                    }
                    methodVisitor.visitInsn(Opcodes.IADD);
                    methodVisitor.visitFieldInsn(Opcodes.PUTSTATIC, currentClassName, name,
                            GeneratorHelpFunctions.getDescriptor(null, fieldVars.get(name)));
                }

            }
        } else { //InstVar

        }


    }

}
