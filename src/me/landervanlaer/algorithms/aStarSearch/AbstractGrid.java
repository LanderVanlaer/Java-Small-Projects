package me.landervanlaer.algorithms.aStarSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractGrid<T extends Cell> {
    private final ArrayList<ArrayList<T>> cells = new ArrayList<>();
    private final LinkedList<T> OPEN = new LinkedList<>();
    private final LinkedList<T> CLOSED = new LinkedList<>();
    private T end;
    private T start;

    @SuppressWarnings("unchecked")
    public AbstractGrid(int width, int height) {
        this();
        for(int i = 0; i < width; i++) {
            cells.add(new ArrayList<>());

            for(int j = 0; j < height; j++) {
                cells.get(i).add((T) new Cell(i, j));
            }
        }
    }

    protected AbstractGrid() {
        T.GRID = this;
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(T end) {
        this.end = end;
    }

    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        this.start = start;
    }

    public void setEnd(int x, int y) {
        setEnd(get(x, y));
    }

    private T getCellWithLowestF_Cost() {
        if(OPEN.size() == 0) return null;
        T prevCell = OPEN.getFirst();
        int prevFcost = Integer.MAX_VALUE;

        for(int i = 1; i < OPEN.size(); i++) {
            final T cell = OPEN.get(i);
            final int fcost = cell.getF_cost();

            if(fcost < prevFcost || (fcost == prevFcost && cell.getH_cost() < prevCell.getH_cost())) {
                prevCell = cell;
                prevFcost = fcost;
            }
        }
        OPEN.remove(prevCell);
        CLOSED.add(prevCell);
        return prevCell;
    }

    public T start() {
        return getStart() != null ? start(getStart().getX(), getStart().getY()) : null;
    }

    public T start(int x, int y) {
        if(getEnd() == null) throw new NullPointerException("'end' is null");

        OPEN.clear();
        CLOSED.clear();
        OPEN.add(get(x, y));
        while(true) {
            T cell = getCellWithLowestF_Cost();

            if(cell == null) return null;

            if(cell == getEnd()) return cell; //FOUND

            List<Cell> list = cell.getNeighbours();

            for(Cell neighbour : list) {
                if(neighbour.isAvailable() && !CLOSED.contains(neighbour)) {
                    final int newG_cost = cell.getG_cost() + (cell.getX() != neighbour.getX() && cell.getY() != neighbour.getY() ? 14 : 10);
                    final boolean includes = OPEN.contains(neighbour);

                    if(newG_cost < neighbour.getG_cost() || !includes) {
                        neighbour.setG_cost(newG_cost);
                        neighbour.setPreviousPathCell(cell);
                        if(!includes) OPEN.add((T) neighbour);
                    }
                }
            }

        }
    }

    public int getWidth() {
        return getCells().size();
    }

    @SuppressWarnings("unchecked")
    public void setWidth(int width) {
        if(width < getWidth()) {
            getCells().subList(width, getWidth()).clear();
        } else {
            while(getWidth() < width) {
                getCells().add(new ArrayList<>());

                for(int j = 0; j < getHeight(); j++) {
                    getCells().get(getWidth() - 1).add((T) new Cell(getWidth() - 1, j));
                }
            }
        }
    }

    public int getHeight() {
        return getCells().get(0).size();
    }

    @SuppressWarnings("unchecked")
    public void setHeight(int height) {
        if(getHeight() < height) {
            while(getHeight() < height) {
                final int currentHeight = getHeight();
                for(int i = 0; i < getCells().size(); i++)
                    getCells().get(i).add((T) new Cell(i, currentHeight));
            }
        } else {
            for(ArrayList<T> list : getCells()) {
                list.subList(height, list.size()).clear();
            }
        }
    }

    public T get(int x, int y) {
        return getCells().get(x).get(y);
    }

    public ArrayList<ArrayList<T>> getCells() {
        return cells;
    }

    public void clear() {
        for(ArrayList<T> list : getCells()) {
            for(T cell : list) {
                cell.reset();
            }
        }
        setEnd(null);
    }
}
