package ProcedureMethods;

public class ProcedureType3 {
    public static void main(String[] args) {
        int num = 12;
        String ln = "X";

        printBar(num, ln);
    }
    public static void printBar(int num, String ln) {
        for (int i = 0; i < num; i++) {
            System.out.print(ln);
        }
    }
}
