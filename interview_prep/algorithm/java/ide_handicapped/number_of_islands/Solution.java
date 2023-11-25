class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for(int i=0; i< grid.length;i++){
            for(int j=0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    islandCount +=1 ;
                    clearAllConnected(grid, i, islandCount);
                }
            }
        }
        return islandCount;    
    }

    
    private void clearAllConnected(char[][] grid, int row, int col){
        bfs(grid, row, col);
    }

    private void bfs(char[][] grid, int r, int c){
        if(r<0 || r >= grid.length || c<0 || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }
        
        grid[r][c] = '0';
        //System.out.println("r:"+r+"  c:"+c);
        bfs(grid, r+1, c);
        bfs(grid, r-1, c);
        bfs(grid, r, c - 1);
        bfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/number-of-islands/description/
        char[][] i1 = new char[][]{
            new char[]{'1','1','1','1','1'},
            new char[]{'1','1','0','1','0'},
            new char[]{'1','1','0','0','0'},
            new char[]{'0','0','0','0','0'}                        
        };

        char[][] i2 = new char[][]{
            new char[]{'1','1','0','0','0'},
            new char[]{'1','1','0','0','0'},
            new char[]{'0','0','1','0','0'},
            new char[]{'0','0','0','1','0'}                        
        };
                
        Solution self = new Solution();
       
        assert self.numIslands(i1)==1;
        assert self.numIslands(i2)==3;
    }
}