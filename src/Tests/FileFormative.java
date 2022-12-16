package Tests;

import java.io.PrintWriter;
import java.util.Scanner;

public class FileFormative {
    public static void main(String[] args) throws Exception {
        PrintWriter write = new PrintWriter("formative.txt");
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter 5 words.");

        for (int i = 0; i <5; i++) {
            System.out.print("Please enter a word: ");
            write.println(scan.nextLine());
        }

        write.close();
    }
}
