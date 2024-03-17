import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {

        return new AbstractList<List<Integer>>() {
            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }

            public int size() {
                init();
                return res.size();
            }

            private void init() {
                if (res != null)
                    return;
                Arrays.sort(nums);
                int l, r, sum;
                final Set<List<Integer>> tempRes = new HashSet<>();
                for (int i = 0; i < nums.length - 2; ++i) {
                    l = i + 1;
                    r = nums.length - 1;
                    while (l < r) {
                        sum = nums[i] + nums[l] + nums[r];
                        if (sum == 0)
                            tempRes.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        if (sum < 0)
                            ++l;
                        else
                            --r;
                    }
                }
                res = new ArrayList<List<Integer>>(tempRes);
            }

        };
    }

    public static void main(String[] args) {
        // https://leetcode.com/problems/3sum/description/
        t1();
        t2();
        t3();

    }

    public static void t1() {
        final Solution sol = new Solution();
        final List res = sol.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        assert res.contains(Stream.of(-1, -1, 2).collect(Collectors.toList()));
        assert res.contains(Stream.of(-1, 0, 1).collect(Collectors.toList()));
        // System.out.println(res);
    }

    public static void t2() {
        final Solution sol = new Solution();
        final List res = sol.threeSum(new int[] { 0, 1, 1 });
        assert res.isEmpty();
    }

    public static void t3() {
        final Solution sol = new Solution();
        final List res = sol.threeSum(new int[] { 0, 0, 0 });
        assert res.contains(Stream.of(0, 0, 0).collect(Collectors.toList()));
        // System.out.println(res);
    }

    public List<List<Integer>> threeSumSlow(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();
        Arrays.sort(nums);
        int l, r, sum;
        final Set<List<Integer>> tempRes = new HashSet<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum == 0)
                    tempRes.add(Arrays.asList(nums[i], nums[l], nums[r]));
                if (sum < 0)
                    ++l;
                else
                    --r;
            }
        }
        return new ArrayList<List<Integer>>(tempRes);
    }
}