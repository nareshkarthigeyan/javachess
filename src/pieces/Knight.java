package pieces;

import main.Board;

import java.awt.*;

public class Knight extends Piece{
    public Knight(Board board, int col, int row, boolean isWhite) {
        super(board, col, row, isWhite, 3);
        this.name = "Knight";
    }
}
