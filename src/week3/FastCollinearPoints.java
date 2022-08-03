import java.util.Arrays;

public class FastCollinearPoints {

    private int numOfSegments;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        int n = points.length;
        Point[] temp = new Point[n];
        for (int i = 0; i < n; i++) {
            temp[i] = points[i];
        }
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            Point ti = temp[i];
            Point[] others = new Point[n - (i + 1)];
            double[] d = new double[others.length];
            for (int j = i + 1; j < n; j++) {
                others[j - 1 - i] = temp[j];
            }
            Arrays.sort(others, ti.slopeOrder());

            int setSize = 1;
            for (int l = 1; l < others.length; l++) {
                double slope = ti.slopeTo(others[l - 1]);

                if (slope == ti.slopeTo(others[l])) {
                    setSize++;

                } else {
                    if (setSize >= 3) {
                        LineSegment seg = new LineSegment(ti, others[l - 1]);
                        System.out.println("test " + seg);
                    }
                    setSize = 1;
                }

            }
            if (setSize >= 3) {
                LineSegment seg = new LineSegment(ti, others[others.length - 1]);
                System.out.println("test " + seg);
            }

            for (int k = 0; k < d.length; k++) {
                d[k] = ti.slopeTo(others[k]);
            }
            // System.out.println(ti + " " + Arrays.toString(others));
            System.out.println(ti + " " + Arrays.toString(d));
        }
        numOfSegments++;

    }

    // the number of line segments
    public int numberOfSegments() {
        return numOfSegments;
    }

    // the line segments
    public LineSegment[] segments() {
        return null;

    }

    public static void main(String[] args) {
        Point[] points = new Point[] {
                new Point(1, 2),
                new Point(2, 4),
                new Point(3, 6),
                new Point(4, 8),
                new Point(5, 10),

                // new Point(10, 11),
                // new Point(20, 22),
                // new Point(30, 33),
                // new Point(40, 44),

                // new Point(1, 1),
                // new Point(2, 2),
                // new Point(3, 3),
                // new Point(4, 4),

                // new Point(15, 59),
                // new Point(23, 64),
                // new Point(73, 34),
                // new Point(24, 87),
        };

        FastCollinearPoints f = new FastCollinearPoints(points);
        System.out.println(f.numOfSegments);

    }
}