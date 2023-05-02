package mmc.ast.expressions;

import mmc.Visitable;
import mmc.ast.Type;

public interface IExpression extends Visitable {
    public Type getType();
}
