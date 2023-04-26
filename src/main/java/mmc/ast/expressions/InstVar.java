package mmc.ast.expressions;

public class InstVar extends Expression{
    public String name;
    public Expression expression;

    public InstVar(String pName, Expression pExpression)
    {
        name=pName;
        expression=pExpression;
    }
}
