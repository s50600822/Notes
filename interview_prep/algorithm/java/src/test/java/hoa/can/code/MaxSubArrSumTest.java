package hoa.can.code;

import hoa.can.code.ez.LongestPalindrome;
import hoa.can.code.med.MaxSubArr;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSubArrSumTest {
    MaxSubArr tst = new MaxSubArr();
    @Test
    @DisplayName("max sub arr sum")
    public void test(){
        assertEquals(1, tst.maxSubArray(new int[]{1}));
        assertEquals(6, tst.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        assertEquals(23, tst.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
