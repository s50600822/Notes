package hoa.can.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class SubArrGivenSumTest {
    @Test
    @DisplayName("https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1")
    public void test() {
        java.util.List<Integer> res = new ArrayList<>(2);
        res.add(2);
        res.add(2);
        assertEquals(
                res,
                hoa.can.code.ez.SubArrGivenSum.subarraySum(new int[] { 1,2 }, 1, 2)
        );
    }
    @Test
    @DisplayName("https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1")
    public void test2() {
        java.util.List<Integer> res = new ArrayList<>(2);
        res.add(1);
        res.add(1);
        assertEquals(
                res,
                hoa.can.code.ez.SubArrGivenSum.subarraySum(new int[] { 1,2 }, 1, 1)
        );
    }
    
    @Test
    @DisplayName("https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1")
    public void test3() {
        java.util.List<Integer> res = new ArrayList<>(2);
        res.add(2);
        res.add(2);
        assertEquals(
                res,
                hoa.can.code.ez.SubArrGivenSum.subarraySum(new int[] { 1,2 }, 1, 2)
        );
    }    
}
