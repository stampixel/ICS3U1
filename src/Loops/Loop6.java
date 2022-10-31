package Loops;

import java.util.Scanner;

public class Loop6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt(); // get the num frmo the user
        int reverseNum = 0;

        for (; num != 0 ; num /= 10) { // We already have num, so no need to redefine it in the loop
            int digit = num % 10; // getting the first digit
            reverseNum = reverseNum * 10 + digit; // 123 = 123 * 10 + 4
                                                    /// 1234
        }
        System.out.println(reverseNum);
    }
}