import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class MarioGame {

    public static void main(String[] args) {
        Terminal terminal = TerminalFacade.createTerminal();
        terminal.enterPrivateMode();

        int marioX = 5;
        int marioY = 5;

        while (true) {
            terminal.moveCursor(marioX, marioY);
            terminal.putCharacter('M');

            Key key;
            do {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                key = terminal.readInput();
            } while (key == null);

            terminal.moveCursor(marioX, marioY);
            terminal.putCharacter(' ');

            switch (key.getKind()) {
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
                case Escape:
                    terminal.exitPrivateMode();
                    return;
            }
        }
    }
}
