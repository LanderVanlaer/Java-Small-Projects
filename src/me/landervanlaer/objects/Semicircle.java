package me.landervanlaer.objects;

import me.landervanlaer.math.Angle;
import me.landervanlaer.math.Coordinates;

public class Semicircle extends Circle {

    public Semicircle(Coordinates position, Angle rotation, double radius) {
        super(position, rotation, radius);
    }

    public Semicircle(Coordinates position, double radius) {
        super(position, null, radius);
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter() / 2;
    }

    @Override
    public double getArea() {
        return super.getArea() / 2;
    }
}
