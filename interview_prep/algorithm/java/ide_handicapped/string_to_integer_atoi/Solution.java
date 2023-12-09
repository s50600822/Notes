class Solution {
    public int myAtoi(String s) {
        return -1;
    }

    public static void main(String[] args) {
        Solution self = new Solution();
        assert self.myAtoi("42") == 42;
        assert self.myAtoi("  -42") == -42;
        assert self.myAtoi("4193 with words") == 4193;
    }
}