import javax.swing.*;
import java.awt.*;

public class MainFram {
    private static void disableButtons(JButton[][] buttons) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(400, 300);

        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        JPanel choosePanel = new JPanel();
        JLabel chooseLabel = new JLabel("Player 1 choose X or O:");
        JTextField chooseField = new JTextField(5);
        JButton chooseButton = new JButton("Choose");
        choosePanel.add(chooseLabel);
        choosePanel.add(chooseField);
        choosePanel.add(chooseButton);

        JPanel gamePanel = new JPanel(new BorderLayout());

        JPanel buttonsPanel = new JPanel(new GridLayout(3, 3));
        JButton[][] buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setFocusPainted(false);
                buttonsPanel.add(buttons[i][j]);
            }
        }

        JLabel gameLabel = new JLabel("", SwingConstants.CENTER);
        gameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        gamePanel.add(buttonsPanel, BorderLayout.CENTER);
        gamePanel.add(gameLabel, BorderLayout.SOUTH);

        cardPanel.add(choosePanel, "choosePanel");
        cardPanel.add(gamePanel, "gamePanel");
        frame.add(cardPanel);

        Game game=new Game();


        chooseButton.addActionListener(e -> {
            String s = chooseField.getText();
            if (s.length() != 1 || (s.charAt(0) != 'X' && s.charAt(0) != 'O')) {
                JOptionPane.showMessageDialog(frame, "Please enter either 'X' or 'O'");
                return;
            }
            char p1 = s.charAt(0);
            char p2 = (p1 == 'X') ? 'O' : 'X';

            gameLabel.setText("Player 1 chose: " );
            cardLayout.show(cardPanel, "gamePanel");
            final boolean[] isPlayer1Turn = {true};
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                 int x=i;
                 int y=j;
                 buttons[x][y].addActionListener(e1 -> {
                     if (!buttons[x][y].getText().isEmpty()) {
                       JOptionPane.showMessageDialog(frame, "This position is already taken. Choose again.");
                       return;
                     }
                     char currentPlayer = isPlayer1Turn[0] ? p1 : p2;
                            game.play(x, y, currentPlayer);
                            buttons[x][y].setText(String.valueOf(currentPlayer));
                            if (game.checkWin(currentPlayer)) {
                                gameLabel.setText("Player " + (isPlayer1Turn[0] ? 1 : 2) + " wins!");
                                disableButtons(buttons);
                            } else if (game.checkDraw()) {
                                gameLabel.setText("It's a draw!");
                                disableButtons(buttons);
                            } else {
                                isPlayer1Turn[0] = !isPlayer1Turn[0];
                                gameLabel.setText("Player " + (isPlayer1Turn[0] ? 1 : 2) + "'s turn: " + (isPlayer1Turn[0] ? p1 : p2));
                            }
                 });
                }
            }
        });

        frame.setVisible(true);
    }
}
