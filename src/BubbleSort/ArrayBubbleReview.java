package BubbleSort;

public class ArrayBubbleReview {
    public static void main(String[] args) {
        // (1)
        String[] sandwiches = new String[] {"cheese", "ham", "lettuce"};

        for (String sandwich : sandwiches) {
//            System.out.print(sandwich + " ");
        }


        // (2)
        int[] values = {3, 5, -30, 0};
        int count = 1;

        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j+1]) {
                    int temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }

                System.out.println(count + ".\t" + i + "-" + j +
                        "==> {" + values[0] +
                        ", " + values[1] +
                        ", " + values[2] +
                        ", " + values[3] + "}");
                count++;
            }
        }


        // (3, 4)
        int[] numbers = {20, 6, 3, 1, 0};

        // (5) Smallest value
        int small = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (small > numbers[i]) {
                small = numbers[i];
            }
        }
        System.out.println("The smallest value is: " + small);


        // (6) Bubble sort, then get middle value
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        System.out.println("The middle value is: " + numbers[numbers.length/2]);
    }
}
