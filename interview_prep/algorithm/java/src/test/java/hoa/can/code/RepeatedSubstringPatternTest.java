package hoa.can.code;

import hoa.can.code.ez.RepeatedSubstringPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedSubstringPatternTest {
    @Test
    @DisplayName("https://leetcode.com/problems/repeated-substring-pattern/description/ - pos")
    public void testPositive() {

        assertTrue(RepeatedSubstringPattern.solve("abab"));
        assertTrue(RepeatedSubstringPattern.solve("abcabc"));
        assertTrue(RepeatedSubstringPattern.solve("xyzxyzxyz"));
        assertTrue(RepeatedSubstringPattern.solve("aaaaa"));
        assertTrue(RepeatedSubstringPattern.solve("123123"));
        assertTrue(RepeatedSubstringPattern.solve("abcdeabcde"));   
    }

        @Test
    @DisplayName("https://leetcode.com/problems/repeated-substring-pattern/description/ - neg")
    public void testNegative() {
        assertFalse(RepeatedSubstringPattern.solve("a"));// tested on leetcode submission
        assertFalse(RepeatedSubstringPattern.solve("aba"));
        assertFalse(RepeatedSubstringPattern.solve("abcde"));
        assertFalse(RepeatedSubstringPattern.solve("abcdabcde"));
        assertFalse(RepeatedSubstringPattern.solve("abcdefg"));
        assertFalse(RepeatedSubstringPattern.solve("abcdefgh"));
    }
}
