import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private int x = 10;
    private int y = 10;
    private Screen screen;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.screen.setCursorPosition(null); // we don't need a cursor
            this.screen.startScreen(); // screens must be started
            this.screen.doResizeIfNecessary(); // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        this.screen.clear();
        this.screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        this.screen.refresh();
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
            y = y - 1;
                    }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 's') {
            y = y + 1;
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'd') {
            x = x + 1;
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'a') {
            x = x - 1;
        }
        if (key.getKeyType() == KeyType.ArrowUp) {
            y = y - 1;
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            y = y + 1;
        }
        if (key.getKeyType() == KeyType.ArrowRight) {
            x = x + 1;
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            x = x - 1;
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
        }

    }
}