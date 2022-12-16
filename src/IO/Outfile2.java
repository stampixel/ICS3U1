package IO;

import java.io.PrintWriter;

public class Outfile2 {
    public static void main(String[] args) throws Exception {
        PrintWriter write = new PrintWriter("file2.txt");
        for (int i = 1; i < 11; i++) {
            write.println(i);
        }
        write.close();
    }
}
