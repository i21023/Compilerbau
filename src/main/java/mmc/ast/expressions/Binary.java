package mmc.ast.expressions;

import mmc.ast.Operator;

public class Binary extends Expression{
    Operator operator;
    Expression expression1;
    Expression expression2;
}
