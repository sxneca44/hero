package com.sxneca44.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{

    public Monster(int x, int y){
        super(x,y);
    }

    public Position move(Monster monster){
        Random random = new Random();
        int cont = random.nextInt(4);
            if (cont == 0) {
                position.setX(position.getX() - 1);
                return position;
            }
            if (cont == 1) {
                position.setX(position.getX() + 1);
                return position;
            }
            if (cont == 2) {
                position.setX(position.getY() - 1);
                return position;
            }
            if (cont == 3) {
                position.setX(position.getY() + 1);
                return position;
            }
        return position;
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ff1a1a"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.position.getX(), super.position.getY()), "M");
    }

}
