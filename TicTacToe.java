package com.TickTackToe;


import java.util.Scanner;

public class TicTacToe {
	
	/*
	 * Tic-Tac-Toe Game
	 *
	 * Class: TicTacToe
	 *
	 * Purpose:
	 * A console-based Tic-Tac-Toe game for two players.
	 * The game is played on a 3x3 grid where players take turns placing their marks (X or O).
	 * The first player to align three marks in a row, column, or diagonal wins.
	 * If the grid is full and no player wins, the game ends in a tie.
	 *
	 * Features:
	 * 1. Console grid display:
	 *    - Shows a 3x3 grid with row and column numbers for easier move input.
	 *    - Clean formatting with dividers (| and ---+---+---) to visualize the board.
	 *
	 * 2. Player input validation:
	 *    - Ensures moves are within the grid (0–2 for rows and columns).
	 *    - Prevents overwriting of already occupied cells.
	 *    - Handles invalid input gracefully, prompting the user again.
	 *
	 * 3. Game logic:
	 *    - Detects horizontal, vertical, and diagonal wins.
	 *    - Detects tie if the grid is full and no winner.
	 *    - Alternates turns between Player X and Player O.
	 *
	 * 4. Console enhancements:
	 *    - Optional clearing of the console each turn for a cleaner board display.
	 *    - Friendly messages for wins, ties, and invalid moves.
	 *
	 * Methods Documentation:
	 * 1. main(String[] args)
	 *    - Entry point of the program.
	 *    - Initializes the grid and runs the game loop until a winner or tie.
	 *    - Handles player input, updates the grid, and switches turns.
	 *
	 * 2. printGrid()
	 *    - Prints the current state of the grid with row and column numbers.
	 *    - Uses visual dividers to separate rows and columns.
	 *
	 * 3. isGameOver()
	 *    - Checks if the game has ended.
	 *    - Returns true if there is a winner or if the grid is full.
	 *
	 * 4. hasWinner()
	 *    - Determines if a player has won the game.
	 *    - Checks all rows, columns, and diagonals.
	 *    - Returns true if a winning combination exists.
	 *
	 * 5. isRowWin(int row)
	 *    - Checks if a specific row contains three identical marks (X or O).
	 *    - Returns true if the row is a winning row.
	 *
	 * 6. isColWin(int col)
	 *    - Checks if a specific column contains three identical marks.
	 *    - Returns true if the column is a winning column.
	 *
	 * 7. isDiag1Win()
	 *    - Checks the diagonal from top-left to bottom-right.
	 *    - Returns true if all three cells in this diagonal are identical.
	 *
	 * 8. isDiag2Win()
	 *    - Checks the diagonal from top-right to bottom-left.
	 *    - Returns true if all three cells in this diagonal are identical.
	 *
	 * 9. isFull()
	 *    - Checks if the grid has any empty spaces remaining.
	 *    - Returns true if the grid is completely filled.
	 *
	 * Game Flow:
	 * 1. Initialize the grid with empty spaces.
	 * 2. Print the grid to the console.
	 * 3. Prompt the current player to enter row and column numbers.
	 * 4. Validate input: ensure coordinates are valid and the cell is empty.
	 * 5. Update the grid with the player's mark.
	 * 6. Check for game over:
	 *    - If a player has won, announce the winner.
	 *    - If the grid is full without a winner, declare a tie.
	 * 7. Switch to the other player and repeat steps 2–6 until the game ends.
	 *
	 * Notes:
	 * - Players: Player X always starts first.
	 * - Grid indices: Rows and columns are numbered 0, 1, 2.
	 * - Winning condition: Three identical marks in a row, column, or diagonal.
	 * - Tie condition: All cells filled with no winner.
	 */


    // The grid where the game is played
    private static char[][] grid = new char[3][3];

    // Players
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    // Current player
    private static char currentPlayer = PLAYER_X;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }

        // Game loop
        while (true) {
            // Optional: clear console for better display
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Print grid
            printGrid();

            // Get valid move from player
            int row, col;
            while (true) {
                System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt();
                } else {
                    System.out.println("Invalid input! Please enter numbers 0-2.");
                    scanner.next(); // discard invalid input
                    continue;
                }

                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                } else {
                    System.out.println("Invalid input! Please enter numbers 0-2.");
                    scanner.next(); // discard invalid input
                    continue;
                }

                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (grid[row][col] == ' ') {
                        break; // valid move
                    } else {
                        System.out.println("Cell already occupied! Try again.");
                    }
                } else {
                    System.out.println("Invalid coordinates! Row and column must be 0, 1, or 2.");
                }
            }

            // Update grid
            grid[row][col] = currentPlayer;

            // Check for game over
            if (isGameOver()) {
                printGrid(); // final grid

                if (hasWinner()) {
                    System.out.println("Player " + currentPlayer + " wins! ");
                } else {
                    System.out.println("It's a tie! ");
                }
                break; // end game
            }

            // Switch player
            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }

        scanner.close();
    }

    // Print the grid with row and column numbers
    private static void printGrid() {
        System.out.println("   0   1   2"); // column headers
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " "); // row header
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + grid[i][j] + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  ---+---+---");
        }
        System.out.println();
    }

    // Check if the game is over
    private static boolean isGameOver() {
        return hasWinner() || isFull();
    }

    // Check if there is a winner
    private static boolean hasWinner() {
        for (int i = 0; i < 3; i++) {
            if (isRowWin(i) || isColWin(i)) return true;
        }
        return isDiag1Win() || isDiag2Win();
    }

    // Row check
    private static boolean isRowWin(int row) {
        return (grid[row][0] != ' ' && grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2]);
    }

    // Column check
    private static boolean isColWin(int col) {
        return (grid[0][col] != ' ' && grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]);
    }

    // Diagonal checks
    private static boolean isDiag1Win() {
        return (grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]);
    }

    private static boolean isDiag2Win() {
        return (grid[0][2] != ' ' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]);
    }

    // Check if grid is full
    private static boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i][j] == ' ')
                    return false;
        return true;
    }
}
