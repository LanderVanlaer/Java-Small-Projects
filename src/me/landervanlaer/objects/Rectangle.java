package me.landervanlaer.objects;

import me.landervanlaer.math.Angle;
import me.landervanlaer.math.Coordinate;

public class Rectangle extends Shape {
    private double width;

    private double height;


    public Rectangle(Coordinate position, double width, double height) {
        super(position);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Coordinate position, Angle rotation, double width, double height) {
        super(position, rotation);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return this.getWidth() * this.getHeight();
    }

    @Override
    public double getPerimeter() {
        return (this.getWidth() + this.getHeight()) * 2;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width <= 0) throw new Error("Length can't be negative or 0 ");
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height <= 0) throw new Error("Length can't be negative or 0 ");
        this.height = height;
    }
}
