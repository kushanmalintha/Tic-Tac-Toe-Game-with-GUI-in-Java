public class tictactoeGame {

    // Main method to start the game
    public static void main(String[] args) {
        startGame();
    }

    // Method to initialize and start the game
    public static void startGame() {
        // Create the model
        tictactoeModel model = new tictactoeModel();
        // Create the view
        tictactoeView view = new tictactoeView();
        // Create the controller with the model and view
        tictactoeController controller = new tictactoeController(model, view);
    }
}
