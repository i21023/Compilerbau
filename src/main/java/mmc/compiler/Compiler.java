package mmc.compiler;

import mmc.Main;
import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.ReferenceType;
import mmc.ast.expressions.*;
import mmc.ast.expressions.Class;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.Crement;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.*;
import mmc.codegen.visitors.ProgramCodeGenerator;
import mmc.semantikcheck.SemanticCheck;
import org.antlr.v4.runtime.CharStreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Compiler implements ICompiler {
    //ToDo: für Abgabe überflüssige Elemente löschen und einheitlich mit Interfaces arbeiten; Factory einfügen?

    @Override
    public void compile(String fileName, String outDir) {
        // get the filename without the extension
        File file = new File(fileName);

        if (outDir.equals("")) {
            outDir = "compile";
            File outDirectory = new File(outDir);
            if (!outDirectory.exists()) {
                outDirectory.mkdir();
            } else {
                outDirectory.delete();
                outDirectory.mkdir();
            }
        }

        if (file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                ISyntaxTreeGenerator astGenerator = new SyntaxTreeGenerator();

                Program program = astGenerator.generateSyntaxTree(CharStreams.fromStream(inputStream));

                Method method = new MainMethod(new Block(new ArrayList<>(Arrays.asList(
                        new LocalVarDecl("p", new ReferenceType("Bar"), new New(new ArrayList<>(), new ReferenceType("Bar"))),
                        new Assign(new InstVar("i", new Class("Bar", new ReferenceType("Bar")), BasicType.INT, true), new IntExpr(10), BasicType.INT),
                        new MethodCall(
                                new InstVar("out",
                                        new Class("java/lang/System",
                                                new ReferenceType("java/lang/System")),
                                        new ReferenceType("java/io/PrintStream"), true), "println",
                                new ArrayList<>(Arrays.asList(
                                        new InstVar("i", new Class("Bar", new ReferenceType("Bar")), BasicType.INT, true))
                ), BasicType.VOID),
                        new MethodCall(new LocalOrFieldVar("p", new ReferenceType("Bar"), false), "foo", new ArrayList<>(), BasicType.VOID)
                        ))));


                ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                        new ArrayList<Constructor>());

                program = new Program(new ArrayList<>(Arrays.asList(classDecl)));

                SemanticCheck tAst = new SemanticCheck();
                //Program tAstProgram = tAst.generateTypedast(program);

                ProgramCodeGenerator programVisitor = new ProgramCodeGenerator();
                HashMap<String, byte[]> code = programVisitor.getBytecode(program);


                String finalOutDir = outDir;
                code.forEach((x, y) -> {
                    try {
                        FileOutputStream fos = new FileOutputStream(finalOutDir + File.separator + file.getName().replace(".java", ".class"));
                        fos.write(code.get("Test"));
                        fos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                System.out.println(file.getAbsolutePath());
                System.out.println("Bytes written to file successfully.");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
