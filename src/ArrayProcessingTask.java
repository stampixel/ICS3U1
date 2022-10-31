import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.10.25
 */

public class ArrayProcessingTask {
    /**
     * Write an algorithm, flow chart, program and memory map that prompts the user to enter LENGTH number of numbers to an array called list[] and do the following:
     * Calculates the average of the elements stored in the list and outputs the average to the screen.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompting user for length of the list
        int[] list;
        System.out.print("Enter the length of the list: ");
        int length = scan.nextInt();
        list = new int[length];

        // Prompting user for numbers to fill the list
        // Getting the sum of all the numbers
        int sum = 0;
        for (int i = 0; i < length; i++) {
            System.out.print("Enter a number: ");
            list[i] = scan.nextInt();
            sum += list[i];
        }

        double average = sum/length; // Calculating average
        System.out.print("The average of all the numbers in the list is: " + average);
    }
}
