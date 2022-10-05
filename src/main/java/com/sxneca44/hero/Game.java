package com.sxneca44.hero;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;

    private Hero hero;
    public Game() {
        try {
            hero = new Hero(10,10);
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }


    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.EOF) {
                break;
            }
        }
    }

    private void processKey(KeyStroke key) throws IOException {
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
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
        }
    }
    private void moveHero(Position position) {
        hero.setPosition(position);
    }
}