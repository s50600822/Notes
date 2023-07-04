import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF weightedQuickUnionUF;
    private final boolean[] opened;
    private final int n;
    private final int firstReserved, secondReserved;
    private int numOfSitesOpen = 0;

    public Percolation(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid grid size");
        }        
        this.n = size;
        firstReserved = size * size;
        secondReserved = firstReserved + 1;
        int gridSize = (size > 1) ? secondReserved + 1 : 2; 
        weightedQuickUnionUF = new WeightedQuickUnionUF(gridSize);
        opened = new boolean[firstReserved];
    }

    public boolean isOpen(int y, int x) {
        validate(x, y);
        return opened[to1Dimension(y, x)];
    }

    public void open(int y, int x) {
        validate(x, y);
        int index = to1Dimension(y, x),
                right = index + 1,
                left = index - 1,
                up = index - n,
                down = index + n;
        opened[index] = true;
        numOfSitesOpen++;
        if (y == 1) {
            weightedQuickUnionUF.union(index, firstReserved);
        } else if (y == n) {
            weightedQuickUnionUF.union(index, secondReserved);
        }
        connectIfIsOpened(index, right, left, up, down);
    }

    public boolean isFull(int y, int x) {
        validate(x, y);
        return weightedQuickUnionUF.find(to1Dimension(y, x)) == weightedQuickUnionUF.find(firstReserved);
    }

    public boolean percolates() {
        if (1 == n) {
            return opened[0];
        }
        return weightedQuickUnionUF.find(firstReserved) == weightedQuickUnionUF.find(secondReserved);
    }

    public int numberOfOpenSites() {
        return numOfSitesOpen;
    }

    private void connectIfIsOpened(int main, int... others) {
        for (int site : others) {
            if (neighbourIsOpened(main, site)) {
                weightedQuickUnionUF.union(main, site);
            }
        }
    }

    private boolean neighbourIsOpened(int first, int second) {
        return (first > second ? second >= 0 : second < firstReserved)
                && opened[second]
                && !(weightedQuickUnionUF.find(first) == weightedQuickUnionUF.find(second));
    }

    private void validate(int x, int y) {
        if (x <= 0 || x > n || y <= 0 || y > n) {
            throw new IllegalArgumentException("Whatitsays");
        }
    }

    /**
     * present a cell in a grid by 1 dimension array, eg: in a 5x5 grid:
     *   0x0 -> 0, 0x1-> 1, 0x2 -> 2, 1x0 -> 5, 1x1 -> 6
     */
    private int to1Dimension(int y, int x) {
        return n * (y - 1) + x - 1;
    }
}