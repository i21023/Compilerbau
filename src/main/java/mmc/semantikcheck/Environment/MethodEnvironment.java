package mmc.semantikcheck.Environment;

import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.ast.main.Method;
import mmc.ast.main.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodEnvironment {
    public AccessModifier accessModifier;
    public Type type;
    public List<Type> parameterTypes;
    public boolean isStatic;

    public MethodEnvironment(Method method) {
        this.accessModifier = method.accessModifier;
        this.type = method.getType();
        this.isStatic = method.isStatic;
        this.parameterTypes = method.parameters.stream().map(Parameter::getType)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
