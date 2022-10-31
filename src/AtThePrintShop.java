import java.util.Scanner; // Importing scanner class
/**
 * @author kevin.tang
 * 2022.09.26
 */

public class AtThePrintShop {
    /**
     * A printing company&#39;s prices are typically based on the number of copies to be printed. For example:
     *
     *      # of prints      price
     *      0 – 99           $0.30 per copy
     *      100-499          $0.28 per copy
     *      500-749          $0.27 per copy
     *      750-1000         $0.26 per copy
     *      over 1000        $0.25 per copy
     *
     * Write a program that prompts the user for the number of copies to print and then displays the price per copy and the total price
     * for the job.
     *
     * The program output should look similar to:
     *
     * Enter the number of copies to be printed: 1001
     * Price per copy is: $0.25
     * Total cost is: $250.25
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user for amount of copies to print
        System.out.println("Enter the number of copies to be printed: ");
        int copies = scan.nextInt();

        // calculating the total cost of all copies based on the amount, then printing it
        if (copies > 1000) {  // Using selection to determine price per copy based on the amount
            System.out.println("Price per copy is: $0.25");
            System.out.println("Total cost is: $" + copies*0.25);
        } else if (copies >= 750) {
            System.out.println("Price per copy is: $0.26");
            System.out.println("Total cost is: $" + copies*0.26);
        } else if (copies >= 500) {
            System.out.println("Price per copy is: $0.27");
            System.out.println("Total cost is: $" + copies*0.27);
        } else if (copies >= 100) {
            System.out.println("Price per copy is: $0.28");
            System.out.println("Total cost is: $" + copies*0.28);
        } else if (copies >= 0) {
            System.out.println("Price per copy is: $0.30");
            System.out.println("Total cost is: $" + copies*0.3);
        } else { // Making sure the input is valid
            System.out.println("Invalid input. Amount of copies can't be negative.");
        }

        scan.close();
    }
}
