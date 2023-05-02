package mmc.ast.statements;

import mmc.ast.expressions.IExpression;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

import javax.swing.plaf.nimbus.State;
import java.beans.Expression;

public class If implements IStatement{
    public IExpression expression;
    public IStatement statement1;
    public IStatement statement2;

 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }
}
