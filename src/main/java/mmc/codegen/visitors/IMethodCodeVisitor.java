package mmc.codegen.visitors;

import mmc.ast.Type;
import mmc.ast.expressions.*;
import mmc.ast.main.Constructor;
import mmc.ast.main.Method;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.*;
import org.objectweb.asm.Opcodes;

import java.util.List;
import java.util.stream.Collectors;

public interface IMethodCodeVisitor {

    public void visit(Method method);

    public void visit(Constructor constructor);

    public void visit(Block block);

    public void visit(If ifStmt);

    public void visit(LocalVarDecl localVarDecl);

    public void visit(Return returnStmt);

    public void visit(While whileStmt);

    public void visit(Unary unary);

    public void visit(Binary binary);

    public void visit(BoolExpr boolExpr);

    public void visit(CharExpr charExpr);

    public void visit(InstVar instVar);

    public void visit(IntExpr intExpr);

    public void visit(JNull jNull);

    public void visit(LocalOrFieldVar localOrFieldVar);

    public void visit(This thisExpr);

    public void visit(Assign assign);

    public void visit(MethodCall methodCall);

    public void visit(New newCall);
}
