public class Board {
    private String[][] grid;
    private static final int SIZE = 3;

    public Board() {
        grid = new String[SIZE][SIZE];
        reset();
    }

    public void reset() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = "";
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return grid[row][col].equals("");
    }

    public void makeMove(int row, int col, String symbol) {
        grid[row][col] = symbol;
    }

    public boolean checkWin() {
        // Check rows
        for (int i = 0; i < SIZE; i++) {
            if (!grid[i][0].equals("") &&
                    grid[i][0].equals(grid[i][1]) &&
                    grid[i][0].equals(grid[i][2])) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < SIZE; j++) {
            if (!grid[0][j].equals("") &&
                    grid[0][j].equals(grid[1][j]) &&
                    grid[0][j].equals(grid[2][j])) {
                return true;
            }
        }

        // Check diagonals
        if (!grid[0][0].equals("") &&
                grid[0][0].equals(grid[1][1]) &&
                grid[0][0].equals(grid[2][2])) {
            return true;
        }

        if (!grid[0][2].equals("") &&
                grid[0][2].equals(grid[1][1]) &&
                grid[0][2].equals(grid[2][0])) {
            return true;
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }
}