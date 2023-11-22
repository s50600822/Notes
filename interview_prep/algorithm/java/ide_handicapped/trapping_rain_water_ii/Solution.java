import java.util.PriorityQueue;

/**
 * m == h.length
 * n == h[i].length
 * 1 <= m, n <= 200
 * 0 <= h[i][j] <= 2 * 104
 */
class Solution {
    
    public static int trapRainWater(int[][] h) {
        if(h==null || h.length == 0 || h[0].length ==0){
            return 0;
        }
        int m = h.length;
        int n = h[0].length;
        int collected = 0;

        //store cells with their heights in ascending order. 
        //This priority queue helps prioritize exploring lower terrain first.
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((cellA,cellB)->cellA.y - cellB.y);
        
        
        boolean[][] visited = new boolean[m][n];
        //Boundary Cells Initialization: 
        //boundary cells represent the outer edges of the terrain and are used as starting points for the exploration
        
        for(int i=0; i<m; i++){
            minHeap.offer(new Cell(i, 0, h[i][0]));
            visited[i][0]=true;
            minHeap.offer(new Cell(i, n-1, h[i][n-1]));
            visited[i][n-1]=true;
        }

        for (int j = 1; j < n - 1; j++) {
            minHeap.offer(new Cell(0, j, h[0][j]));
            minHeap.offer(new Cell(m - 1, j, h[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        //Exploration Loop:
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();

            // Explore neighboring cells
            for (int[] dir : directions) {
                int newRow = cell.x + dir[0];
                int newCol = cell.y + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    collected += Math.max(0, cell.z - h[newRow][newCol]);
                    minHeap.offer(new Cell(newRow, newCol, Math.max(cell.z, h[newRow][newCol])));
                    visited[newRow][newCol] = true;
                }
            }
        }    
        return collected;
    }

    public static void main(String[] args) {
        int r = trapRainWater(new int[][]{
                new int[]{1,4,3,1,3,2},
                new int[]{3,2,1,3,2,4},
                new int[]{2,3,3,2,3,1}
            });
        assert r == 4: "[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] ---> 4";
    }

    public static class Cell {
        int x;
        int y;
        int z;

        public Cell(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}