package mmc.ast.expressions;

import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class StringExpr implements IExpression {

    public String value;
    private Type type;
    public int startLine; public int stopLine;

    public StringExpr(String pString) {
        value = pString;
        type = new ReferenceType("java/lang/String");
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringExpr SE = (StringExpr) o;
        if (type == null && SE.type == null) {
            typeIsEqual = true;
        } else if (type.equals(SE.type)) {
            typeIsEqual = true;
        }
        return typeIsEqual && value.equals(SE.value);
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
