package hoa.can.code;

import hoa.can.code.diff.WildcardMatching;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildcardMatchingTest {
    @Test
    @DisplayName("a")
    public void test1() {

        assertEquals(
                true,
                (WildcardMatching.solve("abcxxxxzzzzzzz", "a*z")
                ));

        assertEquals(
                true,
                (WildcardMatching.solve("abc", "abc")
        ));

        assertEquals(
                true,
                (WildcardMatching.solve("abc", "ab*")
                ));

        assertEquals(
                true,
                (WildcardMatching.solve("abc", "***")
                ));

        assertEquals(
                true,
                (WildcardMatching.solve("abc", "*b*")
                ));
    }
}
