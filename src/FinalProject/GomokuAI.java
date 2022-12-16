package FinalProject;

import java.util.Scanner;

public class GomokuAI {
    Scanner scan = new Scanner(System.in);

    char[][] currentBoard = new char[15][15];
    char playerTurn = 'X';

    public static void main(String[] args) {
        GomokuAI game = new GomokuAI();

        // Finishing up creating the board
        for (int i = 0; i < game.currentBoard.length; i++) {
            for (int j = 0; j < game.currentBoard.length; j++) {
                game.currentBoard[i][j] = '+';
            }
        }


//        game.startMenu();
        game.playerVersusAI();
    }

    public void startMenu() {
        System.out.println("Please select an option: ");
        int choice = scan.nextInt();

    }

    public void playerVersusAI() {
        while (true) {
            drawBoard();
            char result = checkWinner();

            // Printing the appropriate message if the game has ended
            if (result != 0) {
                if (result == 'X') {
                    System.out.println("The winner is X!");
                } else if (result == 'O') {
                    System.out.println("The winner is O!");
                } else if (result == '+') {
                    System.out.println("The game is a tie!");
                }
                return;
            }

            // If it is the players turn
            if (playerTurn == 'X') {
                while (true) {
                    System.out.print("Insert the X coordinates (row): ");
                    int playedX = scan.nextInt() - 1;
                    System.out.print("Insert the Y coordinates (column): ");
                    int playedY = scan.nextInt() - 1;

                    if (checkValidPlay(playedX, playedY)) {
                        currentBoard[playedX][playedY] = 'X';
                        playerTurn = 'O';
                        break;
                    } else {
                        System.out.println("Move is not valid! Try again.");
                    }

                }
            } else {
                int[] maxArray = maxScore();
                int playedAIX = maxArray[1];
                int playedAIY = maxArray[2];
                currentBoard[playedAIX][playedAIY] = 'O';
                playerTurn = 'X';
            }
        }
    }

    public void drawBoard() {
        System.out.println("   1  2  3  4  5  6  7  8  9 10 11 12 13 14 15");
        for (int i = 1; i < currentBoard.length + 1; i++) {
            if (i < 10) {
                System.out.print(" " + i + " ");
            } else {
                System.out.print(i + " ");
            }
            for (int j = 0; j < currentBoard.length; j++) {
                System.out.print(currentBoard[i - 1][j] + "  ");
            }
            System.out.println();

        }

    }

    public boolean checkValidPlay(int x, int y) {

        // Need to first check if they are larger than the game board, so we don't get outOfBounds error
        // Check to see that the spot is empty
        if (x > currentBoard.length || y > currentBoard.length || x < 0 || y < 0) {
            return false;
        } else return currentBoard[x][y] == '+';
    }


    public char checkWinner() {
        for (int row = 0; row < currentBoard.length; row++) {
            for (int col = 0; col < currentBoard[0].length - 4; col++) {
                if (currentBoard[row][col] != '+' &&
                        currentBoard[row][col + 1] == currentBoard[row][col] &&
                        currentBoard[row][col + 2] == currentBoard[row][col] &&
                        currentBoard[row][col + 3] == currentBoard[row][col] &&
                        currentBoard[row][col + 4] == currentBoard[row][col]) {
                    return currentBoard[row][col];
                }
            }
        }

        // Vertical
        for (int row = 0; row < currentBoard.length - 4; row++) {
            for (int col = 0; col < currentBoard[0].length; col++) {
                if (currentBoard[row][col] != '+' &&
                        currentBoard[row + 1][col] == currentBoard[row][col] &&
                        currentBoard[row + 2][col] == currentBoard[row][col] &&
                        currentBoard[row + 3][col] == currentBoard[row][col] &&
                        currentBoard[row + 4][col] == currentBoard[row][col]) {
                    return currentBoard[row][col];
                }
            }
        }

        // Check upward diagonal
        for (int row = 4; row < currentBoard.length; row++) {
            for (int col = 0; col < currentBoard[0].length - 4; col++) {
                if (currentBoard[row][col] != '+' &&
                        currentBoard[row - 1][col + 1] == currentBoard[row][col] &&
                        currentBoard[row - 2][col + 2] == currentBoard[row][col] &&
                        currentBoard[row - 3][col + 3] == currentBoard[row][col] &&
                        currentBoard[row - 4][col + 4] == currentBoard[row][col]) {
                    return currentBoard[row][col];
                }
            }
        }

        //check downward diagonal
        for (int row = 0; row < currentBoard.length - 4; row++) {
            for (int col = 0; col < currentBoard[0].length - 4; col++) {
                if (currentBoard[row][col] != '+' &&
                        currentBoard[row + 1][col + 1] == currentBoard[row][col] &&
                        currentBoard[row + 2][col + 2] == currentBoard[row][col] &&
                        currentBoard[row + 3][col + 3] == currentBoard[row][col] &&
                        currentBoard[row + 4][col + 4] == currentBoard[row][col]) {
                    return currentBoard[row][col];
                }
            }
        }
        return 0;
    }

