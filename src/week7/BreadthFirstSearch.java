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
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(s)) {
                edgeTo[w] = v;
                distTo[w] = distTo[v] + 1;
                marked[w] = true;
                q.enqueue(w);
            }
        }
    }

    public int distTo(int v) {
        validVertex(v);
        return distTo(v);
    }

    public boolean hasPathTo(int v) {
        validVertex(v);
        return marked[v];
    }

    private void validVertex(int v) {
        int V = marked.length;
        if (v < 0 || v > V) {
            throw new IllegalArgumentException("Vertex " + v + "is out of range");
        }
    }

}
