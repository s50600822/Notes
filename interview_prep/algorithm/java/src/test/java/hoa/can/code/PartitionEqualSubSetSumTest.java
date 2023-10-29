package hoa.can.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PartitionEqualSubSetSumTest {
    // why is this an int? I don't know, just playing along
    final int YES = 1;
    @Test
    @DisplayName("https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1")
    public void test(){
        assertEquals(
                YES,
                hoa.can.code.ez.PartitionEqualSubSetSum.equalPartition(1, new int[]{1,5,11,5})
        );
        assertEquals(
                YES,
                hoa.can.code.ez.PartitionEqualSubSetSum.equalPartition(1, new int[]{6,2,3,10,2,9,10,2})
        );
    }
}
