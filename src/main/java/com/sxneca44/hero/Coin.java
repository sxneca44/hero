package com.sxneca44.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element {


    public Coin (Position position)
    {
        super(position);
    }
    public Coin (int x, int y)
    {
        super(x, y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#eeff00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.position.getX(), super.position.getY()), "0");
    }
}
