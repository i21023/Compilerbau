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
        return switch (a){
            case PUBLIC -> Opcodes.ACC_PUBLIC;
            case PRIVATE -> Opcodes.ACC_PRIVATE;
            case PROTECTED -> Opcodes.ACC_PROTECTED;
            case PUBLIC_STATIC -> 0;
            case PRIVATE_STATIC -> 0;
        };
    }

    public static String getDescriptor(List<Type> parameterTypes, Type returnValue){
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
        else {
            return ((ReferenceType) type).type;
        }

    }
}
