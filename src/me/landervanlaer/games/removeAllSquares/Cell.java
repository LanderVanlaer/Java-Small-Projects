package me.landervanlaer.games.removeAllSquares;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Cell {
    public static final String ACTIVE_CLASS_NAME = "active";
    private final Button button;
    private final int x;
    private final int y;
    private final Cell[][] cells;
    private boolean active = false;

    public Cell(Cell[][] cells, Button button, int x, int y, boolean active) {
        this(cells, button, x, y);
        this.active = active;
    }

    public Cell(Cell[][] cells, Button button, int x, int y) {
        this.cells = cells;
        this.button = button;
        this.x = x;
        this.y = y;

        this.button.setOnAction(this::click);
    }

    private void click(ActionEvent event) {
        toggleActive();
        toggleButton(x - 1, y);
        toggleButton(x + 1, y);
        toggleButton(x, y - 1);
        toggleButton(x, y + 1);
    }

    private void toggleButton(int x, int y) {
        if(x >= 0 && x < cells.length && y >= 0 && y < cells[x].length)
            cells[x][y].toggleActive();
    }

    public void toggleActive() {
        this.setActive(!this.isActive());
    }

    public void update() {
        if(isActive())
            this.button.getStyleClass().add(ACTIVE_CLASS_NAME);
        else
            this.button.getStyleClass().remove(ACTIVE_CLASS_NAME);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        update();
    }
}
