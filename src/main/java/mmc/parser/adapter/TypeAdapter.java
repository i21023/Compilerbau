package mmc.parser.adapter;

import mmc.ast.BasicType;
import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.ast.main.Constructor;
import mmc.parser.antlr.MiniJavaParser;

import java.awt.image.BandedSampleModel;

public class TypeAdapter {

    public static Type adapt(MiniJavaParser.TypeContext typeContext) {
        switch(typeContext.getText()) {
            case "int":
                return BasicType.INT;
            case "boolean":
                return BasicType.BOOL;
            case "char":
                return BasicType.CHAR;
            default:
                return new ReferenceType(typeContext.ID().getText());
        }
    }


}
