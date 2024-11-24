package main;

import pieces.Knight;
import pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    public int tileSize = 85;
    int cols = 8, rows = 8;
    final int layoutSize = (tileSize * cols) + tileSize;


    ArrayList<Piece> piecesList = new ArrayList<>();

    public Board() {
        this.setPreferredSize(new Dimension(cols*tileSize, rows*tileSize));
        this.setBackground(Color.GREEN);
        addPieces();
    }

    public void addPieces(){
        piecesList.add(new Knight(this, 4, 5, false));
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                g2d.setColor((c + r) % 2 == 0 ? Color.lightGray : Color.darkGray);
                g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
            }
        }

        for(Piece piece : piecesList) {
            piece.paint(g2d);
        }
    }
}
