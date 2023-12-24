import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/set-matrix-zeroes/
        test(
                new int[][]{{1,1,1}, {1,0,1},{1,1,1}},
                new int[][]{{1,0,1},{0,0,0},{1,0,1}}
        );

        test(
                new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}},
                new int[][]{{0,0,0,0},{0,4,5,0},{0,3,1,0}}
        );
    }
    static void test(int[][] in, int[][] out){
        Solution self = new Solution();
        self.setZeroes(in);
        assert Arrays.deepEquals(in, out) == true;
    }
}