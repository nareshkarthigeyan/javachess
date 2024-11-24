package main;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import pieces.*;

public class Board extends JPanel {
    public int tileSize = 85;
    int cols = 8, rows = 8;
    final int layoutSize = (tileSize * cols) + tileSize;

    Input input = new Input(this);

    ArrayList<Piece> piecesList = new ArrayList<>();

    public Piece selectedPiece;

    public Board() {
        this.setPreferredSize(new Dimension(cols*tileSize, rows*tileSize));
        this.setBackground(Color.GREEN);
        this.addMouseListener(input);
        this.addMouseMotionListener(input);
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

    public Piece getPiece(int col, int row){
        for(Piece p: piecesList){
            if(p.row == row && p.col == col){
                return p;
            }
        }
        return null;
    }

    public boolean isValidMove(Move move){
        //TODO
        if(sameTeam(move.piece, move.capture)) return false;
        return true;
    }

    public void makeMove(Move move){
        move.piece.col = move.newCol;
        move.piece.row = move.newRow;
        move.piece.xPos = move.newCol * tileSize;
        move.piece.yPos = move.newRow * tileSize;

        capture(move);
    }

    public void capture(Move move){
        piecesList.remove(move.capture);
    }

    public boolean sameTeam(Piece p1, Piece p2){
        if(p1 == null || p2 == null){ return false; }
        return p1.isWhite == p2.isWhite;
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
