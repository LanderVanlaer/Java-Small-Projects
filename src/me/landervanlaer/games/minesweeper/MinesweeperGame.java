package me.landervanlaer.games.minesweeper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import me.landervanlaer.math.grids.ArrayGrid2DIntegers;

public class MinesweeperGame extends Application {
    static final int CELLS_HEIGT = 10;
    static final int CELLS_WIDTH = 15;

    private GridPane gridPane;
    private ArrayGrid2DIntegers intGrid = new ArrayGrid2DIntegers(CELLS_WIDTH, CELLS_HEIGT);

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Minesweeper");
        primaryStage.setResizable(true);
        primaryStage.setHeight(800);
        primaryStage.setWidth(1200);


        this.setGridPane(new GridPane());

        intGrid.setGrid(new int[][]{
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8}});

        final int SCALE = (int) Math.min(primaryStage.getWidth() / intGrid.getWidth(), primaryStage.getHeight() / intGrid.getHeight());

        intGrid.forEach((ints, value) -> {
            Button b = new Button(String.valueOf(value));
            b.setPrefWidth(SCALE);
            b.setPrefHeight(SCALE);
            gridPane.add(b, ints[0], ints[1]);
        });
        primaryStage.setScene(new Scene(this.getGridPane(), primaryStage.getWidth(), primaryStage.getHeight()));
        primaryStage.show();
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }
}