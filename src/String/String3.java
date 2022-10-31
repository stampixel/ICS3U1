package String;
import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.10.12
 */

public class String3 {
    /**
     * Write a program that asks the user to enter a word and a letter.
     * Your program should count how many times the letter appears in the word.
     * If the letter is not in the word, output a message saying so.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a word: ");
        String word = scan.next();

        System.out.print("Please enter a letter: ");
        char letter = scan.next().charAt(0);

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                count++;

            }
        }
        System.out.println("The letter occurred " + count + " times.");
    }
}
