package me.landervanlaer.games.TowerStack;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import me.landervanlaer.math.Coordinates;
import me.landervanlaer.objects.Drawable;
import me.landervanlaer.objects.Rectangle;

import java.util.ArrayList;

public class Block implements Drawable {
    private Rectangle rectangle;
    private Color fillColor = Color.LIGHTGOLDENRODYELLOW;
    private Color strokeColor = Color.BLACK;


    public Block(Coordinates c, double w, double h) {
        this(new Rectangle(c, w, h));
    }

    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.getFillColor());
        gc.fillRect(rectangle.getPosition().getX(),
                rectangle.getPosition().getY(),
                rectangle.getWidth(),
                rectangle.getHeight());
    }

    /**
     * TODO Lowering with screen
     *
     * @param blocks An {@link ArrayList<Block>} of all the blockss in the game.
     */
    public void update(ArrayList<Block> blocks) {
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }
}
