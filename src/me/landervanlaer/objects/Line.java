package me.landervanlaer.objects;

import me.landervanlaer.math.Coordinates;

public class Line {
    private Coordinates pos1;
    private Coordinates pos2;

    public Line(double x1, double y1, double x2, double y2) {
        this(new Coordinates(x1, y1), new Coordinates(x2, y2));
    }

    public Line(Coordinates pos1, Coordinates pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public double getLength() {
        return pos1.getDistanceBetween(pos2);
    }

    public Coordinates getPos1() {
        return pos1;
    }

    public void setPos1(Coordinates pos1) {
        this.pos1 = pos1;
    }

    public Coordinates getPos2() {
        return pos2;
    }

    public void setPos2(Coordinates pos2) {
        this.pos2 = pos2;
    }
}
