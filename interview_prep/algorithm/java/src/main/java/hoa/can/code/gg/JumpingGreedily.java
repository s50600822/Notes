package hoa.can.code.gg;

public class JumpingGreedily implements Jumping {
    final static int NO_WAY = 10000;

    public boolean canJump(int[] nums) {
        return minJumps(nums) != NO_WAY;
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        int maxReach = nums[0];
        int currentMax = nums[0];

        if (currentMax == 0) return NO_WAY;
        if (currentMax >= n - 1) return 1;

        int steps = 1;

        for (int currentBase = 1; currentBase < n; currentBase++) {
            if (currentBase > maxReach) {
                steps++;
                maxReach = currentMax;
                if (currentMax >= n - 1) return steps;
            }
            if (nums[currentBase] == 0) {
                if ((currentMax == currentBase)) {
                    return NO_WAY;
                }
                if (currentMax >= n - 1) {
                    steps++;
                    return steps;
                }
            }

            currentMax = Math.max(currentMax, currentBase + nums[currentBase]);
        }
        return steps;
    }
}
