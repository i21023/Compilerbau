package mmc.semantikcheck.Environment;

import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.ast.main.Constructor;
import mmc.ast.main.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructorEnvironment {
    public AccessModifier accessModifier;
    public Type type;
    public List<Type> parameterTypes;

    public ConstructorEnvironment(Constructor constructor) {
        this.accessModifier = constructor.accessModifier;
        this.type = constructor.getType();
        this.parameterTypes = constructor.parameters.stream().map(Parameter::getType)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
