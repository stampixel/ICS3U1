package Tests;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class SumOfTwoDice {
    /**
     * Part 1:
     *
     * Write a small program that will simulate 1000 rolls of two standard dice and output their sums to screen and to file.
     * This program should be coded so that each time it is run, the new output is appended to the file.
     * @param args
     */
    public static void main(String[] args) throws Exception {
        PrintWriter write = new PrintWriter(new FileWriter("die.txt", true));
        for (int i = 0; i < 1000; i++) {
            int roll = dieRoll() + dieRoll();
            System.out.println(roll);
            write.println(roll);

        }
        write.close();
    }
    public static int dieRoll() {
        int Min = 1;
        int Max = 6;

        return Min + (int)(Math.random() * ((Max - Min) + 1));
    }
}
