package AssignemntThreeSelection;
import java.util.Scanner;

public class Sel1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a number between 1 and 10: ");
        int num = scan.nextInt();

        if (num >= 5) {
            System.out.println("You Won!");
        }
    }
}
