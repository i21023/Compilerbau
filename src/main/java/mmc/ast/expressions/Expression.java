package mmc.ast.expressions;

import mmc.ast.Type;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class Expression  {
    public Type type;

    public Expression(Type pType)
    {
        type=pType;
    }
    public Expression(){}


}
