class Solution {

    /**
     * 1 <= nums.length <= 1000
     * -109 <= nums[i] <= 109
     */
    public long subArrayRanges(int[] arr) {
        return calculateMaxSum(arr, 0, arr.length - 1) - calculateMinSum(arr, 0, arr.length - 1);
    }

    public long calculateMinSum(int[] arr, int i, int j) {
        int n = j - i + 1;
        if (n == 1) return arr[i];

        int minIndex = i;
        for (int k = i + 1; k <= j; k++) {
            if (arr[k] < arr[minIndex]) {
                minIndex = k;
            }
        }
        long sum = 1l * (n - (minIndex - i)) * (minIndex - i + 1) * arr[minIndex];
        if (minIndex == i) {
            return sum + calculateMinSum(arr, minIndex + 1, j);
        }

        if (minIndex == j) {
            return sum + calculateMinSum(arr, i, minIndex - 1);
        }
        return sum + calculateMinSum(arr, i, minIndex - 1) + calculateMinSum(arr, minIndex + 1, j);
    }

    public long calculateMaxSum(int[] arr, int i, int j) {
        int n = j - i + 1;
        if (n == 1) return arr[i];

        int maxIndex = i;
        for (int k = i + 1; k <= j; k++) {
            if (arr[k] > arr[maxIndex]) {
                maxIndex = k;
            }
        }
        long sum = 1l * (n - (maxIndex - i)) * (maxIndex - i + 1) * arr[maxIndex];
        if (maxIndex == i) {
            return sum + calculateMaxSum(arr, maxIndex + 1, j);
        }

        if (maxIndex == j) {
            return sum + calculateMaxSum(arr, i, maxIndex - 1);
        }
        return sum + calculateMaxSum(arr, i, maxIndex - 1) + calculateMaxSum(arr, maxIndex + 1, j);
    }

    public static void main(String[] args) {
        // https://leetcode.com/problems/sum-of-subarray-ranges/
        Solution self = new Solution();
        assert self.subArrayRanges(new int[] { 1, 2, 3 }) == 4;
        assert self.subArrayRanges(new int[] { 1, 3, 3 }) == 4;
        assert self.subArrayRanges(new int[] { 4, -2, -3, 4, 1 }) == 59;
    }
}