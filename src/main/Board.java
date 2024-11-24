package main;

import pieces.*;

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
        // Black pieces
        piecesList.add(new Knight(this, 1, 0, false));
        piecesList.add(new Knight(this, 6, 0, false));

        piecesList.add(new Bishop(this, 2, 0, false));
        piecesList.add(new Bishop(this, 5, 0, false));

        piecesList.add(new Rook(this, 0, 0, false));
        piecesList.add(new Rook(this, 7, 0, false));

        piecesList.add(new Queen(this, 3, 0, false));
        piecesList.add(new King(this, 4, 0, false));

        piecesList.add(new Pawn(this, 0, 1, false));
        piecesList.add(new Pawn(this, 1, 1, false));
        piecesList.add(new Pawn(this, 2, 1, false));
        piecesList.add(new Pawn(this, 3, 1, false));
        piecesList.add(new Pawn(this, 4, 1, false));
        piecesList.add(new Pawn(this, 5, 1, false));
        piecesList.add(new Pawn(this, 6, 1, false));
        piecesList.add(new Pawn(this, 7, 1, false));

        // White pieces
        piecesList.add(new Knight(this, 1, 7, true));
        piecesList.add(new Knight(this, 6, 7, true));

        piecesList.add(new Bishop(this, 2, 7, true));
        piecesList.add(new Bishop(this, 5, 7, true));

        piecesList.add(new Rook(this, 0, 7, true));
        piecesList.add(new Rook(this, 7, 7, true));

        piecesList.add(new Queen(this, 3, 7, true));
        piecesList.add(new King(this, 4, 7, true));

        piecesList.add(new Pawn(this, 0, 6, true));
        piecesList.add(new Pawn(this, 1, 6, true));
        piecesList.add(new Pawn(this, 2, 6, true));
        piecesList.add(new Pawn(this, 3, 6, true));
        piecesList.add(new Pawn(this, 4, 6, true));
        piecesList.add(new Pawn(this, 5, 6, true));
        piecesList.add(new Pawn(this, 6, 6, true));
        piecesList.add(new Pawn(this, 7, 6, true));
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
