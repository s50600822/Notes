import java.util.List;
import java.util.Collections;
import java.util.PriorityQueue;

import java.util.ArrayList;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        // Create a list to store critical points (start and end points of buildings)
        List<int[]> criticalPoints = new ArrayList<>();

        // Populate the critical points list
        for (int[] building : buildings) {
            // Use negative height for the start point to distinguish it from the end point
            criticalPoints.add(new int[]{building[0], -building[2]});
            criticalPoints.add(new int[]{building[1], building[2]});
        }

        // Sort the critical points based on their x-coordinate (and then by height in case of a tie)
        Collections.sort(criticalPoints, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        // Max heap to keep track of the heights of active buildings
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Initialize the heap with a dummy value
        maxHeap.offer(0);

        // Previous max height, used to determine if a new point is a critical point
        int prevMaxHeight = 0;

        // Process each critical point
        for (int[] point : criticalPoints) {
            int x = point[0];
            int height = Math.abs(point[1]);

            if (point[1] < 0) { // Start point of a building
                maxHeap.offer(height);
            } else { // End point of a building
                maxHeap.remove(height);
            }

            // Get the current max height in the heap
            int currentMaxHeight = maxHeap.peek();

            // If the max height changes, add a new critical point to the result
            if (prevMaxHeight != currentMaxHeight) {
                result.add(List.of(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/the-skyline-problem/
        int[][] building = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<List<Integer>>  expected = List.of(
            List.of(2,10), 
            List.of(3,15),
            List.of(7,12),
            List.of(12,0),
            List.of(15,10),
            List.of(20,8),
            List.of(24,0));
        //new int[][]{{2,10},{3,15},{7,12},{12,0},{15,10},{20,8},{24,0}};
        
        List<List<Integer>>  actual = new Solution().getSkyline(building);
        assert expected.equals(actual);
    }
}