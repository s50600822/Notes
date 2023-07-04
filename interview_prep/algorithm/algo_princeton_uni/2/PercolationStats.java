import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {
    // https://math.stackexchange.com/questions/1480904/given-a-95-confidence-interval-why-are-we-using-1-96-and-not-1-64
    private static final double CONF = 1.96;    
	private final double mean;
	private final double stddev;
	private final double confidenceLo;
	private final double confidenceHi;
	public PercolationStats(int n, int trials) {
	    if (n <= 0 || trials <= 0)
		    throw new IllegalArgumentException();
	    int rdr, rdc;
	    double[] x = new double[trials];
	    for (int i = 0; i < trials; i++) {
		Percolation uf = new Percolation(n);
		while (!uf.percolates()) {
			do {
				rdr = StdRandom.uniformInt(n) + 1;
				rdc = StdRandom.uniformInt(n) + 1;
			} while (uf.isOpen(rdr, rdc));
			uf.open(rdr, rdc);
		}
		x[i] = (double) uf.numberOfOpenSites() / (n * n);
	}
	    mean = StdStats.mean(x);
	    stddev = StdStats.stddev(x);
	    confidenceLo = mean() - CONF * stddev() / Math.sqrt(trials);
	    confidenceHi = mean() + CONF * stddev() / Math.sqrt(trials);
	}
	public double mean() {
	    	return mean;
		
	}
	public double stddev() {
	    	return stddev;
	}
	public double confidenceLo() {
	    	return confidenceLo;
	}
	public double confidenceHi() {
	    	return confidenceHi;
	}
	public static void main(String[] args) {
        int n = 200;
        int t = 100;

        if (args.length == 2) {
            n = Integer.parseInt(args[0]);
            t = Integer.parseInt(args[1]);
        }
		PercolationStats p = new PercolationStats(n, t);
		
		System.out.println("mean = " + p.mean());
		System.out.println("stddev = " + p.stddev());
		System.out.println("95% confidence interval = [" + p.confidenceLo() + ", " + p.confidenceHi() + "]");
	}
}
