public class Map {
    private char[][] map;

    public Map(int width, int height) {
        map = new char[height][width];
        initializeMap();
    }

    private void initializeMap() {
        // Here you can populate the map with your desired initial layout
        // For example, you could fill it with '#' characters for walls
        // and ' ' characters for empty spaces
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                // Check if the position is on the edge of the map
                if (x == 0 || x == map[y].length - 1 || y == 0 || y == map.length - 1) {
                    map[y][x] = '#'; // Wall
                } else {
                    map[y][x] = ' '; // Empty space
                }
            }
        }
    }

    public char[][] getMap() {
        return map;
    }
}
