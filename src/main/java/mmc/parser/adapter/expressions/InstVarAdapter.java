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
            previous = new This(instVar.getStart().getLine(), instVar.getStop().getLine());
        } else if (instVar.new_statement() != null) {
            previous = NewStatementAdapter.adapt(instVar.new_statement());
        }

        return generatePreviousInstVar(instVar.ID(), previous, 0, instVar.getStart().getLine(), instVar.getStart().getLine()); //Durchlaufen der IDs: Bei einer ID --> LocalFieldVar, sonst InstVar
    }

    private static IExpression generatePreviousInstVar(List<TerminalNode> ids, IExpression previous, int position,
                                                       int startLine, int endLine) {
        if (position >= ids.size()) {
            return previous;
        }

        String id = ids.get(position).getText();
        if (previous == null && id.equals("System")) {
            id = "java/lang/System";
        } else if (previous == null && id.equals("String")) {
            id = "java/lang/String";
        }

        IExpression currentExpression = (previous == null) ?
                new LocalOrFieldVar(id, startLine, endLine) :
                new InstVar(id, previous, startLine, endLine);

        return generatePreviousInstVar(ids, currentExpression, position + 1, startLine, endLine);
    }
}
