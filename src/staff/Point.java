package staff;

/** Represents a point in 2D space. */
public class Point implements Comparable<Point> {
    public int x;
    public int y;
    
    /** Create a new point at (x, y). */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
    
    public int compareTo(Point other) {
        if (other.x != this.x) return this.x - other.x;
        return this.y - other.y;
    }
}
