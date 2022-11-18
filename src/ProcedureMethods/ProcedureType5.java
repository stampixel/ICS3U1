package ProcedureMethods;

public class ProcedureType5 {
    public static void main(String[] args) {
        int num1 = 10; int num2 = 5; int num3 = 0;

        minMax(num1, num2, num3);
    }
    public static void minMax(int num1, int num2, int num3) {
        int min = num1;
        min = Math.min(num1, num2);
        min = Math.min(min, num3);

        int max = num1;
        max = Math.max(num1, num2);
        max = Math.max(max, num3);

        System.out.println("The lowest number is " + min);
        System.out.println("The highest number is " + max);
    }
}
