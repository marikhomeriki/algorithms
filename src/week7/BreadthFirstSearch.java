import edu.princeton.cs.algs4.Queue;

public class BreadthFirstSearch {
    private static final int INFINITY = Integer.MAX_VALUE;
    private int[] distTo;
    private int[] edgeTo;
    private boolean[] marked;

    public BreadthFirstSearch(Graph G, int v) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        validVertex(v);
        bfs(G, v);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = INFINITY;
        }
        distTo[s] = 0;
        marked[s] = true;

    }

    private void validVertex(int v) {
        int V = marked.length;
        if (v < 0 || v > V) {
            throw new IllegalArgumentException("Vertex " + v + "is out of range");
        }
    }

}
