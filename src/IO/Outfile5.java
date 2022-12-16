package IO;

import java.io.PrintWriter;
import java.util.Scanner;

public class Outfile5 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the file name: ");
        scan.next();

        PrintWriter write = new PrintWriter("file5.txt");

        int[] numbers = new int[20];

        System.out.println("Please enter 20 numbers: ");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();
        }

        for (int number : numbers) {
            write.println(number);
        }
        write.close();
    }
}
