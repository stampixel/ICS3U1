package FinalProject;

import java.util.Scanner;

public class TicTacToe4x {
    Scanner scan = new Scanner(System.in);

    char[][] currentBoard = new char[5][5];
    char playerTurn = 'X';

    public static void main(String[] args) {
        TicTacToe4x game = new TicTacToe4x();


        for (int i = 0; i < game.currentBoard.length; i++) {
            for (int j = 0; j < game.currentBoard.length; j++) {
                game.currentBoard[i][j] = '+';
            }
        }


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
                int[] maxArray = maxScore(-20000, 20000);
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


        // If there's an empty spot, we continue the game
        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard.length; j++) {
                if (currentBoard[i][j] == '+') {
                    return 0;
                }
            }
        }

        // If none of the previous loops or conditions return anything, it means the game is a tie
        return '+';
    }


    public int[] maxScore(int alpha, int beta) {

        int maxv = -2;

        int x = -1;
        int y = -1;

        char result = checkWinner();


        if (result == 'X') {
            return new int[]{-1, 0, 0};
        } else if (result == 'O') {
            return new int[]{1, 0, 0};
        } else if (result == '+') {
            return new int[]{0, 0, 0};
        }

        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard.length; j++) {
                if (currentBoard[i][j] == '+') {
                    currentBoard[i][j] = 'O';

                    int[] minReturn = minScore(alpha, beta);
                    int m = minReturn[0];
                    int min_i = minReturn[1];
                    int m_j = minReturn[2];
                    if (m > maxv) {
                        maxv = m;
                        x = i;
                        y = j;
                    }
                    currentBoard[i][j] = '+';

                    if (maxv >= beta) {
                        return new int[]{maxv, x, y};
                    }

                    if (maxv > alpha) {
                        alpha = maxv;
                    }
                }
            }
        }


        return new int[]{maxv, x, y};
    }


    public int[] minScore(int alpha, int beta) {

        int minv = 2;

        int x = -1;
        int y = -1;

        char result = checkWinner();


        if (result == 'X') {
            return new int[]{-1, 0, 0};
        } else if (result == 'O') {
            return new int[]{1, 0, 0};
        } else if (result == '+') {
            return new int[]{0, 0, 0};
        }

        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard.length; j++) {

                if (currentBoard[i][j] == '+') {
                    currentBoard[i][j] = 'X';

                    int[] minReturn = maxScore(alpha, beta);
                    int m = minReturn[0];
                    int min_i = minReturn[1];
                    int m_j = minReturn[2];
                    if (m < minv) {
                        minv = m;
                        x = i;
                        y = j;
                    }
                    currentBoard[i][j] = '+';

                    if (minv <= alpha) {
                        return new int[]{minv, x, y};
                    }

                    if (minv < beta) {
                        beta = minv;
                    }
                }
            }
        }
        return new int[]{minv, x, y};
    }
}

