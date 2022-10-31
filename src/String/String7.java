package String;

import java.util.Scanner;

public class String7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = scan.next();
        System.out.print("Enter a letter: ");
        String letter = scan.next();

        int index = word.indexOf(letter);
        System.out.println("The index of that letter is " + index);

        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i+1).equals(letter)) {
                System.out.print(i + " ");
            }
        }
    }
}
