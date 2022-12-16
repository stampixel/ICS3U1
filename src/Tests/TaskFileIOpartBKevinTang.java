package Tests;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.12.06
 */

public class TaskFileIOpartBKevinTang {
    /**
     * 1. Prompt the user to enter their first name and last name, store it in appropriate memory
     * locations.
     *
     * 2. Write a method called createUserName that will take in the first name and the last name as
     * parameters and return a user name made from these two names. The user name will be
     * constructed by taking the lowercase first letter of the first name and adding it on to a maximum
     * of the first 7 letters of the last name in upper case.
     *
     * 3. Now generate a random four digit pin number for the user name. The PIN should be comprised
     * of the digits 0 to 9 (inclusive).
     *
     * 3. Output the user name and pin to the console. Also, write/save the user name and
     * corresponding PIN to an append-able file: called Credentials<your name>.txt.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        PrintWriter write = new PrintWriter(new FileWriter("CredentialsKevinTang.txt", true)); // Creating credentials file and making it appendable


        // Prompting user to enter first and last name
        System.out.print("Enter your firstname: ");
        String firstname = scan.next();

        System.out.print("Enter your lastname: ");
        String lastname = scan.next();

        // Generating the 4 digit pin
        String pin = "";
        for (int i = 0; i < 4; i++) { // Looping 4 times, as it is 4 digit pin
            pin += (int) (Math.random() * 9) + 1; // Generate a random number between 0-9 inclusive, then adding it to the pin
        }

        // Using method to get username, then outputting username & pin
        String username = createUserName(firstname, lastname);
        System.out.println("Your username is: " + username);
        System.out.println("Your pin is: " + pin);

        // Writing username and pin to file
        write.println(username);
        write.println(pin);

        write.close(); // Close writer in order to save what we appended
    }

    /**
     * This method takes in the first and last name as parameters and return a username.
     * The username will be constructed by taking the lowercase first letter of the firstname
     * and adding it on to a maximum of the first 7 letters of the last name in upper case.
     *
     * @param first
     * @param last
     * @return
     */
    public static String createUserName(String first, String last) {
        String username = "";
        int lastNameLoop;


        // Convert entirety of firstname to lowercase, and lastname to uppercase
        first = first.toLowerCase();
        last = last.toUpperCase();

        username += first.charAt(0); // Adding first letter of firstname to the username


        // lastNameLoop can either be the length of the lastname (if it is lower than seven), or 7 (if it is longer than seven)
        // Tells the program how many times to loop
        lastNameLoop = Math.min(last.length(), 7); // Getting the lower one

        for (int i = 0; i < lastNameLoop; i++) {
            username += last.charAt(i); // Adding each of the uppercase lastname letters to username
        }
        return username;
    }
}
