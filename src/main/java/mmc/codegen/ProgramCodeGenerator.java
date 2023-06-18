package mmc.codegen;

import mmc.ast.main.Program;
import mmc.codegen.ClassCodeGenerator;
import mmc.codegen.visitors.IProgramCodeVisitor;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramCodeGenerator implements IProgramCodeVisitor {

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
        final List<String> classNames = program.classes.stream().map(x -> x.name).collect(Collectors.toList());

        program.classes.forEach(c -> {
            ClassCodeGenerator classGenerator = new ClassCodeGenerator(classNames);
            c.accept(classGenerator);
            classes.put(c.name, classGenerator.getBytecode());
        });
    }
}
