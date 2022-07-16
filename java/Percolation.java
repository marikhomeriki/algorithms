import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.*;

public class Percolation {
    private int id[][];

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        id = new int[n][n];
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
                if (id[row + i][col + j] == 1) {
                    int k = n * (row + i) + (col + j);
                    neighbors.add(k);
                }

            }
        }

        return neighbors;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (id[row][col] != 1) {
            id[row][col] = 1;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return true;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return true;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return 1;
    }

    // does the system percolate?
    public boolean percolates() {
        return true;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation per = new Percolation(10);
        System.out.println(per.getOpenNeighbors(0, 9));
    }

}
