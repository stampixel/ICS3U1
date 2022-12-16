package FinalProject;

import java.util.Scanner;

public class GomokuAlphaBetaPruningTest {
    Scanner scan = new Scanner(System.in);

    char[][] currentBoard = {{'+', '+', '+'}, {'+', '+', '+'}, {'+', '+', '+'}};
    char playerTurn = 'X';

    public static void main(String[] args) {
        GomokuAlphaBetaPruningTest game = new GomokuAlphaBetaPruningTest();
        game.startGame();


    }

    public void startGame() {
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
                    int playedX = scan.nextInt()-1;
                    System.out.print("Insert the Y coordinates (column): ");
                    int playedY = scan.nextInt()-1;

                    if (validMove(playedX, playedY)) {
                        currentBoard[playedX][playedY] = 'X';
                        playerTurn = 'O';
                        break;
                    } else {
                        System.out.println("Move is not valid! Try again.");
                    }

                }
            } else {
                int[] maxArray = maxScore(-2, 2);
                int playedAIX = maxArray[1];
                int playedAIY = maxArray[2];
                currentBoard[playedAIX][playedAIY] = 'O';
                playerTurn = 'X';
            }
        }
    }

    public void drawBoard() {
        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard.length; j++) {
                System.out.print(currentBoard[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean validMove(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return false;
        } else return currentBoard[x][y] == '+';
    }

    public char checkWinner() {

        // Vertical win
        for (int i = 0; i < 3; i++) {
            if (currentBoard[0][i] != '+' && currentBoard[0][i] == currentBoard[1][i] && currentBoard[1][i] == currentBoard[2][i]) {
                return currentBoard[0][i];
            }
        }

        // Horizontal win
        for (char[] row : currentBoard) {
            if (row[0] == 'X' && row[1] == 'X' && row[2] == 'X') {
                return 'X';
            } else if (row[0] == 'O' && row[1] == 'O' && row[2] == 'O') {
                return 'O';
            }
        }

        // Diagonal wins
        if (currentBoard[0][0] != '+' && currentBoard[0][0] == currentBoard[1][1] && currentBoard[0][0] == currentBoard[2][2]) {
            return currentBoard[0][0];
        } else if (currentBoard[0][2] != '+' && currentBoard[0][2] == currentBoard[1][1] && currentBoard[0][2] == currentBoard[2][0]) {
            return currentBoard[0][2];

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

    // Player 'O' is our AI, which means we need to try to find it's max
    public int[] maxScore(int alpha, int beta) {
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

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // If the current box is empty, the AI (player 'O') calls Min
                // Which creates a new branch of the game decision tree
                if (currentBoard[i][j] == '+') {
                    currentBoard[i][j] = 'O';

                    int[] minReturn = minScore(alpha, beta);
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


    // Player 'X' is the Player, which means we need to try to find it's min
    public int[] minScore(int alpha, int beta) {
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

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // If the current box is empty, we call min to find the least amount of possible wins for the player
                // Which creates a new branch of the game decision tree
                if (currentBoard[i][j] == '+') {
                    currentBoard[i][j] = 'X';

                    int[] minReturn = maxScore(alpha, beta);
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

