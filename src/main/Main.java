package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Naresh");
        frame.setVisible(true);

        Board board = new Board();
        frame.setLayout(new GridBagLayout());
        frame.setMinimumSize(new Dimension(board.layoutSize, board.layoutSize));
        frame.setLocationRelativeTo(null);

        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
    }
}