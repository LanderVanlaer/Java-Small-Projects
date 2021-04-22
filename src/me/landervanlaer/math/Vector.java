package me.landervanlaer.math;

/**
 * A class to describe a two dimensional vector
 *
 * @author Lander Van Laer
 * @version 4.2 2021/04/22
 */
public class Vector implements Cloneable {
    /**
     * The x component of the {@link Vector}
     *
     * @see #getX()
     * @since 1.0
     */
    private double x;
    /**
     * The y component of the {@link Vector}
     *
     * @see #getY()
     * @since 1.0
     */
    private double y;

    /**
     * Creates a {@link Vector} of {@code 0}
     *
     * @since 1.0
     */
    public Vector() {
        this(0, 0);
    }

    /**
     * Creates a {@link Vector} out of the given {@code x} & {@code y} speed
     *
     * @param speedX The x component of the vector
     * @param speedY The y component of the vector
     * @since 2.0
     */
    public Vector(double speedX, double speedY) {
        this.x = speedX;
        this.y = speedY;
    }

    /**
     * Creates a {@link Vector} from a {@link Coordinate} to another Coordinate
     *
     * @param from The starting Coordinate of the Vector
     * @param to   The ending Coordinate of the Vector
     * @since 2.0
     */
    public Vector(Coordinate from, Coordinate to) {
        this(to.getX() - from.getX(), to.getY() - from.getY());
    }

    /**
     * Adds the 2 given Vectors to eachother and returns a new {@link Vector}.
     * The given Vectors are not changed
     * <code>
     * return vector1 + vector2
     * </code>
     *
     * @param vector1 A Vector to add to the other
     * @param vector2 A Vector to add to the other
     * @return A new Vector
     * @see #add(Vector)
     * @see Vector#sub(Vector, Vector)
     * @since 2.0
     */
    public static Vector add(Vector vector1, Vector vector2) {
        return new Vector(vector1.getX() + vector2.getX(),
                vector1.getY() + vector2.getY());
    }

    /**
     * Subtrats the 2 given Vectors from eachother and returns a new {@link Vector}.
     * The given Vectors are not changed
     * <code>
     * return vector1 - vector2
     * </code>
     *
     * @param vector1 A Vector to subtract from
     * @param vector2 A Vector to subtract with
     * @return A new Vector
     * @see #sub(Vector)
     * @see Vector#add(Vector, Vector)
     * @since 2.0
     */
    public static Vector sub(Vector vector1, Vector vector2) {
        return new Vector(vector1.getX() - vector2.getX(),
                vector1.getY() - vector2.getY());
    }

    /**
     * Multiplies the given Vector by a scalar and returns a new {@link Vector}.
     * The given Vector will not change
     *
     * <code>
     * return vector * scalar
     * </code>
     *
     * @param vector A Vector that must be multiplied
     * @param scalar A scalar to multiply with | multiplier
     * @return A new Vector
     * @see #mult(double)
     * @see Vector#div(Vector, double)
     * @since 4.0
     */
    public static Vector mult(Vector vector, double scalar) {
        return new Vector(vector.getX() * scalar, vector.getY() * scalar);
    }

    /**
     * Divides the given Vector by a scalar and returns a new {@link Vector}.
     * The given Vector will not change
     * <code>
     * return vector / scalar
     * </code>
     *
     * @param vector A Vector to divide from | numerator
     * @param scalar A scalar to divide with | denominator
     * @return A new Vector
     * @see #div(double)
     * @see Vector#mult(Vector, double)
     * @since 4.0
     */
    public static Vector div(Vector vector, double scalar) {
        return Vector.mult(vector, 1 / scalar);
    }

    /**
     * Calculate the {@link Angle} of rotation for this vector
     *
     * @return The {@link Angle} the vector is heading to.
     * @since 1.0
     */
    public Angle getAngle() {
        return new Angle(Math.acos(this.getX() / this.getMag()));
    }

    /**
     * Change the Vectors {@link Angle} to the given Angle by not changing the magnitude
     *
     * @param angle the desired {@link Angle}
     * @since 2.0
     */
    public void setAngle(Angle angle) {
        final double mag = getMag();
        final double rad = angle.getRadians();
        this.setX(Math.cos(rad) * mag);
        this.setY(Math.sin(rad) * mag);
    }

    /**
     * Adds the given {@link Angle} to the Angle of the {@link Vector}
     * <p>
     * So if the Angle of the Vector is {@code 180} and you rotate it with {@code 90},
     * the Angle of the Vector will be {@code 270}
     *
     * @param angle An Angle to add to the Angle of the Vector
     * @see #getAngle()
     * @see #setAngle(Angle)
     * @since 2.0
     */
    public void rotate(Angle angle) {
        this.setAngle(new Angle(getAngle().getRadians() + angle.getRadians()));
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
        return Double.compare(vector.getX(), getX()) == 0 &&
                Double.compare(vector.getY(), getY()) == 0;
    }

