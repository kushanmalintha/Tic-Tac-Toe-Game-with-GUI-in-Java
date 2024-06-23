import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tictactoeController {

    // Model and View components
    tictactoeModel model;
    tictactoeView view;

    // Constructor to initialize the controller
    tictactoeController(tictactoeModel model, tictactoeView view) {

        this.model = model;
        this.view = view;

        // Add action listeners to the buttons on the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i;
                final int col = j;
                view.getButton(row, col).addActionListener(new ActionListener() {

                    // Handle button click events
                    public void actionPerformed(ActionEvent e) {
                        char player = model.getCurrentPlayer();
                        // Check if the move is valid
                        if (model.canMove(row, col)) {
                            // Update the view with the player's move
                            view.updateButton(row, col, player);
                            // Check if the game is over
                            if (model.isGameOver()) {
                                view.result("Game Over! Player " + model.getCurrentPlayer() + " wins!");
                            } else if (model.isGameDraw()) {
                                view.result("Game Draw!");
                            }
                        }
                    }
                });
            }
        }

        // Add action listener to the replay button
        view.replayButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.closeResultDialog();
                view.dispose();
                tictactoeGame.startGame();
            }
        });

        // Add action listener to the close button
        view.closeButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.closeResultDialog();
                view.dispose();
            }
        });
    }
}
