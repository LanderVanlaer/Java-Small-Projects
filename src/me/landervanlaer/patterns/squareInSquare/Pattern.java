package me.landervanlaer.patterns.squareInSquare;

import javafx.scene.canvas.GraphicsContext;
import me.landervanlaer.math.Angle;
import me.landervanlaer.math.Coordinate;

/**
 * A Pattern that drawes squares alternately rotated to 0° and 45°
 *
 * @author LanderVanlaer
 * @version 1.0 2020/10/13
 */
public class Pattern {
    /**
     * Draw squares alternately rotated to 0° and 45°
     *
     * @param g      The {@link GraphicsContext} to draw on
     * @param amount The number of squares you want to draw
     * @since 1.0
     */
    public static void draw(GraphicsContext g, int amount) {
        final double WIDTH = g.getCanvas().getWidth();
        final double HEIGHT = g.getCanvas().getHeight();

        final Angle NORMAL_ANGLE = new Angle(0);
        final Angle ROTATED_ANGLE = new Angle(Angle.degreesToRadians(45));

        final Coordinate MIDDLE_POINT = new Coordinate(WIDTH / 2D, HEIGHT / 2D);

        double side = WIDTH;
        for(int i = 0; i < amount; i++) {
            side = Math.hypot(side / 2D, side / 2D);
            //random colors
//            g.setStroke(new Color(Math.random(), Math.random(), Math.random(), 1D));

            Square square = new Square(
                    MIDDLE_POINT,
                    i % 2D == 0 ? ROTATED_ANGLE : NORMAL_ANGLE,
                    side
            );
            square.draw(g);
        }
    }
}
