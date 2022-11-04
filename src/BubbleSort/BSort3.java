package BubbleSort;

public class BSort3 {
    public static void main(String[] args) {
        int[] array = {2, 123, 125, 5, 12, 9, 4, 1};

        int comparisons = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - i - 1; j ++) {
                comparisons += 1;
                if (array[j] < array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("The program made " + comparisons + ", the length of the array was " + array.length);
    }
}
