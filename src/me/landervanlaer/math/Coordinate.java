package me.landervanlaer.math;

/**
 * A class representing a Coordinate, by storing the x & y component
 */
public class Coordinate {
    /**
     * How far the {@link Coordinate} is, horizontally from the origin of a Cartesian coordinate system
     *
     * @see #setX(double)
     * @see #getX()
     */
    private double x;
    /**
     * How far the {@link Coordinate} is, vertically from the origin of a Cartesian coordinate system
     *
     * @see #setY(double)
     * @see #getY()
     */
    private double y;

    /**
     * Constructs a {@link Coordinate} with a given {@link #x} and {@link #y}
     *
     * @param x The {@link #x} component
     * @param y The {@link #y} component
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the distance between 2 {@link Coordinate}, by means of the Pythagoras Theorem
     *
     * @param pos The second Coordinate
     * @return The distance between the Coordinate
     */
    public double getDistanceBetween(Coordinate pos) {
        return Math.hypot(this.getX() - pos.getX(), this.getY() - pos.getY());
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(that.getX(), getX()) == 0 &&
                Double.compare(that.getY(), getY()) == 0;
    }

    /**
     * Apply an {@link Vector} to the {@link Coordinate}
     *
     * @param v The {@link Vector} to apply to the Coordinate
     */
    public void add(Vector v) {
        setX(getX() + v.getSpeedX());
        setY(getY() + v.getSpeedY());
    }

    /**
     * @return {@link #x}
     * @see #x
     */
    public double getX() {
        return x;
    }

    /**
     * Change the {@code x} value of the {@link Coordinate}
     *
     * @param x The {@code x} component of the new Coordinate
     * @see #x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return {@link #y}
     * @see #y
     */
    public double getY() {
        return y;
    }

    /**
     * Change the {@code y} value of the {@link Coordinate}
     *
     * @param y The {@code y} component of the new Coordinate
     * @see #y
     */
    public void setY(double y) {
        this.y = y;
    }
}
