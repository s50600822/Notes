import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] m) {
        m[0][0] = 9999;
    }

    public static void main(String[] args) {
        Solution self = new Solution();
        int[][] i1 = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] o1 = new int[][]{{0,0,0,0},{0,4,5,0},{0,3,1,0}};

        self.setZeroes(i1);

        assert Arrays.equals(i1, o1) == true;
    }
}