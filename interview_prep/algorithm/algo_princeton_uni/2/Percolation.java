import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF weightedQuickUnionUF;
    private final boolean[] opened;
    private final int N;
    private final int firstReserved, secondReserved;
    public Percolation(int size) {
        this.N = size;
        firstReserved = size * size;
        secondReserved = firstReserved + 1;
        weightedQuickUnionUF = new WeightedQuickUnionUF(secondReserved + 1);
        opened = new boolean[firstReserved];
    }

    public boolean isOpen(int y, int x) {
        validate(x, y);
        return opened[xyTo1D(y, x)];
    }

    public void open(int y, int x) {
        validate(x, y);
        int index = xyTo1D(y, x),
                right = index + 1,
                left = index - 1,
                up = index - N,
                down = index + N;
        opened[index] = true;
        if (y == 1) {
            weightedQuickUnionUF.union(index, firstReserved);
        } else if (y == N) {
            weightedQuickUnionUF.union(index, secondReserved);
        }
        connectIfIsOpened(index, right, left, up, down);
    }

    public boolean isFull(int y, int x) {
        validate(x, y);
        return weightedQuickUnionUF.find(xyTo1D(y, x)) == weightedQuickUnionUF.find(firstReserved);
    }

    public boolean percolates() {
        return weightedQuickUnionUF.find(firstReserved) == weightedQuickUnionUF.find(secondReserved);
    }

    public int numberOfOpenSites(){
        int count = 0;
            for (boolean open : opened) {
            if (open) {
                count++;
            }
        }
        return count;
    
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
        if (x <= 0 || x > N || y <= 0 || y > N) {
            throw new IndexOutOfBoundsException("Whatitsays");
        }
    }

    private int xyTo1D(int y, int x) {
        return N * (y - 1) + x - 1;
    }
}