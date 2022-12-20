package ISP;

public class GomokuAI {

    // Each position guarantees a certain amount of score, you can see that points increase when going towards the center
    final int[][] boardScore =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                    {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                    {0, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 1, 0},
                    {0, 1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 3, 2, 1, 0},
                    {0, 1, 2, 3, 4, 5, 5, 5, 5, 5, 4, 3, 2, 1, 0},
                    {0, 1, 2, 3, 4, 5, 6, 6, 6, 5, 4, 3, 2, 1, 0},
                    {0, 1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1, 0},
                    {0, 1, 2, 3, 4, 5, 6, 6, 6, 5, 4, 3, 2, 1, 0},
                    {0, 1, 2, 3, 4, 5, 5, 5, 5, 5, 4, 3, 2, 1, 0},
                    {0, 1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 3, 2, 1, 0},
                    {0, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 1, 0},
                    {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0},
                    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    // Point system based on how many are in a row, all of them are string arrays so it is easier to work with (compared to having both String and String Arrays)
    String[] fiveInARow = {"22222"}; // Score: 50000
    String[] fourInARow = {"022220"}; // Score: 4320
    String[] midThree = {"022200", "002220", "022020", "020220", "22220",
            "02222", "22022", "20222", "22202"}; // Score: 720
    String[] midTwo = {"002200", "002020", "020200"}; // Score: 120
    String[] oneInARow = {"000200", "002000"}; // Score: 20


    public int[] moveAI(int[][] board) {
        int[] minimumSearchSpace = fourCorner(board);
        int xMin = minimumSearchSpace[0];
        int xMax = minimumSearchSpace[1];
        int yMin = minimumSearchSpace[2];
        int yMax = minimumSearchSpace[3];

        int score = 0; // Tracks the highest score move/position
        int[] xList = new int[board.length]; // Stores all the X coordinates of good moves
        int[] yList = new int[board.length]; // Stores all the Y coordinates of good moves

        int index = 0; // Used to access stuff in the 2 arrays later on

        for (int i = xMin; i < xMax + 1; i++) {
            for (int j = yMin; j < yMax + 1; j++) {
                if (board[j][i] == 0) {
                    int temp = positionScore(board, i, j); // temp stores the value of how good a position is
                    if (temp > score) { // If temp equals to the score, we refresh the 2 arrays and add the value into it
                        score = temp;
                        xList = new int[board.length];
                        yList = new int[board.length];
                        index = 0; // Also need to reset index back to 0
                        xList[index] = i;
                        yList[index] = j;
                    } else if (temp == score) { // If temp == score, we keep the list of positions that give us the highest score
                        xList[index] = i;
                        yList[index] = j;
                        index++;
                    }
                }

            }
        }

        // Need this, cus the length of our list is fixed to 15, but some of those indices dont have numbers
        index = (int) (Math.random() * index); // Random number form list so the move isn't predictable (all coords have the same score, so it doesn't matter which one we return)
        return new int[]{xList[index], yList[index]};
    }

    public int[] fourCorner(int[][] board) {
        int xMin = 0;
        int xMax = board.length - 1;
        int yMin = 0;
        int yMax = board.length - 1;

        while (yMin < board.length && sumOfArray(board[yMin]) == 0) {
            yMin += 1;
        }
        if (yMin - 5 < 0 || yMin == board.length) { // If there are no pieces on the board, or the board is almost full, we set yMin to the smallest (row)
            yMin = 0;
        } else {
            yMin = yMin - 5; // yMin will always be at least 5 blocks away
        }


        while (yMax >= 0 && sumOfArray(board[yMax]) == 0) {
            yMax -= 1;
        }
        if (yMax + 5 > board.length - 1 || yMax == -1) {
            yMax = board.length - 1;
        } else {
            yMax = yMax + 5; // yMax will always be at least 5 blocks away
        }

        int row = 0;
        int column = 0;

        while (column < board.length && board[row][column] == 0) {
            row++;
            if (row > board.length - 1) {
                row = 0;
                column++;
            }
        }
        if (column - 5 > 0 && column - 5 != 10) {
            xMin = column - 5;
        } else {
            xMin = 0;
        }

        row = 0;
        column = board.length - 1;

        while (column >= 0 && board[row][column] == 0) {
            row++;
            if (row > board.length - 1) {
                row = 1;
                column--;
            }
        }
        if (column + 5 < board.length - 1 && column + 5 != 4) {
            xMax = column + 5;
        } else {
            xMax = board.length - 1;
        }

        return new int[]{xMin, xMax, yMin, yMax};

    }

    public int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }


    // BASED ON THE POSTITION WE GENERATE 4 LINES, 2 DIAGONAL, AND 2 CROSSING IT, SO WE KNOW HOW LIKELY IT IS TO CONNECT
    public int positionScore(int[][] board, int x, int y) { // Gives each position a score, telling the program how good it is to place your peice there
        int score;
        board[y][x] = 2;

        String lineOne = "";
        int left = x - 4;
        int right = x + 4;

        if (left < 0) {
            left = 0;
        }

        if (right > board.length - 1) {
            right = board.length - 1;
        }
        for (int i = left; i < right + 1; i++) {
            lineOne += Integer.toString(board[y][i]);
        }

        String lineTwo = "";
        int top = y - 4;
        int down = y + 4;

        if (top < 0) {
            top = 0;
        }
        if (down > board.length - 1) {
            down = board.length - 1;
        }
        for (int i = top; i < down + 1; i++) {
            lineTwo += Integer.toString(board[i][x]);
        }

        String lineThree = "";
        left = x - 4;
        right = x + 4;
        top = y - 4;
        down = y + 4;

        while (left < 0 || top < 0) {
            left += 1;
            top += 1;
        }

        while (right > board.length - 1 || down > board.length - 1) {
            right -= 1;
            down--;
        }
        while (left <= right) {
            lineThree += Integer.toString(board[top][left]);
            left++;
            top++;
        }

        String lineFour = "";
        left = x - 4;
        right = x + 4;
        top = y - 4;
        down = y + 4;

        while (left < 0 || down > board.length - 1) {
            left++;
            down--;
        }

        while (right > board.length - 1 || top < 0) {
            right--;
            top++;
        }

        while (left <= right) {
            lineFour += Integer.toString(board[down][left]);
            left++;
            down--;
        }

        score = lineScore(lineOne) + lineScore(lineTwo) + lineScore(lineThree) + lineScore(lineFour);

        // Resetting evaluated square back to the original
        board[y][x] = 0;
        return score + boardScore[y][x];
    }

    public int lineScore(String line) { // Evaluating the line score based on what we defined earlier
        int score = 0;
        if (inLineOrNot(line, fiveInARow[0])) {
            score = 50000;
        } else if (inLineOrNot(line, fourInARow[0])) {
            score = 4320;
        } else {
            for (int i = 0; i < midThree.length; i++) {
                if (inLineOrNot(line, midThree[i])) {
                    score = 720;
                    return score;
                }
            }

            for (int i = 0; i < midTwo.length; i++) {
                if (inLineOrNot(line, midTwo[i])) {
                    score = 120;
                    return score;
                }
            }

            for (int i = 0; i < oneInARow.length; i++) {
                if (inLineOrNot(line, oneInARow[i])) {
                    score = 20;
                    return score;
                }
            }
        }
        return score;
    }

    public boolean inLineOrNot(String line, String combination) {
        // Same thing as .indexOf(), but returns true/false
        return line.contains(combination);
    }
}
