package mmc.ast.expressions;

import mmc.ast.Type;

public class Expression {
    public Type type;

    public Expression(Type pType)
    {
        type=pType;
    }
    public Expression(){}
}
