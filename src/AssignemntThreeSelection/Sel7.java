package AssignemntThreeSelection;

import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.09.19
 */

public class Sel7 {
    /**
     * Ask the user for a password.
     * If a password is correct, output “you are logged in” if not, then output “incorrect password”
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user for the password
        System.out.println("Please enter a password: ");
        String userGuess = scan.nextLine();

        // Checking to see if the password is correct
        if (userGuess.equals("happy")) {
            System.out.println("you are logged in");
        } else {
            System.out.println("incorrect password");
        }
    }
}
