package me.landervanlaer.algorithms.aStarSearch.javaFx;

import javafx.scene.layout.GridPane;
import me.landervanlaer.algorithms.aStarSearch.AbstractGrid;

import java.util.ArrayList;

public class GridFx extends AbstractGrid<CellFx> {
    private final GridPane gridPane;
    private boolean selectingStartPoint = false;
    private boolean selectingEndPoint = false;

    public GridFx(GridPane gridPane, int width, int height) {
        super();
        this.gridPane = gridPane;
        for(int i = 0; i < width; i++) {
            getCells().add(new ArrayList<>());

            for(int j = 0; j < height; j++) {
                getCells().get(i).add(new CellFx(i, j));
            }
        }
    }

    @Override
    public CellFx start(int x, int y) {
        final CellFx endCell = super.start(x, y);
        if(endCell == null) return null;
        CellFx c = endCell;
        while(c != null) {
            c.getButton().getStyleClass().add("path");
            c = (CellFx) c.getPreviousPathCell();
        }
        return endCell;
    }

    public void show() {
        getGridPane().getChildren().clear();
        for(int i = 0; i < super.getWidth(); i++) {
            for(int j = 0; j < super.getHeight(); j++) {
                final CellFx cell = get(i, j);
                cell.initialize();
                getGridPane().add(cell.getButton(), i, j);
            }
        }
    }

    @Override
    public void setEnd(CellFx end) {
        setSelectingEndPoint(false);
        if(getEnd() != null)
            this.getEnd().getButton().getStyleClass().remove("end");
        super.setEnd(end);
        if(getEnd() != null)
            this.getEnd().getButton().getStyleClass().add("end");
    }

    @Override
    public void setStart(CellFx start) {
        setSelectingStartPoint(false);
        if(getStart() != null)
            this.getStart().getButton().getStyleClass().remove("start");
        super.setStart(start);
        if(getStart() != null)
            this.getStart().getButton().getStyleClass().add("start");
    }

    @Override
    public void setWidth(int width) {
        if(width < getWidth()) {
            getCells().subList(width, getWidth()).clear();
        } else {
            while(getWidth() < width) {
                getCells().add(new ArrayList<>());

                for(int j = 0; j < getHeight(); j++) {
                    getCells().get(getWidth() - 1).add(new CellFx(getWidth() - 1, j));
                }
            }
        }
        this.show();
    }

    @Override
    public void setHeight(int height) {
        if(getHeight() < height) {
            while(getHeight() < height) {
                final int currentHeight = getHeight();
                for(int i = 0; i < getCells().size(); i++)
                    getCells().get(i).add(new CellFx(i, currentHeight));
            }
        } else {
            for(ArrayList<CellFx> list : getCells()) {
                list.subList(height, list.size()).clear();
            }
        }
        this.show();
    }

    @Override
    public CellFx start() {
        try {
            return super.start();
        } catch(NullPointerException e) {
            return null;
        }
    }

    @Override
    public void clear() {
        this.setEnd(null);
        this.setStart(null);
        super.clear();
    }

    public void changeCellSize(int s) {
        for(ArrayList<CellFx> list : getCells())
            for(CellFx cell : list)
                cell.getButton().setPrefSize(s, s);
        this.show();
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public boolean isSelectingStartPoint() {
        return selectingStartPoint;
    }

    public void setSelectingStartPoint(boolean selectingStartPoint) {
        this.selectingStartPoint = selectingStartPoint;
    }

    public boolean isSelectingEndPoint() {
        return selectingEndPoint;
    }

    public void setSelectingEndPoint(boolean selectingEndPoint) {
        this.selectingEndPoint = selectingEndPoint;
    }
}
