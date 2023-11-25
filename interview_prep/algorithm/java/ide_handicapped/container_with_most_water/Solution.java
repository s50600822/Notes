class Solution {
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
        Solution self = new Solution();
        assert self.maxArea(new int[]{1,8,6,2,5,4,8,3,7}) == 49;
        assert self.maxArea(new int[]{1,1}) == 1;
    }
}