package com.sxneca44.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;

    private Wall wall = new Wall (this.width, this.height);
    private List<Wall> walls;
    private List<Coin> coins;
    private Coin coin;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    private void retrieveCoins() {
        for (Coin coin : coins) {
            if (this.hero.getPosition().equals(coin.getPosition())) {
                coins.remove(coin);
                break;
            }

        }
    }

    public Arena(int width, int height) {
        this.hero = new Hero(10, 10);
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins();
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        List<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1,
                    random.nextInt(height - 2) + 1));
        return coins;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
        for (Coin coin : coins) {
            coin.draw(graphics);
        }
        this.hero.draw(graphics);
    }
    private boolean canHeroMove(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {
                return false;
            }
        }
        return true;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
    public void processKey(KeyStroke key) throws IOException {
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'w') {
            moveHero(hero.moveUp());
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 's') {
            moveHero(hero.moveDown());
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'd') {
            moveHero(hero.moveRight());
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'a') {
            moveHero(hero.moveLeft());
        }
        if (key.getKeyType() == KeyType.ArrowUp) {
            moveHero(hero.moveUp());
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            moveHero(hero.moveDown());
        }
        if (key.getKeyType() == KeyType.ArrowRight) {
            moveHero(hero.moveRight());
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            moveHero(hero.moveLeft());
        }
        retrieveCoins();
    }
}
