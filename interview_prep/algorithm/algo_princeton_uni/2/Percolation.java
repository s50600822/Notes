public class Percolation {
    private int[][] grid;
    private int openSites;
    private int size;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid grid size");
        }
        this.size = size;
        grid = new int[size][size];
        openSites = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateIndices(row, col);
        if (!isOpen(row, col)) {
            grid[row - 1][col - 1] = 1; // Open site
            openSites++;

            // Check neighboring sites and open them if they are valid
            if (row > 1 && isOpen(row - 1, col)) {
                connectSites(row, col, row - 1, col);
            }
            if (row < size && isOpen(row + 1, col)) {
                connectSites(row, col, row + 1, col);
            }
            if (col > 1 && isOpen(row, col - 1)) {
                connectSites(row, col, row, col - 1);
            }
            if (col < size && isOpen(row, col + 1)) {
                connectSites(row, col, row, col + 1);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        validateIndices(row, col);
        return grid[row - 1][col - 1] == 1;
    }

    public boolean isFull(int row, int col) {
        validateIndices(row, col);
        if (!isOpen(row, col)) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (isConnected(row, col, 1, i + 1)) {
                return true;
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
        // Check if the bottom row has a full site
        for (int i = 0; i < size; i++) {
            if (isFull(size, i + 1)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to validate the indices
    private void validateIndices(int row, int col) {
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException("Invalid indices");
        }
    }

    // Helper method to check if two sites are connected
    private boolean isConnected(int row1, int col1, int row2, int col2) {
        return root(row1, col1) == root(row2, col2);
    }

    // Helper method to find the root of a site using weighted quick union algorithm
    private int root(int row, int col) {
        int i = row - 1;
        int j = col - 1;
        while (i != grid[i][j]) {
            grid[i][j] = grid[grid[i][j] / size][grid[i][j] % size];
            i = grid[i][j] / size;
            j = grid[i][j] % size;
        }
        return i;
    }

    // Helper method to connect two sites using weighted quick union algorithm
    private void connectSites(int row1, int col1, int row2, int col2) {
        int root1 = root(row1, col1);
        int root2 = root(row2, col2);
        if (root1 != root2) {
            grid[root1][col1 - 1] = root2;
        }
    }
}
