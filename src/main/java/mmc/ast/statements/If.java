package mmc.ast.statements;

import javax.swing.plaf.nimbus.State;
import java.beans.Expression;

public class If extends Statement{
    public Expression expression;
    public Statement statement1;
    public Statement statement2;
}
