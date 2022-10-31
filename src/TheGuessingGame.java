import java.util.Scanner;

public class TheGuessingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int randInt = (int) (Math.random()*(10))+1; // Generating the random number from 1-10
        int guessAmount = 0;
        int guess;

        do { // Checking if the user gets the number correct
            System.out.print("Please guess a number (1-10): ");
            guess = scan.nextInt();
            guessAmount++;

        } while (guess != randInt);
        // Shows the amoount of guesses used if it was right
        System.out.println("The right number was " + randInt + ", it took you just " + guessAmount + " tries to get it right!");
    }
}
