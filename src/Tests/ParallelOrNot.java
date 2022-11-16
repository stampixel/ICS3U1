package Tests;
/**
 * @author kevin.tang
 * 2022.11.15
 */

import java.util.Scanner;

public class ParallelOrNot {
    /**
     * Write a program that would prompt the user to input the coordinates of the endpoints of 2 different line segments.
     * Your program should determine if the two line segments are parallel or not.
     * (Hint:  line segments that are parallel have equal slopes. Use a method to determine the slopes of the line segments).
     * You must write and use a method called Slope with the appropriate parameters.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the 2 endpoints for the first line.");
        int slope1x1 = scan.nextInt();
        int slope1y1 = scan.nextInt();
        int slope1x2 = scan.nextInt();
        int slope1y2 = scan.nextInt();
        System.out.println("Enter the 2 endpoints for the second line.");
        int slope2x1 = scan.nextInt();
        int slope2y1 = scan.nextInt();
        int slope2x2 = scan.nextInt();
        int slope2y2 = scan.nextInt();

        if (Slope(slope1x1, slope1y1, slope1x2, slope1y2, slope2x1, slope2y1, slope2x2, slope2y2)) {
            System.out.println("The 2 slopes are parallel.");
        } else {
            System.out.println("The 2 slopes are not parallel.");
        }



    }

    /**
     * Method that returns a boolean.
     * return true if the slopes are parallel, return false if it is not
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param sx1
     * @param sx2
     * @param sy1
     * @param sy2
     * @return
     */
    public static boolean Slope(int x1, int y1, int x2, int y2, int sx1, int sx2, int sy1, int sy2) {
        return (y2 - y1) / (x2 - x1) == (sy2 - sy1) / (sx2 - sx1);
    }
}
