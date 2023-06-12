package mmc.parser.adapter.expressions;

import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.InstVar;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.expressions.This;
import mmc.parser.adapter.statementexpressions.NewStatementAdapter;
import mmc.parser.antlr.MiniJavaParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class InstVarAdapter {

    public static IExpression adapt(MiniJavaParser.Inst_varContext instVar) {

        IExpression previous = null;
        if (instVar.THIS() != null) {
            previous = new This();
        } else if (instVar.new_statement() != null) {
            previous = NewStatementAdapter.adapt(instVar.new_statement());
        }

        return generatePreviousInstVar(instVar.ID(), previous, 0); //Durchlaufen der IDs: Bei einer ID --> LocalFieldVar, sonst InstVar
    }

    private static IExpression generatePreviousInstVar(List<TerminalNode> ids, IExpression previous, int position) {
        if (position >= ids.size()) {
            return previous;
        }

        String id = ids.get(position).getText();
        IExpression currentExpression = (previous == null) ? new LocalOrFieldVar(id) : new InstVar(id, previous);

        return generatePreviousInstVar(ids, currentExpression, position + 1);
    }
}
