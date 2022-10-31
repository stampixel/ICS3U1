package Loops;

import java.util.Scanner;

public class Loop9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int num1 = scan.nextInt();
        System.out.println("Enter second number: ");
        int num2 = scan.nextInt();

        int gcf = 1;

        for (int i = 1; i <= num1 && i <= num2; i++)
        {
            if (num1 % i == 0 && num2 % i == 0)
                gcf = i;
        }
        System.out.println("The GCF of " + num1 + " and " + num2 + " is " + gcf);
    }
}
