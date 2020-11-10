package me.landervanlaer.algorithms.aStarSearch.javaFx;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import me.landervanlaer.algorithms.aStarSearch.Cell;

public class CellFx extends Cell {
    private static final String NOT_AVAILABLE_CLASSNAME = "not-available";
    private final Button button = new Button();

    public CellFx(int x, int y) {
        super(x, y);
    }

    public void initialize() {
        getButton().setOnMouseClicked(this::click);

        this.button.setOnMouseEntered(this::hover);
    }

    private void click(MouseEvent mouseEvent) {
        final GridFx grid = ((GridFx) GRID);
        if(grid.isSelectingEndPoint())
            grid.setEnd(this);
        else if(grid.isSelectingStartPoint())
            grid.setStart(this);
        else toggleAvailable();
    }

    public void toggleAvailable() {
        setAvailable(!isAvailable());
    }

    @Override
    public void setAvailable(boolean available) {
        if(this.isAvailable() == available) return;
        super.setAvailable(available);

        if(available)
            getButton().getStyleClass().remove(NOT_AVAILABLE_CLASSNAME);
        else
            getButton().getStyleClass().add(NOT_AVAILABLE_CLASSNAME);

    }

    public Button getButton() {
        return button;
    }

    @Override
    public void reset() {
        super.reset();
        this.getButton().getStyleClass().clear();
    }

    private void hover(MouseEvent e) {
        if(e.isShiftDown()) setAvailable(false);
        else if(e.isAltDown()) setAvailable(true);
    }
}
