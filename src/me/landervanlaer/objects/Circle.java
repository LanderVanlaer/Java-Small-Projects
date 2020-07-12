package me.landervanlaer.objects;

import me.landervanlaer.math.Angle;
import me.landervanlaer.math.Coordinates;

public class Circle extends Shape {
    private double radius;


    public Circle(Coordinates position, double radius) {
        this(position, null, radius);
    }

    public Circle(Coordinates position, Angle rotation, double radius) {
        super(position, rotation);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.pow(this.getRadius(), 2) * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return this.getRadius() * 2 * Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(radius <= 0) throw new Error("Length can't be negative or 0 ");
        this.radius = radius;
    }
}
