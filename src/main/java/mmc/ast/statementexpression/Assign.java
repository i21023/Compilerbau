package mmc.ast.statementexpression;

import mmc.ast.Operator;
import mmc.ast.expressions.Expression;

public class Assign extends StatementExpression {
    Operator operator;
    Expression expression;
}
