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
        clazz.constructors
                .forEach(constructor -> constructors.add(new ConstructorEnvironment(constructor)));
        clazz.methods.forEach(method -> {
            /*if (method instanceof MainMethodDecl) {
                hasMain = true;
                return;
            }*/
            if (!methods.containsKey(method.name)) {
                methods.put(method.name, new ArrayList<>());
            }
            methods.get(method.name).add(new MethodEnvironment(method));
        });
    }

    public boolean hasMain() {
        return hasMain;
    }

    /**
     * @return HashMap<String, FieldContext>
     */
    public HashMap<String, FieldEnvironment> getFields() {
        return fields;
    }

    /**
     * @return ArrayList<ConstructorContext>
     */
    public ArrayList<ConstructorEnvironment> getConstructors() {
        return constructors;
    }

    /**
     * @return HashMap<String, ArrayList<MethodContext>>
     */
    public HashMap<String, ArrayList<MethodEnvironment>> getMethods() {
        return methods;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Fields:\n");
        fields.forEach((identifier, field) -> {
            builder.append(identifier);
            builder.append(" -> ");
            builder.append(field.toString());
        });
        builder.append("\n----------\n");
        builder.append("Methods:\n");
        methods.forEach((identifier, method) -> {
            builder.append(identifier);
            builder.append(" -> ");
            builder.append(method.toString());
        });
        return builder.toString();
    }
}
