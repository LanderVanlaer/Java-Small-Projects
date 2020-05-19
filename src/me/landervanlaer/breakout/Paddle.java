package me.landervanlaer.breakout;

import java.awt.*;

public class Paddle implements BreakoutObject {
    private Position pos;
    private Vector vector;
    private int width = 100;
    private int height = 15;
    public static final double SPEED = 2.5;
    public static final double MAX_SPEED = 12.5;
    private boolean visible;


    public Paddle(int x, int y) {
        this(new Position(x, y), new Vector(0, 0));
    }

    public Paddle(Position pos, Vector vector) {
        this.setPos(pos);
        this.setVector(vector);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(getPos().getX(), getPos().getY(), getWidth(), getHeight());
    }

    @Override
    public void update(BreakoutGame breakoutGame) {
        //VALIDATE BORDERS
        if(this.getPos().getX() < 0) {
            this.getPos().setX(0);
            this.getVector().setSpeedX(0);
        } else if(this.getPos().getX() + this.width > BreakoutGame.WIDTH) {
            this.getPos().setX(BreakoutGame.WIDTH - this.width);
            this.getVector().setSpeedY(0);
        }


        if(this.getVector().getSpeedX() < -Paddle.MAX_SPEED)
            this.getVector().setSpeedX(-Paddle.MAX_SPEED);
        else if(this.getVector().getSpeedX() > Paddle.MAX_SPEED)
            this.getVector().setSpeedX(Paddle.MAX_SPEED);
        this.getPos().setX((int) Math.round(this.getPos().getX() + this.getVector().getSpeedX()));
        this.getPos().setY((int) Math.round(this.getPos().getY() + this.getVector().getSpeedY()));
    }

    public void idle() {
        this.getVector().setSpeedX(this.getVector().getSpeedX() / 2D);
    }

    public void left() {
        this.getVector().setSpeedX(this.getVector().getSpeedX() - Paddle.SPEED);
    }

    public void right() {
        this.getVector().setSpeedX(this.getVector().getSpeedX() + Paddle.SPEED);
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void unvisible() {
        this.setVisible(false);
    }

    public void visible() {
        this.setVisible(true);
    }
}
