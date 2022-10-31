package WhileLoop;

import java.util.Scanner;

public class DoWhileEx2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        int num = 0;
        do {
            sum += num;
            System.out.println("Please enter a positive number: ");
            num = input.nextInt();
        } while (num > 0);
        System.out.println("The sum of the numbers is " + sum);
    }
}
