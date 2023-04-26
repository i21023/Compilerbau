package mmc.ast.expressions;

import mmc.ast.Operator;

public class Binary extends Expression{
    public Operator operator;
    public Expression expression1;
    public Expression expression2;
}
