package mmc.semantikcheck.Environment;

import mmc.ast.main.ClassDecl;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassEnvironment {
    private HashMap<String, FieldEnvironment> fields;
    private ArrayList<ConstructorEnvironment> constructors;
    private HashMap<String, ArrayList<MethodEnvironment>> methods;
    private boolean hasMain = false;

    public ClassEnvironment(ClassDecl clazz) {
        fields = new HashMap<>();
        constructors = new ArrayList<>();
        methods = new HashMap<>();

        clazz.fields.forEach(field -> fields.put(field.name, new FieldEnvironment(field)));
        clazz.constructors.forEach(constructor -> constructors.add(new ConstructorEnvironment(constructor)));
        clazz.methods.forEach(method -> {
            if (!methods.containsKey(method.name)) {
                methods.put(method.name, new ArrayList<>());
            }
            methods.get(method.name).add(new MethodEnvironment(method));
        });
    }

    public boolean hasMain() {
        return hasMain;
    }
    public HashMap<String, FieldEnvironment> getFields() {
        return fields;
    }

    public ArrayList<ConstructorEnvironment> getConstructors() {
        return constructors;
    }
    public HashMap<String, ArrayList<MethodEnvironment>> getMethods() {
        return methods;
    }

}
