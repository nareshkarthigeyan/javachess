package main;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    int tileSize = 85;
    int cols = 8, rows = 8;
    final int layoutSize = (tileSize * cols) + tileSize;

    public Board() {
        this.setPreferredSize(new Dimension(cols*tileSize, rows*tileSize));
        this.setBackground(Color.GREEN);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                g2d.setColor((c + r) % 2 == 0 ? Color.WHITE : Color.BLACK);
                g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
            }
        }
    }
}
