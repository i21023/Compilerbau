package mmc.parser.adapter.main;

import mmc.ast.AccessModifier;
import mmc.ast.main.Constructor;
import mmc.ast.main.Parameter;
import mmc.ast.statements.Block;
import mmc.parser.adapter.TypeAdapter;
import mmc.parser.adapter.statements.StatementBlockAdapter;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class ConstDeclAdapter {

    public static Constructor adapt(MiniJavaParser.Const_declContext constuctorDeclContext) {

        AccessModifier accessModifier = AccessModifier.PUBLIC;
        if (constuctorDeclContext.ACCES_MOD() != null) {
            switch (constuctorDeclContext.ACCES_MOD().getText()) {
                case "public":
                    accessModifier = AccessModifier.PUBLIC;
                    break;
                case "private":
                    accessModifier = AccessModifier.PRIVATE;
                    break;
                case "protected":
                    accessModifier = AccessModifier.PROTECTED;
                    break;
                default:
                    accessModifier = AccessModifier.PUBLIC;
                    break;
            }
        }

        List<Parameter> parameterList = new ArrayList<>();

        if (constuctorDeclContext.parameter_list() != null) {
            if (constuctorDeclContext.parameter_list().COMMA() != null && constuctorDeclContext.parameter_list().COMMA().size() > 0) {
                for (int i = 0; i < constuctorDeclContext.parameter_list().COMMA().size(); i++) {
                    Parameter parameter = new Parameter(TypeAdapter.adapt(constuctorDeclContext.parameter_list().type(i)),
                            constuctorDeclContext.parameter_list().ID(i).getText());
                    parameterList.add(parameter);
                }
            } else {
                Parameter parameter = new Parameter(TypeAdapter.adapt(constuctorDeclContext.parameter_list().type(0)),
                        constuctorDeclContext.parameter_list().ID(0).getText());
                parameterList.add(parameter);
            }
        }

        Block block = StatementBlockAdapter.adapt(constuctorDeclContext.statement_block());

        return new Constructor(block,parameterList, accessModifier);
    }
}
