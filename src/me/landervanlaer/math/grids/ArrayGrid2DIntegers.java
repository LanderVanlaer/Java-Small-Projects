package me.landervanlaer.math.grids;

import java.util.function.IntPredicate;

public class ArrayGrid2DIntegers {
    private int[][] grid;
    private IntPredicate condition;

    public ArrayGrid2DIntegers(int width, int height) {
        this(ArrayGrid2DIntegers.createArrayGrid(width, height));
    }

    public ArrayGrid2DIntegers(int[][] grid) {
        this.setGrid(grid);
    }

    static int[][] createArrayGrid(int width, int height) {
        return new int[width][height];
    }

    static int[][] createArrayGrid(int width, int height, int defaultInt) {
        int[][] grid = ArrayGrid2DIntegers.createArrayGrid(width, height);
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                grid[i][j] = defaultInt;
        return grid;
    }

    public void fill(int value) {
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                grid[i][j] = value;
    }

    public int getTotalOfColumn(int i) {
        int total = 0;
        for(int j = 0; j < grid[i].length; j++)
            total += this.get(i, j);
        return total;
    }

    public int getTotalOfRow(int i) {
        int total = 0;
        for(int j = 0; j < grid[i].length; j++)
            total += this.get(j, i);
        return total;
    }

    public int getTotal() {
        int total = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                total += this.get(i, j);
        return total;
    }

    public void print() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++)
                System.out.print(this.get(j, i) + " ");
            System.out.println();
        }
    }

    public int getTotalOfValuesAround(int x, int y) {
        int total = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if((newX >= 0 && newX < this.getWidth()) && (newY >= 0 && newY < this.getHeight()) && (newX != 0 && newY != 0))
                    total += this.get(newX, newY);
            }
        }
        return total;
    }

    public void changeColumn(int indexColumn1, int indexColumn2) {
        int[] column = this.getGrid()[indexColumn1];
        this.getGrid()[indexColumn1] = this.getGrid()[indexColumn2];
        this.getGrid()[indexColumn2] = column;
    }

    public void changeRow(int indexRow1, int indexRow2) {
        for(int i = 0; i < this.getWidth(); i++)
            this.changeCells(i, indexRow1, i, indexRow2);
    }

    public void changeCells(int x1, int y1, int x2, int y2) {
        int t = this.get(x1, y1);
        this.set(x1, y1, this.get(x2, y2));
        this.set(x2, y2, t);
    }

    public int get(int x, int y) {
        return this.getGrid()[x][y];
    }

    public boolean set(int x, int y, int value) {
        if(condition != null && !condition.test(value))
            return false;
        this.getGrid()[x][y] = value;
        return true;
    }

    public int getWidth() {
        return this.getGrid().length;
    }

    public int getHeight() {
        return this.getGrid()[0].length;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public IntPredicate getCondition() {
        return condition;
    }

    public void setCondition(IntPredicate condition) {
        this.condition = condition;
    }
}
