import java.util.ArrayList;
import java.util.List;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void validVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("This Vertex is not valid");
        }
    }

    public void addEdge(int v, int w) {
        validVertex(v);
        validVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        validVertex(v);
        return adj[v];
    }

    public int degree(int v) {
        validVertex(v);
        return adj[v].size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " Vertexes " + E + " Edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

}
