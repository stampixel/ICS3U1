package ProcedureMethods;

public class ProcedureType2 {
    public static void main(String[] args) {
        double principal = 1000.00;
        double interestRate = 0.05;
        double timeYears = 5.0;
        interestBalance(principal, interestRate, timeYears);
    }

    private static void interestBalance(double principal, double interest, double time) {
        double costBorrowing = principal * interest * time;
        double finalBalance = principal + principal * interest * time;
        finalBalance = Math.round(finalBalance * 100) / 100.0;

        System.out.println("The cost of borrowing $" + principal + " for " + time + " years is: $" + costBorrowing);
        System.out.println("Your balance after " + time + " years is $" + finalBalance);
    }
}
