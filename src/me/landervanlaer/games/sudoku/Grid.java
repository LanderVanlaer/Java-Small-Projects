package me.landervanlaer.games.sudoku;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import me.landervanlaer.math.Coordinate;

public class Grid {
    /**
     * Start values
     *
     * @see <a href="https://voorbeginners.info/sudoku-puzzels/3-6.png">Empty</a>
     * @see <a href="https://voorbeginners.info/sudoku-puzzels/3-6-sol.gif">Solution</a>
     */
    private final static int[][] INTS = new int[][]{
            new int[]{3, 7, 0, 9, 0, 0, 0, 8, 0},
            new int[]{0, 6, 0, 0, 0, 7, 5, 0, 0},
            new int[]{0, 8, 0, 0, 0, 0, 0, 0, 0},
            new int[]{0, 3, 9, 0, 0, 8, 0, 0, 5},
            new int[]{0, 2, 0, 0, 1, 0, 0, 4, 0},
            new int[]{8, 1, 0, 4, 0, 0, 3, 7, 0},
            new int[]{0, 9, 0, 0, 0, 0, 0, 5, 0},
            new int[]{0, 4, 1, 2, 0, 0, 0, 0, 0},
            new int[]{0, 5, 0, 0, 0, 9, 0, 3, 6}
    };
    //    private final static int[][] INTS = new int[][]{
//            new int[]{3, 7, 0, 9, 0, 0, 0, 8, 0},
//            new int[]{0, 0, 0, 0, 0, 7, 5, 0, 0},
//            new int[]{0, 8, 0, 0, 0, 0, 0, 0, 0},
//            new int[]{0, 3, 9, 0, 0, 8, 0, 0, 5},
//            new int[]{0, 2, 0, 0, 1, 0, 0, 4, 0},
//            new int[]{8, 0, 0, 4, 0, 0, 3, 7, 0},
//            new int[]{0, 0, 0, 0, 0, 0, 0, 5, 0},
//            new int[]{0, 0, 1, 2, 0, 0, 0, 0, 0},
//            new int[]{0, 5, 0, 0, 0, 9, 0, 3, 6}
//    };
    private final GridPane pane;

    private Cell[][] grid;

    public Grid(GridPane pane) {
        this.pane = pane;
        this.grid = new Cell[9][9];
        initializeGridFromINTS();
        solve();
    }

    public GridPane getPane() {
        return pane;
    }

    private void initializeGridFromINTS() {
        for(int i = 0; i < getGrid().length; i++) {
            for(int j = 0; j < getGrid()[0].length; j++) {
                getGrid()[i][j] = new Cell(new Label(), INTS[i][j], new Coordinate(i, j), INTS[i][j] != 0);

                getPane().add(getGrid()[i][j].getLabel(), i, j);

                if(i == 2 || i == 5) getGrid()[i][j].getLabel().getStyleClass().add("right");
                if(j == 2 || j == 5) getGrid()[i][j].getLabel().getStyleClass().add("bottom");
            }
        }
    }

    public void solve() {
        new Solver(this);
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }


    public int getWidth() {
        return getGrid().length;
    }

    public int getHeight() {
        return getGrid()[0].length;
    }

}
