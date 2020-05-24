package me.landervanlaer.breakout;

public class Vector {
    private double speedX;
    private double speedY;

    public static void main(String[] args) {
        Vector vector = new Vector(90, 10);
    }

    public Vector(double speedX, double speedY) {
        this.setSpeedX(speedX);
        this.setSpeedY(speedY);
    }

    public Vector(int degrees, double speed) {
        this.setDegrees(degrees, speed);
    }

    public int getDegrees() {
//        double acosValue = Math.acos(this.getSpeedX() / this.getTotalSpeed());
//        double asinValue = -Math.asin(this.getSpeedY() / this.getTotalSpeed());


        return (int)
                Math.round(
                        Math.acos(this.getSpeedX() / this.getTotalSpeed())
                                * 180D / Math.PI);
    }

    public void setDegrees(int degrees) {
        this.setDegrees(degrees, this.getTotalSpeed());
    }

    public void setDegrees(int degrees, double speed) {
        final double radians = -Math.PI / 180D * (double) degrees;
        this.setSpeedY(Math.sin(radians) * speed);
        this.setSpeedX(Math.cos(radians) * speed);
    }

    public double getTotalSpeed() {
        return Math.hypot(this.getSpeedX(), this.getSpeedY());
    }

    public void invertSpeedX() {
        this.setSpeedX(-speedX);
    }

    public void invertSpeedY() {
        this.setSpeedY(-speedY);
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }
}
