import java.util.Scanner;
/**
 * @author kevin.tang
 * 2022.09.22
 */
public class HeightCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your height (cm): ");

        int height = scan.nextInt();
        if (height < 120) {
            System.out.println("You are short.");
        } else if (height > 180) {
            System.out.println("You are tall.");
        } else {
            System.out.println("You are average.");
        }
    }
}
