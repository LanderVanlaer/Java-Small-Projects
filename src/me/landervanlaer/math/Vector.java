package me.landervanlaer.math;

/**
 * A class to describe a two dimensional vector
 *
 * @author LanderVanLaer
 * @version 1.0 2020/08/04
 */
public class Vector {
    /**
     * The x component of the {@link Vector}
     *
     * @since 1.0
     */
    private double speedX;
    /**
     * The y component of the {@link Vector}
     *
     * @since 1.0
     */
    private double speedY;

    /**
     * Clones a {@link Vector}
     *
     * @param v The vector that has to be cloned.
     * @since 1.0
     */
    public Vector(Vector v) {
        this(v.getSpeedX(), v.getSpeedY());
    }

    /**
     * Creates a {@link Vector} of 0
     *
     * @since 1.0
     */
    public Vector() {
        this(0, 0);
    }

    /**
     * Creates a {@link Vector} out of the given x & y speed
     *
     * @param speedX The x component of the vector
     * @param speedY The y component of the vector
     * @since 1.0
     */
    public Vector(double speedX, double speedY) {
        this.setSpeedX(speedX);
        this.setSpeedY(speedY);
    }

    /**
     * See {@link Object#toString()}
     *
     * @return A representation of the {@link Vector}
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Vector{" +
                "speedX=" + speedX +
                ", speedY=" + speedY +
                '}';
    }

    /**
     * Calculate the {@link Angle} of rotation for this vector
     *
     * @return The {@link Angle} the vector is heading to.
     * @since 1.0
     */
    public Angle getAngle() {
        return new Angle(Math.acos(this.getSpeedX() / this.getTotalSpeed()));
    }

    /**
     * Works just like {@link #setAngle(Angle, double)} only the length is set to 1 (a unit vector).
     *
     * @param angle the desired {@link Angle}
     * @since 1.0
     */
    public void setAngle(Angle angle) {
        this.setAngle(angle, 1);
    }

    /**
     * Change the {@link Vector} to an angle with a desired length
     *
     * @param angle the desired {@link Angle}
     * @param speed the new length of the {@link Vector}
     * @since 1.0
     */
    public void setAngle(Angle angle, double speed) {
        final double rad = angle.getRadians();
        this.setSpeedX(Math.cos(rad) * speed);
        this.setSpeedY(Math.sin(rad) * speed);
    }

    /**
     * See {@link Object#equals(Object)}
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see Object#equals(Object)
     * @since 1.0
     */
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Double.compare(vector.getSpeedX(), getSpeedX()) == 0 &&
                Double.compare(vector.getSpeedY(), getSpeedY()) == 0;
    }

    /**
     * Adds a {@link Vector} to the vector
     *
     * @param vector The {@link Vector} to add.
     * @return The new {@link Vector}
     * @since 1.0
     */
    public Vector add(Vector vector) {
        this.setSpeedX(this.getSpeedX() + vector.getSpeedX());
        this.setSpeedX(this.getSpeedY() + vector.getSpeedY());
        return this;
    }

    /**
     * Subtracts a {@link Vector} from the vector
     *
     * @param vector The {@link Vector} to subtract with.
     * @return The new {@link Vector}
     * @since 1.0
     */
    public Vector subtract(Vector vector) {
        this.setSpeedX(this.getSpeedX() - vector.getSpeedX());
        this.setSpeedX(this.getSpeedY() - vector.getSpeedY());
        return this;
    }

    /**
     * Normalize the {@link Vector} to length 1 (make it a unit vector).
     *
     * @since 1.0
     */
    public void normalize() {
        final double length = Math.hypot(this.getSpeedX(), this.getSpeedY());
        this.setSpeedX(this.getSpeedX() / length);
        this.setSpeedY(this.getSpeedY() / length);
    }

    /**
     * Calculates the total speed of the {@link Vector} out of the x and y component
     *
     * @return The length of the {@link Vector}
     * @since 1.0
     */
    public double getTotalSpeed() {
        return Math.hypot(this.getSpeedX(), this.getSpeedY());
    }

    /**
     * Inverts the speed of the x component
     * <code>
     * newSpeedX = -{@link #speedX}
     * </code>
     *
     * @since 1.0
     */
    public void invertSpeedX() {
        this.setSpeedX(-this.getSpeedX());
    }

    /**
     * Inverts the speed of the y component
     * <code>
     * newSpeedY = -{@link #speedY}
     * </code>
     *
     * @since 1.0
     */
    public void invertSpeedY() {
        this.setSpeedY(-this.getSpeedY());
    }

    /**
     * Gives the x component of the {@link Vector}
     *
     * @return {@link #speedX}
     * @since 1.0
     */
    public double getSpeedX() {
        return speedX;
    }

    /**
     * Change the x component of the {@link Vector} to the given value
     *
     * @param speedX The new x component
     * @since 1.0
     */
    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    /**
     * Gives the y component of the {@link Vector}
     *
     * @return {@link #speedY}
     * @since 1.0
     */
    public double getSpeedY() {
        return speedY;
    }

    /**
     * Change the y component of the {@link Vector} to the given value
     *
     * @param speedY The new y component
     * @since 1.0
     */
    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }
}
