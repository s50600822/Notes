package hoa.can.code;

import hoa.can.code.ez.TwoSum;
import hoa.can.code.med.SimplifyPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimplifyPathTest
{
    @Test
    @DisplayName("/../")
    public void test1() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                "/",
                new SimplifyPath().solve("/../")
        );
    }

    @Test
    @DisplayName("/home//foo/")
    public void test2() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                "/home/foo",
                new SimplifyPath().solve("/home//foo/")
        );
    }

    @Test
    @DisplayName("/home/../foo/")
    public void test3() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                "/foo",
                new SimplifyPath().solve("/home/../foo/")
        );
    }


    @Test
    @DisplayName("/home/foo/bar/../..")
    public void test4() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals(
                "/home",
                new SimplifyPath().solve("/home/foo/bar/../..")
        );
    }
}
