package Loops;

import java.util.Scanner;

public class Loop8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please input a positive integer: ");
        int num = scan.nextInt();
        boolean isPrime = true;

        for (int i = 2; i < num/2; i++) {
            if (num % i == 0) {
                System.out.println("It is not a prime.");
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("It is a prime");
        }

    }
}
