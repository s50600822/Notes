package hoa.can.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hoa.can.code.diff.RegularExpressionMatching.solve;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegularExpressionMatchingTest {
    @Test
    @DisplayName("empty matches empty")
    public void test1() {
        assertTrue(solve("",""));
    }

    @Test
    @DisplayName("a matches a")
    public void test2() {
        assertTrue(solve("a","a"));
    }


    @Test
    @DisplayName("abc matches abc")
    public void test3() {
        assertTrue(solve("abc","abc"));
    }


    @Test
    @DisplayName("abc matches a.*")
    public void test4() {
        assertTrue(solve("abc","a.*"));
    }

    @Test
    @DisplayName("abc matches a..")
    public void test5() {
        assertTrue(solve("abc","a.."));
    }
}
