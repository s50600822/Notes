class Solution {
    public static int[] twoSum(int[] nums, int target) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i< nums.length; i++){
            int com = target - nums[i];
            if(map.containsKey(com)){
                return new int[]{map.get(com),i} ;
            }
            map.put(nums[i],i);
        }
        return new int[] {9999,9999};
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/two-sum/description/
        // assert twoSum(new int[]{3,2,4},6 ) == new int[]{1,2} : "{3,2,4} 6 ---> {1,2}";
        // assert twoSum(new int[]{3,3},6 ) == new int[]{0,1} : "{3,3} 6 ---> {0,1}";

        assert java.util.Arrays.equals(twoSum(new int[]{3,2,4},6 ), new int[]{1,2});
        assert java.util.Arrays.equals(twoSum(new int[]{3,3},6), new int[]{0,1});
        
    }
}