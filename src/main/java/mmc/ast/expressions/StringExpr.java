package mmc.ast.expressions;

import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class StringExpr implements IExpression{

    private String string;
    private Type type;

    public StringExpr(String pString){
        string = pString;
        type = new ReferenceType("java/lang/String");
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return null;
    }

    @Override
    public Type getType() {
        return type;
    }

    /*@Override
    public void accept(IMethodCodeVisitor visitor) {
        visitor.visit(this);
    }*/
}
