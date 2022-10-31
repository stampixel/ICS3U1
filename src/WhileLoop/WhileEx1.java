package WhileLoop;

import java.util.Scanner;

public class WhileEx1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        int sum = 0;
        while (num >= 0) {
            sum += num;
            System.out.println("Enter a number: ");
            num = scan.nextInt();
        }
        System.out.println("The total sum of all entered numbers is " + sum);
    }
}
