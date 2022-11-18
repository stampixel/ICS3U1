package ProcedureMethods;

public class ProcedureType7 {
    public static void main(String[] args) {
        int height = 5;
        drawTriangle(height);
    }
    public static void drawTriangle(int height) {
        for (int i = 1; i < height + 1; i++) {
            for (int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
