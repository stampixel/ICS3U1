package Loops;

import java.util.Scanner;

public class Loop5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOne = scan.nextInt();
        int numTwo = scan.nextInt();

        int total = 1;
        for (int i = 1; i < numTwo; i++) {
            total *= numOne;
        }
        System.out.println(total);
    }
}
