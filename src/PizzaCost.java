import java.util.Scanner; // must import the scanner utility to use it

/**
 * @author kevin.tang
 * 2022.09.16
 */

public class PizzaCost {
    /**
     * The cost of making a pizza is as follows:
     * Labour is $7.50 regardless of size
     * Rent costs $2.00 per pizza, regardless of size
     * Materials are $0.025 * diameter * diameter (in inches)
     * Create a PizzaCost application that prompts the user for the size of pizza in inches and then displays the cost of making the pizza.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Prompt the user for size of pizza in inches
        System.out.println("Enter the size of pizza (inches): ");
        /**
         * In Java we will need to create a scanner object
         * Then use the scanner to capture the value.
         */
        Scanner scan = new Scanner(System.in); //construct a scanner
        int diameter = scan.nextInt();


        // calculate the cost
        final double LABOUR = 7.50;
        final double RENT = 2.00;
        double materials = 0.025 * diameter * diameter;

        double pizzaCost = LABOUR + RENT + materials;

        // display to the user
        System.out.println("The cost of the pizza is: " + pizzaCost);

        scan.close();

    }
}
