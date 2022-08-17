import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Queue;

public class PointSET {
    private SET<Point2D> points;

    public PointSET() {
        points = new SET<Point2D>();
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }

    public int size() {
        return points.size();
    }

    public void insert(Point2D point) {
        points.add(point);
    }

    public boolean contains(Point2D point) {
        return points.contains(point);
    }

    public void draw() {
        for (Point2D point : points) {
            point.draw();
        }
    }

    public Iterable<Point2D> range(RectHV rect) {
        Queue<Point2D> items = new Queue<Point2D>();

        for (Point2D point : points) {
            if (rect.contains(point)) {
                items.enqueue(point);
            }
        }

        return items;
    }

    public Point2D nearest(Point2D otherPoint) {
        Point2D nearest = null;

        for (Point2D point : points) {
            if (nearest == null || point.distanceSquaredTo(otherPoint) < nearest.distanceSquaredTo(otherPoint)) {
                nearest = point;
            }
        }

        return nearest;
    }
}