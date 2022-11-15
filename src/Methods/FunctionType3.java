package Methods;

import java.util.Scanner;

public class FunctionType3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your height in centimeters: ");
        int height = scan.nextInt();
        double heightInch = cmToInches(height);



    }
    public static double cmToInches(int cm) {
        return Math.round(cm * 0.393701 * 100) / 100.0;
    }

}
