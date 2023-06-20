package mmc.ast.expressions;

import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class Class implements IExpression {

    public String name;
    public Type type;

    public Class(String pName, Type pType) {
        name = pName;
        type = pType;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class oClass = (Class) o;
        if (type == null && oClass.type == null) {
            typeIsEqual = true;
        } else if (type.equals(oClass.type)) {
            typeIsEqual = true;
        }
        return name.equals(oClass.name) && typeIsEqual;
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public int getStartLine() {
        return -1;
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
