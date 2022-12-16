package Tests;

import java.io.File;
import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.12.06
 */

public class TaskFileIOpartAKevinTang {
    /**
     * 1. Prompt the user to enter the name of the file to be read (including the extension).
     *
     * 2. Determine how many numbers are in the file (assume one integer on each line)
     *
     * 3. Create an array of the appropriate size to store those values. Assume you do not know how many
     * numbers are in the other data files that your program will run.
     *
     * 4. Read the data from the file and store it in an array.
     *
     * Output all the numbers that are between 5 and 9 (exclusive). Output each number on a
     * separate line.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        // Prompting the user to enter name of file
        System.out.print("Please enter the name of the file to be read (including extension): ");
        String myFile = scan.nextLine();

        // Locating the file path and use scanner to read what's inside
        File file = new File(myFile);
        scan = new Scanner(file);

        // Determining the amount of numbers inside the file
        int count = 0;
        while (scan.hasNextLine()) {
            scan.nextLine();
            count++;
        }

        // Closing and resetting the scanner
        scan.close();
        scan = new Scanner(file);

        int[] numbers = new int[count]; // Creating array based on the amount of numbers that are in the file

        // Storing all numbers from file into the array
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(scan.nextLine());
        }

        // Looping through the number array and find how many numbers are between 5-9 (exclusive)
        for (int i = 0; i < numbers.length; i++) {
            if (5 < numbers[i] && numbers[i] < 9) {
                System.out.println(numbers[i]); // Printing the numbers on seperate lines
            }
        }

        scan.close();
    }
}
