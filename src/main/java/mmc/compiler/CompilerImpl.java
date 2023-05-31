package mmc.compiler;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.expressions.IntExpr;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statements.Block;
import mmc.ast.statements.LocalVarDecl;
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

                Program program = astGenerator.generateSyntaxTree(CharStreams.fromStream(inputStream));

                program = new Program(new ArrayList<>(Arrays.asList(
                        new ClassDecl("Test",
                                new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT, "i", AccessModifier.PUBLIC, null, false))),
                                new ArrayList<Method>(),
                                new ArrayList<Constructor>(Arrays.asList(
                                        new Constructor(
                                                new Block(
                                                        new ArrayList<>(Arrays.asList(new Assign(new LocalOrFieldVar("i"), new IntExpr(5), null)))),
                                                new ArrayList<>(Arrays.asList(new Parameter(BasicType.CHAR, "param"))),
                                                AccessModifier.PUBLIC)))/*,
                                AccessModifier.PUBLIC*/))));

                SemanticCheck tAst = new SemanticCheck();
                Program tAstProgram = tAst.generateTypedast(program);

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
