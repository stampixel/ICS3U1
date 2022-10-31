package WhileLoop;

import java.util.Scanner;

public class WhileEx3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        int sum = 0;
        int amount = -1;

        while (num >= 0) {
            sum += num;
            amount ++;
            System.out.println("Enter a number: ");
//            amount ++;
            num = scan.nextInt();
        }
        System.out.println("The average of all numbers that are entered is: " + sum/amount);
    }
}
