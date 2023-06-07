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

                Program program = astGenerator.generateSyntaxTree(CharStreams.fromStream(inputStream));

/*                Method method = new Method( BasicType.INT, "foo", new ArrayList<Parameter>(),
                        new Block(new ArrayList<IStatement>(Arrays.asList(
                                new LocalVarDecl("i", BasicType.INT),
                                new Assign(new LocalOrFieldVar("i", BasicType.INT), new IntExpr(0), BasicType.INT),
                                new If(new Crement( BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.INCSUF ), new Crement( BasicType.INT, new LocalOrFieldVar("i", BasicType.INT), Operator.DECSUF ),
                                        new Binary(Operator.AND,
                                                new Unary(Operator.NOT, new BoolExpr(false)),
                                                new Binary(Operator.EQUAL, new Assign(new LocalOrFieldVar("i"), new IntExpr(10), BasicType.INT) ,new IntExpr(10))
                                        )),

                                new Return( BasicType.INT, new LocalOrFieldVar("i", BasicType.INT))))), AccessModifier.PUBLIC, false);

                Method method2 = new Method( new ReferenceType("java/lang/String"), "bar", new ArrayList<Parameter>(),
                        new Block(new ArrayList<IStatement>(Arrays.asList(
                                new LocalVarDecl("i", BasicType.INT, new IntExpr(0)),
                                new Return( new ReferenceType("java/lang/String"), new MethodCall(new New(new ArrayList<>(Arrays.asList(new StringExpr("Hallooo"))), new ReferenceType("java/lang/String")), "substring", new ArrayList<>(Arrays.asList(new LocalOrFieldVar("i", BasicType.INT), new IntExpr(3))), new ReferenceType("java/lang/String")))))), AccessModifier.PUBLIC, false);

                ClassDecl classDecl = new ClassDecl("Test", new ArrayList<Field>(), new ArrayList<Method>(Arrays.asList(method, method2)),
                        new ArrayList<Constructor>());


                Program prog = new Program(Arrays.asList(classDecl));*/



                SemanticCheck tAst = new SemanticCheck();
                Program tAstProgram = tAst.generateTypedast(program);

                ProgramCodeGenerator programVisitor = new ProgramCodeGenerator();
                HashMap<String, byte[]> code = programVisitor.getBytecode(tAstProgram);


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
