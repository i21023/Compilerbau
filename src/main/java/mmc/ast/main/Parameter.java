package mmc.ast.main;
import mmc.ast.Type;
public class Parameter {
    public Type type;
    public String name;

    public Parameter(Type pType, String pName)
    {
        type=pType;
        name=pName;
    }

}
