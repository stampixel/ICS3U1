import java.util.Scanner;
/*
@author kevin.tang
2022.10.07
 */

public class PizzaOrderingKevin {
    public static void main(String[] args) {
        /*
        Write a complete Java program called “PizzaOrdering<Your name>” using proper programming style for Bayview’s Pizza Ordering Program.
        The organizer of parties needs a program that will help them calculate the total number of pizzas required to feed junior and senior students.
        The program will go through and ask each student to enter their grade and then output the total number of pizzas required for the party.
        A junior student is in grades 9 or 10.
        A senior student is in grades 11 and 12.
        A pizza can feed a maximum of 4 junior students. Similarly the same pizza could feed a maximum of 2 senior students.

        
The program services one student at a time and repeats until the user enters -1 to stop.  For each student, the program will ask them for their grade.  The coordinator will enter a -1 after the last student enters their information.  Input validation is not required (assume the user will enter what is prompted by the program).

At the end (after all the students have used the program to enter their grade and the coordinator enters a -1), the program displays the total number of junior students, the total number of senior students and the total number of pizzas required. You may round up to the next whole pizza.


         */
        Scanner scan = new Scanner(System.in);
        // defining as double so we can do division with decimal points
        double juniorStudent = 0;
        double seniorStudent = 0;
        int grade = 0;
        double pizzaAmount = 0;

        // checking which grade the student is in based
        do {
            if (grade == 9 || grade == 10) { // adding together all junior students
                juniorStudent += 1;
            } else if (grade == 11 || grade == 12) { // adding together all senior students
                seniorStudent += 1;
            }
            System.out.print("Enter the Grade you are in: "); // getting the grade of student
            grade = scan.nextInt();
        } while(grade != -1); // if the grade is -1, we stop the loop
        pizzaAmount = juniorStudent/4 + seniorStudent/2;

        if (pizzaAmount % 1 != 0) { // doing math in order to calculate the amount of pizzas needed
            pizzaAmount += 1 - pizzaAmount % 1;
        }
        System.out.println("The total amount of pizza required is " + pizzaAmount);
        scan.close();
    }
}
