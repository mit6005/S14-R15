package staff;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Point origin = new Point(0, 0);
        Point oneZero = new Point(1, 0);
        Point zeroOne = new Point(0, 1);
        Point oneOne = new Point(1, 1);
        
        SortedSet<Point> points = new TreeSet<>(
            new Comparator<Point>() {
                public int compare(Point p1, Point p2) {
                    if (p2.x != p1.x) return p2.x - p1.x;
                    return p2.y - p1.y;
                }
            });
        points.add(origin);
        points.add(oneZero);
        points.add(zeroOne);
        points.add(oneOne);
        
        for (Point p : points) {
            System.out.println(p);
        }
    }
}
