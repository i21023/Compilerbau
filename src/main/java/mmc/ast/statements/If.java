package mmc.ast.statements;

import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

import javax.swing.plaf.nimbus.State;
import java.beans.Expression;

public class If implements IStatement{
    public IExpression expression;
    public IStatement blockIf;
    public IStatement blockElse;
    public Type type;

    public If(IStatement pIf, IStatement pElse, IExpression pExpression){
        blockIf = pIf;
        blockElse = pElse;
        expression = pExpression;
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
