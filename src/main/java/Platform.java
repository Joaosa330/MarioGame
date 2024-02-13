public class Platform {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public Platform(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Method to check if a point is within the bounds of the platform
    public boolean collidesWith(int otherX, int otherY) {
        return otherX >= x && otherX < x + width && otherY >= y && otherY < y + height;
    }
}
