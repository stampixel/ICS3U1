import java.util.Scanner;

public class CounterEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        String control = "";
        while (true) {
            System.out.println("Please input a number: ");
            int num = scan.nextInt();
            counter += 1;

            System.out.println("Please answer yes to play again, enter no to terminate program (yes/no): ");
            control = scan.nextLine();

            if (control.equals("no")) {
                break;
            }

        }
        System.out.println("Total amount of numbers entered: " + counter);
    }
}
