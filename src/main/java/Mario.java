class Mario {
    private int x;
    private int y;
    private char symbol; // Store the symbol as a single character

    public Mario(int x, int y) {
        this.x = x;
        this.y = y;
        // Assign a default symbol for Mario
        this.symbol = 'M'; // You can change this to whatever character you like
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

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
        return symbol; // Return the single character symbol
    }

    // You can add a method to change Mario's symbol if needed
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
