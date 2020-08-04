package me.landervanlaer.games.TowerStack;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import me.landervanlaer.math.Coordinates;
import me.landervanlaer.objects.Drawable;
import me.landervanlaer.objects.Rectangle;

import java.util.ArrayList;

//--module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml

public class TowerStackGame extends Application implements Drawable {
    private int WIDTH = 600;
    private int HEIGHT = 500;
    private ArrayList<Block> blocks = new ArrayList<Block>();

    public static void main(String[] args) {
        TowerStackGame.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        blocks.add(new Block(new Rectangle(new Coordinates(10, 10), 100, 100)));


        Group group = new Group();
        Canvas canvas = new Canvas(this.getWIDTH(), this.getHEIGHT());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        this.draw(gc);
        group.getChildren().add(canvas);
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.show();
    }

    public void draw(GraphicsContext gc) {
        for(Block b : blocks) {
            b.draw(gc);
        }
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }
}
