import javax.swing.*;
import java.awt.*;

public class TTTFrame extends JFrame {
    private TTTTileButton[][] buttons;
    private Game game;
    private static final int SIZE = 3;

    public TTTFrame(Game game) {
        this.game = game;
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));

        buttons = new TTTTileButton[SIZE][SIZE];
        initializeButtons();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new TTTTileButton(i, j);
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(e -> game.makeMove(row, col));
                add(buttons[i][j]);
            }
        }
    }

    public void updateButton(int row, int col, String symbol) {
        buttons[row][col].setText(symbol);
        buttons[row][col].setEnabled(false);
    }

    public void resetButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
    }
}
