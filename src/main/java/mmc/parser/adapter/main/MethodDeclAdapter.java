package mmc.parser.adapter.main;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Type;
import mmc.ast.main.MainMethod;
import mmc.ast.main.Method;
import mmc.ast.main.Parameter;
import mmc.ast.statements.Block;
import mmc.parser.adapter.TypeAdapter;
import mmc.parser.adapter.statements.StatementBlockAdapter;
import mmc.parser.antlr.MiniJavaParser;

import java.util.ArrayList;
import java.util.List;

public class MethodDeclAdapter {
    public static Method adapt(MiniJavaParser.Method_declContext methodDeclContext) {
        if (methodDeclContext.main_method_decl() != null) {
            Block block = StatementBlockAdapter.adapt(methodDeclContext.main_method_decl().block());
            if (methodDeclContext.main_method_decl().string_args() != null) {
                return new MainMethod(block, methodDeclContext.getStart().getLine(), methodDeclContext.getStop().getLine());
            } else {
                List<Parameter> parameterList = new ArrayList<>();

                if (methodDeclContext.parameter_list() != null) {
                    if (methodDeclContext.parameter_list().COMMA() != null && methodDeclContext.parameter_list().COMMA().size() > 0) {
                        for (int i = 0; i <= methodDeclContext.parameter_list().COMMA().size(); i++) {
                            Parameter parameter = new Parameter(TypeAdapter.adapt(methodDeclContext.parameter_list().type(i)),
                                    methodDeclContext.parameter_list().ID(i).getText(),
                                    methodDeclContext.parameter_list().getStart().getLine(), methodDeclContext.parameter_list().getStop().getLine());
                            parameterList.add(parameter);
                        }
                    } else {
                        Parameter parameter = new Parameter(TypeAdapter.adapt(methodDeclContext.parameter_list().type(0)),
                                methodDeclContext.parameter_list().ID(0).getText(),
                                methodDeclContext.parameter_list().getStart().getLine(), methodDeclContext.parameter_list().getStop().getLine());
                        parameterList.add(parameter);
                    }
                }

                return new Method(BasicType.VOID, "main", parameterList, block, AccessModifier.PUBLIC, true,
                        methodDeclContext.getStart().getLine(), methodDeclContext.getStop().getLine());
            }
        } else {
            AccessModifier accessModifier = AccessModifier.DEFAULT;
            if (methodDeclContext.access_mod() != null) {
                switch (methodDeclContext.access_mod().getText()) {
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
                        break;
                }
            }

            boolean staticFlag = false;
            if (methodDeclContext.STATIC() != null) {
                staticFlag = true;
            }

            Type type = MethodTypeAdapter.adapt(methodDeclContext.method_type());

            String name = methodDeclContext.ID().getText();

            List<Parameter> parameterList = new ArrayList<>();

            if (methodDeclContext.parameter_list() != null) {
                if (methodDeclContext.parameter_list().COMMA() != null && methodDeclContext.parameter_list().COMMA().size() > 0) {
                    for (int i = 0; i <= methodDeclContext.parameter_list().COMMA().size(); i++) {
                        Parameter parameter = new Parameter(TypeAdapter.adapt(methodDeclContext.parameter_list().type(i)),
                                methodDeclContext.parameter_list().ID(i).getText(),
                                methodDeclContext.parameter_list().getStart().getLine(), methodDeclContext.parameter_list().getStop().getLine());
                        parameterList.add(parameter);
                    }
                } else {
                    Parameter parameter = new Parameter(TypeAdapter.adapt(methodDeclContext.parameter_list().type(0)),
                            methodDeclContext.parameter_list().ID(0).getText(),
                            methodDeclContext.parameter_list().getStart().getLine(), methodDeclContext.parameter_list().getStop().getLine());
                    parameterList.add(parameter);
                }
            }

            Block block = StatementBlockAdapter.adapt(methodDeclContext.block());

            return new Method(type, name, parameterList, block, accessModifier, staticFlag,
                    methodDeclContext.getStart().getLine(), methodDeclContext.getStop().getLine());
        }
    }
}
