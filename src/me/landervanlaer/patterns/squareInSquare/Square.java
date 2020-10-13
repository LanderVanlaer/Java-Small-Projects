package me.landervanlaer.patterns.squareInSquare;

import javafx.scene.canvas.GraphicsContext;
import me.landervanlaer.math.Angle;
import me.landervanlaer.math.Coordinate;
import me.landervanlaer.objects.Drawable;

/**
 * A square that can be drawed.
 * Made for {@link Pattern}
 *
 * @author LanderVanlaer
 * @version 1.0 2020/10/13
 * @see Pattern
 * @see Main
 */
class Square extends me.landervanlaer.objects.Square implements Drawable {

    public Square(Coordinate position, double side) {
        super(position, side);
    }

    public Square(Coordinate position, Angle rotation, double side) {
        super(position, rotation, side);
    }

    /**
     * Draw a square on a {@link GraphicsContext}
     *
     * @param g The {@link GraphicsContext} to draw on
     * @see Pattern
     * @since 1.0
     */
    public void draw(GraphicsContext g) {
        if(getRotation() == null) this.setRotation(new Angle());


        Line[] lines;
        if(getRotation().getDegrees() == 45) {
            final double HALF_DIAGONAL = Math.hypot(getSide(), getSide());
            final double BOTTOM = getPosition().getY() + HALF_DIAGONAL;
            final double TOP = getPosition().getY() - HALF_DIAGONAL;
            final double RIGHT = getPosition().getX() + HALF_DIAGONAL;
            final double LEFT = getPosition().getX() - HALF_DIAGONAL;

            lines = new Line[]{
                    new Line(getPosition().getX(), TOP, RIGHT, getPosition().getY()),
                    new Line(RIGHT, getPosition().getY(), getPosition().getX(), BOTTOM),
                    new Line(getPosition().getX(), BOTTOM, LEFT, getPosition().getY()),
                    new Line(LEFT, getPosition().getY(), getPosition().getX(), TOP)
            };
        } else {
            final double HALF_DIAGONAL = getSide() / 2D;
            final double BOTTOM = getPosition().getY() + HALF_DIAGONAL;
            final double TOP = getPosition().getY() - HALF_DIAGONAL;
            final double RIGHT = getPosition().getX() + HALF_DIAGONAL;
            final double LEFT = getPosition().getX() - HALF_DIAGONAL;
            lines = new Line[]{
                    new Line(LEFT, TOP, RIGHT, TOP),
                    new Line(RIGHT, TOP, RIGHT, BOTTOM),
                    new Line(LEFT, BOTTOM, RIGHT, BOTTOM),
                    new Line(LEFT, BOTTOM, LEFT, TOP)
            };
        }
        for(Line l : lines)
            l.draw(g);
    }
}
