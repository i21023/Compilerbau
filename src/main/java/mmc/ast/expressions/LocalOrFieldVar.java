package mmc.ast.expressions;

public class LocalOrFieldVar extends Expression{
    public String name;

    public LocalOrFieldVar(String pName)
    {
        name=pName;
    }
}
