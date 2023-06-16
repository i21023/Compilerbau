package mmc.parser.adapter;

import mmc.ast.BasicType;
import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.parser.antlr.MiniJavaParser;

public class TypeAdapter {

    public static Type adapt(MiniJavaParser.TypeContext typeContext) {
        switch (typeContext.getText()) {
            case "int":
                return BasicType.INT;
            case "boolean":
                return BasicType.BOOL;
            case "char":
                return BasicType.CHAR;
            case "String":
                return new ReferenceType("java/lang/String",
                        typeContext.getStart().getLine(), typeContext.getStop().getLine());
            case "System":
                return new ReferenceType("java/lang/System",
                        typeContext.getStart().getLine(), typeContext.getStop().getLine());
            default:
                return new ReferenceType(typeContext.ID().getText(),
                        typeContext.getStart().getLine(), typeContext.getStop().getLine());
        }
    }


}
