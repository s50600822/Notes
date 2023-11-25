// https://leetcode.com/problems/maximum-product-subarray/description/
// all pos > product keep increasing
// with neg > product can alternate

class Solution {
    public int maxProduct(int[] n) {
        return 99999;
    }
    public static void main(String[] args) {
        //https://leetcode.com/problems/maximum-product-subarray/
        final Solution self = new Solution();
        assert self.maxProduct(new int[]{2,3,-2,4})==6;
        assert self.maxProduct(new int[]{2,0,-1})==0;
    }
}