package ProcedureMethods;

public class ProcedureType1 {
    public static void main(String[] args) {
        double length, width;
        length = 5; width = 10;
        printArea(length, width);
    }
    private static void printArea(double length, double width) {
        double area = length * width;
        area = Math.round(area);
        System.out.println("The area the rectangle is: " + area + " square units.");
    }
}
