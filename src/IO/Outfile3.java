package IO;

import java.io.PrintWriter;

public class Outfile3 {
    public static void main(String[] args) throws Exception {
        PrintWriter write = new PrintWriter("file3.txt");
        for (int i = 1; i < 11; i++) {
            write.print(i + " ");
        }
        write.close();
    }
}
