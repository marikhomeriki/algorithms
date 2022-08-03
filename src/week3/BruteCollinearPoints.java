import java.util.Arrays;

public class BruteCollinearPoints {

    private int numOfSegments;
    private LineSegment[] segments = new LineSegment[2];

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        Point pi = points[i];
                        Point pj = points[j];
                        Point pk = points[k];
                        Point pl = points[l];
                        if (pi.slopeTo(pj) == pi.slopeTo(pk) && pi.slopeTo(pk) == pi.slopeTo(pl)) {
                            Point[] ps = new Point[] { pi, pj, pk, pl };
                            Arrays.sort(ps);
                            LineSegment seg = new LineSegment(ps[0], ps[3]);
                            if (numOfSegments == segments.length) {
                                int size = segments.length * 2;
                                resize(size);
                            }
                            segments[numOfSegments] = seg;
                            numOfSegments++;
                        }

                    }
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return numOfSegments;
    }

    public LineSegment[] segments() {
        int n = segments.length;
        if (n > numOfSegments) {
            resize(numOfSegments);
        }
        return segments;
    }

    private void resize(int size) {
        LineSegment[] temp = new LineSegment[size];
        for (int i = 0; i < numOfSegments; i++) {
            temp[i] = segments[i];
        }
        segments = temp;
    }

    public static void main(String[] args) {
        Point[] points = new Point[] {
                new Point(1, 2),
                new Point(2, 4),
                new Point(3, 6),
                new Point(4, 8),

                new Point(10, 11),
                new Point(20, 22),
                new Point(30, 33),
                new Point(40, 44),

                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4),

                new Point(15, 59),
                new Point(23, 64),
                new Point(73, 34),
                new Point(24, 87),
        };

        BruteCollinearPoints x = new BruteCollinearPoints(points);
        System.out.println(Arrays.toString(x.segments()));
        System.out.println(x.numOfSegments);
    }
}
