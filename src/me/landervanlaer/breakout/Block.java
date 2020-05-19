package me.landervanlaer.breakout;

import java.awt.*;

public class Block implements BreakoutObject {
    private boolean visible = true;
    private double health;
    public static final double hitHealthDifference = .2;
    private Position pos;

    public Block() {
        this(0, 0);
    }

    public Block(int x, int y) {
        this(new Position(x, y));
    }

    public Block(Position pos) {
        this.setPos(pos);
        this.setHealth(1);
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    @Override
    public void draw(Graphics g) {
    }

    @Override
    public void update(BreakoutGame breakoutGame) {
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void unvisible() {
        this.setVisible(false);
    }

    public void visible() {
        this.setVisible(true);
    }

}
