package WhileLoop;

import java.util.Scanner;

public class DoWhileEx1 {
    public static void main(String[] args) {
        int total = 0, value;
        Scanner input = new Scanner( System.in );

        do {
            System.out.println("Enter values to sum and 0 to quit");
            value = input.nextInt();
            total = total + value;
        } while( value != 0 ) ;

        System.out.println( "Your total is:" + total );

}
}
