package IO;

import java.io.PrintWriter;
import java.util.Scanner;

public class Outfile6 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Please enter a number: ");
            nums[i] = scan.nextInt();

            PrintWriter write = new PrintWriter("file6.txt");

            for (int num : nums) {
                if (num > 50) {
                    write.println(num);
                }
            }
            write.close();
        }
    }
}
