import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.*;

public class Percolation {
    private int id[][];
    private WeightedQuickUnionUF uf;
    private int openSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        id = new int[n][n];
        uf = new WeightedQuickUnionUF(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                id[i][j] = 0;
            }
        }
    }

    private ArrayList<Integer> getOpenNeighbors(int row, int col) {
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int n = id.length;
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
                neighbors.add(k);
            }
        }
        return neighbors;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (id[row][col] == 1) {
            return;
        }
        id[row][col] = 1;
        ArrayList<Integer> openNeighbors = getOpenNeighbors(row, col);
        int n = id.length;
        int k = n * row + col;
        for (int neighbor : openNeighbors) {
            uf.union(neighbor, k);
        }
        openSites++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return id[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int n = id.length;
        int q = n * row + col;
        for (int i = 0; i < n; i++) {
            if (isOpen(0, i)) {
                if (uf.find(i) == uf.find(q)) {
                    return true;
                }
            }
        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        int n = id.length;
        for (int i = 0; i < n; i++) {
            for (int j = n * n - n; j < n * n; j++) {
                if (uf.find(i) == uf.find(j)) {
                    return true;
                }
            }
        }
        return false;
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
