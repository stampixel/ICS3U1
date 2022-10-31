package String;
import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.10.12
 */

public class String4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a word: ");
        String word = scan.next();

        System.out.print("Please enter a letter: ");
        char letter = scan.next().charAt(0);

        int count = 0;
        for (int i = word.length()-1; i > 0; i--) {
            if (word.charAt(i) == letter) {
                count++;
                System.out.println("The location of the last occurrence of the letter is " + (i+1));
                break;
            }
        }
        if (count == 0) {
            System.out.println("Letter was not in the word.");
        }
    }
}
