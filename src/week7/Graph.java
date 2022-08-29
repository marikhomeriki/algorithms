import java.util.ArrayList;
import java.util.List;

public class Graph {
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

    private void ValidVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("This Vertex is not valid");
        }
    }

    public void AddEdge(int v, int w) {
        ValidVertex(v);
        ValidVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

}
