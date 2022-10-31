package Array;

import java.util.Scanner;

/**
 * @author bourrasque
 * 2022.10.17
 */
public class Array3 {
    /**
     * Ask the user for ten integers.
     * Then ask for a “limit” (e.g. Greater than 50).
     * Print all the integers which are equal to or greater than the limit.
     * @param args
     */
    public static void main(String[] args) {
        int[] numbers = new int[10];
        int limit = 0;

        // Ask the user for ten integers.
        System.out.print("Please enter 10 integers: ");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();
        }
        // Then ask for a 'limit'
        System.out.println("Please enter a limit value: ");
        limit = scan.nextInt();

        // Print all the integers greater or equal to the liit
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > limit) {
                System.out.print(i + " ");
            }
        }

    }
}
