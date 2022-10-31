package String;

import java.util.Scanner;

public class String6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        for (int i = word.length(); i > -1; i--) {
            System.out.println(word.substring(i));

        }
    }
}
