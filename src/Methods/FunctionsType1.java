package Methods;

import java.util.Scanner;

public class FunctionsType1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter a number that I will square it: ");
        int num = scan.nextInt();

        int square = squaredValues(num);
    }
    public static int squaredValues(int base) {
        return base * base;
    }
}
