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

        System.out.println("Enter the 2 endpoints for the first line (x1, y1, x2, y2).");
        double x1 = scan.nextInt();
        double y1 = scan.nextInt();
        double x2 = scan.nextInt();
        double y2 = scan.nextInt();
        double m1 = Slope(x1, y1, x2, y2);

        System.out.println("Enter the 2 endpoints for the second line (x1, x2, y1, y2).");
        x1 = scan.nextInt();
        y1 = scan.nextInt();
        x2 = scan.nextInt();
        y2 = scan.nextInt();
        double m2 = Slope(x1, y1, x2, y2);

        if (m1 == m2) {
            System.out.println("The 2 slopes are parallel.");
        } else {
            System.out.println("The 2 slopes are not parallel.");
        }
    }
    /**
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static double Slope(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);
    }
}
