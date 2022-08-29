import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;
    private final int E;
    List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

}
