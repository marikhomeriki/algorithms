public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        validVertex(s);
        dfs(G, s);
    }

    private void dfs(Graph g, int s) {
    }

    private void validVertex(int v) {
        int V = marked.length;
        if (v < 0 || v > V) {
            throw new IllegalArgumentException("Vertex " + v + "is not valid");
        }

    }
}
