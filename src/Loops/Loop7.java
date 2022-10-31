package Loops;

import java.util.Scanner;

public class Loop7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 1; i < 6; i++) {
            System.out.println("Please input a number (" + i + "/5): ");
            int num = scan.nextInt();
            if (num % 2 == 0) {
                sumEven += num;
            } else {
                sumOdd += num;
            }
        }
        System.out.println("Even sum: " + sumEven + " | Odd sum: " + sumOdd);
    }
}
