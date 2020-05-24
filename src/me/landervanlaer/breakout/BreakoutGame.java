package me.landervanlaer.breakout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BreakoutGame extends JFrame implements Runnable, KeyListener {
    public static final int HEIGHT = 720;
    public static final int WIDTH = HEIGHT / 9 * 16;
    public static final int FPS = 60;
    private Thread thread;
    private Image img;
    private Graphics g;
    private boolean left = false;
    private boolean right = false;
    private Level level;

    public BreakoutGame(int levelId) {
        super("Breakout");
        this.setBackground(Color.BLACK);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.addKeyListener(this);

        this.setLevel(new Level(1));

        this.setImg(createImage(WIDTH, HEIGHT));
        this.setG(img.getGraphics());

        this.setLevel(new Level(levelId));

        this.paint(this.getGraphics());
        this.update();

        this.setThread(new Thread(this));
        this.getThread().start();
    }


    public void update() {
        if(this.getLevel().getPaddle() == null) return;

        if(this.isLeft() || this.isRight()) {
            if(this.isLeft())
                this.getLevel().getPaddle().left();
            if(this.isRight())
                this.getLevel().getPaddle().right();
        } else this.getLevel().getPaddle().idle();


        this.getLevel().getPaddle().update(this.getLevel());

        //UPDATE BALLS
        for(int i = 0; i < this.getLevel().getBallListSize(); i++) {
            this.getLevel().getBallList().get(i).update(this.getLevel());
        }

        for(int i = 0; i < this.getLevel().getBallListSize(); i++) {
            if(!this.getLevel().getBallList().get(i).isVisible())
                this.getLevel().getBallList().remove(i);
        }
        if(this.getLevel().getBallListSize() == 0) this.gameOver();


        //UPDATE BLOCK
        for(int i = 0; i < this.getLevel().getBlockListSize(); i++) {
            this.getLevel().getBlockList().get(i).update(this.getLevel());
        }

        for(int i = 0; i < this.getLevel().getBlockListSize(); i++) {
            if(!this.getLevel().getBlockList().get(i).isVisible())
                this.getLevel().getBlockList().remove(i);
        }
        if(this.getLevel().getBlockListSize() == 0) this.gameOver();
    }


    @Override
    public void paint(Graphics graphics) {
        Graphics g = this.getG();
        if(g == null) return;


        //CLEAR
        g.clearRect(0, 0, WIDTH, HEIGHT);

        this.update();

        g.setColor(Color.GREEN);
        this.getG().setFont(new Font("Monospaced", Font.PLAIN, 20));
        this.getG().drawString(
                "BallListSize " + this.getLevel().getBallListSize() +
                        ",  BlockListSize " + this.getLevel().getBlockListSize() +
                        ",  X: " + this.getLevel().getPaddle().getPos().getX() +
                        "   Y: " + this.getLevel().getPaddle().getPos().getY(),
                20, 50);

        g.setColor(Color.WHITE);

        //PADDLE
        if(this.getLevel().getPaddle() != null) this.getLevel().getPaddle().draw(g);

        //BALLS
        for(int i = 0; i < this.getLevel().getBallListSize(); i++) this.getLevel().getBallList().get(i).draw(g);

        //BLOCKS
        for(int i = 0; i < this.getLevel().getBlockListSize(); i++) this.getLevel().getBlockList().get(i).draw(g);


        graphics.drawImage(img, 0, 0, null);
    }

    public void gameOver() {
        this.getG().setColor(Color.GREEN);
        this.getG().setFont(new Font("Arial Black", Font.PLAIN, 30));
        this.getG().drawString("Game Over", BreakoutGame.WIDTH / 2, BreakoutGame.HEIGHT / 2);
        this.getG().drawImage(img, 0, 0, null);
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
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
}
