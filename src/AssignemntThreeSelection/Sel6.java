package AssignemntThreeSelection;

import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.09.19
 */

public class Sel6 {
    /**
     * Ask for a mark (out of 100).  Give the following output:
     * 	75-100	    Great
     * 	50-74		Pass
     * 	0-49		Fail
     * 	Other		Invalid
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user fot a mark
        System.out.println("Enter a mark out of 100: ");
        int mark = scan.nextInt();

        // Determine if they did great, passed, failed, or if the mark was invalid
        if (mark >= 75) {
            System.out.println("Great");
        } else if (mark >= 50) {
            System.out.println("Pass");
        } else if (mark >= 0) {
            System.out.println("Fail");
        } else {
            System.out.println("Invalid!");
        }
    }
}
