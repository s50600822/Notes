import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] thresholds;
    private int trials;
    private double mean;
    private double stddev;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Invalid input values");
        }

        this.trials = trials;
        thresholds = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int openSites = 0;
            boolean[][] visited = new boolean[n][n];

            while (!percolation.percolates()) {
                int row = randomStep(n);
                int col = randomStep(n);
                if(!visited[row - 1][col - 1]){
                    if (!percolation.isOpen(row, col)) {
                        visited[row - 1][col - 1] = true;
                        percolation.open(row, col);
                        openSites++;
                    }
                    //System.out.println("Open Sites: " + openSites);
                    visited[row - 1][col - 1] = true;
                } else {
                    //System.out.println(String.format("skipped(%d, %d)", row, col));
                }
            }

            thresholds[i] = (double) openSites / (n * n);
        }

        calculateStatistics();
    }

    public double mean() {
        return mean;
    }

    public double stddev() {
        return stddev;
    }

    public double confidenceLo() {
        return mean - (1.96 * stddev / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean + (1.96 * stddev / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        int n = 5;
        int t = 25;

        PercolationStats stats = new PercolationStats(n, t);

        System.out.println("Mean: " + stats.mean());
        System.out.println("Standard Deviation: " + stats.stddev());
        System.out.println("95% Confidence Interval: [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }

    private int randomStep(int n) {
        return StdRandom.uniformInt(n) + 1;
    }

    private void calculateStatistics() {
        mean = StdStats.mean(thresholds);
        double squaredSum = 0.0;

        for (double threshold : thresholds) {
            squaredSum += Math.pow(threshold - mean, 2);
        }

        stddev = Math.sqrt(squaredSum / (trials - 1));
    }
}
