package A;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {

    public static void main(String[] args) throws IOException {
        String dir = "src/A/";
        for (int i = 1; i <= 2; i++) {
            var stdin = System.in;
            var stdout = System.out;
            String tempFile = dir + "tmp.txt";
            String inFile = dir + "in" + i + ".txt";
            String outFile = dir + "out" + i + ".txt";
            try {
                System.setIn(new FileInputStream(inFile));
                System.setOut(new PrintStream(tempFile));
                Main.main(args);
            } finally {
                System.setIn(stdin);
                System.setOut(stdout);
            }
            if (isEqualFiles(tempFile, outFile)) {
                System.out.println(inFile + " OK");
            }
            else {
                System.out.println(inFile + " FAIL");
            }

        }
    }
    public static boolean isEqualFiles(String f1, String f2) throws IOException {
        String content1 = Files.readString(Path.of(f1));
        String content2 = Files.readString(Path.of(f2));
        return content1.equals(content2);
    }
}
