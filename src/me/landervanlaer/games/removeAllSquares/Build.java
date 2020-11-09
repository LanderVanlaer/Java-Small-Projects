package me.landervanlaer.games.removeAllSquares;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Build {
    private Cell[][] cells;
    @FXML
    private GridPane pane;

    public void initialize() {
        cells = new Cell[pane.getColumnCount()][pane.getRowCount()];
        int i = 0;

        for(Node node : pane.getChildren())
            if(node instanceof Button) {
                final int X = i % cells.length;
                final int Y = i / cells[0].length;

                cells[X][Y] =
                        new Cell(cells, (Button) node, X, Y);
                ++i;
            }

        final int halfX = cells.length / 2 - 1;
        final int halfY = cells[0].length / 2 - 1;

        cells[halfX][halfY].setActive(true);
        cells[halfX + 1][halfY].setActive(true);
        cells[halfX][halfY + 1].setActive(true);
        cells[halfX + 1][halfY + 1].setActive(true);
    }
}
