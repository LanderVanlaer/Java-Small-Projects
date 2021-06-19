package me.landervanlaer.math;

/**
 * A class that represents an angle by only storing the radians.
 *
 * @author Lander Van Laer
 * @version 2.1 2021/06/19
 */
public class Angle {
    /**
     * If the {@link Angle} has to be simplified when you need the value.
     * So, if the value is {@code true}:
     * <blockquote>
     * <code>
     * 370° == 10°
     * </code>
     * </blockquote>
     * But if the value is false
     * <blockquote>
     * <code>
     * 370° != 10°
     * </code>
     * </blockquote>
     */
    public static final boolean SIMPLIFY = false;
    /**
     * The radians of the {@link Angle}
     */
    private double rad;

    /**
     * Runs {@link #Angle(double)} with a given paremeter of {@code 0}
     *
     * @see #Angle(double)
     */
    public Angle() {
        this(0);
    }

    /**
     * Constructs an {@link Angle} with the given radians value
     */
    public Angle(double rad) {
        this.rad = rad;
    }

    /**
     * Converts a degrees angle value to a radians value
     *
     * @param degrees The angle in degrees you want to convert
     * @return The converted angle in radians
     */
    static public double degreesToRadians(double degrees) {
        return degrees / (180 / Math.PI);
    }

    /**
     * Converts a radians angle value to a degrees value
     *
     * @param radians The angle in radians you want to convert
     * @return The converted angle in degrees
     */
    static public double radiansToDegrees(double radians) {
        return radians * (180 / Math.PI);
    }

    /**
     * Simplifies an radians angle, it gives the absolute angle value.
     * <p>
     * It calculates the lowest angle in radians that is above {@code 0} and equal to the given angle
     *
     * @param radians The angle in radians you want to convert
     * @return The absolute angle in radians
     * @see #simplifyDegrees(double)
     */
    static public double simplifyRadians(double radians) {
        final double DOUBLE_PI = Math.PI * 2D;

        radians %= DOUBLE_PI;
        return radians < 0 ? radians + DOUBLE_PI : radians;
    }

    /**
     * Simplifies an degrees angle, it gives the absolute angle value.
     * <p>
     * It calculates the lowest angle in degrees that is above {@code 0} and equal to the given angle
     *
     * @param degrees The angle in degrees you want to convert
     * @return The absolute angle in degrees
     * @see #simplifyRadians(double)
     */
    static public double simplifyDegrees(double degrees) {
        degrees %= 360D;
        return degrees < 0 ? degrees + 360D : degrees;
    }

    /**
     * See {@link Object#equals(Object)} for more info.
     * Runs {@link #equals(Object, boolean)} with the constant {@link Angle#SIMPLIFY} as the given boolean.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * * argument; {@code false} otherwise.
     * @see #equals(Object, boolean)
     * @see Angle#SIMPLIFY
     */
    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass() && equals(o, false);
    }

    /**
     * See {@link Object#equals(Object)} for more info.
     * If the given boolean is {@code true}, it is going to compare the simplified values.
     * See {@link Angle#SIMPLIFY} for more info.
     *
     * @param o        the reference object with which to compare.
     * @param simplify if it needs to check the simplified values
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see Object#equals(Object)
     * @see Angle#SIMPLIFY
     */
    public boolean equals(Object o, boolean simplify) {
        if(super.equals(o)) return true;
        if(o == null || this.getClass() != o.getClass()) return false;

        Angle angle = (Angle) o;

        if(simplify)
            return Double.compare(angle.getRadians(true), this.getRadians(true)) == 0;
        else
            return Double.compare(angle.getRadians(), this.getRadians()) == 0;
    }

    /**
     * Simplifies the {@link Angle} radians value. See {@link #simplifyRadians(double)} for more info
     *
     * @return Wheter the radians value is changed
     * @see #simplifyRadians(double)
     * @since 2.0
     */
    public boolean simplify() {
        final double prevRad = this.getRadians(false);
        final double newRad = Angle.simplifyRadians(prevRad);

        if(prevRad == newRad) return false;

        setRadians(newRad);
        return true;
    }

    /**
     * Calculates the {@link Angle} value in radians.
     * <p>
     * Runs {@link #getRadians(boolean)} with the constant {@link Angle#SIMPLIFY} as the given boolean.
     *
     * @return The angle in radians
     * @see Angle#SIMPLIFY
     * @see #getRadians(boolean)
     * @since 2.0
     */
    public double getRadians() {
        return getRadians(Angle.SIMPLIFY);
    }

    /**
     * Set the {@link Angle} to a given radians value
     *
     * @param rad The radians value to set the Angle to
     */
    public void setRadians(double rad) {
        this.rad = rad;
    }

    /**
     * Calculates the {@link Angle} value in radians.
     * And if the given boolean is {@code true}, it gives the simplified version of that Angle.
     * See {@link Angle#SIMPLIFY} for more info.
     *
     * @param simplify Whether it should be simplified or not
     * @return The angle in radians
     * @see Angle#SIMPLIFY
     * @see #getRadians()
     * @since 2.0
     */
    public double getRadians(boolean simplify) {
        return simplify ? Angle.simplifyRadians(rad) : rad;
    }

    /**
     * Calculates the {@link Angle} value in degrees.
     * <p>
     * Runs {@link #getRadians(boolean)} with the constant {@link Angle#SIMPLIFY} as the given boolean.
     *
     * @return The angle in degrees
     * @see Angle#SIMPLIFY
     * @see #getDegrees(boolean)
     * @since 2.0
     */
    public double getDegrees() {
        return getDegrees(Angle.SIMPLIFY);
    }

    /**
     * Set the {@link Angle} to a given degrees value
     *
     * @param degrees The degrees value to set the Angle to
     */
    public void setDegrees(double degrees) {
        this.setRadians(Angle.degreesToRadians(degrees));
    }

    /**
     * Calculates the {@link Angle} value in degrees.
     * And if the given boolean is {@code true}, it gives the simplified version of that angle.
     * See {@link Angle#SIMPLIFY} for more info.
     *
     * @param simplify Whether it should be simplified or not
     * @return The angle in degrees
     * @see Angle#SIMPLIFY
     * @see #getDegrees()
     * @since 2.0
     */
    public double getDegrees(boolean simplify) {
        return simplify ?
                Angle.simplifyDegrees(Angle.radiansToDegrees(this.getRadians()))
                : Angle.radiansToDegrees(this.getRadians());
    }
}
