package mmc.ast.statementexpression;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;


import java.util.List;

public class New implements IStatementExpression {
    public List<IExpression> arguments;
    public Type type;
    private String name;

    public New(String pName, List<IExpression> pExpressions) {
        arguments = pExpressions;
        name = pName;
    }

    public New(List<IExpression> pExpressions, Type pType) {
        type = pType;
        arguments = pExpressions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        New oNew = (New) o;
        return arguments.equals(oNew.arguments)&&type.equals(oNew.type)&&name.equals(oNew.name);

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
