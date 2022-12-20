package ISP;

import java.util.Scanner;

public class OOPGomoku {
    Scanner scan = new Scanner(System.in);

    int[][] currentBoard = new int[15][15];
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
                currentBoard[i][j] = 0;
            }
        }
        while (true) {
            System.out.println("<<HELLO, WELCOME TO CONSOLE-MOKU, AN IMPLEMENTATION OF THE POPULAR JAPANESES GAME " +
                    "'GOMOKU,' BUT IN JAVA!>>");
            System.out.println("1 - Player VS Player (You will need a buddy if you pick this option!)");
            System.out.println("2 - Player VS AI (You will be going up against an AI, good luck!)");
            System.out.println("3 - Load Saved Game From File (Continue where you left off!)");
            System.out.println("4 - Read Game Rules (Recommended for beginners)");
            System.out.println("------------------------------");

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
                // Since i starts at 1, we have to minus 1 here
                if (currentBoard[i - 1][j] == 0) {
                    System.out.print("+  ");
                } else if (currentBoard[i - 1][j] == 1) {
                    System.out.print("O  ");

                } else if (currentBoard[i - 1][j] == 2) {
                    System.out.print("X  ");

                }
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
                } else if (result == '+') {
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
                if (result == 1) {
                    System.out.println("The winner is 1!");
                } else if (result == '2') {
                    System.out.println("The winner is 2!");
                } else if (result == '+') {
                    System.out.println("The game is a tie!");
                }
                System.out.println("Test");
                return;
            }

            // AI always goes first
            if (playerTurn == 'X') {
                System.out.println("start of AI move");
                int[] movesXY = AI.moveAI(currentBoard);

                // Y is row, X is column
                int x = movesXY[0];
                int y = movesXY[1];
                currentBoard[y][x] = 2;
                playerTurn = 'O';
                System.out.println("AI has moved");

            } else {
                while (true) {
                    System.out.print("Insert the X coordinates (row): ");
                    int playedX = scan.nextInt() - 1;
                    System.out.print("Insert the Y coordinates (column): ");
                    int playedY = scan.nextInt() - 1;

                    if (validMove(playedX, playedY)) {
                        currentBoard[playedX][playedY] = 1;
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

    // Player 'O' is our AI, which means we need to try to find it's max


    public boolean validMove(int x, int y) {
        if (x < 0 || y < 0 || x > currentBoard.length || y > currentBoard.length) {
            return false;
        } else return currentBoard[x][y] == 0;
    }

    public int checkWinner() {
        for (int row = 0; row < currentBoard.length; row++) {
            for (int col = 0; col < currentBoard[0].length - 4; col++) {
                if (currentBoard[row][col] != 0 &&
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
                if (currentBoard[row][col] != 0 &&
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
                if (currentBoard[row][col] != 0 &&
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
                if (currentBoard[row][col] != 0 &&
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
                if (currentBoard[i][j] == 0) {
                    return 0;
                }
            }
        }

        // If none of the previous loops or conditions return anything, it means the game is a tie
        return -1;
    }
}
