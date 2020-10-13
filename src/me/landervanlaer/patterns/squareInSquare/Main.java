package me.landervanlaer.patterns.squareInSquare;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage s) throws Exception {
        Canvas canvas = new Canvas(950, 950);
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setStroke(Color.BLACK);
        context.setLineWidth(.75);

        Pattern.draw(context, 100);

        s.setScene(new Scene(new Pane(canvas)));
        s.setTitle("square in square");
        s.show();
    }
}
