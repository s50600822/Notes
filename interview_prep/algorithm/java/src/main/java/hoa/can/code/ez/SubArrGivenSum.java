package hoa.can.code.ez;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
public class SubArrGivenSum {
    public static final int BRUTE_FORCE = 1;
    public static final int SLIDING_WINDOWS = 1;

    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        return subarraySum(BRUTE_FORCE, arr, n, s);
    }


    public static ArrayList<Integer> subarraySum(int algo, int[] arr, int n, int s) {
        if(algo==BRUTE_FORCE){
            return subarraySum1(arr, n, s);
        }
        return subarraySum2(arr, n, s);
    }

    // why int n is here, the industry is trash.
    private static ArrayList<Integer> subarraySum1(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<>(2);
        for(int start = 0; start < arr.length; start++){
            int remainder = s-arr[start];
                if(remainder == 0){
                    result.add(start+1);
                    result.add(start+1);
                    return result;
                }
                for(int i=start+1; i< arr.length; i++){
                remainder = remainder-arr[i];
                if(remainder == 0){
                    result.add(start+1);
                    result.add(i+1);
                    return result;
                }
                if(remainder <0){
                    break;
                }
            }
        }
        result.add(-1);
        return result;
    }

  private static ArrayList<Integer> subarraySum2(int[] arr, int n, int s) {
        // sliding window, faster.
        int start = 0;
        int end = 0;

        int arrSum = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while(end < arr.length){
            arrSum += arr[end];// (1)
            if(arrSum == s){
                res.add(start+1);
                res.add(end+1);
                return res;
            }
            if(arrSum < s){
                end = end + 1;
            } else {
                if(start<end){
                    arrSum = arrSum - arr[start];
                    arrSum = arrSum - arr[end]; // compensate (1) cause I dont want to rewrite
                    start = start + 1;
                }else{
                    start = end +1;
                    end = end +1;
                    arrSum = 0;
                }
            }
        }
        res.add(-1);
        return res;
    }
}
