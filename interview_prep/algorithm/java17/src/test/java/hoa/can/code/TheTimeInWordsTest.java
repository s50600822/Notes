package hoa.can.code;

import hoa.can.code.ez.TwoSum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hoa.can.code.ez.TheTimeInWords.timeInWords;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheTimeInWordsTest {

    @Test
    @DisplayName("repeating chars")
    public void test() throws TwoSum.NoTwoSumSolutionFor {
        assertEquals("five o' clock", timeInWords(5, 0));
        assertEquals("five o' clock", timeInWords(5, 00));
        assertEquals("one minute past five", timeInWords(5, 01));
        assertEquals("ten minutes past five", timeInWords(5, 10));
        assertEquals("quarter past five", timeInWords(5, 15));
        assertEquals("twenty nine minutes past five", timeInWords(5, 29));

        assertEquals("half past five", timeInWords(5, 30));
        assertEquals("twenty minutes to six", timeInWords(5, 40));
        assertEquals("quarter to six", timeInWords(5, 45));
        assertEquals("one minute to six", timeInWords(5, 59));

        assertEquals("thirteen minutes to six", timeInWords(5, 47));
        assertEquals("twenty eight minutes past five", timeInWords(5, 28));
        assertEquals("three o' clock", timeInWords(3, 00));
        assertEquals("twenty five minutes to seven", timeInWords(6, 35));

        assertEquals("quarter past seven", timeInWords(7, 15));
        assertEquals("twelve o' clock", timeInWords(12, 0));
        assertEquals("one minute past twelve", timeInWords(12, 1));
        assertEquals("half past twelve", timeInWords(12, 30));
        assertEquals("quarter to one", timeInWords(12, 45));
        assertEquals("one minute past one", timeInWords(1, 1));
    }
}
