package e2;

import e2.logics.Logics;
import e2.logics.LogicsImpl;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.util.*;
import java.util.Map.Entry;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {

    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton, Pair<Integer, Integer>> buttons = new HashMap<>();
    private final Logics logics;

    public GUI(int size) {
        this.logics = new LogicsImpl(size);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100 * size, 100 * size);

        JPanel panel = new JPanel(new GridLayout(size, size));
        this.getContentPane().add(BorderLayout.CENTER, panel);

        ActionListener onClick = (e) -> {
            final JButton bt = (JButton) e.getSource();
            final Pair<Integer, Integer> pos = buttons.get(bt);
            this.logics.hit(pos);
            boolean aMineWasFound = this.logics.isMine(pos); // call the logic here to tell it that cell at 'pos' has been seleced
            if (aMineWasFound) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You lost!!");
            } else {
                drawBoard();
            }
            boolean isThereVictory = this.logics.isThereVictory(); // call the logic here to ask if there is victory
            if (isThereVictory) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You won!!");
                System.exit(0);
            }
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton) e.getSource();
                if (bt.isEnabled()) {
                    final Pair<Integer, Integer> pos = buttons.get(bt);
                    // call the logic here to put/remove a flag
                    logics.toggleFlag(pos);
                }
                drawBoard();
            }
        };

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb, new Pair<>(i, j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }

    private void quitGame() {
        this.drawBoard();
        for (Entry<JButton, Pair<Integer, Integer>> entry : this.buttons.entrySet()) {
            // call the logic here
            // if this button is a mine, draw it "*"
            // disable the button
            if (this.logics.isMine(entry.getValue())) {
                entry.getKey().setText("*");
            }
            entry.getKey().setEnabled(false);
        }
    }

    private void drawBoard() {
        for (Entry<JButton, Pair<Integer, Integer>> entry : this.buttons.entrySet()) {
            // call the logic here
            // if this button is a cell with counter, put the number
            // if this button has a flag, put the flag
            if (this.logics.isHitted(entry.getValue())) {
                entry.getKey().setEnabled(false);
                entry.getKey().setText(String.valueOf(this.logics.getCellNearbyMines(entry.getValue())));
            } else if (this.logics.isFlagged(entry.getValue())) {
                entry.getKey().setText("F");
            } else {
                entry.getKey().setText("");
            }
        }
    }

}
