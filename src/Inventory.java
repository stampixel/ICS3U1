import java.util.Scanner;

/**
 * @author Kevin Tang
 * 2022.10.30
 */
public class Inventory {
    /**
     * An inventory is a complete list of items such as property, goods in stock, or the contents of a building.
     *
     * Design a program that: (KA)
     * a) Asks the user for the number of items to enter in the inventory.
     * b) Then for each item, record the item name, its price,  and quantity.
     *
     * e.g. the user may make up computer parts, prices and quantities.
     * keyboard, $14.99, 3
     *
     * Once all the items are entered, the program should:
     *
     *      Calculate the total value of inventory and display that for the user. (T)
     *      Display all items, unit price and quantities in a well formatted output. (KA)
     * @param args
     */
     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);

         System.out.print("Please enter the amount of items in the inventory: ");

         // Getting amount of items in the inventory and creating arrays for the part, price, and quantity
         int num = scan.nextInt();
         String[] parts = new String[num];
         double[] price = new double[num];
         int[] quantity = new int[num];

         // Storing the part name, price, and quantity into the arrays
         for (int i = 0; i < parts.length; i++) {
             System.out.print("Enter part: ");
             parts[i] = scan.next();
             System.out.print("Enter price for " + parts[i]+ ": ");
             price[i] = scan.nextDouble();
             System.out.print("Enter quantity of " + parts[i]+ ": ");
             quantity[i] = scan.nextInt();
         }

         System.out.println("\nCalculating total value of inventory...\n");

         // Calculating the total value of inventory
         double totalValue = 0;
         for (int i = 0; i < parts.length; i++) {
             totalValue += price[i] * quantity[i];
         }
         System.out.println("The total value of inventory is $" + totalValue);

         // Displaying all the parts, prices, and quantities in a well formatted output
         System.out.println("Part  |  Price  |  Quantity");
         System.out.println("-----------------------");
         for (int i = 0; i < parts.length; i++) {
             System.out.println(parts[i] + "  |  $" + price[i] + "  |  " + quantity[i]);
             System.out.println("-----------------------");
         }

         scan.close();
     }
}
