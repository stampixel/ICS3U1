package Tests;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FileFormative2 {
    public static void main(String[] args) throws Exception {
        File file = new File("formative.txt");
        Scanner scan = new Scanner(file);
        String[] words;

        int count = 0;
        while (scan.hasNextLine()) {
            scan.nextLine();
            count ++;
        }

        words = new String[count];

        scan = new Scanner(file);

        for (int i = 0; i < count; i++) {
            words[i] = scan.nextLine();
        }

        int eCount = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <words[i].length(); j++) {
                if (words[i].charAt(j) == 'e') {
                    eCount++;
                }
            }
        }
        System.out.println(eCount);

        Arrays.sort(words);

        PrintWriter write = new PrintWriter("formativeB.txt");
        for (int i = 0; i < words.length; i++) {
            write.println(words[i]);
        }

        write.close();
    }
}
