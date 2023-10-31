package hoa.can.code.gg;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/jump-game/">Desc</a>
 */
public class JumpingRecursive implements Jumping {
    final static int NO_WAY = 10000;

    public boolean canJump(int[] nums) {
        int step = minJumps(nums);
        return (step != NO_WAY);
    }

    public int minJumps(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int lastIdx = nums.length - 1;
        return minJumps(nums, 0, lastIdx, memo);
    }

    private static int minJumps(int[] steps, int begin, int dest, int[] memo) {
        if (begin == dest)
            return 0;
        if (steps[begin] == 0)
            return NO_WAY;

        int minJump = NO_WAY;
        for (int step = steps[begin]; step >= 1; --step) {
            if (begin + step <= dest) {
                minJump = Math.min(minJump, 1 + minJumps(steps, begin + step, dest, memo));
            }
        }
        return memo[begin] = minJump;
    }
}
