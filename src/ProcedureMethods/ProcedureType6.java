package ProcedureMethods;

public class ProcedureType6 {
    public static void main(String[] args) {
        int stick1 = 3;
        int stick2 = 4;
        int stick3 = 5;

        triangle(stick1, stick2, stick3);
    }
    public static void triangle(int side1, int side2, int side3) {
        boolean possible = false;

        if (side1 > side2 && side1 > side3) {
            if ((side2 + side3) > side1) {
                possible = true;
            }
        } else if (side2 > side1 && side2 > side3) {
            if ((side1 + side3) > side2) {
                possible = true;
            }
        } else if (side3 > side1 && side3 > side2) {
            if ((side1 + side2) > side3) {
                possible = true;
            }
        }
        if (possible) {
            System.out.println("The triangle can be formed by the 3 given sticks.");
        } else {
            System.out.println("The triangle can't be formed by the 3 sticks.");
        }
    }
}
