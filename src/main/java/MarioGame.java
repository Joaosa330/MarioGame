import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class MarioGame {
    private TerminalScreen screen;
    private Mario mario;
    private Map map;

    public MarioGame() {
        try {
            screen = new TerminalScreen(new DefaultTerminalFactory().createTerminal());
            screen.startScreen();
            screen.setCursorPosition(null);
            // Adjust map size based on terminal size
            TerminalSize terminalSize = screen.getTerminalSize();
            map = new Map(terminalSize.getColumns(), terminalSize.getRows());
            mario = new Mario(0, 0, 'M');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            boolean running = true;
            while (running) {
                screen.clear();
                renderGame();
                screen.refresh();

                KeyStroke keyStroke = screen.pollInput();
                if (keyStroke != null) {
                    processInput(keyStroke);
                    if (keyStroke.getKeyType() == KeyType.Escape) {
                        running = false;
                    }
                }
            }
            screen.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void renderGame() throws IOException {
        char[][] gameMap = map.getMap();
        for (int y = 0; y < gameMap.length; y++) {
            for (int x = 0; x < gameMap[y].length; x++) {
                TextCharacter character = new TextCharacter(gameMap[y][x]);
                screen.setCharacter(x, y, character);
            }
        }
        renderMap();
        renderMario(); // Call renderMario() to render Mario on top of the map
        screen.refresh();
    }
    private void renderMario() throws IOException {
        TextCharacter marioCharacter = new TextCharacter('M');
        screen.setCharacter(mario.getX(), mario.getY(), marioCharacter);
    }

    private void renderMap() throws IOException {
        char[][] gameMap = map.getMap();
        for (int y = 0; y < gameMap.length; y++) {
            for (int x = 0; x < gameMap[y].length; x++) {
                TextCharacter character = new TextCharacter(gameMap[y][x]);
                screen.setCharacter(x, y, character);
            }
        }
    }


    private void processInput(KeyStroke keyStroke) {
        switch (keyStroke.getKeyType()) {
            case ArrowUp:
                mario.moveUp();
                break;
            case ArrowDown:
                mario.moveDown();
                break;
            case ArrowLeft:
                mario.moveLeft();
                break;
            case ArrowRight:
                mario.moveRight();
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        MarioGame game = new MarioGame();
        game.run();
    }
}
