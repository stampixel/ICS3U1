package String;

import java.util.Scanner;

public class String5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        for (int i = 1; i < word.length()+1; i++) {
            System.out.println(word.substring(0, i));

        }
    }
}
