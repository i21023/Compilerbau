package mmc.parser.adapter.main;

import mmc.ast.BasicType;
import mmc.ast.Type;
import mmc.parser.adapter.TypeAdapter;
import mmc.parser.antlr.MiniJavaParser;

public class MethodTypeAdapter {

    public static Type adapt(MiniJavaParser.Method_typeContext method_typeContext) {

        if (method_typeContext.VOID() != null) {
            return BasicType.VOID;
        } else return TypeAdapter.adapt(method_typeContext.type());
    }
}
