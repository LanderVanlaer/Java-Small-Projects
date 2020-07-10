package me.landervanlaer.breakout;

import java.awt.*;

abstract class BreakoutObject{
    private boolean visible = true;
    abstract void draw(Graphics g);

    abstract void update(Level level);

    public boolean isVisible(){
        return this.visible;
    };

    void setVisible(boolean visible){
        this.visible = visible;
    };
}