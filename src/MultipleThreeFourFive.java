public class MultipleThreeFourFive {
    public static void main(String[] args) {
        for (int i = 1; i < 500; i++) {
            if (i % 3 == 0 || i % 4 == 0 || i % 5 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
