import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.11.03
 */

public class MarkProgramFormative {
    /**
     * Design a program that:
     *      asks for 5 student names and their marks(out of 100). (K)
     *
     * Once all the students are entered, the program should:
     *      Without using a bubble sort, list the student with the highest mark. (T, A)
     *      Determine and display the average mark of all students.	(T, A)
     *      Now Bubble sort the students and their marks and then print out a report in ascending order by name. (A,C)
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Creating copies of the array object to store the marks and names
        int[] marks = new int[5];
        String[] names = new String[5];

        System.out.println("Please enter the student name, followed by their mark (5 times): ");
        for (int i = 0; i < names.length; i++) {
            names[i] = scan.next();
            marks[i] = scan.nextInt();
        }

        // Getting the student with the highest mark and printing it
        int max = marks[0];
        String nameMax = "";
        for (int i = 0; i < names.length; i++) {
            if (marks[i] > max) {
                max = marks[i];
                nameMax = names[i];
            }
        }
        System.out.println("The student with the highest mark is: " + nameMax);

        // Calculating average and printing it
        int sum = 0;
        for (int i = 0; i < names.length; i++) {
            sum += marks[i];
        }
        System.out.println("The average marks for all students is: " + sum / marks.length);


        // Using Bubble Sorting algorithm in order to sort the marks
        for (int i = 0; i < marks.length - 1; i++) { // THINKING, using -1 because we only need n-1 swaps
            /**
             * // Minus "i" because the n-i elements are already sorted
             * -1 as once we reach the last element, we won't get an out of bound error
             */
            for (int j = 0; j < marks.length - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Sorting the marks
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;

                    // Sorting the names based on the marks
                    String nameTemp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = nameTemp;
                }
            }
        }

        // For loop to print everything in ascending order
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " has a mark of " + marks[i] + "/100.");
        }
    }
}
