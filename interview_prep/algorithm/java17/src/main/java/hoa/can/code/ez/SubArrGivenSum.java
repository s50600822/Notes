package hoa.can.code.ez;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
public class SubArrGivenSum {
    // why int n is here, the industry is trash.
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
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
}
