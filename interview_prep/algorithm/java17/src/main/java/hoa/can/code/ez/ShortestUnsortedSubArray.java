package hoa.can.code.ez;

public class ShortestUnsortedSubArray {

    public Sol solution;
    
    public ShortestUnsortedSubArray(Sol solution) {
        this.solution = solution;
    }

    public int findShortestUnorderedSubarray(int[] arr){
        return solution.findShortestUnorderedSubarray(arr);
    }

    public interface Sol {
        public int findShortestUnorderedSubarray(int[] arr);
    }

    public static class SolA implements Sol{
        public SolA(){};
        public int findShortestUnorderedSubarray(int[] arr) {
            int n = arr.length;
            boolean increasing = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    increasing = false;
                    break;
                }
            }
    
            boolean decreasing = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    decreasing = false;
                    break;
                }
            }
    
            if (increasing || decreasing) {
                return 0;
            }
    
            return 3;
        }        
    }

    public static class SolB implements Sol{
        public SolB(){};
        public int findShortestUnorderedSubarray(int[] arr) {
            int n = arr.length;
            int start = -1, end = -1;
            for (int i = 0; i < n; i++) {
                if (i > 0 && arr[i] < arr[i - 1]) {
                    start = i;
                }
                if (i < n - 1 && arr[i] > arr[i + 1]) {
                    end = i;
                }
            }
    
            if (start != -1 && end != -1) {
                return end - start + 1;
            } else {
                return 0;
            }
        }        
    }
}
