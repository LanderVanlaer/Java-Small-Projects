package me.landervanlaer.algorithms.aStarSearch;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    protected static AbstractGrid<? extends Cell> GRID;
    private boolean available = true;
    private int x;
    private int y;
    private int g_cost = Integer.MAX_VALUE;
    private Cell previousPathCell = null;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getF_cost() {
        return getG_cost() + getH_cost();
    }

    public Cell getPreviousPathCell() {
        return previousPathCell;
    }

    public void setPreviousPathCell(Cell previousPathCell) {
        this.previousPathCell = previousPathCell;
    }

    public int getH_cost() {
        return (int) Math.hypot(getX() + GRID.getEnd().getX(), getY() + GRID.getEnd().getY()) * 10;
    }

    public int getG_cost() {
        return g_cost;
    }

    public void setG_cost(int g_cost) {
        this.g_cost = g_cost;
    }

    public List<Cell> getNeighbours() {
        List<Cell> list = new ArrayList<>();
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(i != 0 || j != 0) {
                    final int x = getX() + i;
                    final int y = getY() + j;
                    if(x >= 0 && x < GRID.getWidth() && y >= 0 && y < GRID.getHeight())
                        list.add(GRID.get(x, y));
                }
            }
        }
        return list;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void reset() {
        this.setG_cost(Integer.MAX_VALUE);
        this.setPreviousPathCell(null);
        setAvailable(true);
    }
}
