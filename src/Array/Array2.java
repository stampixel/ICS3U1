package Array;

import java.util.Scanner;

public class Array2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = scan.nextInt();
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int i = numbers.length-1; i > -1; i--) {
            System.out.print(numbers[i] + " ");
        }

    }
}
