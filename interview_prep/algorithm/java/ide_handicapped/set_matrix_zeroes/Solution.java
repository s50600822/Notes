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

    public void setZeroesBetterSpace(int[][] matrix) {
        // using first row and col as marker instead of using separated array
        // special note to the first element
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // use first row and first column as marker
        // first row/col itself 0 or not? use a boolean flag
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {

                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // set 0: rest first, first-row/col last
        for (int col = 1; col < n; col++) {
            if (matrix[0][col] == 0) {

                int i = 1;
                while (i < m) {
                    matrix[i][col] = 0;
                    i++;
                }
            }
        }
        for (int row = 1; row < m; row++) {
            if (matrix[row][0] == 0) {

                int j = 1;
                while (j < n) {
                    matrix[row][j] = 0;
                    j++;
                }
            }
        }

        if (isFirstRowZero) {
            int j = 0;
            while (j < n) {
                matrix[0][j] = 0;
                j++;
            }
        }
        if (isFirstColZero) {
            int i = 0;
            while (i < m) {
                matrix[i][0] = 0;
                i++;
            }
        }
    }
}