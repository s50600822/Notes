package hoa.can.code;

import hoa.can.code.diff.StrongPasswordChecker;
import hoa.can.code.ez.TwoSum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrongPasswordCheckerTest {
    StrongPasswordChecker checker = new StrongPasswordChecker();
    @Test
    @DisplayName("repeating chars")
    public void test2() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                2,
                checker.strongPasswordChecker("aaaaaaa")
        );
        assertEquals(
                2,
                checker.strongPasswordChecker("aaaaaaaa")
        );
        assertEquals(
                3,
                checker.strongPasswordChecker("aaaaaaaaa")
        );
    }

    @Test
    @DisplayName("aaa")
    public void testaaa() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                3,
                checker.strongPasswordChecker("aaa")
                //aaa
        );
    }

    @Test
    @DisplayName("1234")
    public void testL() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                2,
                checker.strongPasswordChecker("1234")
        );
    }


    @Test
    @DisplayName("aA1")
    public void test3() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                3,
                checker.strongPasswordChecker("aA1")
        );
    }

    @Test
    @DisplayName("1337C0d3")
    public void test4() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                0,
                checker.strongPasswordChecker("1337C0d3")
        );
    }

    @Test
    @DisplayName("aA123")
    public void test5() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                1,
                checker.strongPasswordChecker("aA123")
        );
    }

    @Test
    @DisplayName("aaaB1")
    public void test6() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                1,
                checker.strongPasswordChecker("aaaB1")
        );
    }


//    @Test
//    @DisplayName("bbaaaaaaaaaaaaaaacccccc")
//    public void testbbaaaaaaaaaaaaaaacccccc() throws TwoSum.NoTwoSumSolutionFor {
//        assertEquals(
//                8,
//                checker.strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc")
//        );
//    }
}
