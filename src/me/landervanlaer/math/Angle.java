package me.landervanlaer.math;

public class Angle {
    private double rad;
    /**
     * If the {@link Angle} has to be simplified
     * <code>
     * //{@code true}
     * 370° == 10°
     * <p>
     * //{@code false}
     * 370° != 10°
     * </code>
     */
    private boolean simplify;

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

    public double getRadians() {
        return rad;
    }

    public void setRadians(double rad) {
        this.rad = rad;
    }

    public double getDegrees() {
        return Angle.radiansToDegrees(this.getRadians());
    }

    public void setDegrees(double degrees) {
        this.setRadians(Angle.degreesToRadians(degrees));
    }
}
