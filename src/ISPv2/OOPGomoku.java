package ISPv2;

/**
 * @author kevin.tang
 * 2022.12.20
 * ISP project for ICS3U1
 */

import java.io.*;
import java.util.Scanner;

public class OOPGomoku {
    // Using OOP, we created all the class variables inside here, rather than inside the main method
    Scanner scan = new Scanner(System.in);
    GomokuAI AI = new GomokuAI();
    char[][] currentBoard = new char[15][15]; // Game board is represented by a 2d char array (see references)
    char playerTurn = 'X'; // Default player turn is X

    public static void main(String[] args) throws IOException {

        // Creating an object using our class (e.i. the same way we do it win java.util.Scanner)
        OOPGomoku game = new OOPGomoku();

        game.startGame(); // Running the game
    }

    /**
     * This is the method used to run the game
     *
     * @throws IOException
     */
    public void startGame() throws IOException {
        // Inside a while loop because player might want to return to menu screen
        while (true) {
            printMenu();

            playerTurn = 'X'; // Resetting the player turn to X

            // Populating the game board with "+," representing empty spots that a player can place their pieces on
            for (int i = 0; i < currentBoard.length; i++) {
                for (int j = 0; j < currentBoard.length; j++) {
                    currentBoard[i][j] = '+';
                }
            }

            System.out.print("Please select an option by entering the corresponding number: "); // Prompting user for a choice based on the different options
            int choice = scan.nextInt();

            if (choice == 1) { // Player VS Player
                playerVersusPlayer();

                System.out.print("Would you like to navigate to the main menu (Y/N): ");
                if (scan.next().equals("Y")) {
                    continue;
                } else {
                    break;
                }
            } else if (choice == 2) { // Player VS Computer
                playerVersusAI();

                System.out.print("Would you like to navigate to the main menu (Y/N): ");
                if (scan.next().equals("Y")) {
                    continue;
                } else {
                    System.out.println("Bye!");
                    break;
                }
            } else if (choice == 3) { // Quit game
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }


    /**
     * We read a file called "menu.txt" in order to get the main menu of the game and printing it
     *
     * @throws FileNotFoundException
     */
    public void printMenu() throws FileNotFoundException {
        File myFile = new File("C:\\Users\\Kevin Tang\\IdeaProjects\\ICS3U1\\src\\ISPv2\\Menu");
        Scanner scan = new Scanner(myFile);

        // Counting total amount of lines
        int count = 0;
        while (scan.hasNextLine()) {
            scan.nextLine();
            count++;
        }

        scan = new Scanner(myFile); // Resetting scanner
        for (int i = 0; i < count; i++) {
            System.out.println(scan.nextLine()); // Reading and printing the lines
        }

    }


    /**
     * This method is used to draw the game board
     */
    public void drawBoard() {
        System.out.println("   a  b  c  d  e  f  g  h  i  j  k  l  m  n  o"); // Alphabets representing column
        for (int i = 1; i < currentBoard.length + 1; i++) {
            if (i < 10) { // Numbers representing the rows
                System.out.print(" " + i + " ");
            } else {
                System.out.print(i + " ");
            }
            for (int j = 0; j < currentBoard.length; j++) {
                System.out.print(currentBoard[i - 1][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");
    }

    /**
     * Method that takes care of player versus player
     *
     * @throws IOException
     */
    public void playerVersusPlayer() throws IOException {
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
                System.out.println("Would you like to save the state of the current board to a file (Y/N): ");
                if (scan.next().equals("Y")) { // Ability to save/append the game board data into a file, so it can be analyzed by the player
                    saveCurrentBoard(currentBoard, result);
                    System.out.println("Game successfully saved in file: 'GamesPlayed.txt'");
                    System.out.println("-------------------------------------------");
                } else {
                    System.out.println("Game not saved.");
                }
                return; // Returns to the startGame function
            }

            // Each player takes turns placing their pieces onto the board
            while (true) {
                System.out.println("IT IS PLAYER " + playerTurn + "'S TURN");
                System.out.print("Enter the column letter, followed by the row number (i.e. c13): ");
                String position = scan.next();

                int row;
                int column;

                try { // Using try and except in case user enters something that doesn't follow the format: [letter][number]
                    int[] coordinates = parsePosition(position); // Since position inputs would look something like "c12," we use a separate function to translate that into row and column
                    column = coordinates[0];
                    row = coordinates[1];

                } catch (Exception e) {
                    System.out.println("Move is not valid! Try again.");
                    continue;
                }

                // Using function to check if row and column is inside the board or not
                if (validMove(row, column)) {
                    currentBoard[row][column] = playerTurn;
                    if (playerTurn == 'X') { // Switching turns of the player based on what the previous turn was
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


    /**
     * Method that takes care of player versus computer
     *
     * @throws IOException
     */
    public void playerVersusAI() throws IOException { // Essentially the same thing as player vs player, so no comments unless something is different
        while (true) {
            drawBoard();
            int result = checkWinner();

            if (result != 0) {
                if (result == 'X') {
                    System.out.println("The Computer won the game, better luck next time!");
                } else if (result == 'O') {
                    System.out.println("Congrats, you won!");
                } else if (result == -1) {
                    System.out.println("The game is a tie!");
                }

                System.out.println("Would you like to save the state of the current board to a file (Y/N): ");
                if (scan.next().equals("Y")) {
                    saveCurrentBoard(currentBoard, result);
                    System.out.println("Game successfully saved in file: 'GamesPlayed.txt'");
                    System.out.println("-------------------------------------------");
                } else {
                    System.out.println("Game not saved.");
                }
                return;
            }

            // X in this case is the computer, it always gets first move
            if (playerTurn == 'X') { // AI's turn
                int[] movesXY = AI.moveAI(currentBoard); // Using a method inside the AI object, that determines which position the AI will place its piece on

                int column = movesXY[0];
                int row = movesXY[1];
                currentBoard[row][column] = 'X';
                playerTurn = 'O'; // Switching player turn

            } else { // Player's turn
                while (true) {
                    System.out.print("Enter the column letter, followed by the row number (i.e. c13): ");
                    String position = scan.next();

                    int row;
                    int column;

                    try {
                        int[] coordinates = parsePosition(position);
                        column = coordinates[0];
                        row = coordinates[1];

                    } catch (Exception e) {
                        System.out.println("Move is not valid! Try again.");
                        continue;
                    }

                    if (validMove(row, column)) {
                        currentBoard[row][column] = 'O';
                        playerTurn = 'X';
                        break;
                    } else {
                        System.out.println("Move is not valid! Try again.");
                    }
                }
            }
        }
    }

    /**
     * Parses the move that the player entered, taking it in as the parameter "position"
     * @param position
     * @return
     */
    public int[] parsePosition(String position) { // Format looks like "c12"
        int[] coordinates = new int[2]; // Int array to store the row and column that will be returned
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        coordinates[0] = alphabet.indexOf(position.charAt(0)); // Directly turning the letter into a number based on its index in "alphabet" variable (column)
        coordinates[1] = Integer.parseInt(position.substring(1)) - 1; // Getting the number after the letter (row)
        return coordinates;
    }

    /**
     * Allows the user to save the state of the board into a file, so it can be reviewed later for analysis
     * @param board
     * @param winner
     * @throws IOException
     */

    public void saveCurrentBoard(char[][] board, int winner) throws IOException { // Board is the 2d array of the game board, winner is the winner
        PrintWriter write = new PrintWriter(new FileWriter("C:\\Users\\Kevin Tang\\IdeaProjects\\ICS3U1\\src\\ISPv2\\GamesPlayed.txt", true)); // Setting the file as appendable

        write.println("The winner of this game is: " + winner);
        for (int i = 0; i < board.length; i++) { // Appending game board to the file
            for (int j = 0; j < board.length; j++) {
                write.print(board[i][j] + " ");
            }
            write.println();
        }

        write.println("\n-------------------------------------------\n");

        write.close();
    }

    /**
     * Checking if the row and column that the player has chosen is within the range of the game board
     * @param column
     * @param row
     * @return
     */
    public boolean validMove(int column, int row) {
        if (column < 0 || row < 0 || column > currentBoard.length || row > currentBoard.length) {
            return false;
        } else return currentBoard[column][row] == '+';
    }

    /**
     * Traverses the game board to find potential winners and checking if the game is a tie
     * @return
     */
    public int checkWinner() {
        // Horizontal win
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

        // Vertical win
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

        // Upward diagonal win
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

        // Downward diagonal win
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
        return (char) -1;
    }
}
