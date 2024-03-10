class Solution {
    private int digitSquaredSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            n = digitSquaredSum(n);
        }
        return n == 1;
    }
    public static void main(String[] args) {
        //https://leetcode.com/problems/happy-number/
        Solution self = new Solution();
        assert !self.isHappy(2);
        assert self.isHappy(19);
    }
}