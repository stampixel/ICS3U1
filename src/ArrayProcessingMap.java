import java.util.Scanner;

public class ArrayProcessingMap {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        final int SIZE = 5;
        int numbers[] = new int[SIZE];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("numbers[] is: " + numbers[i]);
        }


        // Prompt for 5 numbers
        // Store those numbers in an array
        System.out.println("You will be entering " + SIZE + " numbers:");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();
            System.out.println("SIZE is: " + SIZE);
        }
    }
}
