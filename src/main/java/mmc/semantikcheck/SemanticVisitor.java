package mmc.semantikcheck;

import mmc.ast.expressions.*;
import mmc.ast.expressions.Class;
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

    TypeCheckResult typeCheck(While toCheck);

    TypeCheckResult typeCheck(For toCheck);

    TypeCheckResult typeCheck(Return toCheck);

    TypeCheckResult typeCheck(LocalVarDecl toCheck);

    TypeCheckResult typeCheck(If toCheck);

    TypeCheckResult typeCheck(Block toCheck);

    TypeCheckResult typeCheck(New toCheck);

    TypeCheckResult typeCheck(MethodCall toCheck);

    TypeCheckResult typeCheck(Crement toCheck);

    TypeCheckResult typeCheck(Unary toCheck);

    TypeCheckResult typeCheck(This toCheck);

    TypeCheckResult typeCheck(JNull toCheck);

    TypeCheckResult typeCheck(LocalOrFieldVar toCheck);
    TypeCheckResult typeCheck(Binary toCheck);
    TypeCheckResult typeCheck(InstVar toCheck);

    TypeCheckResult typeCheck(IntExpr toCheck);
    TypeCheckResult typeCheck(CharExpr toCheck);

    TypeCheckResult typeCheck(BoolExpr toCheck);
    TypeCheckResult typeCheck(StringExpr toCheck);

    TypeCheckResult typeCheck(Class toCheck);

}
