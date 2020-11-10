package me.landervanlaer.algorithms.aStarSearch.javaFx;

import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;

public class Build {
    public Spinner<Integer> widthSpinner;
    public Spinner<Integer> heightSpinner;
    public Spinner<Integer> cellWidthSpinner;
    public GridPane gridPane;
    private GridFx grid;

    public void initialize() {
        widthSpinner.valueProperty().addListener(this::changeWidth);
        heightSpinner.valueProperty().addListener(this::changeHeight);
        cellWidthSpinner.valueProperty().addListener(this::changeCellWidth);

        grid = new GridFx(gridPane, widthSpinner.getValue(), heightSpinner.getValue());

        changeCellWidth(null);
    }

    private void changeWidth(Observable observable) {
        grid.setWidth(widthSpinner.getValue());
        changeCellWidth(null);
    }

    private void changeHeight(Observable observable) {
        grid.setHeight(heightSpinner.getValue());
        changeCellWidth(null);
    }

    private void changeCellWidth(Observable observable) {
        grid.changeCellSize(cellWidthSpinner.getValue());
    }

    public void start(ActionEvent event) {
        grid.start();
    }

    public void clearField(ActionEvent event) {
        grid.clear();
    }

    public void setStartPoint(ActionEvent event) {
        grid.setSelectingEndPoint(false);
        grid.setSelectingStartPoint(true);
    }

    public void setEndPoint(ActionEvent event) {
        grid.setSelectingStartPoint(false);
        grid.setSelectingEndPoint(true);
    }
}
