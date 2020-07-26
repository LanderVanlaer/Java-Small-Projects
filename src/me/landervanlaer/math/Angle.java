package me.landervanlaer.math;

public class Angle {
    private double rad;
    /**
     * If the {@link Angle} has to be simplified
     * <p>
     * <code>
     * //{@code true}
     * 370° == 10°
     * //{@code false}
     * 370° != 10°
     * </code>
     */
    private boolean simplify = true;

    public Angle() {
        this(0);
    }

    public Angle(double rad) {
        this.setRadians(rad);
    }

    static public double degreesToRadians(double degrees) {
        return degrees / (180 / Math.PI);
    }

    static public double radiansToDegrees(double radians) {
        return radians * (180 / Math.PI);
    }

    static public double simplifyRadians(double radians) {
        final double DOUBLE_PI = Math.PI * 2D;

        while(radians < 0 || radians >= DOUBLE_PI) {
            if(radians < 0) radians += DOUBLE_PI;
            else radians -= DOUBLE_PI;
        }
        return radians;
    }

    static public double simplifyDegrees(double degrees) {
        while(degrees < 0 || degrees >= 360D) {
            if(degrees < 0) degrees += 360D;
            else degrees -= 360D;
        }
        return degrees;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Angle angle = (Angle) o;
        return angle.getRadians() == this.getRadians();
    }

    public double getRadians() {
        if(this.isSimplify())
            return Angle.simplifyRadians(rad);
        else
            return rad;
    }

    public void setRadians(double rad) {
        this.rad = rad;
    }

    public double getDegrees() {
        if(this.isSimplify())
            return Angle.simplifyDegrees(Angle.radiansToDegrees(this.getRadians()));
        else
            return Angle.radiansToDegrees(this.getRadians());
    }

    public void setDegrees(double degrees) {
        this.setRadians(Angle.degreesToRadians(degrees));
    }

    public boolean isSimplify() {
        return simplify;
    }

    public void setSimplify(boolean simplify) {
        this.simplify = simplify;
    }
}
