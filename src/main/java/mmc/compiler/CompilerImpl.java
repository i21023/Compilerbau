package mmc.compiler;

import mmc.ast.main.Program;
import mmc.codegen.visitors.ProgramCodeGenerator;
import org.antlr.v4.runtime.CharStreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class CompilerImpl implements Compiler {
    @Override
    public void compile(String fileName, String outDir) {
        // get the filename without the extension
        File file = new File(fileName);

        if (file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                SyntaxTreeGenerator astGenerator = new SyntaxTreeGeneratorImpl();

                Program program = astGenerator.generateSyntaxTree(CharStreams.fromStream(inputStream));

                ProgramCodeGenerator programVisitor = new ProgramCodeGenerator();
                HashMap<String, byte[]> code = programVisitor.getBytecode(program);

                code.forEach((x,y) -> {
                    try {
                        FileOutputStream fos = new FileOutputStream(outDir + x + ".class");
                        fos.write(code.get("Test"));
                        fos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                System.out.println("Bytes written to file successfully.");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
