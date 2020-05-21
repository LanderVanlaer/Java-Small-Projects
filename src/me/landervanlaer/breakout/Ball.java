package me.landervanlaer.breakout;

import java.awt.*;

public class Ball implements BreakoutObject {
    public static final int WIDTH = 10;
    public static final int SPEED = 8;
    private Position pos;
    private Vector vector;
    private Color color = Color.white;
    private boolean visible = true;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public Ball(int x, int y) {
        this(x, y, null);
    }

    public Ball(int x, int y, Integer degrees) {
        setPos(x, y);
        if(degrees == null) degrees = -90;
        setVector(new Vector(degrees, Ball.SPEED));
    }

    public void update(Level level) {
        //VALIDATE BORDERS
        if(this.getPos().getX() < 0) {
            this.getPos().setX(0);
            this.getVector().invertSpeedX();
        } else if(this.getPos().getX() + Ball.WIDTH > BreakoutGame.WIDTH) {
            this.getPos().setX(BreakoutGame.WIDTH - Ball.WIDTH);
            this.getVector().invertSpeedX();
        }
        if(this.getPos().getY() < 0) {
            this.getPos().setY(0);
            this.getVector().invertSpeedY();
        } else if(this.getPos().getY() + Ball.WIDTH > BreakoutGame.HEIGHT) {
            //DELETE
            this.unvisible();
        }


        //COLLISIONS PADDLE
        if(this.pos.getX() + Ball.WIDTH >= level.getPaddle().getPos().getX()
                && this.pos.getX() <= level.getPaddle().getPos().getX() + level.getPaddle().getWidth()
                && this.pos.getY() + Ball.WIDTH >= level.getPaddle().getPos().getY()
                && this.pos.getY() <= level.getPaddle().getPos().getY() + level.getPaddle().getHeight()) {

            final int lengthDifferencePaddleLeft = this.pos.getX() + Ball.WIDTH - level.getPaddle().getPos().getX();
            final int lengthDifferencePaddleRight = level.getPaddle().getPos().getX() + level.getPaddle().getWidth() - this.pos.getX();
            final int lengthDifferencePaddleTop = this.pos.getY() + Ball.WIDTH - level.getPaddle().getPos().getY();
            final int lengthDifferencePaddleBottom = level.getPaddle().getPos().getY() + level.getPaddle().getHeight() - this.pos.getY();

            final int min = Math.min(Math.min(lengthDifferencePaddleTop, lengthDifferencePaddleBottom), Math.min(lengthDifferencePaddleLeft, lengthDifferencePaddleRight));
            if(min == lengthDifferencePaddleLeft || min == lengthDifferencePaddleRight) {
                this.getVector().invertSpeedX();
            } else {
                this.getVector().invertSpeedY();
            }
        }

        //COLLISIONS BLOCKS
        for(Block block : level.getBlockList()) {
            if(this.pos.getX() + Ball.WIDTH >= block.getPos().getX()
                    && this.pos.getX() <= block.getPos().getX() + block.getWidth()
                    && this.pos.getY() + Ball.WIDTH >= block.getPos().getY()
                    && this.pos.getY() <= block.getPos().getY() + block.getHeight()) {

                //TOUCHING BLOCK
                block.hit();

                final int lengthDifferenceBlockLeft = this.pos.getX() + Ball.WIDTH - block.getPos().getX();
                final int lengthDifferenceBlockRight = block.getPos().getX() + block.getWidth() - this.pos.getX();
                final int lengthDifferenceBlockTop = this.pos.getY() + Ball.WIDTH - block.getPos().getY();
                final int lengthDifferenceBlockBottom = block.getPos().getY() + block.getHeight() - this.pos.getY();

                final int min = Math.min(Math.min(lengthDifferenceBlockTop, lengthDifferenceBlockBottom), Math.min(lengthDifferenceBlockLeft, lengthDifferenceBlockRight));
                if(min == lengthDifferenceBlockLeft) {
                    this.pos.setX(block.getPos().getX() - Ball.WIDTH);
                    this.getVector().invertSpeedX();
                } else if(min == lengthDifferenceBlockRight) {
                    this.pos.setX(block.getPos().getX() + block.getWidth());
                    this.getVector().invertSpeedX();
                } else if(min == lengthDifferenceBlockTop) {
                    this.pos.setY(block.getPos().getY() - Ball.WIDTH);
                    this.getVector().invertSpeedY();
                } else {
                    this.pos.setY(block.getPos().getY() + block.getHeight());
                    this.getVector().invertSpeedY();
                }
            }
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
