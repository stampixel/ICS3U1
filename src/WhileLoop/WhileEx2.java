package WhileLoop;

import java.util.Scanner;

public class WhileEx2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = "";
        while (!name.equals("END")) {
            System.out.println(name);
            System.out.println("Please enter name: ");
            name = scan.nextLine();
        }
        System.out.println("I am done.");
    }
}
