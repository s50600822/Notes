class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);// i as center - s is ODD in length
            int len2 = expandAroundCenter(s, i, i + 1); // i and i + 1 as center - s is EVEN in length
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return (right - left) - 1;
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/longest-palindromic-substring/
        Solution self = new Solution();
        assert self.longestPalindrome("a").equals("a");
        assert self.longestPalindrome("babad").equals("aba");
        assert self.longestPalindrome("cbbd").equals("bb");
        assert self.longestPalindrome("noon").equals("noon");
        assert self.longestPalindrome("abacdfgdcaba").equals("aba");
    }
}