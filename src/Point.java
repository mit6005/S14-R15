
/** Represents a point in 2D space. */
public class Point {
    private int x;
    private int y;
    
    /** Create a new point at (x, y). */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
