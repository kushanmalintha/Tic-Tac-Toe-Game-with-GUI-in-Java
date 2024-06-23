import java.awt.*;
import javax.swing.*;

public class tictactoeView extends JFrame {

    // Create a 2D array of buttons for the tic-tac-toe grid
    JButton[][] buttons = new JButton[3][3];

    // Buttons for replaying the game and closing the result dialog
    JButton Replay = new JButton();
    JButton close = new JButton();

    // Dialog to display game results
    JDialog resultDialog;

    // Constructor to set up the view
    tictactoeView() {

        // Set the title of the JFrame
        this.setTitle("Tic Tac Toe");
        // Set the layout to a 3x3 grid
        this.setLayout(new GridLayout(3, 3));
        // Set the size of the JFrame
        this.setSize(600, 600);
        // Set the default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the buttons and add them to the JFrame
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("-");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                this.add(buttons[i][j]);
            }
        }

        // Make the JFrame visible
        this.setVisible(true);
    }

    // Method to update the text of a button to reflect the player's move
    public void updateButton(int row, int col, char player) {
        buttons[row][col].setText(String.valueOf(player));
        buttons[row][col].setFont(new Font("Arial", Font.BOLD, 40));
    }

    // Method to get a specific button from the grid
    public JButton getButton(int row, int col) {
        return buttons[row][col];
    }

    // Method to display the result dialog with a message
    public void result(String msg) {

        // Create and set up the result dialog
        resultDialog = new JDialog();
        resultDialog.setSize(300, 300);
        resultDialog.setLayout(new GridLayout(3, 1));

        // Create a label to display the message
        JLabel label = new JLabel();
        label.setText(msg);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        // Set up the Replay button
        Replay.setText("Replay");
        Replay.setFont(new Font("Arial", Font.BOLD, 20));

        // Set up the Close button
        close.setText("Close");
        close.setFont(new Font("Arial", Font.BOLD, 20));

        // Add the label and buttons to the result dialog
        resultDialog.add(label);
        resultDialog.add(Replay);
        resultDialog.add(close);

        // Make the result dialog visible
        resultDialog.setVisible(true);
    }

    // Method to get the replay button
    public JButton replayButton() {
        return Replay;
    }

    // Method to get the close button
    public JButton closeButton() {
        return close;
    }

    // Method to close the result dialog
    public void closeResultDialog() {
        if (resultDialog != null) {
            resultDialog.setVisible(false);
        }
    }
}
