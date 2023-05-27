package mmc.semantikcheck.Environment;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.ReferenceType;
import mmc.ast.main.*;
import mmc.ast.statements.Block;

import java.util.ArrayList;
import java.util.HashMap;

public class ProgramEnvironment {
    private HashMap<String, ClassEnvironment> classes;
    private ArrayList<String> mains;
    private HashMap<String, String> imports;

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

    public HashMap<String, String> getImports() {
        return imports;
    }

    public String getMain() {
        if (mains.size() == 1) {
            return mains.get(0);
        }
        return null;
    }



    public HashMap<String, ClassEnvironment> getClasses() {
        return classes;
    }


    public void addStaticContext() {
        ClassDecl SystemClass = new ClassDecl("java/lang/System", new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>());

        Field out = new Field(AccessModifier.PUBLIC_STATIC, new ReferenceType("java/io/PrintStream"),
                "out");
        Field err = new Field(AccessModifier.PUBLIC_STATIC, new ReferenceType("java/io/PrintStream"),
                "err");
        SystemClass.fields.add(out);
        SystemClass.fields.add(err);
        var intParams = new ArrayList<Parameter>();
        intParams.add(new Parameter(BasicType.INT, "i"));
        var boolParams = new ArrayList<Parameter>();
        boolParams.add(new Parameter(BasicType.BOOL, "b"));
        var charParams = new ArrayList<Parameter>();
        charParams.add(new Parameter(BasicType.CHAR, "c"));
        var stringParams = new ArrayList<Parameter>();
        stringParams.add(new Parameter(new ReferenceType("java/lang/String"), "s"));

        Method printlnInt = new Method(AccessModifier.PUBLIC, BasicType.VOID, "println",
                intParams,
                new Block());
        Method printlnBool = new Method(AccessModifier.PUBLIC, BasicType.VOID, "println",
                boolParams, new Block());
        Method printlnChar = new Method(AccessModifier.PUBLIC, BasicType.VOID, "println",
                charParams,
                new Block());
        Method println = new Method(AccessModifier.PUBLIC, BasicType.VOID, "println",
                new ArrayList<>(),
                new Block());

        Method printlnString = new Method(AccessModifier.PUBLIC, BasicType.VOID,
                "println",
                stringParams,
                new Block());
        Method printInt = new Method(AccessModifier.PUBLIC, BasicType.VOID, "print",
                intParams,
                new Block());
        Method printBool = new Method(AccessModifier.PUBLIC, BasicType.VOID, "print",
                boolParams,
                new Block());
        Method printChar = new Method(AccessModifier.PUBLIC, BasicType.VOID, "print",
                charParams,
                new Block());
        Method print = new Method(AccessModifier.PUBLIC, BasicType.VOID, "print",
                new ArrayList<>(),
                new Block());
        Method printString = new Method(AccessModifier.PUBLIC, BasicType.VOID,
                "print",
                stringParams,
                new Block());

        ArrayList streamMethods = new ArrayList<>();
        streamMethods.add(printlnInt);
        streamMethods.add(printlnBool);
        streamMethods.add(printlnChar);
        streamMethods.add(println);
        streamMethods.add(printInt);
        streamMethods.add(printBool);
        streamMethods.add(printChar);
        streamMethods.add(print);
        streamMethods.add(printlnString);
        streamMethods.add(printString);
        ClassDecl PrintStreamClass = new ClassDecl("java/io/PrintStream", new ArrayList<>(),
                new ArrayList<>(),
                streamMethods);

        classes.put(SystemClass.name, new ClassEnvironment(SystemClass));
        classes.put(PrintStreamClass.name, new ClassEnvironment(PrintStreamClass));
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        classes.forEach((identifier, clazz) -> {
            builder.append(identifier);
            builder.append(": \n");
            builder.append(clazz.toString());
            builder.append("\n--------------------\n");
        });
        return builder.toString();
    }
}
