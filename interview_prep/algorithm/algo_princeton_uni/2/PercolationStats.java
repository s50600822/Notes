import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    // https://math.stackexchange.com/questions/1480904/given-a-95-confidence-interval-why-are-we-using-1-96-and-not-1-64
    private static final double CONF = 1.96;

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
                if (!visited[row - 1][col - 1]) {
                    if (!percolation.isOpen(row, col)) {
                        visited[row - 1][col - 1] = true;
                        percolation.open(row, col);
                        openSites++;
                    }
                    // System.out.println("Open Sites: " + openSites);
                    visited[row - 1][col - 1] = true;
                } else {
                    // System.out.println(String.format("skipped(%d, %d)", row, col));
                }
            }

            thresholds[i] = (double) openSites / (n * n);
        }

        mean = StdStats.mean(thresholds);
        stddev = StdStats.stddev(thresholds);
        if (1 == thresholds.length) {
            stddev = 0;
        }
    }

    public double mean() {
        return mean;
    }

    public double stddev() {
        return stddev;
    }

    public double confidenceLo() {
        return mean - (CONF * stddev / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean + (CONF * stddev / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        int n = 200;
        int t = 100;

        if (args.length == 2) {
            n = Integer.parseInt(args[0]);
            t = Integer.parseInt(args[1]);
        }

        PercolationStats stats = new PercolationStats(n, t);    
        System.out.println("mean = " + stats.mean());
        System.out.println("stddev = " + stats.stddev());
        System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }

    private int randomStep(int n) {
        return StdRandom.uniformInt(n) + 1;
    }
}
