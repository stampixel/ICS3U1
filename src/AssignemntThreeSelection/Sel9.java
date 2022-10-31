package AssignemntThreeSelection;

import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.09.19
 */

public class Sel9 {
    /**
     * Modify the previous question so that the program outputs the lower mark instead.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user for two marks
        System.out.println("Enter the first mark: ");
        int mark1 = scan.nextInt();
        System.out.println("Enter the second mark: ");
        int mark2 = scan.nextInt();

        // Checking and printing the lower mark
        if (mark1 < mark2) {
            System.out.println(mark1 + " is lower");
        } else {
            System.out.println(mark2 + " is lower");
        }
    }
}
