package me.landervanlaer.breakout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BreakoutGame extends JFrame implements Runnable, KeyListener {
    public static final int HEIGHT = 720;
    public static final int WIDTH = HEIGHT / 9 * 16;
    public static final int FPS = 60;
    private Thread thread;
    private Image img;
    private Graphics g;
    private ArrayList<Ball> ballList;
    private ArrayList<Block> blockList;
    private Paddle paddle;
    private boolean left = false;
    private boolean right = false;

    public BreakoutGame() {
        super("Breakout");
        this.setBackground(Color.BLACK);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.addKeyListener(this);


        this.setImg(createImage(WIDTH, HEIGHT));
        this.setG(img.getGraphics());

        this.setBallList(new ArrayList<Ball>());
        this.addBall(
                (int) Math.round(BreakoutGame.WIDTH / 2D),
                (int) Math.round(BreakoutGame.HEIGHT / 2D),
                new Vector((int) (Math.random() * 90D) - 135, Ball.SPEED));

        this.setPaddle(new Paddle((int) (BreakoutGame.WIDTH / 2D), (int) (BreakoutGame.HEIGHT / 10D * 9.5)));

        this.paint(this.getGraphics());
        this.update();

        this.setThread(new Thread(this));
        this.getThread().start();
    }

    public static void main(String[] args) {
        new BreakoutGame();
    }

    public void update() {
        if(this.left || this.right) {
            if(this.left)
                this.getPaddle().left();
            if(this.right)
                this.getPaddle().right();
        } else this.getPaddle().idle();

        this.getPaddle().update(this);
        for(int i = 0; i < this.getBallListSize(); i++) {
            if(!this.getBall(i).isVisible())
                this.removeBallList(i);
            else
                this.getBall(i).update(this);
        }
        for(int i = 0; i < this.getBlockListSize(); i++) this.getBlock(i).update(this);
    }


    @Override
    public void paint(Graphics graphics) {
        Graphics g = this.getG();
        if(g == null) return;

        //CLEAR
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //PADDLE
        if(this.getPaddle() != null) this.getPaddle().draw(g);

        //BALLS
        for(int i = 0; i < this.getBallListSize(); i++) this.getBall(i).draw(g);

        //BLOCKS
        for(int i = 0; i < this.getBlockListSize(); i++) this.getBlock(i).draw(g);


        graphics.drawImage(img, 0, 0, null);
        this.update();
    }

    @Override
    public void run() {
        boolean stillPlaying = true;
        while(stillPlaying) {
            this.paint(this.getGraphics());
            try {
                Thread.sleep(1000 / BreakoutGame.FPS);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                this.setLeft(true);
                break;
            case KeyEvent.VK_RIGHT:
                this.setRight(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                this.setLeft(false);
                break;
            case KeyEvent.VK_RIGHT:
                this.setRight(false);
                break;
        }
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    private void addBall(int x, int y, Vector vec) {
        this.ballList.add(new Ball(x, y, vec));
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }


    public Ball getBall(int i) {
        return this.ballList.get(i);
    }

    public ArrayList<Ball> getBallList() {
        return ballList;
    }

    public void setBallList(ArrayList<Ball> ballList) {
        this.ballList = ballList;
    }

    public int getBallListSize() {
        return this.ballList != null ? this.ballList.size() : 0;
    }

    public Block getBlock(int i) {
        return this.blockList.get(i);
    }

    public int getBlockListSize() {
        return this.blockList != null ? this.blockList.size() : 0;
    }

    public ArrayList<Block> getBlockList() {
        return blockList;
    }

    public void setBlockList(ArrayList<Block> blockList) {
        this.blockList = blockList;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    public void removeBallList(int i) {
        this.ballList.remove(i);
    }

}
