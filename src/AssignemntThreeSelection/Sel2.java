package AssignemntThreeSelection;

import java.util.Scanner;

public class Sel2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a mark: ");

        int mark = scan.nextInt();
        if (mark >= 50) {
            System.out.println("you passed");
        } else {
            System.out.println("sorry7 you failed");

        }

    }
}
