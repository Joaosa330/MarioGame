public class Mario {
    private int x;
    private int y;
    private char symbol;

    // Constructor
    public Mario(int x, int y, char m) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    // Getter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Movement methods
    public void moveUp() {
        y--;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }
    public char getSymbol() {
        return symbol;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
