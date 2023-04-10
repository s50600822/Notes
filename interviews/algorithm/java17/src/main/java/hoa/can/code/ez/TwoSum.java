package hoa.can.code.ez;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public static int[] solve(int[] nums, int target) throws NoTwoSumSolutionFor {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new NoTwoSumSolutionFor();
    }

    public static class NoTwoSumSolutionFor extends Exception {
    }

    public static int[] solveAlt1(int[] nums, int target) {
        int baseIndex = 0;
        while(baseIndex < nums.length - 1){
            int additionIndex = baseIndex + 1;
            while(additionIndex < nums.length){
                if(target == (nums[baseIndex] + nums[additionIndex])){
                    return new int[]{baseIndex, additionIndex};
                }
                additionIndex++;
            }
            baseIndex++;
        }
        return new int[] {-9999, -9999};
    }
    ;
}
