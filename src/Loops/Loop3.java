package Loops;

import java.util.Scanner;

public class Loop3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        for (int i = 1; i < 13; i ++) {
            System.out.println(i + " * " + num + " = " + i*num);
        }

    }
}
