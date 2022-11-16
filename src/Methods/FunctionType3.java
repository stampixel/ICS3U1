package Methods;

import java.util.Scanner;

public class FunctionType3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your height in centimeters: ");
        int height = scan.nextInt();
        double heightInch = cmToInches(height);

        System.out.println("You are " + heightInch + " inches tall");

        if (heightInch > 48) {
            System.out.println("You are tall enough to go on the ride");
        } else {
            System.out.println("You are not tall enough to go on the ride.");
        }
    }
    public static double cmToInches(int cm) {
        return Math.round(cm * 0.393701 * 100) / 100.0;
    }

}
