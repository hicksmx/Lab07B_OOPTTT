import javax.swing.*;
import java.awt.*;

public class TTTTileButton extends JButton {
    private int row;
    private int col;

    public TTTTileButton(int row, int col) {
        this.row = row;
        this.col = col;
        setPreferredSize(new Dimension(100, 100));
        setFont(new Font("Arial", Font.BOLD, 40));
        setFocusPainted(false);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}