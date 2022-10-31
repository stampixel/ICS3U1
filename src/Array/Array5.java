package Array;

import java.util.Scanner;

public class Array5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstname = new String[10];
        String[] lastname = new String[10];
        int[] mark = new int[10];

        for (int i = 0; i < 9; i++) {
            System.out.print("Please enter a first name: ");
            firstname[i] = scan.next();
            System.out.print("Please enter a last name: ");
            lastname[i] = scan.next();
            System.out.print("Please enter a mark: ");
            mark[i] = scan.nextInt();
        }
        String response = scan.next();

        if (response.equals("pass")) {
            for (int i = 0; i < mark.length-1; i++) {
            }


        } else if (response.equals("fail")) {
            for (int i = 0; i < mark.length-1; i++) {
            }

        }
    }
}
