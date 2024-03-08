class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2=nums2.length;
        int[] merged = new int[l1+l2];
        int midx=0, l1idx=0, l2idx=0;
        while(l1idx< l1 && l2idx<l2){
            if(nums1[l1idx] < nums2[l2idx]){
                merged[midx] = nums1[l1idx];
                l1idx++;
            }else{
                merged[midx] = nums2[l2idx];
                l2idx++;
            }
            midx++;
        }

        while(l1idx < l1){
            merged[midx++] =  nums1[l1idx++];
        }
        while(l2idx < l2){
            merged[midx++] =  nums2[l2idx++];
        }
        int mid = (l1+l2)/2;
        if((l1+l2)%2==0) return (double)(merged[mid -1] + merged[mid]) / 2;
        return  merged[mid];
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/median-of-two-sorted-arrays/
        Solution self = new Solution();
        assert self.findMedianSortedArrays(new int[]{1,2},new int[]{3,4})==2.5;
        assert self.findMedianSortedArrays(new int[]{1,2,6},new int[]{3,4})==3; //1,2,3,4,6
        assert self.findMedianSortedArrays(new int[]{1,2},new int[]{3,4,6,7})==3.5; //1,2,3,4,6,7
        assert self.findMedianSortedArrays(new int[]{1,2,6,7},new int[]{3,4,5})==4; //1,2,3,4,5,6,7

    }
}