class Solution {
    public int myAtoi(String s) {
        long res = 0;
        int fact = 1, i = 0;
        while (i < s.length()) {
            if (' ' != s.charAt(i) )
                break;
            i++;
        }
        if (i < s.length() && s.charAt(i) == '-') {
            fact = -1;
            i++;
        }
        if (i < s.length() && s.charAt(i) == '+' && fact == 1) i++;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            // In ASCII encoding, the digits '0' to '9' are represented by consecutive values from 48 to 57
            res = res * 10 + ((int) s.charAt(i) - 48);
            i++;
            if (res > Integer.MAX_VALUE) break;
        }
        res *= fact;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/string-to-integer-atoi/
        Solution self = new Solution();
        assert self.myAtoi("42") == 42;
        assert self.myAtoi("  -42") == -42;
        assert self.myAtoi("4193 with words") == 4193;
    }
}