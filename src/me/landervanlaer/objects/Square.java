package me.landervanlaer.objects;

import me.landervanlaer.math.Angle;
import me.landervanlaer.math.Coordinates;

public class Square extends Shape {
    /**
     * The length of 1 side
     */
    public double side;

    public Square(Coordinates position, double side) {
        this(position, null, side);
    }

    public Square(Coordinates position, Angle rotation, double side) {
        super(position, rotation);
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(this.getSide(), 2);
    }

    @Override
    public double getPerimeter() {
        return this.getSide() * 4;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if(side <= 0) throw new Error("Length can't be negative or 0 ");
        this.side = side;
    }
}
