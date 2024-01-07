import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private JFrame frame;
    private JButton[][] buttons;
    private JLabel turnLabel;

    public View(int size) {
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(size, size));
        buttons = new JButton[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                buttons[x][y] = new JButton(" ");
                buttons[x][y].setPreferredSize(new Dimension(50, 50));
                boardPanel.add(buttons[x][y]);
            }
        }

        JPanel infoPanel = new JPanel(); //fixar all info, vems tur det är osv
        turnLabel = new JLabel("Player 1's turn", SwingConstants.CENTER);
        infoPanel.add(turnLabel);

        mainPanel.add(boardPanel, BorderLayout.CENTER);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public void setTurnLabel(String text) {
        turnLabel.setText(text);
    }

    public void setButtonLabel(int x, int y, char label) {
        buttons[x][y].setText(String.valueOf(label));
    }

    public void addButtonListener(ActionListener listener, int x, int y) {
        buttons[x][y].addActionListener(listener);
    }
}
