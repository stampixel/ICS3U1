package Methods;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double f, c;
        System.out.print("Enter the degrees F: ");
        f = scan.nextDouble();
        c = convertFtoC(f);

        System.out.print("Degrees C: ");
        System.out.println(c);
    }
    public static double convertFtoC(double fahrenheit) {
        double celsius;
        celsius = (fahrenheit - 32)*5/9;
        return celsius;
    }
}
