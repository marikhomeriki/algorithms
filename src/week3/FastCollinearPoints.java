import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private LineSegment[] segments;

    public FastCollinearPoints(Point[] points) {
        Point[] master = Arrays.copyOf(points, points.length);
        Point[] buffer = Arrays.copyOf(points, points.length);
        ArrayList<LineSegment> list = new ArrayList<LineSegment>();
        Arrays.sort(master);

        for (int i = 0; i < master.length; ++i) {
            Point origin = master[i];
            Arrays.sort(buffer);
            Arrays.sort(buffer, origin.slopeOrder());

            int count = 1;
            Point start = buffer[0];

            for (int j = 0; j < buffer.length - 1; ++j) {
                if (buffer[j].slopeTo(origin) == buffer[j + 1].slopeTo(origin)) {
                    count++;
                    if (count == 2) {
                        start = buffer[j];
                        count++;
                    } else if (count >= 4 && j + 1 == buffer.length - 1) {
                        if (start.compareTo(origin) > 0) {
                            list.add(new LineSegment(origin, buffer[j + 1]));
                        }
                        count = 1;
                    }
                } else if (count >= 4) {
                    if (start.compareTo(origin) > 0) {
                        list.add(new LineSegment(origin, buffer[j]));
                    }
                    count = 1;
                } else {
                    count = 1;
                }

            }
            if (count >= 3 && start.compareTo(origin) > 0) {
                list.add(new LineSegment(origin, buffer[buffer.length - 1]));
            }
        }

        segments = list.toArray(new LineSegment[list.size()]);
    }

    public int numberOfSegments() {
        return segments.length;
    }

    public LineSegment[] segments() {
        return Arrays.copyOf(segments, numberOfSegments());
    }

    public static void main(String[] args) {
        Point[] points = new Point[] {
                new Point(1, 2),
                new Point(2, 4),
                new Point(3, 6),
                new Point(4, 8),
                new Point(5, 10),
                new Point(6, 12),
                new Point(7, 14),
                new Point(8, 16),
                new Point(9, 18),
                new Point(10, 20),

                new Point(10, 11),
                new Point(20, 22),
                new Point(30, 33),
                new Point(40, 44),

                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4),

                new Point(15, 59),
                new Point(23, 24),
                new Point(73, 34),
                new Point(24, 87),
        };

        FastCollinearPoints f = new FastCollinearPoints(points);
        System.out.println(Arrays.toString(f.segments()));
    }
}