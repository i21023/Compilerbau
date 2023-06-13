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

                //Program program = astGenerator.generateSyntaxTree(CharStreams.fromStream(inputStream));

                //SemanticCheck tAst = new SemanticCheck();
                //Program tAstProgram = tAst.generateTypedast(program);


                Method method = new Method(BasicType.BOOL, "foo", new ArrayList<Parameter>(),
                        new Block(new ArrayList<IStatement>(Arrays.asList(
                                new If(new Return(BasicType.BOOL, new BoolExpr(true)), new Return(BasicType.BOOL, new BoolExpr(false)),
                                        new Binary(Operator.NOTEQUAL, new JNull(), new StringExpr("Hallo")))
                        ))), AccessModifier.PUBLIC, false);

                ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(Arrays.asList(
                        new Field(new ReferenceType("java/lang/String"), "a", AccessModifier.PUBLIC, new New(new ArrayList<>(Arrays.asList(new StringExpr("Wel"))), new ReferenceType("java/lang/String")), true)
                )), new ArrayList<Method>(Arrays.asList(method)),
                        new ArrayList<Constructor>());

                Program program = new Program(new ArrayList<>(Arrays.asList(classDecl)));


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
