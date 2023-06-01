package mmc.codegen.visitors;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.ReferenceType;
import mmc.ast.Type;
import mmc.ast.main.Parameter;
import org.objectweb.asm.Opcodes;

import java.util.List;

import static mmc.ast.BasicType.*;

public class GeneratorHelpFunctions {

    public static int getAccessModifier(AccessModifier a, boolean isStatic){

        int accessmodifier = 0;

        switch (a){
            case PUBLIC -> accessmodifier = Opcodes.ACC_PUBLIC;
            case PRIVATE -> accessmodifier = Opcodes.ACC_PRIVATE;
            case PROTECTED -> accessmodifier = Opcodes.ACC_PROTECTED;
            default -> throw new IllegalArgumentException();
        };

        if(isStatic){
            return accessmodifier | Opcodes.ACC_STATIC;
        }
        return accessmodifier;

    }

    public static String getDescriptor(List<Type> parameterTypes, Type returnValue){
        if(parameterTypes == null){
            return getType(returnValue).toString();
        }
        StringBuilder descriptor = new StringBuilder();
        descriptor.append("(");
        parameterTypes.forEach(parameter -> descriptor.append(getType(parameter)));
        descriptor.append(")");
        descriptor.append(getType(returnValue));

        return descriptor.toString();
    }

    public static String getType(Type type){
        if(type instanceof BasicType){
            return switch((BasicType) type){
                case VOID -> "V";
                case INT -> "I";
                case CHAR -> "C";
                case BOOL -> "Z";
            };
        }
        else if (type instanceof ReferenceType){
            return ((ReferenceType) type).type;
        }
        else{
            return "";
        }

    }
}
