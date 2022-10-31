package String;
import java.util.Scanner;

public class String8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter a sentence: ");
        String sentence = scan.next();

        System.out.println("The total number of characters in the sentence is " + sentence.length());
        scan.next();

        System.out.println("Enter the starting and ending number: ");
        int range1 = scan.nextInt();
        int range2 = scan.nextInt();
        if (range1 > sentence.length() && range2 > sentence.length()) {
            System.out.println("Please insure that the range entered is lower than the length of the sentence.");
        } else {
            System.out.println(sentence.substring(range1, range2));
        }
    }
}