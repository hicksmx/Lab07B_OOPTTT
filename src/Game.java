import javax.swing.*;
import java.awt.*;

public class Game {
    private Board board;
    private TTTFrame frame;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private boolean gameOver;

    public Game() {
        board = new Board();
        player1 = new Player("X");
        player2 = new Player("O");
        currentPlayer = player1;
        frame = new TTTFrame(this);
        gameOver = false;
    }

    public void makeMove(int row, int col) {
        if (!gameOver && board.isValidMove(row, col)) {
            board.makeMove(row, col, currentPlayer.getSymbol());
            frame.updateButton(row, col, currentPlayer.getSymbol());

            if (board.checkWin()) {
                gameOver = true;
                String message = "Player " + currentPlayer.getSymbol() + " wins!";
                showResultAndReset(message);
            } else if (board.isBoardFull()) {
                gameOver = true;
                showResultAndReset("It's a draw!");
            } else {
                switchPlayer();
            }
        }
    }

    private void showResultAndReset(String message) {
        // Use Timer to add delay between showing message and resetting
        Timer timer = new Timer(1000, e -> {
            JOptionPane.showMessageDialog(frame, message);
            resetGame();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void resetGame() {
        board.reset();
        frame.resetButtons();
        currentPlayer = player1;
        gameOver = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game());
    }
}