package AssignemntThreeSelection;

import java.util.Scanner;

public class Sel3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a number: ");
        int num = scan.nextInt();

        if (num == 66) {
            System.out.println("you got it");
        } else {
            System.out.println("guess againS");
        }

    }
}
