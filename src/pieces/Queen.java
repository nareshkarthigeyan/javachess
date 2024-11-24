package pieces;

import main.Board;

public class Queen extends Piece {
    public Queen(Board board, int col, int row, boolean isWhite) {
        super(board, col, row, isWhite, 1);
        this.name = "Queen";
    }
}
