class Solution {
    public int findMin(int[] n) {
        // sorted arr that was warp around => left + right => always mid
        if (n.length == 1) return n[0];
        if (n.length == 2) return Math.min(n[0], n[1]);
        if (n[0] < n[n.length - 1]) return n[0];
        int l = 0, r = n.length -1;
        while (l<=r) {
            int mid = l + (r-l)/2;// see also https://github.com/s50600822/Notes/blob/main/vs/java/bitshift/README.md
            if(n[mid] > n[mid+1]) return n[mid+1];
            if(n[mid-1] < n[mid]) return n[mid];
            if(n[l]<n[mid]){
                l = mid+1;
            } else {
                r = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
        final Solution self = new Solution();
        assert self.findMin(new int[]{3,4,5,1,2})==1: "was 1,2,3,4,5 rotated 3 times";
        assert self.findMin(new int[]{4,5,6,7,0,1,2})==0: "was 0,1,2,4,5,6,7 rotated 4 times";
        assert self.findMin(new int[]{11,13,15,17})==11: "was 11,13,15,17 rotated 4 times";
    }
}