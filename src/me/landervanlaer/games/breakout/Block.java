package me.landervanlaer.games.breakout;

import java.awt.*;

public class Block extends BreakoutObject {
    private double health;
    public static final double hitHealthDifference = .2;
    private Position pos;
    private int width;
    private int height;
    private Color color = Color.CYAN;

    public Block() {
        this(0, 0, 100, 50);
    }

    public Block(int x, int y, int width, int height) {
        this(new Position(x, y), width, height);
    }

    public Block(Position pos, int width, int height) {
        this.setPos(pos);
        this.setHealth(1D);
        this.setWidth(width);
        this.setHeight(height);
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fillRect(this.getPos().getX(), this.getPos().getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void update(Level level) {
        if(this.getHealth() <= 0D) {
            this.setVisible(false);
        } else
            this.setColor(new Color(
                    this.getColor().getRed(),
                    this.getColor().getGreen(),
                    this.getColor().getBlue(),
                    (int) (this.getHealth() * 255D)));
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

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void hit() {
        this.setHealth(this.getHealth() - Block.hitHealthDifference);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
