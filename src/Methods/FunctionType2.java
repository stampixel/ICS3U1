package Methods;

import java.util.Scanner;

public class FunctionType2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Shirt $25.99");
        System.out.println("Hoodie $36.99");
        System.out.println("Cap $12.99");

        System.out.print("Which item would you like to buy (1-3): ");
        int choice = scan.nextInt();
        double amount = 0;

        if (choice == 1) {
            amount = salesTax(25.99);
        } else if (choice == 2) {
            amount = salesTax(36.99);
        } else if (choice == 3) {
            amount = salesTax(12.99);
        }
        System.out.println("The total price of your purchase + tax was: " + Math.round(amount * 100) / 100.0);
    }
    public static double salesTax(double total) {
        return total + total * 0.13;
    }
}
