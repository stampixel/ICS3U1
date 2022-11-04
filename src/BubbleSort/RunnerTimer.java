package BubbleSort;

/**
 * @author kevin.tang
 * 2022.11.04
 */

public class RunnerTimer {
    /**
     * i. Initialize two arrays:
     *      Names of Runners and
     *      Time in minutes with the data given above.
     * ii. Outputs the above acquired data in good format.
     * iii. Find and output the name and time of the person with the shortest time.
     * iv. Find and output the average time taken for the race.
     * v. Sort and display the running times from fastest to slowest.
     * vi. Find and display the names and times of all the runners who ran the race in less than 39 minutes.
     * @param args
     */
    public static void main(String[] args) {
        // Initialize the two arrays
        String[] names = {"Yongbin Li", "Angela Wang", "Marcus Akbari", "Sow Zha", "Gabe-Arun Raitsin"};
        double[] minutes = {42.01, 38.05, 39.00, 37.00, 37.01};

        // Printing out the names in a good format
        System.out.println("Names of runners followed by the time in minutes");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + minutes[i]);
        }

        // Print the fastest person and the average minutes of the racers
        String nameFast = "";
        double fastest = minutes[0];

        double sum = 0;
        for (int i = 0; i < names.length; i++) {
            if (fastest > minutes[i]) {
                fastest = minutes[i];
                nameFast = names[i];
            }
            sum += minutes[i];
        }

        System.out.println("\nThe fastest person is " + nameFast + ", finishing the race in " + fastest + " minutes.\n");
        System.out.println("The average minutes of the whole race is " + sum/names.length + " minutes.");

        // Bubble sorting algo to sort racers from fastest to slowest
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = 0; j < names.length - i - 1; j++) {
                if (minutes[j] > minutes[j+1]) {
                    double temp = minutes[j];
                    minutes[j] = minutes[j+1];
                    minutes[j+1] = temp;
                }
            }
        }
        System.out.println("--------------------------------");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + minutes[i]);
        }
        System.out.println("--------------------------------");

        // Displaying all racers who can finish the race in less that 39 minutes
        System.out.print("List of people who can finish the face in less that 39 minutes: ");
        for (int i = 0; i < names.length; i++) {
            if (minutes[i] < 39) {
                System.out.print(names[i] + ", ");
            }
        }

    }
}
