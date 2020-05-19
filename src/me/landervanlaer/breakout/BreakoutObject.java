package me.landervanlaer.breakout;

import java.awt.*;

interface BreakoutObject {
    Position pos = new Position(0, 0);
    boolean visible = true;

    void draw(Graphics g);

    void update(BreakoutGame breakoutGame);

    boolean isVisible();

    void setVisible(boolean visible);

    void unvisible();

    void visible();
}