package AssignemntThreeSelection;

import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.09.19
 */

public class Sel10 {
    /**
     * Ask the user for the number of times to print the word Hello
     * (between 1 and 5).  Then print the following on separate lines:
     * If the user entered 1, print Hello once
     * If the user entered 2, print Hello twice
     * If the user entered 3, print Hello three times  …
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user for amount of times to output "Hello"
        System.out.println("Please enter the amount of times to output the word \"Hello\" (1-5): ");
        int amount = scan.nextInt();

        // Printing amount of Hellos based on the user inputs
        if (amount == 1) {
            System.out.println("Hello");
        } else if (amount == 2) {
            System.out.println("Hello");
            System.out.println("Hello");
        } else if (amount == 3) {
            System.out.println("Hello");
            System.out.println("Hello");
            System.out.println("Hello");
        } else if (amount == 4) {
            System.out.println("Hello");
            System.out.println("Hello");
            System.out.println("Hello");
            System.out.println("Hello");
        } else if (amount == 5) {
            System.out.println("Hello");
            System.out.println("Hello");
            System.out.println("Hello");
            System.out.println("Hello");
            System.out.println("Hello");
        }
    }
}
