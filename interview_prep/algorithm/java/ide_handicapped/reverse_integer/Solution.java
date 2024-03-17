class Solution {
    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        x *= sign;
        int reversedNumber = 0;
        while(x > 0) {
            int digit = x % 10;
            int newNumber = reversedNumber * 10 + digit;
            if((newNumber - digit) / 10 != reversedNumber) {
                return 0;
            } else {
                reversedNumber = newNumber;
            }
            x /= 10;
        }
        return reversedNumber * sign;
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/reverse-integer/description/
        final Solution sol = new Solution();
        assert sol.reverse(123) == 321;
        assert sol.reverse(-123) == -321;
        assert sol.reverse(120) == 21;
        assert sol.reverse(-120) == -21;
    }
}