    /**
     * See {@link Object#clone()} for more info
     *
     * @return A copy of this {@link Object}
     * @see Object#clone()
     * @since 4.1
     */
    @Override
    public Vector clone() {
        Vector clone = null;
        try {
            clone = (Vector) super.clone();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if(clone != null) {
            clone.setX(getX());
            clone.setY(getY());
        }
        return clone;
    }

    /**
     * See {@link Object#toString()}
     *
     * @return A representation of the {@link Vector}
     * @see Object#toString()
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Vector{" +
                "speedX=" + x +
                ", speedY=" + y +
                '}';
    }

    /**
     * Adds a {@link Vector} to the vector
     *
     * @param vector The {@link Vector} to add.
     * @return This {@link Vector}
     * @see #sub(Vector)
     * @since 1.0
     */
    public Vector add(Vector vector) {
        this.setX(this.getX() + vector.getX());
        this.setY(this.getY() + vector.getY());
        return this;
    }

    /**
     * Subtracts a {@link Vector} from the vector
     *
     * @param vector The {@link Vector} to subtract with.
     * @return This {@link Vector}
     * @see #add(Vector)
     * @since 1.0
     */
    public Vector sub(Vector vector) {
        this.setX(this.getX() - vector.getX());
        this.setY(this.getY() - vector.getY());
        return this;
    }

    /**
     * Multiplies the vector by a scalar
     * <p>
     * When multiplying a vector by a scalar, the x and y components of the vector are all multiplied by the scalar.
     *
     * @param scalar The scalar
     * @see #div(double)
     * @since 2.0
     */
    public void mult(double scalar) {
        this.setX(this.getX() * scalar);
        this.setY(this.getY() * scalar);
    }

    /**
     * Divides the vector by a scalar
     * <p>
     * When dividing a vector by a scalar, the x and y components of the vector are all divided by the scalar.
     *
     * @param scalar The scalar to divide with
     * @see #mult(double)
     * @since 2.0
     */
    public void div(double scalar) {
        mult(1 / scalar);
    }

    /**
     * Normalize the {@link Vector} to length 1 (make it a unit vector).
     *
     * @since 2.0
     */
    public void normalize() {
        final double mag = getMag();
        this.setX(this.getX() / mag);
        this.setY(this.getY() / mag);
    }

    /**
     * Calculates the total magnitude of the {@link Vector} out of the x and y component
     *
     * @return The length of the {@link Vector}
     * @since 2.0
     */
    public double getMag() {
        return Math.hypot(this.getX(), this.getY());
    }

    /**
     * Set the magnitude of this vector to the given length
     *
     * @param len The new length of the {@link Vector}
     * @see #getMag()
     * @since 2.0
     */
    public void setMag(double len) {
        this.normalize();
        this.mult(len);
    }

    /**
     * Make it a "zero vector" | "null vector".
     * <p>
     * Sets the {@link #x} and {@link #y} component to {@code 0}.
     *
     * @see #isZero()
     * @since 2.1
     */
    public void zero() {
        setX(0);
        setY(0);
    }

    /**
     * Returns whether the vector is a "zero vector" | "null vector".
     *
     * @return Whether the {@link #x} and {@link #y} component are 0.
     * @see #zero()
     * @since 2.2
     */
    public boolean isZero() {
        return getX() == 0 && getY() == 0;
    }

    /**
     * Limits the magnitude to a desired maximum
     * <p>
     * If {@code magnitude > max} then {@code magnitude = max}
     *
     * @param max The maximum limit
     * @see #getMag()
     * @see #setMag(double)
     * @since 2.0
     */
    public void limit(double max) {
        if(getMag() > max) setMag(max);
    }

    /**
     * Inverts the {@link Vector},
     * so the {@link #x} and {@link #y} component will be multiplied by {@code -1}.
     *
     * @see #mult(double)
     * @since 4.1
     */
    public void invert() {
        mult(-1);
    }

    /**
     * Inverts the {@link #x} component
     *
     * @since 1.0
     */
    public void invertX() {
        this.setX(-this.getX());
    }

    /**
     * Inverts the {@link #y} component
     *
     * @since 1.0
     */
    public void invertY() {
        this.setY(-this.getY());
    }

    /**
     * Gives the x component of the {@link Vector}
     *
     * @return {@link #x}
     * @see #x
     * @since 1.0
     */
    public double getX() {
        return x;
    }

    /**
     * Change the x component of the {@link Vector} to the given value
     *
     * @param x The new x component
     * @see #x
     * @since 1.0
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gives the y component of the {@link Vector}
     *
     * @return {@link #y}
     * @see #y
     * @since 1.0
     */
    public double getY() {
        return y;
    }

    /**
     * Change the y component of the {@link Vector} to the given value
     *
     * @param y The new y component
     * @see #y
     * @since 1.0
     */
    public void setY(double y) {
        this.y = y;
    }
}
