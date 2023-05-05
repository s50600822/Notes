package hoa.can.code;

import hoa.can.code.diff.TrappingRainWater;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrappingRainWaterTest {
    @Test
    @DisplayName("https://leetcode.com/problems/trapping-rain-water/")
    public void test() {
        assertEquals(
                6,
                new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})
        );
        assertEquals(
                9,
                new TrappingRainWater().trap(new int[]{4,2,0,3,2,5})
        );

        assertEquals(
                0,
                new TrappingRainWater().trap(new int[]{6,6,6})
        );

        assertEquals(
                0,
                new TrappingRainWater().trap(new int[]{999})
        );

        assertEquals(
                9*4,
                new TrappingRainWater().trap(new int[]{9,0,0,0,0,9})
        );
    }
}
