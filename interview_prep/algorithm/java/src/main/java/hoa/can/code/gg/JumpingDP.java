package hoa.can.code.gg;

public class JumpingDP {
    public static boolean canJump(int[] nums) {
        return minJumps(nums) != Integer.MAX_VALUE;
    }

    public static int minJumps(int[] arr) {
        int n = arr.length;
        int minCostToIdx[] = new int[n];
        // result
        int i, j;

        // if first element is 0,
        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;

        minCostToIdx[0] = 0;

        for (i = 1; i < n; i++) {
            minCostToIdx[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j] && minCostToIdx[j] != Integer.MAX_VALUE) {
                    minCostToIdx[i] = Math.min(minCostToIdx[i], minCostToIdx[j] + 1);
                    break;
                }
            }
        }
        return minCostToIdx[n - 1];
    }
}
