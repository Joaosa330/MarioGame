public class Map {
    private char[][] map;
    private int width;
    private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        initializeMap();
    }

    private void initializeMap() {
        map = new char[height][width];
        // Initialize map with empty spaces
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                map[y][x] = ' ';
            }
        }
        // Add walls or other obstacles if needed
    }

    public void placeMario(Mario mario) {
        // Find the first free space at the bottom left
        for (int y = height - 1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                if (map[y][x] == ' ') {
                    mario.setX(x);
                    mario.setY(y);
                    return;
                }
            }
        }
    }

    public char[][] getMap() {
        return map;
    }
}
