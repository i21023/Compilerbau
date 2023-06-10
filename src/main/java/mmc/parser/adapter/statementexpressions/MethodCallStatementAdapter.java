package mmc.parser.adapter.statementexpressions;

import mmc.ast.expressions.IExpression;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.expressions.This;
import mmc.ast.statementexpression.MethodCall;
import mmc.parser.adapter.expressions.InstVarAdapter;
import mmc.parser.adapter.expressions.ExpressionAdapter;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class MethodCallStatementAdapter {
    public static MethodCall adapt(MiniJavaParser.Method_call_statementContext methodCallStatement) {

        IExpression methodOwnerPrefix = new This();
        if (methodCallStatement.method_owner_prefix() != null) { // explicit receiver
            if (methodCallStatement.method_owner_prefix().THIS() != null) {
                methodOwnerPrefix = new This();
            } else if (methodCallStatement.method_owner_prefix().inst_var() != null) {
                methodOwnerPrefix = InstVarAdapter.adapt(methodCallStatement.method_owner_prefix().inst_var());
            } else if (methodCallStatement.method_owner_prefix().new_statement() != null) {
                methodOwnerPrefix = NewStatementAdapter.adapt(methodCallStatement.method_owner_prefix().new_statement());
            } else {
                methodOwnerPrefix = new LocalOrFieldVar(methodCallStatement.method_owner_prefix().ID().getText());
            }
        }

        if (methodCallStatement.method_chain() != null && methodCallStatement.method_chain().size() > 0) {
            methodOwnerPrefix = generatePreviousMethodCall(methodCallStatement.method_chain(),
                    methodCallStatement.method_chain().size() - 1, methodOwnerPrefix);
        }

        return new MethodCall(
                methodOwnerPrefix,
                methodCallStatement.ID().getText(),
                getMethodArguments(methodCallStatement.argumentList())
        );
    }

    private static MethodCall generatePreviousMethodCall(List<MiniJavaParser.Method_chainContext> methodChain,
                                                         int position, IExpression methodOwnerPrefix) {

        if (position > 0) {
            return new MethodCall(generatePreviousMethodCall(methodChain, position - 1, methodOwnerPrefix),
                    methodChain.get(position).ID().getText(),
                    getMethodArguments(methodChain.get(position).argumentList()));
        } else {
            return new MethodCall(methodOwnerPrefix,
                    methodChain.get(0).ID().getText(),
                    getMethodArguments(methodChain.get(0).argumentList()));
        }
    }

    private static List<IExpression> getMethodArguments(MiniJavaParser.ArgumentListContext argumentList) {
        List<IExpression> arguments = new ArrayList<>();
        if (argumentList != null) {
            if (argumentList.COMMA().size() > 0) {
                for (int i = 0; i < argumentList.COMMA().size(); i++) {
                    arguments.add(ExpressionAdapter.adapt(argumentList.expr(i)));
                }
            } else {
                arguments.add(ExpressionAdapter.adapt(argumentList.expr(0)));
            }
        }
        return arguments;
    }
}
