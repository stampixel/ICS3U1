package Tests;

import java.io.File;
import java.util.Scanner;

public class SumOfTwoDice2 {
    /**
     * Part 2:
     * Create another program that will read the sum of two die data from the file and display the count of each sum.
     * We will also identify the mode in the data set.
     * @param args
     */
    public static void main(String[] args) throws Exception {
        File myFile = new File("die.txt");
        Scanner scan = new Scanner(myFile);

        int count = 0;
        while (scan.hasNextLine()) {
            scan.nextLine();
            count++;
        }
        System.out.println("There are " + count + " number of dice rolls.");

        int[] rolls = new int[12];
        scan = new Scanner(myFile);
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(scan.nextLine());
            rolls[num-1] ++;
        }

        for (int i = 0; i < rolls.length; i++) {
            System.out.println("The number of " + (i + 1) + " rolled is: " + rolls[i]);
        }

        int mode = rolls[0];
        for (int i = 1; i < rolls.length-1; i++) {
            if (rolls[i] < rolls[i+1]) {
                mode = i+1;
            }
        }
        System.out.println("The number that occurs the most often is: " + (mode + 1));
    }
}
