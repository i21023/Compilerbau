package mmc.ast.expressions;

import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class InstVar implements IExpression {
    public String name;
    public IExpression expression;
    public Type type;
    public boolean isStatic; //TODO: @Emma bitte im Semantikcheck setzen :)

    public InstVar(String pName, IExpression pExpression) {
        name = pName;
        expression = pExpression;
    }

    public InstVar(String pName, IExpression pExpression, Type pType, boolean pIsStatic) {
        name = pName;
        expression = pExpression;
        type = pType;
        isStatic = pIsStatic;
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstVar instVar = (InstVar) o;
        if (type == null && instVar.type == null) {
            typeIsEqual = true;
        } else if (type.equals(instVar.type)) {
            typeIsEqual = true;
        }
        return name.equals(instVar.name) && expression.equals(instVar.expression) && typeIsEqual && isStatic == instVar.isStatic;
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
