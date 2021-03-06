package me.landervanlaer.objects;

import me.landervanlaer.math.Angle;
import me.landervanlaer.math.Coordinate;

import java.awt.*;

/**
 * TODO Add contains Tests if the specified coordinates are inside the boundary of the Shape, as described by the definition of insideness.
 * TODO Get bounds, returns rectangle that contains the figure
 * {@link Shape} and other objects needs to be recreated.
 *
 * @deprecated
 */
@Deprecated
abstract public class Shape {
    /**
     * The {@link Coordinate} of the left top corner
     */
    private Coordinate position;
    private Angle rotation;
    private Color color;

    //CONSTRUCTORS
    public Shape() {
        this(null, null);
    }

    public Shape(Coordinate position) {
        this(position, null);
    }

    public Shape(Coordinate position, Angle rotation) {
        this.position = position;
        this.rotation = rotation;
    }


    //GETTERS AND SETTERS
    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Angle getRotation() {
        return rotation;
    }

    public void setRotation(Angle rotation) {
        this.rotation = rotation;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //ABSTRACT
    abstract public double getArea();

    abstract public double getPerimeter();
}
