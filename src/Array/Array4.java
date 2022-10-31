package Array;

import java.util.Scanner;

public class Array4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = new String[10];

        System.out.print("Please enter 10 numbers: ");
        for (int i = 0; i < words.length; i++) {
            words[i] = scan.next();
        }
        // Printing the numbers in backwards order
        for (int i = words.length-1; i > 0; i--) {
            System.out.println(words[i]);
        }
    }
}
