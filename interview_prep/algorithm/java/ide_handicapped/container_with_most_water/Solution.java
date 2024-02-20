class Solution {
    /**
     * n == height.length
     * 2 <= n <= 105
     * 0 <= height[i] <= 104
     */
    public int maxArea(int[] h) {
        int a=0;
        int l = 0, r = h.length-1;

        // move left and right cursor in to test alternate area
        while(l<r){
            // y-axis bound to the lower one
            int y = Math.min(h[l], h[r]);
            int x = r -l;
            a = Math.max(a, x*y);
            // continue to find alternative
            if(h[l]<h[r]){
                l++;
            }else{
                r--;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/container-with-most-water/description/
        Solution self = new Solution();
        assert self.maxArea(new int[]{1,8,6,2,5,4,8,3,7}) == 49;
        assert self.maxArea(new int[]{1,1}) == 1;
        assert self.maxArea(new int[]{}) == 0;
        assert self.maxArea(new int[]{1}) == 0;
        assert self.maxArea(new int[]{1, 2}) == 1;
        assert self.maxArea(new int[]{1, 2, 3, 4, 5}) == 6;
        assert self.maxArea(new int[]{5, 4, 3, 2, 1}) == 6;
        assert self.maxArea(new int[]{3, 3, 3, 3}) == 9;
        assert self.maxArea(new int[]{104, 104}) == 104;
        assert self.maxArea(new int[]{2, 2, 1, 2, 2}) == 8;
        assert self.maxArea(new int[]{2, 1, 5, 2, 1}) == 6;
        assert self.maxArea(new int[]{5, 1, 2, 3, 4}) == 16;
        assert self.maxArea(new int[]{1, 2, 3, 4, 5}) == 6;
        assert self.maxArea(new int[]{1, 5, 2, 3, 4}) == 12;
    }
}