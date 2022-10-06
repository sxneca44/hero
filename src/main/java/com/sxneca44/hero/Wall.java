package com.sxneca44.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {

    public Position getPosition() {
        return this.position;
    }

    public Wall(int x, int y)
    {
        this.position = new Position(x, y);
    }
    private Position position;

    public void setPosition(Position position){
        this.position = position;
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#D21FB2"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }

}
