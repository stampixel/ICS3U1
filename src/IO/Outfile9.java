package IO;

import java.io.PrintWriter;
import java.util.Scanner;

public class Outfile9 {
    public static void main(String[] args) throws Exception {
        PrintWriter write = new PrintWriter("file8.txt");
        Scanner scan = new Scanner(System.in);

        int[] marks = new int[20];
        int count = 0;
        System.out.println("Enter 20 marks: ");

        do {
            System.out.print("Enter a mark: ");
            int mark = scan.nextInt();

            if (mark < 0 || mark > 100) {
                System.out.println("Invalid mark!");
                continue;
            }
            marks[count] = mark;
            count ++;

        } while (count <= 19);

        int max = marks[0];
        for (int mark : marks) {
            if (mark > max)
                max = mark;
        }

        write.println(max);

        write.close();
    }
}
