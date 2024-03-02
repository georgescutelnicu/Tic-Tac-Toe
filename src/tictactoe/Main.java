package tictactoe;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import tictactoe.game.TicTacToe;
import tictactoe.ui.UserInterface;


public class Main extends Application {
    @Override
    public void start(Stage window) {
        TicTacToe game = new TicTacToe();
        UserInterface ui = new UserInterface(game);

        BorderPane layout = ui.createUI();
        Scene scene = new Scene(layout);

        window.getIcons().add(new Image("tictactoe/ui/icon.png"));
        window.setTitle("Tic Tac Toe");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
