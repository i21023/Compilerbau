package ressources.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class Classwriter {
    public static void WriteClassFile(String fileName, String outDir, HashMap<String, byte[]> pCode) {
        HashMap<String, byte[]> code = pCode;
        String finalOutDir = outDir;
        code.forEach((x, y) -> {
            try {
                FileOutputStream fos = new FileOutputStream(finalOutDir + File.separator + fileName + ".class");
                fos.write(code.get(fileName));
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(outDir);
        System.out.println("Bytes written to file successfully.");
    }
}
