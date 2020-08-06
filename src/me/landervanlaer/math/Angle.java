package me.landervanlaer.math;

/**
 * A class that represents an angle by only storing the radians.
 */
public class Angle {
    private double rad;
    /**
     * If the {@link Angle} has to be simplified when you need the value. When turning it from true to false the real value remains unchanged.
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
    private boolean simplify = true;

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
        this.setRadians(rad);
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
     * Simplifies an radians angle, gives the absolute angle value
     * It calculates the lowest angle in radians that is above {@code 0} and equal to the given angle
     * <blockquote>
     * <code>
     * 2D * Math.PI == 0
     * </code>
     * </blockquote>
     *
     * @param radians The angle in radians you want to convert
     * @return The absolute angle in radians
     */
    static public double simplifyRadians(double radians) {
        final double DOUBLE_PI = Math.PI * 2D;

        while(radians < 0 || radians >= DOUBLE_PI) {
            if(radians < 0) radians += DOUBLE_PI;
            else radians -= DOUBLE_PI;
        }
        return radians;
    }

    /**
     * Simplifies an degrees angle, gives the absolute angle value
     * It calculates the lowest angle in degrees that is above {@code 0} and equal to the given angle
     * <blockquote>
     * <code>
     * 2D * Math.PI == 0
     * </code>
     * </blockquote>
     *
     * @param degrees The angle in degrees you want to convert
     * @return The absolute angle in degrees
     */
    static public double simplifyDegrees(double degrees) {
        while(degrees < 0 || degrees >= 360D) {
            if(degrees < 0) degrees += 360D;
            else degrees -= 360D;
        }
        return degrees;
    }

    /**
     * See {@link Object#equals(Object)} for more info.
     * If {@link #simplify} in both {@link Angle} objects are {@code true}, it is going to compare the simplified values
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Angle angle = (Angle) o;
        if(this.isSimplify() && angle.isSimplify())
            return angle.getRadians() == this.getRadians();
        else
            return angle.getValue() == this.getValue();
    }

    /**
     * Calculates the {@link Angle} value in radians.
     * And if {@link #simplify} is {@code true}, it gives the simplified version of that angle
     *
     * @return The angle in radians
     */
    public double getRadians() {
        if(this.isSimplify())
            return Angle.simplifyRadians(rad);
        else
            return rad;
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
     * Calculates the {@link Angle} value in degrees.
     * And if {@link #simplify} is {@code true}, it gives the simplified version of that angle
     *
     * @return The angle in degrees
     */
    public double getDegrees() {
        if(this.isSimplify())
            return Angle.simplifyDegrees(Angle.radiansToDegrees(this.getRadians()));
        else
            return Angle.radiansToDegrees(this.getRadians());
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
     * Returns {@link #simplify}
     *
     * @return {@link #simplify}
     * @see #simplify
     */
    public boolean isSimplify() {
        return simplify;
    }

    /**
     * Set the {@link #simplify} value to the given value
     *
     * @param simplify The value to set {@link #simplify} to
     * @see #simplify
     */
    public void setSimplify(boolean simplify) {
        this.simplify = simplify;
    }

    /**
     * Get innital value of {@link #rad}
     *
     * @return {{@link #rad}}
     * @hidden
     */
    protected double getValue() {
        return this.rad;
    }
}
