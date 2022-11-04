package BubbleSort;

import java.util.Scanner;

public class BSort5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String abc = "abcdefghijklmnopqrstuvwxyz";
        String[] array = new String[5];

        System.out.println("Please enter 5 names: ");
        for (int i = 0; i< array.length; i++) {
            array[i] = scan.nextLine();
        }

        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - i - 1; j ++) {
                if (abc.indexOf(array[j].charAt(0)) > abc.indexOf(array[j+1].charAt(0)) ) {
                    String temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for (String i : array) {
            System.out.print(i + " ");
        }
    }
}
