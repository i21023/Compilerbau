package mmc.ast.statementexpression;

import mmc.ast.Operator;
import mmc.ast.expressions.Expression;

public class Assign extends StatementExpression {
    Expression leftExpr;
    Operator operator;
    Expression rightExpr;
}
