import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;

public class MarioGame {
    private final Terminal terminal;
    private int marioX;
    private int marioY;

    public MarioGame() throws IOException {
        terminal = new DefaultTerminalFactory().createTerminal();
        terminal.setCursorVisible(false);
        marioX = 5;
        marioY = 5;
    }

    public void run() throws IOException {
        boolean running = true;
        while (running) {
            terminal.clearScreen();
            renderMario();
            terminal.flush();

            KeyStroke keyStroke = terminal.pollInput();
            if (keyStroke != null) {
                processInput(keyStroke);
                if (keyStroke.getKeyType() == KeyType.Escape) {
                    running = false;
                }
            }
        }
    }

    private void renderMario() throws IOException {
        terminal.setCursorPosition(marioX, marioY);
        terminal.setForegroundColor(TextColor.ANSI.RED);
        terminal.putCharacter('M');
    }

    private void processInput(KeyStroke keyStroke) {
        switch (keyStroke.getKeyType()) {
            case ArrowUp:
                marioY--;
                break;
            case ArrowDown:
                marioY++;
                break;
            case ArrowLeft:
                marioX--;
                break;
            case ArrowRight:
                marioX++;
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        try {
            MarioGame game = new MarioGame();
            game.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
