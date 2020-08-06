package me.landervanlaer.objects;

import me.landervanlaer.math.Coordinate;

public class Line {
    private Coordinate pos1;
    private Coordinate pos2;

    public Line(double x1, double y1, double x2, double y2) {
        this(new Coordinate(x1, y1), new Coordinate(x2, y2));
    }

    public Line(Coordinate pos1, Coordinate pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public double getLength() {
        return pos1.getDistanceBetween(pos2);
    }

    public Coordinate getPos1() {
        return pos1;
    }

    public void setPos1(Coordinate pos1) {
        this.pos1 = pos1;
    }

    public Coordinate getPos2() {
        return pos2;
    }

    public void setPos2(Coordinate pos2) {
        this.pos2 = pos2;
    }
}
