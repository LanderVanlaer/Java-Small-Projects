package me.landervanlaer.objects;

import me.landervanlaer.math.Angle;
import me.landervanlaer.math.Coordinates;

/**
 * TODO Add contains Tests if the specified coordinates are inside the boundary of the Shape, as described by the definition of insideness.
 * TODO Get bounds, returns rectangle that contains the figure
 */
abstract public class Shape {
    /**
     * The {@link Coordinates} of the left top corner
     */
    private Coordinates position;
    private Angle rotation;


    //CONSTRUCTORS
    public Shape() {
        this(null, null);
    }

    public Shape(Coordinates position) {
        this(position, null);
    }

    public Shape(Coordinates position, Angle rotation) {
        this.position = position;
        this.rotation = rotation;
    }


    //GETTERS AND SETTERS
    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public Angle getRotation() {
        return rotation;
    }

    public void setRotation(Angle rotation) {
        this.rotation = rotation;
    }

    //ABSTRACT
    abstract public double getArea();

    abstract public double getPerimeter();
}
