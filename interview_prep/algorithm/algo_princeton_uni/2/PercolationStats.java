
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationStats {
    private double[] thresholds;
    private int trials;
    private double meanValue;
    private double stddevValue;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Invalid input values");
        }

        this.trials = trials;
        thresholds = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int openSites = 0;

            while (!percolation.percolates()) {
                int row = getRandomIndex(n);
                int col = getRandomIndex(n);

                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                    openSites++;
                }
            }

            thresholds[i] = (double) openSites / (n * n);
        }

        calculateStatistics();
    }

    // sample mean of percolation threshold
    public double mean() {
        return meanValue;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddevValue;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return meanValue - (1.96 * stddevValue / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return meanValue + (1.96 * stddevValue / Math.sqrt(trials));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = 20; // Size of the grid
        int trials = 100; // Number of trials

        PercolationStats stats = new PercolationStats(n, trials);

        System.out.println("Mean: " + stats.mean());
        System.out.println("Standard Deviation: " + stats.stddev());
        System.out.println("95% Confidence Interval: [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }

    // Helper method to generate random indices
    private int getRandomIndex(int n) {
        Random random = new Random();
        return random.nextInt(n) + 1;
    }

    // Helper method to calculate mean and standard deviation
    private void calculateStatistics() {
        double sum = 0.0;

        for (double threshold : thresholds) {
            sum += threshold;
        }

        meanValue = sum / trials;

        double squaredSum = 0.0;

        for (double threshold : thresholds) {
            squaredSum += Math.pow(threshold - meanValue, 2);
        }

        stddevValue = Math.sqrt(squaredSum / (trials - 1));
    }
}
