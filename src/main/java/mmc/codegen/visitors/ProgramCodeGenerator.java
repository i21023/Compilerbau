package mmc.codegen.visitors;

import mmc.ast.main.Program;

import java.util.HashMap;

public class ProgramCodeGenerator implements IProgramCodeVisitor{

    private final HashMap<String, byte[]> classes;

    public ProgramCodeGenerator(){
        classes = new HashMap<>();
    }

    public HashMap<String, byte[]> getBytecode (Program program){
        program.accept(this);
        return classes;
    }

    @Override
    public void visit(Program program) {
        program.classes.forEach(c -> {
            ClassCodeGenerator classGenerator = new ClassCodeGenerator();
            c.accept(classGenerator);
            classes.put(c.name, classGenerator.getBytecode());
        });
    }
}
