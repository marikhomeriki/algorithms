import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // compare two points by y-coordinates, breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (y < that.y) {
            return -1;
        } else if (y > that.y) {
            return 1;
        } else if (x < that.x) {
            return -1;
        } else if (x > that.x) {
            return 1;
        } else {
            return 0;
        }
    }

    public double slopeTo(Point that) {
        if (that.y - y == 0 && that.x - x == 0) {
            return Double.NEGATIVE_INFINITY;
        } else if (that.x - x == 0) {
            return Double.POSITIVE_INFINITY;
        } else if (that.y - y == 0) {
            return +0.0;
        } else {
            return (double) (that.y - y) / (that.x - x);
        }
    }

    private class SlopeOrder implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            if (Point.this.slopeTo(o1) < Point.this.slopeTo(o2)) {
                return -1;
            } else if (Point.this.slopeTo(o1) > Point.this.slopeTo(o2)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    // compare two points by slopes they make with this point
    public Comparator<Point> slopeOrder() {
        return new SlopeOrder();
    }

    public static void main(String[] args) {
        Point p0 = new Point(1, 2);
        Point p1 = new Point(3, 6);
        Point p2 = new Point(1, 5);
        Comparator<Point> x = p0.slopeOrder();
        x.compare(p1, p2);
        System.out.println(p0.toString());
        p0.compareTo(p1);
        System.out.println(p0.compareTo(p1));
        System.out.println(p0.slopeTo(p1));
    }
}