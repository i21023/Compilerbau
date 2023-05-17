package mmc.semantikcheck;

import mmc.ast.expressions.*;
import mmc.ast.main.*;
import mmc.ast.statementexpression.*;
import mmc.ast.statements.*;

public interface SemanticVisitor {
    TypeCheckResult typeCheck(Program toCheck);

    TypeCheckResult typeCheck(ClassDecl toCheck);

    TypeCheckResult typeCheck(Field toCheck);

    TypeCheckResult typeCheck(Constructor toCheck);

    TypeCheckResult typeCheck(Method toCheck);

    TypeCheckResult typeCheck(Assign toCheck);

    TypeCheckResult typeCheck(Parameter toCheck);

    TypeCheckResult typeCheck(While whileStmt);

    TypeCheckResult typeCheck(For forStmt);

    TypeCheckResult typeCheck(Return returnStmt);

    TypeCheckResult typeCheck(LocalVarDecl localVarDecl);

    TypeCheckResult typeCheck(If ifStmt);

    TypeCheckResult typeCheck(Block block);

    TypeCheckResult typeCheck(New newDecl);

    TypeCheckResult typeCheck(MethodCall methodCall);

    TypeCheckResult typeCheck(Unary unary);

    TypeCheckResult typeCheck(This aThis);

    TypeCheckResult typeCheck(JNull aNull);

    TypeCheckResult typeCheck(LocalOrFieldVar localOrFieldVar);

    TypeCheckResult typeCheck(IntExpr integerExpr);

    TypeCheckResult typeCheck(InstVar instVar);

    TypeCheckResult typeCheck(CharExpr charExpr);

    TypeCheckResult typeCheck(BoolExpr boolExpr);

    TypeCheckResult typeCheck(Binary binary);

}
