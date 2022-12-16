package IO;

import java.io.PrintWriter;
import java.util.Scanner;

public class Outfile4 {
    public static void main(String[] args) throws Exception {
        PrintWriter write = new PrintWriter("file4.txt");
        Scanner scan = new Scanner(System.in);

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
