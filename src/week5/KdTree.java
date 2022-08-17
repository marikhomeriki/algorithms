import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Queue;

public class KdTree {
    private Node root;
    private int size;

    private static class Node {
        private Point2D point;
        private RectHV rect;
        private Node left;
        private Node right;

        public Node(Point2D point, RectHV rect) {
            this.point = point;
            this.rect = rect;
        }
    }

    public KdTree() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(Point2D point) {
        root = insert(root, point, 0.0, 0.0, 1.0, 1.0, true);
    }

    public boolean contains(Point2D point) {
        return contains(root, point, true);
    }

    public void draw() {
        draw(root, true);
    }

    public Iterable<Point2D> range(RectHV rect) {
        Queue<Point2D> items = new Queue<>();
        range(root, rect, items);
        return items;
    }

    public Point2D nearest(Point2D point) {
        if (root == null) {
            return null;
        }

        return nearest(root, point, root.point, true);
    }

    private Node insert(Node node, Point2D point, double x0, double y0, double x1, double y1, boolean axis) {
        if (node == null) {
            size++;
            RectHV rect = new RectHV(x0, y0, x1, y1);
            return new Node(point, rect);
        }

        if (node.point.x() == point.x() && node.point.y() == point.y()) {
            return node;
        }

        if (axis) {
            double cmp = point.x() - node.point.x();

            if (cmp < 0) {
                node.left = insert(node.left, point, x0, y0, node.point.x(), y1, !axis);
            } else {
                node.right = insert(node.right, point, node.point.x(), y0, x1, y1, !axis);
            }
        } else {
            double cmp = point.y() - node.point.y();

            if (cmp < 0) {
                node.left = insert(node.left, point, x0, y0, x1, node.point.y(), !axis);
            } else {
                node.right = insert(node.right, point, x0, node.point.y(), x1, y1, !axis);
            }
        }

        return node;
    }

    private boolean contains(Node node, Point2D point, boolean axis) {
        if (node == null) {
            return false;
        }

        if (node.point.x() == point.x() && node.point.y() == point.y()) {
            return true;
        }

        if (axis) {
            double cmp = point.x() - node.point.x();

            if (cmp < 0) {
                return contains(node.left, point, !axis);
            } else {
                return contains(node.right, point, !axis);
            }
        } else {
            double cmp = point.y() - node.point.y();

            if (cmp < 0) {
                return contains(node.left, point, !axis);
            } else {
                return contains(node.right, point, !axis);
            }
        }
    }

    private void draw(Node node, boolean axis) {
        if (node == null) {
            return;
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        node.point.draw();

        if (axis) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius();
            StdDraw.line(node.point.x(), node.rect.ymin(), node.point.x(), node.rect.ymax());
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.setPenRadius();
            StdDraw.line(node.rect.xmin(), node.point.y(), node.rect.xmax(), node.point.y());
        }

        draw(node.left, !axis);
        draw(node.right, !axis);
    }

    private void range(Node node, RectHV rect, Queue<Point2D> items) {
        if (node == null) {
            return;
        }

        if (rect.contains(node.point)) {
            items.enqueue(node.point);
        }

        if (rect.intersects(node.rect)) {
            range(node.left, rect, items);
            range(node.right, rect, items);
        }
    }

    private Point2D nearest(Node node, Point2D point, Point2D closest, boolean axis) {
        if (node == null) {
            return closest;
        }

        if (node.point.distanceSquaredTo(point) < closest.distanceSquaredTo(point)) {
            closest = node.point;
        }

        if (node.rect.distanceSquaredTo(point) < closest.distanceSquaredTo(point)) {
            Node near = null;
            Node far = null;

            if ((axis && (point.x() < node.point.x())) || (!axis && (point.y() < node.point.y()))) {
                near = node.left;
                far = node.right;
            } else {
                near = node.right;
                far = node.left;
            }

            closest = nearest(near, point, closest, !axis);
            closest = nearest(far, point, closest, !axis);
        }

        return closest;
    }
}
