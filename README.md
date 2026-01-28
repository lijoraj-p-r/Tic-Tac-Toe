
# Tic-Tac-Toe Java Console Game
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/e50047ad-17b1-4fef-93c4-e81458d4d70a" />

## Overview

This is a **console-based Tic-Tac-Toe game** implemented in **Java**. Two players take turns marking cells on a **3x3 grid** with their symbols: `X` and `O`. The first player to align **three marks in a row, column, or diagonal wins**. If the grid is full and no player wins, the game ends in a tie.

This project is ideal for **beginners** learning:

* Java basics (`arrays`, `loops`, `conditionals`)
* Methods and modular programming
* Input validation and console interaction

---

## Features

* Interactive **3x3 console grid** display
* **Row and column numbers** for easy move selection
* **Input validation** to prevent invalid moves or overwriting
* Automatic detection of **winner or tie**
* Clear **turn switching** between Player X and Player O
* Optional console clearing for a cleaner board display

---

## How to Play

1. Run the program in a Java IDE or terminal.
2. Player X goes first.
3. Players take turns entering their move in the format:

```
row column
```

* `row` and `column` are numbers between `0` and `2`.
* Example: `1 2` places a mark at row 1, column 2.

4. The program validates the input:

   * Checks if the coordinates are valid (0–2)
   * Ensures the chosen cell is empty

5. The game continues until:

   * A player gets **three in a row** → winner is announced
   * All cells are filled → game ends in a tie

6. The board is displayed after each move.

---

## Grid Example

```
   0   1   2
0  X |   | O
  ---+---+---
1    | X |  
  ---+---+---
2  O |   | X
```

* Column and row numbers help players select cells easily.

---

## Code Structure

* **`TicTacToe` class**: main class containing the game logic.

* **Variables**:

  * `grid` → 3x3 char array representing the board
  * `PLAYER_X` and `PLAYER_O` → symbols for players
  * `currentPlayer` → tracks whose turn it is

* **Methods**:

| Method                | Description                                                  |
| --------------------- | ------------------------------------------------------------ |
| `main(String[] args)` | Starts the game, initializes the grid, and handles game loop |
| `printGrid()`         | Displays the current grid with row and column numbers        |
| `isGameOver()`        | Checks if a player has won or the grid is full               |
| `hasWinner()`         | Returns true if a player has a winning combination           |
| `isRowWin(int row)`   | Checks if a specific row has the same marks                  |
| `isColWin(int col)`   | Checks if a specific column has the same marks               |
| `isDiag1Win()`        | Checks top-left to bottom-right diagonal for a win           |
| `isDiag2Win()`        | Checks top-right to bottom-left diagonal for a win           |
| `isFull()`            | Checks if all cells in the grid are filled                   |

---

## Tips for Beginners

* Understand how **2D arrays** are used to represent the board.
* Learn how **loops** iterate through rows and columns to check for wins.
* Notice the use of **methods** to modularize the code and avoid repetition.
* Input validation is key to prevent crashes or illegal moves.
* The `currentPlayer` variable helps **alternate turns** easily.

---

## How to Run

1. Save the code as `TicTacToe.java`.
2. Open a terminal or IDE (e.g., IntelliJ, Eclipse, VS Code).
3. Compile the program:

```
javac TicTacToe.java
```

4. Run the program:

```
java TicTacToe
```

5. Follow on-screen instructions to play.

---

## Example Game Play

```
   0   1   2
0    |   |  
  ---+---+---
1    |   |  
  ---+---+---
2    |   |  

Player X, enter your move (row and column): 0 0

   0   1   2
0  X |   |  
  ---+---+---
1    |   |  
  ---+---+---
2    |   |  

Player O, enter your move (row and column): 1 1
...
Player X wins! 🎉
```

---

## License

This project is **free to use and modify**.
Ideal for learning and practice.
