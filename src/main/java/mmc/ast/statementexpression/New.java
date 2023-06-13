package mmc.ast.statementexpression;

import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;


import java.util.List;

public class New implements IStatementExpression {
    public List<IExpression> arguments;
    public Type type;
    public String name;

    public New(String pName, List<IExpression> pExpressions) {
        arguments = pExpressions;
        name = pName;
        type = new ReferenceType(pName);
    }

    @Override
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        New oNew = (New) o;
        if (type == null && oNew.type == null) {
            typeIsEqual = true;
        } else if (type.equals(oNew.type)) {
            typeIsEqual = true;
        }
        return arguments.equals(oNew.arguments) && typeIsEqual && name.equals(oNew.name);

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
