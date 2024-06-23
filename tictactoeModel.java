public class tictactoeModel {

    // The board of the game, initialized to a 3x3 grid
    char[][] board = new char[3][3];
    // The current player, '1' or '2'
    char currentPlayer = '1';
    // Flags to indicate if the game is over or drawn
    boolean gameOver = false;
    boolean gameDraw = false;

    // Constructor to initialize the board
    tictactoeModel() {
        // Loop through each cell of the board and set it to '-'
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Method to check if a move can be made
    public boolean canMove(int row, int col) {
        // Check if the cell is empty and the game is not over or drawn
        if (board[row][col] == '-' && !gameOver && !gameDraw) {
            // Place the current player's mark on the board
            board[row][col] = currentPlayer;

            // Check if the current move wins the game
            if (checkWin(row, col)) {
                gameOver = true;
                // Check if the game is drawn
            } else if (checkDraw()) {
                gameDraw = true;
            } else {
                // Switch to the other player
                currentPlayer = (currentPlayer == '1') ? '2' : '1';
            }
            return true;
        }
        return false;
    }

    // Method to check if the current player has won
    public boolean checkWin(int row, int col) {
        // Check if the current player has a complete row
        boolean win = true;
        for (int i = 0; i < 3; i++) {
            if (board[row][i] != currentPlayer) {
                win = false;
                break;
            }
        }
        if (win)
            return true;

        // Check if the current player has a complete column
        win = true;
        for (int i = 0; i < 3; i++) {
            if (board[i][col] != currentPlayer) {
                win = false;
                break;
            }
        }
        if (win)
            return true;

        // Check if the current player has a complete diagonal (top-left to
        // bottom-right)
        if (row == col) {
            win = true;
            for (int i = 0; i < 3; i++) {
                if (board[i][i] != currentPlayer) {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
        }

        // Check if the current player has a complete diagonal (top-right to
        // bottom-left)
        if (row + col == 2) {
            win = true;
            for (int i = 0; i < 3; i++) {
                if (board[i][2 - i] != currentPlayer) {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
        }

        return false;
    }

    // Method to check if the game is a draw
    public boolean checkDraw() {
        // Loop through each cell to check if all are filled
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to get the current player
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    // Method to check if the game is over
    public boolean isGameOver() {
        return gameOver;
    }

    // Method to check if the game is a draw
    public boolean isGameDraw() {
        return gameDraw;
    }
}
