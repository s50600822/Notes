import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones) {
            q.offer(s);
        }
        while (q.size() > 1) {
            int biggest = q.poll();
            int secBiggest = q.poll();
            if (biggest != secBiggest) {
                q.offer(biggest - secBiggest);
            }
        }
        if (q.isEmpty()) {
            return 0;
        }
        return q.poll();
    }
    public static void main(String[] args) {
        //https://leetcode.com/problems/last-stone-weight/
        Solution self = new Solution();
        assert self.lastStoneWeight(new int[]{2,7,4,1,8,1}) == 1;
        assert self.lastStoneWeight(new int[]{1}) == 1;
    }
}
