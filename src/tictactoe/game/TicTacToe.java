package tictactoe.game;


import javafx.scene.control.Button;
import tictactoe.enums.GameState;
import tictactoe.enums.Player;


public class TicTacToe {
    private Player currentPlayer;
    private GameState currentState;

    public TicTacToe() {
        this.currentPlayer = Player.X;
        this.currentState = GameState.ONGOING;
    }

    public void changeTurn() {
        this.currentPlayer = (this.currentPlayer == Player.X)
                ? Player.O : Player.X;
    }

    public void checkForWin(Button[][] board) {
        this.checkDraw(board);
        this.checkRows(board);
        this.checkColumns(board);
        this.checkDiagonals(board);
    }

    private void checkRows(Button[][] board) {
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].getText().isEmpty() &&
                    board[i][0].getText().equals(board[i][1].getText()) &&
                    board[i][1].getText().equals(board[i][2].getText())) {
                this.currentState = (currentPlayer == Player.X)
                        ? GameState.X_WINS : GameState.O_WINS;
            }
        }
    }

    private void checkColumns(Button[][] board) {
        for (int j = 0; j < 3; j++) {
            if (!board[0][j].getText().isEmpty() &&
                    board[0][j].getText().equals(board[1][j].getText()) &&
                    board[1][j].getText().equals(board[2][j].getText())) {
                this.currentState = (currentPlayer == Player.X)
                        ? GameState.X_WINS : GameState.O_WINS;
            }
        }
    }

    private void checkDiagonals(Button[][] board) {
        if (!board[0][0].getText().isEmpty() &&
                board[0][0].getText().equals(board[1][1].getText()) &&
                board[1][1].getText().equals(board[2][2].getText())) {
            this.currentState = (currentPlayer == Player.X)
                    ? GameState.X_WINS : GameState.O_WINS;
        }
        if (!board[0][2].getText().isEmpty() &&
                board[0][2].getText().equals(board[1][1].getText()) &&
                board[1][1].getText().equals(board[2][0].getText())) {
            this.currentState = (currentPlayer == Player.X)
                    ? GameState.X_WINS : GameState.O_WINS;
        }
    }

    private void checkDraw(Button[][] board) {
        boolean isDraw = true;
        for (Button[] row : board) {
            for (Button button : row) {
                if (button.getText().isEmpty()) {
                    isDraw = false;
                    break;
                }
            }
        }
        if (isDraw) {
            this.currentState = GameState.DRAW;
        }
    }

    public void disableButtons(Button[][] board) {
        for (Button[] row : board) {
            for (Button button : row) {
                button.setDisable(true);
            }
        }
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

}
