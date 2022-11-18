package ProcedureMethods;

import java.util.Scanner;

public class ProcedureType8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the length of the bar: ");
        int len  = scan.nextInt();

        System.out.print("Enter the letter of your choice: ");
        String letter = scan.next();

        System.out.print("Enter the number of lines/bars: ");
        int lines = scan.nextInt();

        printBar(lines, len, letter);
    }
    public static void printBar(int height, int width, String letter) {
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(letter);
            }
        }
    }
}
