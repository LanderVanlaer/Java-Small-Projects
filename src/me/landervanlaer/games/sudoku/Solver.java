package me.landervanlaer.games.sudoku;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import me.landervanlaer.math.Coordinate;

import java.util.ArrayList;

public class Solver {
    private final ArrayList<Cell> changedCells = new ArrayList<>();
    private Grid field;
    private final Timeline timeline = new Timeline(new KeyFrame(Duration.millis(.1), event -> next()));

    public Solver(Grid field) {
        this.field = field;
        this.next();
    }

    private void next() {
        Cell target;

        if(changedCells.size() == 0)
            target = findNextTarget(-1, -1);
        else {
            Coordinate pos = changedCells.get(changedCells.size() - 1).pos;
            target = findNextTarget((int) pos.getX(), (int) pos.getY());
        }

        if(target == null) {
            System.out.println("DONE");
            return;
        }


        changedCells.add(target);
        int[] ints = getPossibilities(target.pos);
        //FILTER ALL INTS > CURRENT NUM
        ArrayList<Integer> possibilitiesList = new ArrayList<>();

        if(target.getNumber() != 0) {
            for(int i = 0; i < ints.length; i++)
                if(ints[i] > target.getNumber()) possibilitiesList.add(ints[i]);
            ints = this.arrayListToIntArr(possibilitiesList);
        }

        if(ints.length == 0) {
            System.out.println("(" + target.pos.getX() + ", " + target.pos.getY() + ")\t" + ints.length);

            changedCells.get(changedCells.size() - 1).setNumber(0);
            changedCells.remove(changedCells.size() - 1);
            if(changedCells.size() != 0) {
                changedCells.remove(changedCells.size() - 1);
            }

//            next();
            timeline.setCycleCount(1);
            timeline.playFromStart();
            return;
        }

        target.setNumber(ints[0]);
//        next();
        timeline.setCycleCount(1);
        timeline.playFromStart();
    }

    public int[] getPossibilities(Coordinate coordinate) {
        ArrayList<Integer> possibilities = new ArrayList<>();
        for(int i = 1; i <= 9; i++) possibilities.add(i);

        // HORIZONTAL
        for(int i = 0; i < getField().getWidth(); i++)
            if(i != coordinate.getX())
                possibilities.remove((Integer) getField().getGrid()[i][(int) coordinate.getY()].getNumber());

        // VERTICAL
        for(int i = 0; i < getField().getHeight(); i++)
            if(i != coordinate.getY())
                possibilities.remove((Integer) getField().getGrid()[(int) coordinate.getX()][i].getNumber());


        //Top left Coordinate of 3 x 3 square
        final Coordinate topLeft = new Coordinate((int) (coordinate.getX() / 3D) * 3, (int) (coordinate.getY() / 3D) * 3);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int newX = (int) (i + topLeft.getX());
                int newY = (int) (j + topLeft.getY());
                possibilities.remove((Integer) getField().getGrid()[newX][newY].getNumber());
            }
        }
        return arrayListToIntArr(possibilities);
    }

    private int[] arrayListToIntArr(ArrayList<Integer> integers) {
        int[] arr = new int[integers.size()];
        for(int i = 0; i < arr.length; i++) arr[i] = integers.get(i);
        return arr;
    }

    public Cell findNextTarget(int x, int y) {
        if(x < -1) x = -1;
        if(y < 0) y = 0;
        x++;
        if(x >= getField().getWidth()) {
            x = 0;
            y++;
        }

        if(y >= getField().getHeight()) return null;

        for(int i = x; i < getField().getWidth(); i++)
            if(!getField().getGrid()[i][y].isFIXED()) return getField().getGrid()[i][y];

        if(y >= getField().getWidth()) return null;

        for(int j = y; j < getField().getHeight(); j++)
            for(int i = 0; i < getField().getWidth(); i++)
                if(!getField().getGrid()[i][j].isFIXED()) return getField().getGrid()[i][j];

        return null;
    }

    public Grid getField() {
        return field;
    }

    public void setField(Grid field) {
        this.field = field;
    }
}
