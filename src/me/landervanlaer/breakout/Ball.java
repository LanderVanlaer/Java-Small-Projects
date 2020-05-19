package me.landervanlaer.breakout;

import java.awt.*;

public class Ball implements BreakoutObject {
    public static final int WIDTH = 10;
    public static final int SPEED = 8;
    private Position pos;
    private Vector vector;
    private Color color = Color.white;
    private boolean visible;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Ball(int x, int y) {
        this(x, y, new Vector(0D, 0D));
    }

    public Ball(int x, int y, Vector vector) {
        setPos(x, y);
        if(vector != null) {
            setVector(vector);
        } else {
            setVector(new Vector(0D, 0D));
        }
        System.out.println(this.getVector().getSpeedX());
        System.out.println(this.getVector().getSpeedY());
    }

    public void update(BreakoutGame breakoutGame) {
        //VALIDATE BORDERS
        if(this.getPos().getX() < 0) {
            this.getPos().setX(0);
            this.getVector().invertSpeedX();
        } else if(this.getPos().getX() + Ball.WIDTH > BreakoutGame.WIDTH) {
            this.getPos().setX(BreakoutGame.WIDTH - Ball.WIDTH);
            this.getVector().invertSpeedX();
        }
        if(this.getPos().getY() < 0) {
            //DELETE
            this.unvisible();
        } else if(this.getPos().getY() + Ball.WIDTH > BreakoutGame.HEIGHT) {
            this.getPos().setY(BreakoutGame.HEIGHT - Ball.WIDTH);
            this.getVector().invertSpeedY();
        }


        //COLLISIONS
        if(this.pos.getX() + this.WIDTH >= breakoutGame.getPaddle().getPos().getX()
                && this.pos.getX() <= breakoutGame.getPaddle().getPos().getX() + breakoutGame.getPaddle().getWidth()
                && (this.pos.getY() + this.WIDTH >= breakoutGame.getPaddle().getPos().getY()
                && this.pos.getY() <= breakoutGame.getPaddle().getPos().getY() + breakoutGame.getPaddle().getHeight())) {

            if(this.pos.getY() + this.WIDTH >= breakoutGame.getPaddle().getPos().getY()
                    && this.pos.getY() <= breakoutGame.getPaddle().getPos().getY() + breakoutGame.getPaddle().getHeight()) {
                this.getVector().invertSpeedY();
            } else
                this.getVector().invertSpeedX();
        }


        this.getPos().setX((int) Math.round(this.getPos().getX() + this.getVector().getSpeedX()));
        this.getPos().setY((int) Math.round(this.getPos().getY() + this.getVector().getSpeedY()));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fillOval(getPos().getX(), getPos().getY(), Ball.WIDTH, Ball.WIDTH);
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

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void setPos(int x, int y) {
        this.pos = new Position(x, y);
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }
}
