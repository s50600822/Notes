package hoa.can.code.ez;

import java.util.Arrays;

import util.Array;

public class PartitionEqualSubSetSum {
    public static int equalPartition(int n, int arr[]){
        int sum = sum(arr);
        if(sum % 2 != 0) return 0;
        return canAddUp(arr, sum/2);
    }

    static int canAddUp(int arr[], int target){
        System.out.println(String.format("canAddUp %d %s", target, Arrays.toString(arr)));
        if(target==0){
            return 1;
        }
        if(target < 0){
            return 0;
        }
        if(arr.length == 0){
            return 0;
        }
        // retarded API of the problem
        if (canAddUp(Array.tail(arr), target - arr[0])>0 || canAddUp(Array.tail(arr), target)>0) return 1;
        return 0;
    }


    static int sum(int arr[]){
        int sum =0;
        for(int i:arr){
            sum += i;
        }
        return sum;
    }

}