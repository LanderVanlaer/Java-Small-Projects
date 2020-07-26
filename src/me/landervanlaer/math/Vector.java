package me.landervanlaer.math;

public class Vector {
    private double speedX;
    private double speedY;

    public Vector() {
        this(0, 0);
    }

    public Vector(double speedX, double speedY) {
        this.setSpeedX(speedX);
        this.setSpeedY(speedY);
    }

    public Angle getAngle() {
        return new Angle(Math.acos(this.getSpeedX() / this.getTotalSpeed()));
    }

    public void setAngle(Angle angle) {
        this.setAngle(angle, this.getTotalSpeed());
    }

    public void setAngle(Angle angle, double speed) {
        final double rad = angle.getRadians();
        this.setSpeedX(Math.cos(rad) * speed);
        this.setSpeedY(Math.sin(rad) * speed);
    }

    public void add(Vector vector) {
        this.setSpeedX(this.getSpeedX() + vector.getSpeedX());
        this.setSpeedX(this.getSpeedY() + vector.getSpeedY());
    }

    public void subtract(Vector vector) {
        this.setSpeedX(this.getSpeedX() - vector.getSpeedX());
        this.setSpeedX(this.getSpeedY() - vector.getSpeedY());
    }

    public double getTotalSpeed() {
        return Math.hypot(this.getSpeedX(), this.getSpeedY());
    }

    public void invertSpeedX() {
        this.setSpeedX(-this.getSpeedX());
    }

    public void invertSpeedY() {
        this.setSpeedY(-this.getSpeedY());
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
