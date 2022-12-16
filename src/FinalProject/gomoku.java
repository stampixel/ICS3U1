package FinalProject;

import java.util.Scanner;

public class gomoku {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("<< Welcome to GOMOKU >>\nIn this game you will compete with another player in trying to complete an unbroken line of 5 pieces.");

        int column = 0;
        int row = 0;
        boolean win = false;
        char playerIcon = ' ';
        String playerTurn = "";

        // Creating a char array which will be used as our game board
        char[][] board = new char[15][15];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '+';
            }
        }

        // Randomizing which player starts first
        if (((int) (Math.random() * 2) + 1) == 1) {
            playerTurn = "one";
            playerIcon = 'X';
        } else {
            playerTurn = "two";
            playerIcon = 'O';
        }

        System.out.println("Player " + playerTurn + " gets to start first! Enter any key to continue to the game.");
        scan.next();


        System.out.println("Make sure to enter valid moves, or else you will be prompted again!");

        while (!win) {
            displayBoard(board);
            System.out.println("It is player " + playerTurn + "'s turn.");
            do {
                System.out.println("-------------------------------");
                System.out.print("Enter the row you want to place your piece on: ");
                row = scan.nextInt();
                System.out.print("Enter the column you want to place your piece on: ");
                column = scan.nextInt();
                System.out.println("-------------------------------");
            } while (!checkValidPlay(board, row - 1, column - 1));


            placePiece(board, playerIcon, row - 1, column - 1);

            win = checkWinner(board, playerTurn, playerIcon);
            if (win) {
                System.out.print("yes");
                break;
            }

            if (playerTurn.equals("one")) {
                playerTurn = "two";
                playerIcon = 'O';
            } else {
                playerTurn = "one";
                playerIcon = 'X';
            }
        }


    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static boolean checkValidPlay(char[][] gameBoard, int row, int column) {

        // Need to first check if they are larger than the game board, so we don't get outOfBounds error
        if (row > gameBoard.length || column > gameBoard.length || row < 0 || column < 0) {
            return false;
        } else if ((gameBoard[row][column] != '+')) { // Check to see that the spot is empty
            return false;
        }
        return true;
    }

    public static void placePiece(char[][] gameBoard, char playerIcon, int row, int column) {
        gameBoard[row][column] = playerIcon;
    }

    /**
     * Procedural method to print the game board
     *
     * @param gameBoard
     */

    public static void displayBoard(char[][] gameBoard) {
        System.out.println("   1  2  3  4  5  6  7  8  9 10 11 12 13 14 15");
        for (int i = 1; i < gameBoard.length+1; i++) {
            if (i < 10) {
                System.out.print(" " + i + " ");
            } else {
                System.out.print(i + " ");
            }
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print(gameBoard[i-1][j] + "  ");
            }
            System.out.println();

        }

    }

    public static void saveGame(char[][] gameBoard, String player) {

    }

    /**
     * Checks to see if a player has won or not
     *
     * @param gameBoard
     * @param player
     * @return
     */

    public static boolean checkWinner(char[][] gameBoard, String player, char playerIcon) {

        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length - 4; col++) {
                if (gameBoard[row][col] == playerIcon &&
                        gameBoard[row][col + 1] == playerIcon &&
                        gameBoard[row][col + 2] == playerIcon &&
                        gameBoard[row][col + 3] == playerIcon &&
                        gameBoard[row][col + 4] == playerIcon) {
                    return true;
                }
            }
        }
        //check for 4 up and down
        for (int row = 0; row < gameBoard.length - 4; row++) {
            for (int col = 0; col < gameBoard[0].length; col++) {
                if (gameBoard[row][col] == playerIcon &&
                        gameBoard[row + 1][col] == playerIcon &&
                        gameBoard[row + 2][col] == playerIcon &&
                        gameBoard[row + 3][col] == playerIcon &&
                        gameBoard[row + 4][col] == playerIcon) {
                    return true;
                }
            }
        }
        //check upward diagonal
        for (int row = 4; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length - 4; col++) {
                if (gameBoard[row][col] == playerIcon &&
                        gameBoard[row - 1][col + 1] == playerIcon &&
                        gameBoard[row - 2][col + 2] == playerIcon &&
                        gameBoard[row - 3][col + 3] == playerIcon &&
                        gameBoard[row - 4][col + 4] == playerIcon) {
                    return true;
                }
            }
        }
        //check downward diagonal
        for (int row = 0; row < gameBoard.length - 4; row++) {
            for (int col = 0; col < gameBoard[0].length - 4; col++) {
                if (gameBoard[row][col] == playerIcon &&
                        gameBoard[row + 1][col + 1] == playerIcon &&
                        gameBoard[row + 2][col + 2] == playerIcon &&
                        gameBoard[row + 3][col + 3] == playerIcon &&
                        gameBoard[row + 4][col + 4] == playerIcon) {
                    return true;
                }
            }
        }
        return false;
    }
}
