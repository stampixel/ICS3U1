package Tests;

public class IndexOfThree {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,23,8,9,3};

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 3) {
                System.out.print("index: " + i);
                break;
            }
        }
    }
}
