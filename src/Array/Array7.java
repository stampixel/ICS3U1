package Array;

import java.util.Scanner;

public class Array7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num[] = new int [10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Please enter an integether and 0n to exit: ");
            num[i] = scan.nextInt();
            if (num[i] == 0) {
                break;
            }
        }

        for (int number : num) {
            if (number < 0) {
                System.out.print(number + " ");
            }
        }
    }
}
