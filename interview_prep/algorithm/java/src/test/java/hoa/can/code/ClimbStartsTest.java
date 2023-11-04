package hoa.can.code;

import hoa.can.code.ez.ClimbStairs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbStartsTest {
    ClimbStairs sol = new ClimbStairs();

    @Test
    @DisplayName("https://leetcode.com/problems/climbing-stairs/")
    public void test() {
        assertEquals(0, sol.climbs(0));
        assertEquals(1, sol.climbs(1));
        assertEquals(3, sol.climbs(3));
    }
}
