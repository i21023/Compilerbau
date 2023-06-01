package mmc.semantikcheck.Environment;

import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.ast.main.Constructor;
import mmc.ast.main.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructorEnvironment {
    private AccessModifier accessModifier;
    private Type type;
    private List<Type> parameterTypes;

    public ConstructorEnvironment(Constructor constructor) {
        this.accessModifier = constructor.accessModifier;
        this.type = constructor.getType();
        this.parameterTypes = constructor.parameters.stream().map(Parameter::getType)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public Type getType() {
        return type;
    }

    public List<Type> getParameterTypes() {
        return parameterTypes;
    }

}
