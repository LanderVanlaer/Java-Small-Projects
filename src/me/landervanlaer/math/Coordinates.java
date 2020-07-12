package me.landervanlaer.math;

public class Coordinates {
    private double x;
    private double y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistanceBetween(Coordinates pos) {
        return Math.hypot(this.getX() - pos.getX(), this.getY() - pos.getY());
    }

    public boolean equivalent(Coordinates coordinates) {
        return this.getX() == coordinates.getX() && this.getY() == coordinates.getY();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