    // Player 'O' is our AI, which means we need to try to find it's max
    public int[] maxScore() {
        // Possible values for maxv are:
        // -1 - loss
        // 0  - a tie
        // 1  - win

        // Initializing it for now, to a case that is worse than the worst case
        int maxv = -2;

        // Init the variables to something that isn't an index
        int x = -1;
        int y = -1;

        char result = checkWinner();

//        If the game came to an end, the function needs to return
//        the evaluation function of the end.That can be:
//        -1 - loss
//        0 - a tie
//        1 - win

        if (result == 'X') {
            return new int[]{-1, 0, 0};
        } else if (result == 'O') {
            return new int[]{1, 0, 0};
        } else if (result == '+') {
            return new int[]{0, 0, 0};
        }

        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard.length; j++) {

                // If the current box is empty, the AI (player 'O') calls Min
                // Which creates a new branch of the game decision tree
                if (currentBoard[i][j] == '+') {
                    currentBoard[i][j] = 'O';

                    int[] minReturn = minScore();
                    int m = minReturn[0];
                    int min_i = minReturn[1];
                    int m_j = minReturn[2];
                    // Fixing the maxv value if needed
                    if (m > maxv) {
                        maxv = m;
                        x = i;
                        y = j;
                    }
                    // Reset the value of the board to the original
                    currentBoard[i][j] = '+';
                }
            }
        }


        return new int[]{maxv, x, y};
    }


    // Player 'X' is the Player, which means we need to try to find it's min
    public int[] minScore() {
        // Possible values for minv are:
        // -1 - win
        // 0  - a tie
        // 1  - loss

        // Initializing it for now, to a case that is worse than the worst case
        int minv = 2;

        // Init the variables to something that isn't an index
        int x = -1;
        int y = -1;

        char result = checkWinner();

//        If the game came to an end, the function needs to return
//        the evaluation function of the end.That can be:
//        -1 - win
//        0 - a tie
//        1 - loss

        if (result == 'X') {
            return new int[]{-1, 0, 0};
        } else if (result == 'O') {
            return new int[]{1, 0, 0};
        } else if (result == '+') {
            return new int[]{0, 0, 0};
        }

        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard.length; j++) {

                // If the current box is empty, we call min to find the least amount of possible wins for the player
                // Which creates a new branch of the game decision tree
                if (currentBoard[i][j] == '+') {
                    currentBoard[i][j] = 'X';

                    int[] minReturn = maxScore();
                    int m = minReturn[0];
                    int min_i = minReturn[1];
                    int m_j = minReturn[2];
                    // Fixing the minv value if needed
                    if (m < minv) {
                        minv = m;
                        x = i;
                        y = j;
                    }
                    // Reset the value of the board to the original
                    currentBoard[i][j] = '+';
                }
            }
        }


        return new int[]{minv, x, y};
    }


}

