package hoa.can.code;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import hoa.can.code.ez.TwoSum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Unit test for simple App.
 */
public class TwoSumTest
{

    @Test
    @DisplayName("2+7 = 9")
    public void test1() throws TwoSum.NoTwoSumSolutionFor {
        assertArrayEquals(
                new int[]{0,1},
                TwoSum.solve(new int[]{2,7,11,15}, 9)
        );
    }

    @Test
    @DisplayName("2+7 = 9 ALT")
    public void test1alt() throws TwoSum.NoTwoSumSolutionFor {
        assertArrayEquals(
                new int[]{0,1},
                TwoSum.solveAlt1(new int[]{2,7,11,15}, 9)
        );
    }
}
