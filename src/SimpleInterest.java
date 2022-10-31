import java.util.Scanner;

/**
 * @author bourrasque
 * 2022.09.17
 */
public class SimpleInterest {
    /**
     * Write a simpleInterest program that will ask the user for a principal in $CAD, a period of time in years, and an annual interest rate.
     * The program will then calculate the total balance at the end of the period.
     *
     * SI = P × R × T,
     * @param args
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); // construct a scanner
        // Prompt the user for principal amount
        System.out.println("Enter principal in $CAD: ");
        double principal = scan.nextDouble();
        // Prompt the user for amount of years
        System.out.println(("Enter the period of time in years: "));
        int years = scan.nextInt();
        // Prompt the user for interest rate in %
        System.out.println("Annual interest rate in %: ");
        double interestRate = scan.nextDouble()/100;

        // Calculating the total balance at the end of the period
        double totalBalance = principal + principal * years * interestRate;

        // Display to the user
        System.out.println("The total balance at the end of the period is: $" + totalBalance);
    }
}
