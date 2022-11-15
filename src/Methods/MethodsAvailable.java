package Methods;

/**
 * @author kevin.tang
 * 2022.11.11
 */
public class MethodsAvailable {
    /**
     * Part A: List of available functions
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * Write a return type (function type) method called findSum that takes in three integers
     * and returns the sum of the 3 values.
     * @param num1
     * @param num2
     * @param num3
     * @return
     */
    public static int findSum(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    /**
     * Write a return type (function type) method called findDifference that takes in two
     * decimal numbers and returns the difference.
     * @param num1
     * @param num2
     * @return
     */
    public static double findDifference(double num1, double num2) {
        return num1 - num2;
    }

    /**
     * Write a return type (function type) method called squaredValues that accepts an integer.
     * The method finds the square of that value and then returns it.
     * @param num
     * @return
     */
    public static int squaredValues(int num) {
        return num*num;
    }

    /**
     * Write a return type (function type) method called cmToInches, which accepts a double
     * value for centimetres, and converts it to inches (a double value) and returns that value
     * to the main program. (2.54 cm = 1 inch).
     * @param cm
     * @return
     */
    public static double cmToInches(int cm) {
        return Math.round(cm * 0.393701 * 100) / 100.0;
    }

    /**
     * Write a return type (function type) method called poundToKg that accepts a double value
     * for pounds, and converts it to kilograms and returns that value to the main program. (2.2
     * lbs = 1 Kg).
     * @param pound
     * @return
     */
    public static double poundToKg(double pound) {
        return pound/2.2;
    }

    /**
     * Write a return type (function type) method called kmToMiles that accepts a double value
     * for kilometres, and converts it to miles and returns that value to the main program.
     * @param kilometer
     * @return
     */
    public static double kmToMiles(double kilometer) {
        return Math.round(kilometer * 0.621371 * 100) / 100.0;
    }

    /**
     * Write a return type (function type) method that is called salesTax. It takes in the total of
     * a purchase. The method calculates the sales tax (13% in Ontario) and returns the total
     * purchase value including the sales tax.
     * @param total
     * @return
     */
    public static double salesTax(double total) {
        return total + total * 0.13;
    }
}
