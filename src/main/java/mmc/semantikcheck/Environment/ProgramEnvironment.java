package mmc.semantikcheck.Environment;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.ReferenceType;
import mmc.ast.expressions.*;
import mmc.ast.expressions.Class;
import mmc.ast.main.*;
import mmc.ast.statements.Block;
import mmc.semantikcheck.Exception;

import java.io.PrintStream;
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

    public ClassEnvironment getClass(LocalOrFieldVar localFieldVar){ //Für static InstVar
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

        //Um String sowie String Methoden wie Concat && Equals zu unterstützen
        //Println unterstützen

        var stringParams = new ArrayList<Parameter>();
        stringParams.add(new Parameter(new ReferenceType("java/lang/String"), "s1"));


        Method concatString = new Method(
                new ReferenceType("java/lang/String"),"concat",stringParams,new Block(),AccessModifier.PUBLIC, false);

        Method equalString = new Method(
                new ReferenceType("java/lang/String"),"equals",stringParams,new Block(),AccessModifier.PUBLIC, false);


        var stringMethods = new ArrayList<Method>();
        stringMethods.add(concatString);
        stringMethods.add(equalString);

        /* MethodCall ( InstVar ("out", Class("java/lang/System", new ReferenceType("java/lang/System"), true) "println)
        * new MethodCall(new InstVar("out"), new LocalOrFieldVar("System"), "println")*/

        ClassDecl SystemClass = new ClassDecl("java/lang/System", new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>());



        ClassDecl StringClass = new ClassDecl("java/lang/String", new ArrayList<>(),
                stringMethods,
                new ArrayList<>());


        Method printlnString = new Method(BasicType.VOID,"println",stringParams,new Block(),AccessModifier.PUBLIC,true);

        var printlnMethods = new ArrayList<Method>();
        printlnMethods.add(printlnString);

        ClassDecl PrintStreamClass = new ClassDecl("java/io/PrintStream",new ArrayList<>(),printlnMethods,new ArrayList<>(),AccessModifier.PUBLIC);
        Class clazz = new Class("java/lang/System", new ReferenceType("java/lang/System"));

        Field out = new Field(AccessModifier.PUBLIC,true,new ReferenceType("java/io/PrintStream"),"out");
        PrintStreamClass.fields.add(out);

        classes.put(SystemClass.name, new ClassEnvironment(SystemClass));
        classes.put(StringClass.name, new ClassEnvironment(StringClass));
        classes.put(PrintStreamClass.name, new ClassEnvironment(PrintStreamClass));
    }
}
