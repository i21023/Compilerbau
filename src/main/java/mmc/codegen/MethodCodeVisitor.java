package mmc.codegen;

import mmc.ast.expressions.*;
import mmc.ast.main.Constructor;
import mmc.ast.main.Method;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.*;

public interface MethodCodeVisitor {

    void visit(Method method);
    void visit(Constructor constructor);

    //Statements
    void visit(Block block);
    void visit(If ifStmt);
    void visit(LocalVarDecl localVarDecl);
    void visit(Return returnStmt);
    void visit(While whileStmt);

    //Expressions
    void visit(Unary unary);
    void visit(Binary binary);
    void visit(BoolExpr boolExpr);
    void visit(CharExpr charExpr);
    void visit(InstVar instVar);
    void visit(IntExpr intExpr);
    void visit(JNull jNull);
    void visit(LocalOrFieldVar localOrFieldVar);
    void visit(This thisExpr);

    //StatementExpression
    void visit(Assign assign);
    void visit(MethodCall methodCall);
    void visit(New newCall);
}
