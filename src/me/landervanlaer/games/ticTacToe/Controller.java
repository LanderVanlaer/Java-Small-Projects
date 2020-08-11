package me.landervanlaer.games.ticTacToe;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    private Button[][] buttons;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button1.setText("nen");
        buttons = new Button[][]{
                {button1, button4, button7},
                {button2, button5, button8},
                {button3, button6, button9}
        };

        for(int i = 0; i < buttons.length; i++)
            for(int j = 0; j < buttons[0].length; j++) {
                final Button button = buttons[i][j];
//                button.setText(String.valueOf((i + 1) + j * 3));
                button.setText("");

                button.setOnMouseClicked((MouseEvent e) -> {
                    pressButton(button);
                });
            }
    }

    /**
     * A method that handles a {{@link MouseEvent}}
     *
     * @param button The button that has been pressed
     */
    public void pressButton(Button button) {
        final int[] pos = this.getIndexOfButton(button);
        if(pos == null) return;
        Game.clickButton(button, pos);
        Game.validate(buttons);
    }

    /**
     * Get the x and y position of a button
     *
     * @param btn The button whose position you need
     * @return The position
     */
    public int[] getIndexOfButton(Button btn) {
        for(int i = 0; i < buttons.length; i++)
            for(int j = 0; j < buttons[0].length; j++) {
                if(buttons[i][j] == btn) return new int[]{i, j};
            }
        return null;
    }
}
