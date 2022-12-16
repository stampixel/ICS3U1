package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class append {
    /**
     * Write a Program that will append the names of world cup qualified teams to a file called "qatar2022.txt".
     * Run it several times to append more countries to the world cup file.
     * @param args
     */
    public static void main(String[] args) throws IOException {
        PrintWriter write = new PrintWriter(new FileWriter("qatar2022.txt", true));

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the world cup country you want to add to the file: ");
        String country = scan.next() + " ";

        write.println(country);
        write.close();
    }
}
