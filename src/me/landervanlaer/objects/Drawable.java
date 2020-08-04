package me.landervanlaer.objects;

import javafx.scene.canvas.GraphicsContext;

/**
 * A {@link Drawable} is a general abstraction for "something that can be drawn".
 */
public interface Drawable {
    void draw(GraphicsContext gc);
}