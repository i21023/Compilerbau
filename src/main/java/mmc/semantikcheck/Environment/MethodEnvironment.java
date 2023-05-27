package mmc.semantikcheck.Environment;

import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.ast.main.Method;
import mmc.ast.main.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodEnvironment {
    private AccessModifier accessModifier;
    private Type type;
    private List<Type> parameterTypes;

    public MethodEnvironment(Method method) {
        this.accessModifier = method.accessModifier;
        this.type = method.getType();
        this.parameterTypes = method.parameters.stream().map(Parameter::getType)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * @return AccessModifier
     */
    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    /**
     * @return Type
     */
    public Type getType() {
        return type;
    }

    /**
     * @return PrintableVector<Type>
     */
    public List<Type> getParameterTypes() {
        return parameterTypes;
    }


}
