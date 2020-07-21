package me.landervanlaer.objects;

public class Ellipse extends Shape {
    private double radius0;
    private double radius1;

    @Override
    public double getArea() {
        return this.getRadius0() * this.getRadius1() * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt(
                (Math.pow(this.getRadius0(), 2) + Math.pow(this.getRadius1(), 2))
                        / 2
        );
    }

    public double getRadius0() {
        return radius0;
    }

    public void setRadius0(double radius0) {
        if(radius0 <= 0) throw new Error("Length can't be negative or 0 ");
        this.radius0 = radius0;
    }

    public double getRadius1() {
        return radius1;
    }

    public void setRadius1(double radius1) {
        if(radius1 <= 0) throw new Error("Length can't be negative or 0 ");
        this.radius1 = radius1;
    }
}
