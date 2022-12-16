package IO;

import java.io.PrintWriter;
import java.util.Scanner;

public class Outfile8 {
    /**
     * Ask the user to enter 20 marks.
     * Check if the marks are valid (e.g. if the marks are between 0 and 100 then it is valid).
     * If they are, write the values to a file.
     * Do not use an array to store the values.
     * If the marks are not valid, ask the user to re-enter the mark.
     * Do not write invalid marks to the file.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        PrintWriter write = new PrintWriter("file8.txt");
        Scanner scan = new Scanner(System.in);

        int count = 0;
        System.out.println("Enter 20 marks: ");

        do {
            System.out.print("Enter a mark: ");
            int mark = scan.nextInt();

            if (mark < 0 || mark > 100) {
                System.out.println("Invalid mark!");
                continue;
            }
            write.println(mark);
            count ++;

        } while (count <= 19);
        write.close();
    }
}
