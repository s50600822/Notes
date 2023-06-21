package hoa.can.code;

import hoa.can.code.ez.SearchInsertPosition;
import hoa.can.code.ez.TwoSum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInsertPositionTest {
    final SearchInsertPosition sol = new SearchInsertPosition();
    @Test
    @DisplayName("[1,3,5,6]   5")
    public void test1() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                2,
                sol.searchInsert(new int[]{1,3,5,6}, 5)
        );
    }

    @Test
    @DisplayName("[1,3,5,6]   7")
    public void test3() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                4,
                sol.searchInsert(new int[]{1,3,5,6}, 7)
        );
    }
    @Test
    @DisplayName("[1,3,5,6]   0")
    public void test4() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                0,
                sol.searchInsert(new int[]{1,3,5,6}, 0)
        );
    }
    @Test
    @DisplayName("[1]   0")
    public void test5() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                0,
                sol.searchInsert(new int[]{1}, 0)
        );
    }
    @Test
    @DisplayName("[]   5")
    public void test6() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                0,
                sol.searchInsert(new int[]{}, 5)
        );
    }
}
