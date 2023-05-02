package mmc.ast.main;
import mmc.Visitable;
import mmc.ast.Type;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

import java.beans.Visibility;

public class Parameter implements Visitable {
    public Type type;
    public String name;

    public Parameter(Type pType, String pName)
    {
        type=pType;
        name=pName;
    }


 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }
}
