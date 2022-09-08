import java.util.ArrayList;
import java.util.List;

public class Digraph {

    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];
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

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph reversed = new Digraph(V);

        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                reversed.addEdge(w, v);
            }
        }

        return reversed;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(3);
        G.addEdge(1, 0);
        G.addEdge(2, 0);
        System.out.println(G);
        System.out.println();
        System.out.println(G.reverse());
    }
}