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
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

}
