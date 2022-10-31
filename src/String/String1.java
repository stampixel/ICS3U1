package String;
import java.util.Scanner;

public class String1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter a word: ");
        String word = scan.next();

        System.out.println("The length of the word is: " + word.length());
    }
}
