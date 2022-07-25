import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] thresholds;
    private static final double CONFIDENCE_95 = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        thresholds = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation per = new Percolation(n);
            int threshold = 0;
            while (!per.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (per.isOpen(row, col)) {
                    continue;
                }
                per.open(row, col);
                threshold++;
            }
            thresholds[i] = (double) threshold / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        int t = thresholds.length;
        double lo = mean() - ((CONFIDENCE_95 * stddev()) / Math.sqrt(t));
        return lo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        int t = thresholds.length;
        double hi = mean() + ((CONFIDENCE_95 * stddev()) / Math.sqrt(t));
        return hi;
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats perStat = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.printf("mean                    = %f\n", perStat.mean());
        System.out.printf("stddev                  = %f\n", perStat.stddev());
        System.out.printf("95%% confidence interval = [%f, %f]\n", perStat.confidenceLo(), perStat.confidenceHi());

    }

}
