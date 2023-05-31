package mmc.ast.statements;
import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public class LocalVarDecl implements IStatement{
    public String name;
    public Type type;
    public IExpression expression;

    public LocalVarDecl(String pName, Type pType, IExpression pExpression) {
        type = pType;
        name = pName;
        expression = pExpression;
    }
    public LocalVarDecl(String pName) {
        name = pName;
    }

    public LocalVarDecl(String pName, Type pType) {
        type = pType;
        name = pName;
        expression = null;
    }

    public Type getType() {
        return type;
    }
 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public void accept(IMethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
