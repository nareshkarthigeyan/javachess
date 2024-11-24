package pieces;
import main.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Piece {
    public int col, row;
    public int xPos, yPos;

    public boolean isWhite;
    public String name;
    public int value;

    protected int sheetScale;

    BufferedImage sheet;


    Image sprite;
    Board board;
    public Piece(Board board, int col, int row, boolean isWhite, int imageCol){
        this.board = board;
        this.col = col;
        this.row = row;
        this.isWhite = isWhite;
        {
            try {
                sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces.png"));
                sheetScale = sheet.getWidth() / 6;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        setPosition(col, row, imageCol);
    }

    public void setPosition(int col, int row, int imageCol){
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;

        int spriteRow = isWhite ? 0 : 1;
        int spriteCol = imageCol;
        sprite = sheet.getSubimage(spriteCol * sheetScale, spriteRow * sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize, board.tileSize, Image.SCALE_SMOOTH);

    }

    public void paint(Graphics g2d){
        g2d.drawImage(sprite, xPos, yPos, null);
    }
}
