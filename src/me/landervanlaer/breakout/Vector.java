package me.landervanlaer.breakout;

public class Vector {
    private double speedX;
    private double speedY;

    public Vector(double speedX, double speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public Vector(int degrees, double speed) {
        final double radians = -(Math.PI / 180D * (double) degrees);
        this.setSpeedY(Math.sin(radians) * speed);
        this.setSpeedX(Math.cos(radians) * speed);
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
