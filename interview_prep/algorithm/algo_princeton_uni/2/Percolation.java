import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
  private final int n;
  private int openedSites;
  private boolean[] sites;
  private final WeightedQuickUnionUF uf;
  private final WeightedQuickUnionUF fuf;
  public Percolation(int n) {
	  if (n <= 0)
	    throw new IllegalArgumentException();
	  sites = new boolean[ n * n ];
	  uf = new WeightedQuickUnionUF(n * n + 2);
	  fuf = new WeightedQuickUnionUF(n * n + 1);
	  this.n = n;
	  if (n == 1) {
	      uf.union(0, 1);
	      uf.union(0, 2);
	      fuf.union(0, 1);
	  } else {
        for (int i = 0; i < n; i++) {
            uf.union(i, n * n); 
            uf.union(i + (n-1) * n, n * n + 1);
            fuf.union(i, n * n); 
        }
	  }
  }
  public void open(int row, int col) {
	  if (row < 1 || row > n || col < 1 || col > n)
		  throw new IllegalArgumentException();
	  if (!isOpen(row, col)) {
		  openedSites++;
	  }
	  sites[col-1 + n*(row-1)] = true;
	  if (0 < row-1 && row-1 <= n && isOpen(row-1, col)) {
		  uf.union(col-1 + n*(row-1), col-1 + n*(row-2));
		  fuf.union(col-1 + n*(row-1), col-1 + n*(row-2));
	  }
	  if (0 < row+1 && row+1 <= n && isOpen(row+1, col)) {
		  uf.union(col-1 + n*(row-1), col-1 + n*row);
		  fuf.union(col-1 + n*(row-1), col-1 + n*row);
	  }
	  if (0 < col-1 && col-1 <= n && isOpen(row, col-1)) {
		  uf.union(col-1 + n*(row-1), col-2 + n*(row-1));
		  fuf.union(col-1 + n*(row-1), col-2 + n*(row-1));
	  }
	  if (0 < col+1 && col+1 <= n && isOpen(row, col+1)) {
		  uf.union(col-1 + n*(row-1), col + n*(row-1));
		  fuf.union(col-1 + n*(row-1), col + n*(row-1));
	  }
  }
  public boolean isOpen(int row, int col) {
	  if (row < 1 || row > n || col < 1 || col > n)
		  throw new IllegalArgumentException();
	  return sites[col-1 + n*(row-1)];
  }

  public boolean isFull(int row, int col) {
	  if (row < 1 || row > n || col < 1 || col > n)
		  throw new IllegalArgumentException();
	  if (isOpen(row, col)) {
		  if (uf.find(col - 1 + n * (row - 1)) == uf.find(n * n) && fuf.find(col - 1 + n * (row - 1)) == fuf.find(n * n)) {
			  return true;
		  }
		  else return false;
	  }
	  else return false;
  }
  
  public int numberOfOpenSites() {
	  return openedSites;
  }

  public boolean percolates() {
      if (n == 1) {
	  return connected(1, 2) && isOpen(1, 1);
      } else return connected(n * n, n * n + 1);
  }

  private boolean connected(int p, int q) {
    return uf.find(p) == uf.find(q);
  }
}
