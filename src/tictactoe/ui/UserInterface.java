package tictactoe.ui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import tictactoe.game.TicTacToe;

import tictactoe.enums.GameState;


public class UserInterface {
    private final Button[][] board;
    private final TicTacToe game;

    public UserInterface(TicTacToe game) {
        this.board = new Button[3][3];
        this.game = game;
    }

    public BorderPane createUI() {
        BorderPane layout = new BorderPane();
        layout.setPrefSize(320, 370);

        Label turn = new Label("Turn: X");
        turn.setFont(Font.font("Monospaced", 25));
        BorderPane.setMargin(turn, new Insets(0, 0, 20, 0));
        BorderPane.setAlignment(turn, Pos.CENTER);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        layout.setTop(turn);
        layout.setCenter(grid);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                Button btn = new Button("");
                btn.setFont(Font.font("Monospaced", 40));
                btn.setPrefSize(100, 100);
                board[i][j] = btn;
                grid.add(btn, i, j);

                btn.setOnAction((e) -> {
                    Button clickedButton = (Button) e.getSource();
                    if (!clickedButton.getText().isEmpty()){
                        return;
                    }

                    clickedButton.setText(game.getCurrentPlayer().toString());

                    game.checkForWin(board);

                    if (game.getCurrentState() == GameState.ONGOING) {
                        game.changeTurn();
                    } else {
                        turn.setText(game.getCurrentState().toString());
                        game.disableButtons(board);
                        return;
                    }

                    turn.setText("Turn: " + game.getCurrentPlayer().toString());

                });
            }
        }

        return layout;
    }
}