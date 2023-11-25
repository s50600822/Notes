class Solution {
    public int findMin(int[] n) {
        return 999;
    }
    public static void main(String[] args) {
        // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
        final Solution self = new Solution();
        assert self.findMin(new int[]{3,4,5,1,2})==1: "was 1,2,3,4,5 rotated 3 times";
        assert self.findMin(new int[]{4,5,6,7,0,1,2})==0: "was 0,1,2,4,5,6,7 rotated 4 times";
        assert self.findMin(new int[]{11,13,15,17})==11: "was 11,13,15,17 rotated 4 times";
    }
}