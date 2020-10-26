package me.landervanlaer.games.sudoku;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sudoku");

        GridPane pane = new GridPane();

        Grid grid = new Grid(pane);

        Scene scene = new Scene(pane);
        scene.getStylesheets().add("me/landervanlaer/games/sudoku/style.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
