package me.landervanlaer.games.ticTacToe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Game extends Application {
    public static char[] PLAYER_CHAR = new char[]{'X', 'O'};
    private static boolean playerTurn1 = true;
    private static String text = "";


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tic Tac Toe");
        Parent root = FXMLLoader.load(this.getClass().getResource("GameLayout.fxml"));
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void clickButton(Button btn, int[] pos) {
        if(btn.getText().equals(""))
            btn.setText(String.valueOf(PLAYER_CHAR[playerTurn1 ? 0 : 1]));
        playerTurn1 = !playerTurn1;
    }

    /**
     * see if anyone won
     *
     * @param buttons the button grid to validate
     */
    public static void validate(Button[][] buttons) {

        for(int i = 0; i < 3; i++) {
            if(!buttons[i][0].getText().equals("") && buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][1].getText().equals(buttons[i][2].getText())) {
                playerWon(buttons[i][0].getText().charAt(0));
                return;
            }
            if(!buttons[0][i].getText().equals("") && buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[1][i].getText().equals(buttons[2][i].getText())) {
                playerWon(buttons[0][i].getText().charAt(0));
                return;
            }
        }

        if(!buttons[1][1].getText().equals("") &&
                ((buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText())) ||
                        (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText())))) {

            playerWon(buttons[1][1].getText().charAt(0));
        }
    }

    private static void playerWon(char player) {
        Game.setText("Player " + (new String(PLAYER_CHAR).indexOf(player) + 1) + " won!");
    }

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        Game.text = text;
        System.out.println(Game.getText());
    }
}
