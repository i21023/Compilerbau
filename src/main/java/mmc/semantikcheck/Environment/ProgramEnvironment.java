package mmc.semantikcheck.Environment;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.ReferenceType;
import mmc.ast.expressions.*;
import mmc.ast.expressions.Class;
import mmc.ast.main.*;
import mmc.ast.statements.Block;
import mmc.semantikcheck.Exception;
import mmc.semantikcheck.SemanticCheck;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ProgramEnvironment {
    public HashMap<String, ClassEnvironment> classes;
    public ArrayList<String> mains;

    public ProgramEnvironment(Program program) {
        classes = new HashMap<>();
        mains = new ArrayList<>();

        addStaticContext();

        program.classes.forEach(clazz -> {

            if (classes.containsKey(clazz.name)) {
                SemanticCheck.errors.add(new Exception("Error: Duplicate classes found: " + clazz.name));
            }

            ClassEnvironment cc = new ClassEnvironment(clazz);
            classes.put(clazz.name, cc);
            if (cc.hasMain) {
                mains.add(clazz.name);
            }
        });
    }

    public ClassEnvironment getClass(LocalOrFieldVar localFieldVar){ //Für static InstVar
        var classes = getClasses().get(localFieldVar.name);
        if(classes == null){
            throw new Exception("Error in line " + localFieldVar.startLine + ": the variable " + localFieldVar.name + " is not defined");
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

        Constructor stringConstructor = new Constructor(new Block(), new ArrayList<>(List.of(new Parameter(new ReferenceType("java/lang/String"), "s1"))), AccessModifier.PUBLIC);

        Method concatString = new Method(
                new ReferenceType("java/lang/String"),"concat",stringParams,new Block(),AccessModifier.PUBLIC, false);

        Method charAt = new Method(
                BasicType.CHAR,"charAt",new ArrayList<>(List.of(new Parameter(BasicType.INT, "s1"))),new Block(),AccessModifier.PUBLIC, false);

        Method length = new Method(
                BasicType.INT,"length", new ArrayList<>(),new Block(),AccessModifier.PUBLIC, false);

        Method isEmpty = new Method(
                BasicType.BOOL,"isEmpty", new ArrayList<>(),new Block(),AccessModifier.PUBLIC, false);

        Method indexOfChar = new Method(
                BasicType.INT,"indexOf", new ArrayList<>(List.of(new Parameter(BasicType.CHAR, "s1"))),new Block(),AccessModifier.PUBLIC, false);

        Method indexOfString = new Method(
                BasicType.INT,"indexOf", new ArrayList<>(List.of(new Parameter(new ReferenceType("java/lang/String"), "s1"))),new Block(),AccessModifier.PUBLIC, false);


        var stringMethods = new ArrayList<Method>();
        stringMethods.add(concatString);
        stringMethods.add(charAt);
        stringMethods.add(length);
        stringMethods.add(isEmpty);
        stringMethods.add(indexOfChar);
        stringMethods.add(indexOfString);

        ClassDecl SystemClass = new ClassDecl("java/lang/System", new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>());

        ClassDecl StringClass = new ClassDecl("java/lang/String", new ArrayList<>(),
                stringMethods,
                new ArrayList<>(Arrays.asList(
                        stringConstructor
                )));

        //println
        Method printlnString = new Method(BasicType.VOID,"println",stringParams,new Block(),AccessModifier.PUBLIC,false);
        Method printlnInt = new Method(BasicType.VOID,"println",new ArrayList<>(List.of(new Parameter(BasicType.INT, "s1"))),new Block(),AccessModifier.PUBLIC,false);
        Method printlnChar = new Method(BasicType.VOID,"println",new ArrayList<>(List.of(new Parameter(BasicType.CHAR, "s1"))),new Block(),AccessModifier.PUBLIC,false);
        Method printlnBool = new Method(BasicType.VOID,"println",new ArrayList<>(List.of(new Parameter(BasicType.BOOL, "s1"))),new Block(),AccessModifier.PUBLIC,false);

        //print
        Method printString = new Method(BasicType.VOID,"print",stringParams,new Block(),AccessModifier.PUBLIC,false);
        Method printInt = new Method(BasicType.VOID,"print",new ArrayList<>(List.of(new Parameter(BasicType.INT, "s1"))),new Block(),AccessModifier.PUBLIC,false);
        Method printChar = new Method(BasicType.VOID,"print",new ArrayList<>(List.of(new Parameter(BasicType.CHAR, "s1"))),new Block(),AccessModifier.PUBLIC,false);
        Method printBool = new Method(BasicType.VOID,"print",new ArrayList<>(List.of(new Parameter(BasicType.BOOL, "s1"))),new Block(),AccessModifier.PUBLIC,false);


        var printlnMethods = new ArrayList<Method>();
        printlnMethods.add(printlnString);
        printlnMethods.add(printlnInt);
        printlnMethods.add(printlnChar);
        printlnMethods.add(printlnBool);

        printlnMethods.add(printString);
        printlnMethods.add(printInt);
        printlnMethods.add(printChar);
        printlnMethods.add(printBool);

        ClassDecl PrintStreamClass = new ClassDecl("java/io/PrintStream",new ArrayList<>(),printlnMethods,new ArrayList<>(),AccessModifier.PUBLIC);

        Field out = new Field(AccessModifier.PUBLIC,true,new ReferenceType("java/io/PrintStream"),"out");
        SystemClass.fields.add(out);

        classes.put(SystemClass.name, new ClassEnvironment(SystemClass));
        classes.put(StringClass.name, new ClassEnvironment(StringClass));
        classes.put(PrintStreamClass.name, new ClassEnvironment(PrintStreamClass));
    }
}
