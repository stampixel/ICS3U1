package ProcedureMethods;

public class ProcedureType4 {
    public static void main(String[] args) {
        int height = 3;
        int width = 8;

        printRectangle(height, width);
    }
    public static void printRectangle(int height, int width) {
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
        }
    }
}
