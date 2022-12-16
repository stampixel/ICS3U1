package IO;
import java.io.PrintWriter; // Step 1: import

public class write {
    /**
     * Create a small file with some text in it.
     * @param args
     * @throws Exception
     */
    // Step 2: add throws exception to our mai header
    public static void main(String[] args) throws Exception {
        // Step 3: create the PrintWriter Object
        PrintWriter write = new PrintWriter("myFile.txt");

        // Step 4: write to the file
        write.println("Hello file world!!!");

        // Step 5: save your results
        write.close();

    }
}
