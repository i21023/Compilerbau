package mmc.ast.main;
import mmc.Visitable;
import mmc.ast.BasicType;
import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;


public class Parameter implements Visitable {
    public Type type;
    public String name;

    public Parameter(Type pType, String pName)
    {
        type=pType;
        name=pName;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if(o==null||getClass()!=o.getClass())return false;
        Parameter parameter = (Parameter) o;
        return type.equals(parameter.type)&&name.equals(parameter.name);
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

}
