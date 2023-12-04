class Solution {
    public int findMaximumLength(int[] nums) {
        
        int n = nums.length;
        int[] que =new int[n+1];
        int write = 0, read = 0;     
     
        long[] prefixSum = new long[n+1];
        long[] sums =new long[n+1];
        int[] count = new int[n +1];
        
        for (int i = 1; i <= n;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
            
            while (read < write && prefixSum[i] >= sums[read + 1])
                read++;
                
            int j = que[read];
            long subarraySum = prefixSum[i] - prefixSum[j];
            count[i] = count[j] + 1;           
            
            long sum = prefixSum[i] + subarraySum;
            
            while (sum <= sums[write])
                write--;
                
            que[++write] = i;
            sums[write] = sum;
        }
        return count[n];
    }

    public static void main(String[] args) {
        Solution self = new Solution();
        assert self.findMaximumLength(new int[]{5,2,2}) == 1: "[5,2,2] => [9]";
        assert self.findMaximumLength(new int[]{1,2,3,4}) == 4: "[1,2,3,4] => [1,2,3,4]";
        assert self.findMaximumLength(new int[]{4,3,2,6}) == 3: "[4,3,2,6] => [4,5,6]";        
    }
}