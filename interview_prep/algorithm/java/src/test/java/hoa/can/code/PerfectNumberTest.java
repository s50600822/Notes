package hoa.can.code;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerfectNumberTest {
    @Test
    @DisplayName("https://practice.geeksforgeeks.org/problems/perfect-numbers3207/1")
    public void test() {
        assertEquals(0, hoa.can.code.ez.PerfectNumber.isIt(0L));
        assertEquals(0, hoa.can.code.ez.PerfectNumber.isIt(1L));
        assertEquals(1, hoa.can.code.ez.PerfectNumber.isIt(6L));
        assertEquals(1, hoa.can.code.ez.PerfectNumber.isIt(8589869056L));
       
    }
}
