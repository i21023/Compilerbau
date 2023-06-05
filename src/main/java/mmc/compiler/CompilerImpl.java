package mmc.compiler;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.expressions.IntExpr;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.Crement;
import mmc.ast.statements.Block;
import mmc.ast.statements.LocalVarDecl;
import mmc.ast.statements.Return;
import mmc.codegen.visitors.ProgramCodeGenerator;
import mmc.semantikcheck.SemanticCheck;
import org.antlr.v4.runtime.CharStreams;

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

                //Program program = astGenerator.generateSyntaxTree(CharStreams.fromStream(inputStream));

                Program program = new Program(new ArrayList<>(Arrays.asList(
                        new ClassDecl("Test",
                                new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT,  "i" , AccessModifier.PUBLIC, new IntExpr(5), true))),
                                new ArrayList<Method>(Arrays.asList(new Method(BasicType.INT, "foo", new ArrayList(), new Block (
                                        new ArrayList<>(Arrays.asList(new LocalVarDecl("j", BasicType.INT, new IntExpr(0)),
                                                new Return( BasicType.INT, new Crement(BasicType.INT,
                                                        new LocalOrFieldVar("i", BasicType.INT, true), Operator.INCPRE))))),
                                        AccessModifier.PUBLIC, false))),
                                new ArrayList<Constructor>()
                                ))));

                //SemanticCheck tAst = new SemanticCheck();
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
