package mmc.compiler;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.ReferenceType;
import mmc.ast.expressions.*;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.Crement;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.*;
import mmc.codegen.visitors.ProgramCodeGenerator;
import mmc.semantikcheck.SemanticCheck;
import org.antlr.v4.runtime.CharStreams;

import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static mmc.ast.BasicType.BOOL;

public class CompilerImpl implements Compiler {
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
                SyntaxTreeGenerator astGenerator = new SyntaxTreeGeneratorImpl();

                Method method = new Method( BasicType.INT, "foo", new ArrayList<Parameter>(),
                        new Block(new ArrayList<IStatement>(Arrays.asList(
                                new LocalVarDecl("i", BasicType.INT, new IntExpr(0)),
                                new MethodCall(new InstVar("out", new LocalOrFieldVar("System", new ReferenceType("java/lang/String"), true)), "println", new ArrayList<>(Arrays.asList(new StringExpr("Hallo"))), new ReferenceType("java/io/printStream")),
                                new Return( BasicType.INT, new LocalOrFieldVar("i", BasicType.INT))))), AccessModifier.PUBLIC, false);


                ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method)),
                        new ArrayList<Constructor>());


                Program prog = new Program(Arrays.asList(classDecl));



                SemanticCheck tAst = new SemanticCheck();
                //Program tAstProgram = tAst.generateTypedast(program);

                ProgramCodeGenerator programVisitor = new ProgramCodeGenerator();
                HashMap<String, byte[]> code = programVisitor.getBytecode(prog);


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
