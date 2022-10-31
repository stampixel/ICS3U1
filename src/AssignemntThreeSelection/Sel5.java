package AssignemntThreeSelection;

import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.09.19
 */

public class Sel5 {
    /**
     * Ask the user for a secret number.
     * Ask another user (assume that the user cannot see the secret number on the screen) for a number.
     * If the number matches the secret number, say “you got it” otherwise say “guess again”.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Getting number from two different users
        System.out.println("Please input a secret number: ");
        int num = scan.nextInt();
        System.out.println("Please guess a the number: ");
        int guess = scan.nextInt();

        // Checking if the guess matches the secret number
        if (num == guess) {
            System.out.println("you got it");
        } else {
            System.out.println("guess again");
        }


    }
}
