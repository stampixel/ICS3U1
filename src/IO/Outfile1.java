package IO;
import java.io.PrintWriter;

public class Outfile1 {
    public static void main(String[] args) throws Exception {
        PrintWriter write = new PrintWriter("file1.txt");

        write.print("Kevin Tang");

        write.close();
    }
}
