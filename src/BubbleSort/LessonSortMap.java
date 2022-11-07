package BubbleSort;

/**
 * @author steve.smintich
 * 2021 10 22
 *
 * Try and create the bubble sort map from the lesson...
 */
public class LessonSortMap {

    public static void main(String[] args) {

        int toSort[] = {5, 3, 1, 9, 8, 2, 4, 7, 4, 2, 3, 67, 1, 45, 64, 672, 42, 4, 423, 6};
        int length = toSort.length; //8
        int count = 1;

        //bubble sort
        for (int i = 0; i < length - 1; i++) { // Relates to the number of passes, so minus 1 because we only need n-1 passes
            for (int j = 0; j < length -i - 1; j++) {
                /**
                 * -1?
                 * accounts for the out of bounds error
                 * -i? (0 to 8)
                 * -i will put a limit on the j value, which optimizes the sort
                 */
                //swap code
                if (toSort[j] > toSort[j+1]) {
                    int temp = toSort[j];
                    toSort[j] = toSort[j+1];
                    toSort[j+1] = temp;
                }//end if

                //mapping output
                System.out.println(count + ".\t" + i + "-" + j +
                        "==> {" + toSort[0] +
                        ", " + toSort[1] +
                        ", " + toSort[2] +
                        ", " + toSort[3] +
                        ", " + toSort[4] +
                        ", " + toSort[5] +
                        ", " + toSort[6] + "}");
                count++;
            }//inside for ends
        }//outside for ends

        //print the sorted array
        for (int i = 0; i < toSort.length; i++) {
            System.out.print(toSort[i] + " ");
        }
    }//main ends
}//class ends
