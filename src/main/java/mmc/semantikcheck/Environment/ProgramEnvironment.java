package mmc.semantikcheck.Environment;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.ReferenceType;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.main.*;
import mmc.ast.statements.Block;
import mmc.semantikcheck.Exception;

import java.util.ArrayList;
import java.util.HashMap;

public class ProgramEnvironment {
    private HashMap<String, ClassEnvironment> classes;
    private ArrayList<String> mains;

    public ProgramEnvironment(Program program) {
        classes = new HashMap<>();
        mains = new ArrayList<>();

        addStaticContext();

        program.classes.forEach(clazz -> {
            ClassEnvironment cc = new ClassEnvironment(clazz);
            classes.put(clazz.name, cc);
            if (cc.hasMain()) {
                mains.add(clazz.name);
            }
        });
    }

    public ClassEnvironment getClass(LocalOrFieldVar localFieldVar){
        var classes = getClasses().get(localFieldVar.name);
        if(classes == null){
            throw new Exception("");
        }
        return classes;
    }


    public HashMap<String, ClassEnvironment> getClasses() {
        return classes;
    }


    public void addStaticContext() {

        Field out = new Field(AccessModifier.PUBLIC,true, new ReferenceType("java/io/PrintStream"),
                "out");
        Field err = new Field(AccessModifier.PUBLIC, true , new ReferenceType("java/io/PrintStream"),
                "err");

        var stringParams = new ArrayList<Parameter>();
        stringParams.add(new Parameter(new ReferenceType("java/lang/String"), "s1"));

        Method concatString = new Method(
                new ReferenceType("java/lang/String"),"concat",stringParams,new Block(),AccessModifier.PUBLIC, false);

        var stringMethods = new ArrayList<Method>();
        stringMethods.add(concatString);

        ClassDecl SystemClass = new ClassDecl("java/lang/System", new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>());

        ClassDecl StringClass = new ClassDecl("java/lang/String", new ArrayList<>(),
                stringMethods,
                new ArrayList<>());

        SystemClass.fields.add(out);
        SystemClass.fields.add(err);

        classes.put(SystemClass.name, new ClassEnvironment(SystemClass));
        classes.put(StringClass.name, new ClassEnvironment(StringClass));
    }
}
