class Solution {
    public static int maxProfit(int[] prices) {
        int boughtIdx = 0;
        int profit = 0;
        for(int i=1; i< prices.length; i ++){
            if(prices[i] > prices[boughtIdx]){
                profit = Math.max(profit, prices[i] - prices[boughtIdx]);
            }else{
                boughtIdx = i;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        assert maxProfit(new int[]{7,1,5,3,6,4}) == 5;
        assert maxProfit(new int[]{7,6,4,3,1}) == 0;
        assert maxProfit(new int[]{1, 2, 3, 4, 5}) == 4;
        assert maxProfit(new int[]{7, 6, 8, 9, 10}) == 4;
        assert maxProfit(new int[]{2, 2, 2, 2, 2}) == 0;
        assert maxProfit(new int[]{}) == 0;
        assert maxProfit(new int[]{7}) == 0;
        assert maxProfit(new int[]{7, 1}) == 0;
        assert maxProfit(new int[]{1, 7}) == 6;
        assert maxProfit(new int[]{2, 2, 2, 3, 1}) == 1;
        assert maxProfit(new int[]{2, 1, 4, 5, 2, 9}) == 8;
    }
}