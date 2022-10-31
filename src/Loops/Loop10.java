package Loops;

import java.util.Scanner;

public class Loop10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String repeat = "yes";

        do {
            System.out.println("Please enter 2 numbers: ");
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            int sum = num1 + num2;
            System.out.println("The sum of the 2 numbers is: " + sum);

            System.out.println("Do you want to go again? (yes/no)");
            scan.nextLine();
            repeat = scan.nextLine();

        } while (repeat.equals("yes"));
    }
}
