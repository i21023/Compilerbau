package mmc.parser.adapter.expressions;

import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.InstVar;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.expressions.This;
import mmc.ast.statementexpression.MethodCall;
import mmc.parser.adapter.statementexpressions.MethodCallStatementAdapter;
import mmc.parser.adapter.statementexpressions.NewStatementAdapter;
import mmc.parser.antlr.MiniJavaParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class InstVarAdapter {

    public static IExpression adapt(MiniJavaParser.Inst_varContext instVar) {

        boolean flagTwoIds = false;

        IExpression previous;
        if (instVar.THIS() != null) {
            previous = new This(instVar.getStart().getLine(), instVar.getStop().getLine());
        } else if (instVar.new_statement() != null) {
            previous = NewStatementAdapter.adapt(instVar.new_statement());
        } else if (instVar.method_chain() != null) {
            previous = new MethodCall(null, instVar.method_chain().ID().getText(),
                    MethodCallStatementAdapter.getMethodArguments(instVar.method_chain().argumentList()),
                    instVar.method_chain().getStart().getLine(), instVar.method_chain().getStop().getLine());
        } else {
            String id = instVar.ID().get(0).getText();
            if (id.equals("System")) {
                id = "java/lang/System";
            } else if (id.equals("String")) {
                id = "java/lang/String";
            }
            previous = new LocalOrFieldVar(id,
                    instVar.getStart().getLine(), instVar.getStop().getLine());
            flagTwoIds = true;
        }

        IExpression expression = generatePreviousInstVar(instVar.inst_var_in_between(), previous, 0, instVar.getStart().getLine(), instVar.getStart().getLine()); //Durchlaufen der IDs: Bei einer ID --> LocalFieldVar, sonst InstVar

        if (flagTwoIds) {
            return new InstVar(instVar.ID().get(1).getText(), expression, instVar.getStart().getLine(), instVar.getStop().getLine());
        } else {
            return new InstVar(instVar.ID().get(0).getText(), expression, instVar.getStart().getLine(), instVar.getStop().getLine());
        }
    }

    private static IExpression generatePreviousInstVar(List<MiniJavaParser.Inst_var_in_betweenContext> ids, IExpression previous, int position,
                                                       int startLine, int endLine) {
        if (position >= ids.size()) {
            return previous;
        }

        IExpression currentExpression;
        if (ids.get(position).ID() != null) {
            String id = ids.get(position).ID().getText();
            if (previous == null && id.equals("System")) {
                id = "java/lang/System";
            } else if (previous == null && id.equals("String")) {
                id = "java/lang/String";
            }
            currentExpression = new InstVar(id, previous, startLine, endLine);
        } else {
            currentExpression = new MethodCall(previous, ids.get(position).method_chain().ID().getText(),
                    MethodCallStatementAdapter.getMethodArguments(ids.get(position).method_chain().argumentList()),
                    ids.get(position).method_chain().getStart().getLine(), ids.get(position).method_chain().getStop().getLine());
        }

        return generatePreviousInstVar(ids, currentExpression, position + 1, startLine, endLine);
    }
}
