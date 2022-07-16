import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int[][] id;
    private final WeightedQuickUnionUF uf;
    private final int n;
    private int openSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        id = new int[n][n];
        uf = new WeightedQuickUnionUF(n * n + 2);
        this.n = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                id[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            uf.union(n * n, i);
        }
        for (int i = n * n - n; i < n * n; i++) {
            uf.union(n * n + 1, i);
        }
    }

    private int[] getOpenNeighbors(int row, int col) {
        int[] neighbors = new int[] { -1, -1, -1, -1 };
        int pos = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (Math.abs(i) + Math.abs(j) != 1) {
                    continue;
                }
                if ((row + i < 0) || (col + j < 0)) {
                    continue;
                }
                if ((row + i > n - 1) || (col + j > n - 1)) {
                    continue;
                }
                if (id[row + i][col + j] != 1) {
                    continue;
                }
                int k = n * (row + i) + (col + j);
                neighbors[pos] = k;
                pos++;
            }
        }
        return neighbors;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        row--;
        col--;
        if (id[row][col] == 1) {
            return;
        }
        id[row][col] = 1;
        int[] openNeighbors = getOpenNeighbors(row, col);
        int k = n * row + col;
        for (int neighbor : openNeighbors) {
            if (neighbor == -1) {
                continue;
            }
            uf.union(neighbor, k);
        }
        openSites++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        row--;
        col--;
        return id[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        row--;
        col--;
        if (id[row][col] != 1) {
            return false;
        }
        int q = n * row + col;
        return uf.find(n * n) == uf.find(q);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(n * n) == uf.find(n * n + 1);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation per = new Percolation(3);
        per.open(1, 1);
        per.open(1, 2);
        per.open(0, 1);
        per.isFull(0, 1);
        System.out.println(per.isFull(2, 2));
        System.out.println(per.percolates());
    }

}
