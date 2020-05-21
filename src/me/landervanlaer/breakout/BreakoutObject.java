package me.landervanlaer.breakout;

import java.awt.*;

interface BreakoutObject {
    void draw(Graphics g);

    void update(Level level);

    boolean isVisible();

    void setVisible(boolean visible);

    void unvisible();

    void visible();
}