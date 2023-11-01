package hoa.can.code.gg;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;

public class JumpingDP implements Jumping {
    public boolean canJump(int[] nums) {
        return minJumps(nums) != MAX_VALUE;
    }

    public int minJumps(int[] arr) {
        int n = arr.length;
        int[] cost = new int[n];
        int i, j;

        if (n == 0 || arr[0] == 0)
            return MAX_VALUE;

        cost[0] = 0;
        for (i = 1; i < n; i++) {
            cost[i] = MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j] && cost[j] != MAX_VALUE) {
                    cost[i] = min(cost[i], cost[j] + 1);
                    break;
                }
            }
        }
        return cost[n - 1];
    }
}
