import java.util.Scanner; // Importing scanner class
/**
 * @author kevin.tang
 * 2022.09.20
 */

public class AverageCalculator {
    /**
     * 1) Prompts the user to enter their name and age and outputs the following:
     * <entered name> Welcome to Bayview. You are <entered age> years old.
     * 2) Ask the user to enter their Math, English, and Science mark that they got last year.
     * 3) Also output the average of the three marks they entered
     *
     * @param args
     */
    public static void main(String[] args) { // Only argorithm needs to be commented **, remmeber to close the algorithm
        // Creating new scanner using scanner class
        Scanner scan = new Scanner(System.in);
        // Prompt the user for name, then age. Then welcomes the user and prints the name and age.
        System.out.println("Enter your name: ");
        String name = scan.nextLine();
        System.out.println("Enter your age: ");
        int age = scan.nextInt();

        System.out.println(name + " Welcome to Bayview. You are " + age + " years old.");

        // Getting the Math, English, and Science mark from last year from the user
        System.out.println("Enter your Math mark from last year: ");
        int mathMark = scan.nextInt();
        System.out.println("Enter your English mark from last year: ");
        int englishMark = scan.nextInt();
        System.out.println("Enter your Science mark from last year: ");
        int scienceMark = scan.nextInt();

        // Calculating average of the 3 marks, then displaying it
        double averageMark = (mathMark + englishMark + scienceMark);
        averageMark = averageMark / 3;
        System.out.println("Your average mark for the three subjects is " + averageMark);
    }
}
