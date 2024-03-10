class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, mCandidate = 0;
        for (int x : nums) {
            if (count == 0) {
                mCandidate = x;
                count = 1;
            } else {
                if (mCandidate == x) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return mCandidate;
    }

    public static void main(String[] args) {
        // https://leetcode.com/problems/majority-element/
        Solution self = new Solution();
        assert self.majorityElement(new int[] { 5 }) == 5;
        assert self.majorityElement(new int[] { 5,5,5,5,5 }) == 5;
        assert self.majorityElement(new int[] { 3, 2, 3 }) == 3;
        assert self.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }) == 2;
        assert self.majorityElement(new int[] { 2, 1, 2, 3, 2, 4, 2 }) == 2;
    }
}