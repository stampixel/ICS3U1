package Tests;

/**
 * @author kevin.tang
 * 2022.11.07
 */

public class PayrollInfoKevin {
    /**
     *
     *      Employee         Salary($)
     *      Jessie           57,501.00
     *      Andy             114,506.79
     *      Amy              166,772.72
     *      Dan              28,305.00
     *      Jerry            137,477.62
     *
     * 1. Initialize two arrays: Names of employees and annual salary with the data given above.
     * 2. Find and display (output) the name and the corresponding salary.
     * 3. Sort and display (output) the names and corresponding salary in descending order.
     * 4. Find and display (output) the names of the employees that earn more than $100,000.00. Output the corresponding salary next to the employee’s name.
     * @param args
     */
    public static void main(String[] args) {
        // Initializing the two arrays using the data that was given
        String[] employees = {"Jessie", "Andy", "Amy", "Dan", "Jerry"};
        double[] salary = {57501.00, 114506.79, 166772.72, 28305.00, 137477.62};

        // Displaying the employee and their salary
        System.out.println("These are the employees followed by their annual salaries.");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i] + ": $" + salary[i]);
        }
        System.out.println("---------------------------------------");


        // Sorting employees in descending order based on their corresponding salary
        for (int i  = 0; i < employees.length - 1; i++) { // -1 as that is the amount of passes we need
             for (int j = 0; j < employees.length - i - 1; j++) { // -i because the last i elements are already sorted, -1 to account for out of bounds error
                 if (salary[j] < salary[j+1]) {
                     // Switching the position of the employee's name
                     String tempEmployee = employees[j];
                     employees[j] = employees[j+1];
                     employees[j+1] = tempEmployee;

                     // Switching the position of the salary
                     double tempSalary = salary[j];
                     salary[j] = salary[+1];
                     salary[j+1] = tempSalary;
                 }
            }
        }

        // Displaying the sorted employees and their corresponding salary
        System.out.println("Here are the salaries of the employees sorted in descending order");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i] + ": " + salary[i]);
        }
        System.out.println("---------------------------------------");

        // Displaying all employees that have a salary which is above $100 000
        System.out.println("These are the employees who earn above $100 000 and their corresponding salary.");
        for (int i = 0; i < employees.length; i++) {
            if (salary[i] > 100000) {
                System.out.println(employees[i] + ": " + salary[i]);
            }
        }
    }
}
