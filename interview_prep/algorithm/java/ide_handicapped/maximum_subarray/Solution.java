class Solution {
    /**
     * The key insight here is 
     * the dynamic programming step 
     * where the algorithm calculates 
     * the maximum subarray sum ending at each position. 
     * 
     * By updating and keeping track of 
     * the current sum  and 
     * the overall maximum during the iteration, 
     * the algorithm efficiently finds the maximum subarray sum 
     * in a single pass through the array.
     */
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int max = nums[0];

        for(int i=1; i<nums.length; i++){
            // keep accumuate or start over at i
            currentSum = Math.max(currentSum+nums[i], nums[i]);
            // keep existing or update with accumulate sum
            max = Math.max(max, currentSum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution self = new Solution();
        assert self.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}) == 6;
        assert self.maxSubArray(new int[]{5,4,-1,7,8}) == 23;
        assert self.maxSubArray(new int[]{1}) == 1;
    }
}