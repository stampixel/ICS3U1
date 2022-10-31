import java.util.Scanner; // must import the scanner utility to use it

/**
 * @author kevin.tang
 * 2022.09.17
 */

public class ObjectHeight {
    /**
     * The height of an object at any given time dropped from a starting height of 100 meters is given by the equation h=100–4.9*t^2 where t is the time in seconds.
     * Create an ObjectHeight application that prompts the user for a time less than 4.5 seconds and then displays the height of the object at that time.
     *
     * Make sure to start each line with another step
     *
     * @param args
     */
    public static void main(String[] args) {
        // Prompt the user for time
        System.out.println("Enter the time in seconds (time < 4.5): ");

        Scanner scan = new Scanner(System.in); // construct a scanner
        double time = scan.nextDouble();
        // Calculating the height of the object
        double objectHeight = 100 - 4.9 * time * time;
        // display to the user
        System.out.println("The height of the object at " + time + " is: " + objectHeight);


        scan.close();

    }
}
