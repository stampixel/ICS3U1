import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.10.14
 */

public class DieRoll {
    /**
     * Design a program that will allow the user to simulate the rolling of two die.
     * Display the outcome of each die, and the sum of the dice.
     * If they role doubles, they can role again. Otherwise, the sum is their lucky number for today.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to die rolling simulator.");

        // initializing the loop control variables outside the loop
        int die1, die2;
        String again = "";

        do {
            // using 6 as our range and 1 as our starting value to simulate two dice rolls
            die1 = (int) (Math.random() * 6) + 1;
            die2 = (int) (Math.random() * 6) + 1;

            System.out.println("The first die rolled a " + die1 + ". The second die rolled a " + die2 + ".");
            System.out.println("The sum of the dice rolls is " + (die1+die2));

            if (die1 == die2) { // if the user gets a double, asked if they want to roll again
                System.out.print("You get to rolled a double, would you like to role again (y/n): ");
                again = scan.next().substring(0, 1);
            }
        } while (die1 == die2 && again.equals("y")); // loop will only repeat if the dies are a double and user wants to roll again

        System.out.println((die1+die2) + " is your lucky number today!");
        scan.close();
    }
}
