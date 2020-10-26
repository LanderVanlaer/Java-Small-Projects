package me.landervanlaer.games.sudoku;

import javafx.scene.control.Label;
import me.landervanlaer.math.Coordinate;

public class Cell {
    public final Coordinate pos;
    private final Label label;
    private final boolean FIXED;
    private int number;

    public Cell(Label label, int number, Coordinate pos) {
        this(label, number, pos, false);
    }

    public Cell(Label label, int number, Coordinate pos, boolean FIXED) {
        this.number = number;
        this.label = label;
        this.FIXED = FIXED;
        this.pos = pos;
        this.getLabel().setPrefWidth(20);
        this.getLabel().setPrefHeight(20);
        draw();
    }

    public void draw() {
        getLabel().setText(getNumber() == 0 ? null : String.valueOf(getNumber()));
    }

    public Label getLabel() {
        return label;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        draw();
    }

    public boolean isFIXED() {
        return FIXED;
    }
}
