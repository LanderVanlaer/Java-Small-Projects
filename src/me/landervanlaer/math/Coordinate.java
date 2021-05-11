package me.landervanlaer.math;

/**
 * A class representing a Coordinate, by storing the x & y component
 *
 * @author LanderVanLaer
 * @version 1.5 2021/05/11
 * @since 1.3
 */
public class Coordinate {
    /**
     * How far the {@link Coordinate} is, horizontally from the origin of a Cartesian coordinate system
     *
     * @see #setX(double)
     * @see #getX()
     * @since 1.0
     */
    private double x;
    /**
     * How far the {@link Coordinate} is, vertically from the origin of a Cartesian coordinate system
     *
     * @see #setY(double)
     * @see #getY()
     * @since 1.0
     */
    private double y;

    /**
     * Constructs a {@link Coordinate} with a given {@link #x} and {@link #y}
     *
     * @param x The {@link #x} component
     * @param y The {@link #y} component
     * @since 1.0
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constucts a {@link Coordinate} with a given Coordinate. Creates a copy of the given Coordinate.
     *
     * @param coordinate The Coordinate to copy
     * @see #Coordinate(double, double)
     * @since 1.5
     */
    public Coordinate(Coordinate coordinate) {
        this(coordinate.getX(), coordinate.getY());
    }

    /**
     * Calculates the distance between 2 {@link Coordinate}, by means of the Pythagoras Theorem
     *
     * @param pos The second Coordinate
     * @return The distance between the Coordinate
     * @since 1.2
     */
    public double getDistanceBetween(Coordinate pos) {
        return Math.hypot(this.getX() - pos.getX(), this.getY() - pos.getY());
    }

    /**
     * @param o The Object to compare with
     * @return A boolean that tells if the 2 Objects are a clone of eachother
     * @see Object#equals(Object)
     * @since 1.0
     */
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
     * @since 1.1
     */
    public void add(Vector v) {
        setX(getX() + v.getX());
        setY(getY() + v.getY());
    }

    /**
     * @return {@link #x}
     * @see #x
     * @since 1.0
     */
    public double getX() {
        return x;
    }

    /**
     * Change the {@code x} value of the {@link Coordinate}
     *
     * @param x The {@code x} component of the new Coordinate
     * @see #x
     * @since 1.0
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return {@link #y}
     * @see #y
     * @since 1.0
     */
    public double getY() {
        return y;
    }

    /**
     * Change the {@code y} value of the {@link Coordinate}
     *
     * @param y The {@code y} component of the new Coordinate
     * @see #y
     * @since 1.0
     */
    public void setY(double y) {
        this.y = y;
    }
}
