package hoa.can.code.med;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/">desc</a>
 */
public class MaxSubArr {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingAt = 0;
        for (int num : nums) {
            maxEndingAt = maxEndingAt + num;
            if (maxSoFar < maxEndingAt) {
                maxSoFar = maxEndingAt;
            }
            if (maxEndingAt < 0) {
                maxEndingAt = 0;
            }
        }
        return maxSoFar;
    }
}
