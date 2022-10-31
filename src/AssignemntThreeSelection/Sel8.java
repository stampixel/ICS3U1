package AssignemntThreeSelection;

import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.09.19
 */

public class Sel8 {
    /**
     * Ask the user for two marks between 0 and 100.
     * Output the higher mark.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user for two marks
        System.out.println("Enter the first mark: ");
        int mark1 = scan.nextInt();
        System.out.println("Enter the second mark: ");
        int mark2 = scan.nextInt();

        // Checking and printing the higher mark
        if (mark1 > mark2) {
            System.out.println(mark1 + " is higher");
        } else {
            System.out.println(mark2 + " is higher");
        }
    }
}
