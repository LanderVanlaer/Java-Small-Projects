package me.landervanlaer.patterns.squareInSquare;

import javafx.scene.canvas.GraphicsContext;
import me.landervanlaer.math.Coordinate;
import me.landervanlaer.objects.Drawable;

/**
 * A line that can be drawed.
 * Made for {@link Pattern} and used by {@link Square} as an edge.
 *
 * @author LanderVanlaer
 * @version 1.0 2020/10/13
 * @see Pattern
 * @see Square
 * @see Main
 */
class Line extends me.landervanlaer.objects.Line implements Drawable {
    public Line(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    public Line(Coordinate pos1, Coordinate pos2) {
        super(pos1, pos2);
    }

    /**
     * Draw a line on a {@link GraphicsContext}
     *
     * @param g The {@link GraphicsContext} to draw on
     * @see Pattern
     * @see Square
     * @since 1.0
     */
    @Override
    public void draw(GraphicsContext g) {
        g.strokeLine(getPos1().getX(), getPos1().getY(), getPos2().getX(), getPos2().getY());
    }
}
