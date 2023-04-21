package hoa.can.code;

import hoa.can.code.diff.FindAllAnagramsInAString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindAllAnagramsInAStringTest {

    @Test
    @DisplayName("...")
    public void test1() {

        assertArrayEquals(
                new int[]{0,6},
                (new FindAllAnagramsInAString().findAnagrams("cbaebabacd", "abc")).stream().mapToInt(Integer::intValue).toArray()
        );

        assertArrayEquals(
                new int[]{0},
                (new FindAllAnagramsInAString().findAnagrams("a", "a")).stream().mapToInt(Integer::intValue).toArray()
        );

        assertArrayEquals(
                new int[]{},
                (new FindAllAnagramsInAString().findAnagrams("a", "b")).stream().mapToInt(Integer::intValue).toArray()
        );

        assertArrayEquals(
                new int[]{1},
                (new FindAllAnagramsInAString().findAnagrams("aab", "ab")).stream().mapToInt(Integer::intValue).toArray()
        );
    }
}
