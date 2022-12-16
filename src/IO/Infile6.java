package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Infile6 {
    public static void main(String[] args) throws FileNotFoundException {
        // Read values from file7
        File myFile = new File("file7.txt");
        Scanner scan = new Scanner(myFile);

        // Count the lines in the file to declare the arrya
        int count = 0;
        while (scan.hasNextLine()) {
            count++;
        }
        String[] values = new String[count];

    }
}
