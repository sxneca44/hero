import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Game hero;

    public void Hero(int i, int i1) {
        Hero hero = new Hero(10, 10);
    }
    private Screen screen;

    public Game() {
        try {
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
        hero.draw();
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
            moveUp();
                    }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 's') {
            moveDown();
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'd') {
            moveRight();
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'a') {
            moveLeft();
        }
        if (key.getKeyType() == KeyType.ArrowUp) {
            moveUp();
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            moveDown();
        }
        if (key.getKeyType() == KeyType.ArrowRight) {
            moveRight();
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            moveLeft();
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
        }

    }

    private void moveLeft() {
    }

    private void moveRight() {
    }

    private void moveDown() {
    }

    private void moveUp() {
    }
}