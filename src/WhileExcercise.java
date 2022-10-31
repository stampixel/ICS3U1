import java.util.Scanner;

public class WhileExcercise {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = 0; // we choose a value hat will allow the loop to begin
        // this is also our loop control variable (lcv)
        while (num < 10) {
            System.out.println("Enter a number higher than 10.");
            num = scan.nextInt(); // This is where our LCV is updated
        }
        scan.close();
    }

    public static void ex2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = 1; // we choose a value hat will allow the loop to begin
        // this is also our loop control variable (lcv)
        while ((num >= 1) && (num <= 10)) {
            System.out.println("Enter a number between 1 and 10.");
            System.out.println("INCLUSIVE!");
            num = scan.nextInt();
        }
    }
}
