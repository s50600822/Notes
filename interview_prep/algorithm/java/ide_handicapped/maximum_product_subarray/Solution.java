// https://leetcode.com/problems/maximum-product-subarray/description/
// all pos > product keep increasing
// with neg > product can alternate

class Solution {
    public int maxProduct(int[] n) {
        int answer = n[0]; //just to start
        int min = 1, max = 1;

        for(int i=0; i<n.length; i++){
            if(n[i] == 0){
                // reset
                min = 1;
                max = 1;
                // keep the answer unless neg
                answer = Math.max(answer, n[i]);
                continue;
            }
            //each step we have the choice between
            //the value itself - fresh start
            //the product with accumulated max
            //the product with accumulated min - min negative could flip to max
            int tmp = min;
            min = Math.min(n[i], Math.min(min * n[i], max * n[i]));
            max = Math.max(n[i], Math.max(tmp * n[i], max * n[i]));
            answer = Math.max(answer, max);
        }
        return answer;
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/maximum-product-subarray/
        final Solution self = new Solution();
        assert self.maxProduct(new int[]{2,3,-2,4})==6;
        assert self.maxProduct(new int[]{2,0,-1})==2;
        assert self.maxProduct(new int[]{-2,0,-1})==0;
    }
}