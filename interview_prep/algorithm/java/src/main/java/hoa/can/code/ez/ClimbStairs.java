package hoa.can.code.ez;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">desc</a>
 */
public class ClimbStairs {
    public int climbs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // either one or two steps away
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
