package ISPv2;

import java.util.Scanner;

public class OOPGomoku {
    Scanner scan = new Scanner(System.in);

    char[][] currentBoard = new char[15][15];
    GomokuAI AI = new GomokuAI();

    char playerTurn = 'X';

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        OOPGomoku game = new OOPGomoku();
        GomokuAI AI = new GomokuAI();

        game.startGame();
    }

    public void startGame() {
//        int choice = 0;
        // Finishing up creating the board
        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard.length; j++) {
                currentBoard[i][j] = '+';
            }
        }
        while (true) {
            printMenu();

            System.out.print("Please select an option by entering the corresponding number: ");
            int choice = scan.nextInt();

            if (choice == 1) {
                playerVersusPlayer();
                break;
            } else if (choice == 2) {
                playerVersusAI();
                break;
            } else if (choice == 3) {
                loadGame();
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    public void printMenu() {

    }

    public void printRules() {

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

    public void playerVersusPlayer() {
        while (true) {
            drawBoard();
            int result = checkWinner();
            // CHECK THIS PART MAKE SURE IT MATCHES WIUTH THE AI ONE


            // Printing the appropriate message if the game has ended
            if (result != 0) {
                if (result == 'X') {
                    System.out.println("The winner is X!");
                } else if (result == 'O') {
                    System.out.println("The winner is O!");
                } else if (result == -1) {
                    System.out.println("The game is a tie!");
                }
                return;
            }

            // If it is the players turn
            while (true) {
                System.out.print("Insert the X coordinates (row): ");
                int playedX = scan.nextInt() - 1;
                System.out.print("Insert the Y coordinates (column): ");
                int playedY = scan.nextInt() - 1;

                if (validMove(playedX, playedY)) {
                    currentBoard[playedX][playedY] = playerTurn;
                    if (playerTurn == 'X') {
                        playerTurn = 'O';
                    } else if (playerTurn == 'O') {
                        playerTurn = 'X';
                    }
                    break;
                } else {
                    System.out.println("Move is not valid! Try again.");
                }
            }

        }
    }

    public void playerVersusAI() {
        while (true) {
            drawBoard();
            int result = checkWinner();

            // Printing the appropriate message if the game has ended
            if (result != 0) {
                if (result == 'X') {
                    System.out.println("The winner is X!");
                } else if (result == 'O') {
                    System.out.println("The winner is O!");
                } else if (result == -1) {
                    System.out.println("The game is a tie!");
                }
                return;

            }

            // AI always goes first
            if (playerTurn == 'X') {
                int[] movesXY = AI.moveAI(currentBoard);

                // Y is row, X is column
                int x = movesXY[0];
                int y = movesXY[1];
                System.out.print(x);
                currentBoard[y][x] = 'X';
                playerTurn = 'O';
                System.out.println("AI has moved");

            } else {
                while (true) {
                    System.out.print("Insert the X coordinates (row): ");
                    int playedX = scan.nextInt() - 1;
                    System.out.print("Insert the Y coordinates (column): ");
                    int playedY = scan.nextInt() - 1;

                    if (validMove(playedX, playedY)) {
                        currentBoard[playedX][playedY] = 'O';
                        playerTurn = 'X';
                        break;
                    } else {
                        System.out.println("Move is not valid! Try again.");
                    }
                }
            }
        }

    }

    public void loadGame() {

    }


    public boolean validMove(int x, int y) {
        if (x < 0 || y < 0 || x > currentBoard.length || y > currentBoard.length) {
            return false;
        } else return currentBoard[x][y] == '+';
    }

    public int checkWinner() {
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
        return -1;
    }
}
