package hoa.can.code;

import hoa.can.code.ez.ReverseInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseIntegerTest {
    @Test
    @DisplayName("https://leetcode.com/problems/reverse-integer/description/")
    public void test1() {

        assertEquals(0, ReverseInteger.reverse(0));
        assertEquals(12, ReverseInteger.reverse(21));
        assertEquals(123, ReverseInteger.reverse(321));
        assertEquals(9999999, ReverseInteger.reverse(9999999));
        assertEquals(0, ReverseInteger.reverse(2147483647));
    }
}
