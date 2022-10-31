import java.util.Scanner;

/*
@author kevin.tang
2022.10.04
 */
public class Hurricane {
    /*
    Write a program Hurricane.java
    that asks the user for the wind speed (in miles per hour) as an integer
    and prints whether it qualifies as a hurricane, and if so, whether it is a Category 1, 2, 3, 4, or 5 hurricane.
    Below is a table of the wind speeds according to the Saffir-Simpson scale.
            -----
            Category
            Wind Speed (mph)
            -----
            1
            74 - 95
            2
            96 - 110
            3
            111 - 130
            4
            131 - 155
            5
            above 155

       Repeat the above process and collect wind speeds for 10 days.
       At the end of the program, output the average wind speed of the data collected.

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sum = 0; // Stores the sum of wind speed data

        for (int i = 0; i < 10; i++) {
            // Prompt user for the wind speed of that day
            System.out.println("Please input wind speed (MPH): ");
            int windSpeed = scan.nextInt();
            // Using selection to check for the level of the hurricane
            if (windSpeed > 155) {
                System.out.println("Yes, it qualifies as a hurricane. Based on the wind speed, the hurricane is level 5.");
            } else if (windSpeed > 130) {
                System.out.println("Yes, it qualifies as a hurricane. Based on the wind speed, the hurricane is level 4.");
            } else if (windSpeed > 110) {
                System.out.println("Yes, it qualifies as a hurricane. Based on the wind speed, the hurricane is level 3.");
            } else if (windSpeed > 95) {
                System.out.println("Yes, it qualifies as a hurricane. Based on the wind speed, the hurricane is level 2.");
            } else if (windSpeed > 73) {
                System.out.println("Yes, it qualifies as a hurricane. Based on the wind speed, the hurricane is level 1.");
            } else if (windSpeed < 0) {
                System.out.println("Invalid input.");
            } else {
                System.out.println("Doesn't qualify as hurricane.");
            }
            sum += windSpeed; // Adds the wind speed to the total sum
        }
        double averageWindSpeed = sum / 10; // Gets the average wind speed of the 10 days
        System.out.println("The average wind speed of the 10 days is " + averageWindSpeed + " MPH"); // Prints it

        scan.close();
    }
}
