package IO;

import java.io.PrintWriter;
import java.util.Scanner;

public class Outfile7 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        PrintWriter write = new PrintWriter("file7.txt");

        int[] numbers = new int[15];
        System.out.println("Please enter 15 numbers between 1-20.");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        for (int num : numbers) {
            write.println(num);
        }
        write.close();
    }
}
