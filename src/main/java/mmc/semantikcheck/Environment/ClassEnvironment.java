package mmc.semantikcheck.Environment;

import mmc.ast.main.ClassDecl;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassEnvironment {
    public HashMap<String, FieldEnvironment> fields;
    public ArrayList<ConstructorEnvironment> constructors;
    public HashMap<String, ArrayList<MethodEnvironment>> methods;
    public boolean hasMain = false;

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

}
