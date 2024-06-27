package TictacToeUsingcomputer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToee implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToee() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("Computer turn");
                        if (hasWon('X')) {
                            humanWins();
                        } else if (!isBoardFull()) {
                            computerMove();
                        }
                    }
                }
            }
        }
    }

    public void firstTurn() {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        textfield.setText("Computer turn");
        player1_turn = false;
        computerMove();
    }

    public void computerMove() {
        int move = -1;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                move = i;
                break;
            }
        }
        if (move != -1) {
            buttons[move].setForeground(new Color(0, 0, 255));
            buttons[move].setText("O");
            player1_turn = true;
            textfield.setText("Human turn");
            if (hasWon('O')) {
                computerWins();
            }
        }
    }

    public boolean hasWon(char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (buttons[i * 3].getText().equals(String.valueOf(player)) &&
                buttons[i * 3 + 1].getText().equals(String.valueOf(player)) &&
                buttons[i * 3 + 2].getText().equals(String.valueOf(player))) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(String.valueOf(player)) &&
                buttons[i + 3].getText().equals(String.valueOf(player)) &&
                buttons[i + 6].getText().equals(String.valueOf(player))) {
                return true;
            }
        }
        // Check diagonals
        if (buttons[0].getText().equals(String.valueOf(player)) &&
            buttons[4].getText().equals(String.valueOf(player)) &&
            buttons[8].getText().equals(String.valueOf(player))) {
            return true;
        }
        if (buttons[2].getText().equals(String.valueOf(player)) &&
            buttons[4].getText().equals(String.valueOf(player)) &&
            buttons[6].getText().equals(String.valueOf(player))) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    public void humanWins() {
        textfield.setText("Human wins!");
        disableButtons();
    }

    public void computerWins() {
        textfield.setText("Computer wins!");
        disableButtons();
    }

    public void disableButtons() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new TicTacToee();
    }
}
