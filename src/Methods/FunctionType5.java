package Methods;

import java.util.Scanner;

public class FunctionType5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter 3 numbers.");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        int sum = findSum(squaredValues(num1), squaredValues(num2), squaredValues(num3));

        System.out.println("The sum of the squares of the three numbers is: " + sum);
    }
    public static int findSum(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }
    public static int squaredValues(int num) {
        return num*num;
    }
}
