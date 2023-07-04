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
      validate(row, col);
      if (!isOpen(row, col)) {
          openedSites++;
      }

      int oneDimensionIdx = to1D(col, row);
      sites[oneDimensionIdx] = true;
      if (0 < row-1 && row-1 <= n && isOpen(row-1, col)) {
          uf.union(oneDimensionIdx, col-1 + n*(row-2));
          fuf.union(oneDimensionIdx, col-1 + n*(row-2));
      }
      if (0 < row+1 && row+1 <= n && isOpen(row+1, col)) {
          uf.union(oneDimensionIdx, col-1 + n*row);
          fuf.union(oneDimensionIdx, col-1 + n*row);
      }
      if (0 < col-1 && col-1 <= n && isOpen(row, col-1)) {
          uf.union(oneDimensionIdx, col-2 + n*(row-1));
          fuf.union(oneDimensionIdx, col-2 + n*(row-1));
      }
      if (0 < col+1 && col+1 <= n && isOpen(row, col+1)) {
          uf.union(oneDimensionIdx, col + n*(row-1));
          fuf.union(oneDimensionIdx, col + n*(row-1));
      }
  }

  public boolean isOpen(int row, int col) {
      validate(row, col);
      return sites[to1D(row, col)];
  }

  public boolean isFull(int row, int col) {
      validate(row, col);
      if (isOpen(row, col)) {
          return uf.find(col - 1 + n * (row - 1)) == uf.find(n * n) && fuf.find(col - 1 + n * (row - 1)) == fuf.find(n * n);
      }
      else return false;
  }

  public int numberOfOpenSites() {
      return openedSites;
  }

  public boolean percolates() {
      if (n == 1) {
        if (uf.find(1) != uf.find(2)) {
            return false;
        } else return isOpen(1, 1);
      } else return uf.find(n * n) == uf.find(n * n + 1);
  }

  private int to1D(int col, int row) {
    return col-1 + n*(row-1);
  }

  private void validate(int row, int col) {
      if (row < 1 || row > n || col < 1 || col > n)
          throw new IllegalArgumentException();
  }

}
