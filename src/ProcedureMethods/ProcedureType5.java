package ProcedureMethods;

public class ProcedureType5 {
    public static void main(String[] args) {
        int num1 = 10; int num2 = 5; int num3 = 0;

        minMax(num1, num2, num3);
    }
    public static void minMax(int num1, int num2, int num3) {
        if (num1 < num2 && num1 < num3) {
            System.out.println("The lowest number is " + num1);
        } else if (num2 < num1 && num2 < num3) {
            System.out.println("The lowest number is " + num2);
        } else if (num3 < num1 && num3 < num2) {
            System.out.println("The lowest number is " + num3);
        }

        if (num1 > num2 && num1 > num3) {
            System.out.println("The highest number is " + num1);
        } else if (num2 > num1 && num2 > num3) {
            System.out.println("The highest number is " + num2);
        } else if (num3 > num1 && num3 > num2) {
            System.out.println("The highest number is " + num3);
        }
    }
}
