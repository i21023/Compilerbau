package mmc.ast.expressions;

import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class This implements IExpression {

    public Type type;

    public This() {
    }

    public This(Type pType) {
        type = pType;
    }

    public void setType(String className) { //Für SemantikCheck This
        this.type = new ReferenceType(className);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        This oThis = (This) o;
        return type.equals(oThis.type);
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void accept(IMethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
