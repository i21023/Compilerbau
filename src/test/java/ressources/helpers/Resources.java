package ressources.helpers;


import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.*;

//import common.Compiler;
//import syntaxtree.structure.Program;

public class Resources {

    /**
     * @param fileName
     * @return Program
     */
    //public static Program getProgram(String fileName) {
       // return Compiler.getFactory().getAstAdapter().getAst(getFileAsStream(fileName));
    //}

    /**
     * @param fileName
     * @return InputStream
     */
    public static InputStream getFileAsStream(String fileName) throws FileNotFoundException {
    InputStream inStr = new FileInputStream("C:\\Users\\Micha\\Documents\\GitHub\\MachMalCompiler\\Compilerbau\\src\\test\\java\\ressources\\Testcases\\"+fileName);
        ClassLoader classLoader = Resources.class.getClassLoader();
          File file = new File(classLoader.getResource(fileName).getFile());
        assertNotNull(file);
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail();
        }

        throw new IllegalStateException();
    }

    public static CharStream getFileInput(String filePath) throws IOException {
        CharStream input = CharStreams.fromFileName(filePath);
        return  input;
    }
}